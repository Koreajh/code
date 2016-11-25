package com.naver.translationBot;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import com.naver.bo.CommandBO;
import com.naver.bo.TestBO;
import com.naver.bo.TranslateBO;

@Controller
public class CommandMethod {
	private static CommonMethod commonMethod = new CommonMethod();
	private static TestMethod testMethod = new TestMethod();
	private static TranslateMethod translateMethod = new TranslateMethod();
	
	//모든 봇에 공통되는 명령어인지 판별 아니면 번역함수로
	public final String checkCommonCommand(final CommandBO commandBO, final TestBO testBO, 
			final TranslateBO translateBO, final long writerUserNo,
					final int channelNo, final int botNo, final String inputMessage,
					final int flag, final int botType, final String v1,
											final String v2) throws Exception {
				  if (inputMessage.startsWith("@삭제"))  {
						deleteData(commandBO, writerUserNo, channelNo, inputMessage, botType, botNo);
						return "deleteFin";
					} else if (inputMessage.startsWith("@보기"))  {
						showData(commandBO, writerUserNo, channelNo, inputMessage, botType, botNo);
						return "showFin";
					} else if (inputMessage.equals("@단어암기끝") 
							&&	(testBO.confirmFlag(writerUserNo, botType) != 0)) {
							  testBO.updateFlag(writerUserNo, 0, botType);
								commonMethod.sendmessage("단어암기끝!",  channelNo, botNo);
								return "testFin";
					} else if(testBO.confirmFlag(writerUserNo, botType)==0) { //flag 0이면 번역을 위해 detect함수로
					translateMethod.detectLanguage(translateBO, writerUserNo, channelNo, botNo, inputMessage, v1, v2);
					} else {  //flag 0이 아니면 test중인 것이므로 testcheck함수로
					testMethod.TestCheck(testBO, writerUserNo, channelNo, flag, botType, botNo, inputMessage);
					 }
				return "methodFin";
			}
			
			//삭제함수
			public final void deleteData(final CommandBO commandBO, final long writerUserNo, final int channelNo,
						final String inputMessage, final int botType, final int botNo) throws Exception {
				    //한칸이상의 공백으로 앞부터 3등분으로 자르기
					String[] input = inputMessage.split("\\s+",3);
					
					//명령어 잘못입력 옵션 없이 명령어만
					if (input.length == 1) {
						commonMethod.sendmessage("잘못된 명령어입력 입니다.\n "
								+ " <<사용가능 명령어>>\n\n@삭제 -d = 기간삭제  \n"
								+ "@삭제 -w = 단어지정삭제 ", channelNo, botNo);
				   } else if (input.length == 2) {   //옵션까지만 입력하고 뒤에 작성 안했을때
					  if (input[1].equals("-d")) {
					  		commonMethod.sendmessage("잘못된 명령어입력 입니다.\n <<가능명령어>\n\n@삭제 -d day"
									+ " \n @삭제 -d week,\n@삭제 -d month", channelNo, botNo);
					  } else if (input[1].equals("-w")) {		 
						  commonMethod.sendmessage("잘못된 명령어입력 입니다.\n "
									+ " <<가능명령어>>\n\n	@삭제 -w 강아지 \n@삭제 -w 강아지,cat", channelNo, botNo);
					 }  else {  // 잘못된 옵션 입력하고 뒤에도 작성 안했을때
					  commonMethod.sendmessage("잘못된 명령어입력 입니다.\n "
								+ " <<사용가능 명령어>>\n\n@삭제 -d = 기간삭제  \n"
								+ "@삭제 -w = 단어지정삭제 ", channelNo, botNo);
				      }
				   }
					else {
					 if (input[1].equals("-d")) { // 특정 시기 위로 데이터 삭제
						if (input[2].equals("day")) {
							commandBO.deleteDateWords(writerUserNo, 1, botType);
							} else if (input[2].equals("week")) {	
							commandBO.deleteDateWords(writerUserNo, 7, botType);
						 } else if (input[2].equals("month")) {	
							 commandBO.deleteDateWords(writerUserNo, 30, botType);
						  } else if (input[2].equals("all")) {	
								 commandBO.deleteDateWords(writerUserNo, 0, botType);
							  } else {
							  commonMethod.sendmessage("잘못된 명령어입력 입니다.\n <<가능명령어>\n\n@삭제 -d day"
										+ " \n @삭제 -d week,\n@삭제 -d month", channelNo, botNo);
							}
					} else if (input[1].equals("-w")) {   //특정 데이터삭제 
						String[] split = input[2].toLowerCase().trim().split(",");
						for (int i = 0; i < split.length; i++) {
							commandBO.deleteWords(writerUserNo, split[i], botType);
							}
						} 
					else {    
						commonMethod.sendmessage("잘못된 명령어입력 입니다.\n "
								+ " <<가능명령어>>\n\n	@삭제 -w 강아지 \n@삭제 -w 강아지,cat", channelNo, botNo);
						}
					}
			}

		//조회함수   
				public final void showData(final CommandBO commandBO, final long writerUserNo, final int channelNo
					, final String inputMessage, final int botType, final int botNo) throws Exception {
					String[] input = inputMessage.split("\\s+", 3); 
					ArrayList<HashMap> data = null;
					String outputMessage = "";
					if (input.length == 1) {
						commonMethod.sendmessage("잘못된 명령어입력 입니다.\n "
								+ "<<사용예>>\n\n@보기 -p :기간내 보기\n@보기 -t :기간내 틀린문제 보기",  channelNo, botNo);
				   } else if (input.length == 2) {
					   commonMethod.sendmessage("잘못된 명령어입력 입니다.\n  <<사용예>>\n\n@보기 -p 2016-01-01~2016-03-12 @"
					   		+ "보기 -p 2016-08-03", channelNo, botNo);	
				   } else if (input[1].equals("-p")) {
						String[] split = input[2].toLowerCase().trim().split("~");
						if (split.length == 1) {
						 data = commandBO.selectPeriodWords(writerUserNo,
									split[0].trim(), split[0].trim(), botType);
						} else if(split.length == 2) {
							data = commandBO.selectPeriodWords(writerUserNo,
								split[0].trim(), split[1].trim(), botType);
						}
						if (data.size() == 0) {
							commonMethod.sendmessage("지정하신 기간내에 저장된 데이터가 존재하지 않습니다.",  channelNo, botNo);
						} else {
					 for (int i = 0; i < data.size(); i++) {
						 	if (i == 0 || !data.get(i).get("date").equals(data.get(i-1).get("date"))) {
						 		outputMessage += "\n<< DATE " + data.get(i).get("date")
										.toString() + " >>\n";
						  }
							outputMessage += "" + data.get(i).get("lang1")
									.toString()
									+ " -> " +  data.get(i).get("lang2").
									toString() + '\n';
						}
					 commonMethod.sendmessage(outputMessage, channelNo, botNo);
					 }
					} else if (input[1].equals("-t")) {
						String[] split = input[2].toLowerCase().trim().split("~");
						if (split.length == 1) {
						 data = commandBO.selectWrongWords(writerUserNo,
									split[0].trim(), split[0].trim(), botType);
						} else if (split.length == 2) {
							data = commandBO.selectWrongWords(writerUserNo,
								split[0].trim(), split[1].trim(), botType);
						}
						if (data.size() == 0) {
							commonMethod.sendmessage("지정하신 기간내에 테스트 내역이 없거나, 테스트시 틀린 내역이 없습니다.",  channelNo, botNo);
						} else {
					 for (int i = 0; i < data.size(); i++) {
						 	if (i == 0 || !data.get(i).get("date").equals(data.get(i-1).get("date"))) {
									  outputMessage += "\n<< DATE " + data.get(i).get("date")
										.toString() + " >>\n";
						  }
							outputMessage += "" + data.get(i).get("lang1")
									.toString()
									+ " -> " +  data.get(i).get("lang2").
									toString() + '\n';
						}
					 commonMethod.sendmessage(outputMessage, channelNo, botNo);
					 }
					} else {
						commonMethod.sendmessage("잘못된 명령어입력 입니다.\n  "
								+ "<<사용예>>\n\n@보기 -t 2016-01-01~2016-03-12 @"
						   		+ "보기 -t 2016-08-03", channelNo, botNo);
						}
					} 			

}
