package com.naver.translationBot;

import java.util.Arrays;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RestController;
import com.naver.bo.TestBO;

@RestController
public class TestMethod {
	
	
	private static CommonMethod commonMethod = new CommonMethod();
	
	// 단어암기 명령어 수행시 수행되는 함수
	final String checkTransCommand(final TestBO testBO, 
		final long writerUserNo, final int channelNo, final int botNo, 
				final int flag, final int botType) throws Exception {
		
		String outputMessage = null;
		//bottype에 디한 id의 번역내역이 5개 이하면 데이터 부족하다고 알림
		if (testBO.confirmIdWord(writerUserNo, botType, flag) <= 5) { 
			outputMessage = "회원님의 번역내역이 없거나 부족합니다. (최소 5개의 데이터 필요)";
			commonMethod.sendmessage(outputMessage, channelNo, botNo); 
			return "notEnoughData";
		}
		//5개 이상이면 flag update하고
		testBO.updateFlag(writerUserNo, flag, botType); 
		//bottype ,flag에 맡게 단어문제출제
		sendproblem(testBO, writerUserNo, channelNo,
				flag, botType, botNo);  
		return "testStart";
	}
		
	//단어테스트 함수
	final void sendproblem(final TestBO testBO, final long writerUserNo,
			final int channelNo, final int flag, final int botType,
			final int botNo) throws Exception {
		
		HashMap problem = testBO.sendProblem(writerUserNo, 
												botType, flag); //문제출제

		if (flag % 2 == 1) { //한->영 / 한 ->중 /한->일 /영->일 일 경우의 단어변역내역에서 문제출제
			//문제 출제하고
			commonMethod.sendmessage(problem.get("lang2").toString(), 
													channelNo, botNo);
			//test테이블에 저장
			testBO.addTest(writerUserNo, botType, 
								problem.get("lang2").toString()); 
		//영->한 / 중->한 /일->한 /일->영 일 경우의 단어변역내역에서 문제출제		
		} else if (flag % 2 == 0) {  
			commonMethod.sendmessage(problem.get("lang1").toString(), 
														channelNo, botNo);
			//test테이블에 저장
			testBO.addTest(writerUserNo, botType, problem.get("lang1").
																toString()); 
		}
	}

	//단어테스트 정오여부 함수
	final void TestCheck(final TestBO testBO,final long writerUserNo,
			final int channelNo,final int flag, final int botType, final int botNo,
				final String inputMessage) throws Exception {
			
		String outputMessage = null;
		String[] answer = null;
					
			
		if (flag % 2 == 1) { //flag에 따라서 정답을 테이블 lang1이나 lang2에서 확인
			answer = testBO.confirmAnswerL(writerUserNo, botType);
		} else {
			answer = testBO.confirmAnswerR(writerUserNo, botType);
		}
		//정답메세지
		if (Arrays.asList(answer).contains(inputMessage)) { 
			outputMessage = "정답입니다!";
			//정답이라고 sendMessage
		} else { //오답메세지
			outputMessage = "틀렸습니다 정답은  ";
			if (answer.length == 1) {
				outputMessage += answer[0];
			} else {
				for (int j = 0; j < answer.length; j++) {
					outputMessage += answer[j];
					if (j != answer.length - 1) {
						outputMessage += " 또는 ";
					}
					}
				}
			outputMessage += " 입니다.";
			testBO.updateRw(writerUserNo, botType, 1);
		 }
		 commonMethod.sendmessage(outputMessage, channelNo, botNo);
		 sendproblem(testBO, writerUserNo, channelNo, flag, botType, botNo);
				
		}

}
