package com.naver.translationBot;

import com.naver.bo.CommandBO;
import com.naver.bo.TestBO;
import com.naver.bo.TranslateBO;
import com.naver.dto.TranslateDTO;
import com.naver.translationBot.EnumData.BotNo;
import com.naver.translationBot.EnumData.BotType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * Handles requests for the application home page.
 */
@RestController
public class TranslationController {
	//쿼리수행을 위한 service객체
	@Autowired
	private TranslateBO translateBO;
	@Autowired
	private TestBO testBO;
	@Autowired
	private CommandBO commandBO;
	
	//다른 클래스들의 객체
	private static CommandMethod commandMethod = new CommandMethod();
	private static CommonMethod commonMethod = new CommonMethod();
	private static TestMethod testMethod = new TestMethod();
	private static TranslateMethod translateMethod = new TranslateMethod();
	

	//receivemessage가 callback url
	@RequestMapping(value = "receivemessage/{v1}/{v2}", method =
	{RequestMethod.GET, RequestMethod.POST}, consumes = {"application/json"})
	@ResponseBody
	public String receivemessage(@PathVariable("v1")final String v1, 
	       @PathVariable("v2")final String v2, final HttpServletRequest request,
	       final HttpSession session, @RequestBody final TranslateDTO list) 
	    		   throws Exception {
		//callback input
		String inputMessage = list.getContent().toString();
		//post로 받아오는 데이터값들
		long writerUserNo = list.getWriterUserNo();
		int channelNo = list.getChannelNo();
		int botNo = list.getBotNo();
		String botType = null;
		//botno가 무엇인지 판단
		for (BotNo botno: BotNo.values()) {
			if (botNo == botno.getBOTNO()) {
				botType = botno.toString();
			}
		}
		//단어테스트 명령어 판별하고 수행, 아니면 다른 거 명령어나 번역인지 판별하는 함수로
		for (BotType bot: BotType.values()) {
		//bot에 해당되면	
		if (bot.toString().equals(botType)) {
			//아이디가 db에 들어가 있나 없나 확인하고 없으면 넣음	
			if (translateBO.confirmId(writerUserNo, bot.getBOTTYPE()) == 1) {
				commonMethod.sendmessage("안녕하세요. " + bot.commandLW + "통역입니다."
					+ "통역된 단어들은 누적 저장되어 특정명령어를 입력하시면 단어테스트를 볼 수 있습니다.", 
						channelNo, botNo);
			}
			// 한,영/한,일/한,중/영,일 테스트
			if (inputMessage.equals("@" + bot.commandLW))  {
				testMethod.checkTransCommand(testBO, writerUserNo,
						channelNo, botNo, 1, bot.getBOTTYPE());
				return "TestStart";
			// 영,한/일,한/중,한/일,영 테스트
			} else if (inputMessage.equals("@" + bot.CommandWL)) { 		
				testMethod.checkTransCommand(testBO, writerUserNo, channelNo,
					botNo, 2, bot.getBOTTYPE());
				return "TestStart"; 
			}
			//테스트 명령어가 아니면 다른 공통명령어인지 구분하거나 번역하는 함수로
			commandMethod.checkCommonCommand(commandBO, testBO, translateBO,
				writerUserNo, channelNo, botNo, inputMessage.toLowerCase(),
					testBO.confirmFlag(writerUserNo, bot.getBOTTYPE()), 
						bot.getBOTTYPE(), v1, v2);
			break; //일치되서 갔으면 for문 밖으로 나감
		  } 
		  }
		return "translateMessage";
		}
}