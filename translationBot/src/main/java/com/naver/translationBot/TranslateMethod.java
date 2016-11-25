package com.naver.translationBot;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RestController;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
import com.mzsanford.cld.CompactLanguageDetector;
import com.mzsanford.cld.LanguageDetectionCandidate;
import com.mzsanford.cld.LanguageDetectionResult;
import com.naver.bo.TranslateBO;
import com.naver.translationBot.EnumData.LangK;

@RestController
public class TranslateMethod {
	
	
	
//	CommandMethod commandMethod=new CommandMethod();
	private static CommonMethod commonMethod = new CommonMethod();
	
	//언어탐지 함수
	final String detectLanguage(final TranslateBO translateBO, 
			final long writerUserNo, final int channelNo, final int botNo,
				final String inputMessage, final String v1,
					final String v2) throws Exception {
		String outputMessage = "";
		// 탐지 라이브러리 변수를 만들고, result를 뽑아냄
		CompactLanguageDetector compactLanguageDetector = new CompactLanguageDetector();
		LanguageDetectionResult result = compactLanguageDetector.detect(inputMessage);
	    //bot api 수행을 위한 set
		Translate.setClientId("zzang9083");
		Translate.setClientSecret(
				"beOno9V+dEozWa2P2X9OIeHnGOXYEX7apImLGrXKC4o="); 
		
		
		// input으로 들어온 값에 대해 탐지라이브러리를 사용하여 탐지순위를 메겨 for문 
		for (LanguageDetectionCandidate candidate 
				: result.getCandidates()) {
		//translate Language
			Language DETECT = null; //detect된 언어가 저장
			Language TARGET = null; //target이 된 언어가 저장
			// 판별 결과가 v1과 같고(detect가 v1이고)	
			if (candidate.getLocale().getLanguage().equals(v1)) {    
				//먼저 input이 단어인지 영문인지 판별하는 함수로
				detectInput(DETECT, TARGET, translateBO, writerUserNo,
						channelNo, botNo, inputMessage, v1, v2,1, outputMessage);
				return "flag1";
			// 판별 결과가 v2과 같고 detect가 v2이고)	
			} else  if (candidate.getLocale().getLanguage().equals(v2)) {   
				//먼저 input이 단어인지 영문인지 판별하는 함수로
				detectInput(DETECT, TARGET, translateBO, writerUserNo,
						channelNo, botNo, inputMessage, v2, v1,2, outputMessage);
				return "flag2";
			} 
		}
		commonMethod.sendmessage(inputMessage, channelNo, botNo);
		return "detectLanguage";
	}
	
	//for문으로 detect언어와 target언어 선별
	final Language detectDetTar(final String lang) throws Exception {
		for (LangK d : LangK.values()) {
			if (lang.equals(d.toString())) {
				return d.getLangE();
			}
		}
			return null;
		}
		
	//input이 단어인지, 문장인지 판별
	final String detectInput(Language DETECT, Language TARGET, 
			final TranslateBO translateBO, final long writerUserNo, 
				final int channelNo, final int botNo, final String inputMessage,
					final String det, final String tar, final int flag,
						String outputMessage) throws Exception {
				
		DETECT=detectDetTar(det);
		TARGET=detectDetTar(tar);
		//단어일때 			
		if (inputMessage.matches("[ㄱ-ㅎㅏ-ㅣ가-힣]*") 
			|| inputMessage.matches("[a-z|A-Z]*") 
				|| inputMessage.matches("\\p{IsHan}*") 
					|| inputMessage.matches("[\\p{InHiragana} || \\p{InKatakana} || \\p{IsHan}]*")) {
					translateInput(translateBO, inputMessage, writerUserNo,
							channelNo, DETECT, TARGET, flag, botNo); //번역함수로
		   return "wordCase";
		   } else { //단어가 아닐때
			//번역하여 
			outputMessage = Translate.execute(inputMessage, DETECT, TARGET);
			//결과 sendmessage	
			commonMethod.sendmessage(outputMessage, channelNo, botNo); 
			return "noWordCase";
		    }
		 }
					 
	//단어 번역, 저장함수
	final void translateInput(final TranslateBO translateBO, 
			final String inputMessage, final long writerUserNo, 
				final int channelNo, final Language detect, 
					final Language target, final int flag,
						final int botNo) throws Exception {
	    
		int dicResult;
		ArrayList<HashMap> selectResult = null;	
		String outputMessage = "";
		int botType = 0;
		//detect,target 조합에 따라 bottype이 정해짐 
		if (detect.toString().equals("ko")) {
			if (target.toString().equals("en")) {
				botType = 0;
			} else if (target.toString().equals("ja")) {
				botType = 1;
			} else if (target.toString().equals("zh-CHS")) {
				botType = 2;
			} 
		} else if (detect.toString().equals("en")) {
			 if (target.toString().equals("ja")) {
				botType = 3;
			 }
		}  else if (detect.toString().equals("ja")) {
			if (target.toString().equals("ko")) {
				botType = 1;
			} else if (target.toString().equals("en")) {
				botType = 3;
			}
		}  else if (detect.toString().equals("zh-CHS")) {
			if (target.toString().equals("ko")) {
				botType = 2;
			}
		}
		
		
		if (flag % 2 == 1) {
			//dic_tb에 있는지 확인
			dicResult = translateBO.confirmDicL(botType, inputMessage); 
			if (dicResult != 0) { //번역데이터가 이미  데이터로 있으면
				// dic에서 output select 해준다.
				selectResult = translateBO.selectDicL(botType, inputMessage);  
				for (int j = 0; j < selectResult.size(); j++) {
				  outputMessage += selectResult.get(j).get("lang2").toString();
				  if (j != selectResult.size() - 1) {
						outputMessage += "\n";
				  // 해당 단어 translate hys에 내역이 없으면 저장		
				  } else if (translateBO.confirmTrans(writerUserNo, 
						Integer.parseInt(selectResult.get(j).get("id")
							.toString()), botType, flag) == 0) {
						 translateBO.addTranslate(writerUserNo, Integer.
							parseInt(selectResult.get(j).get("id").toString()),
							botType, flag);
				   }	
			     }
				 //결과 sendmessage
				 commonMethod.sendmessage(outputMessage, channelNo, botNo); 
			} else { //번역데이터가 없으면
					//번역하고 
					 outputMessage = Translate.execute(inputMessage, 
							 detect, target);
					 //결과 sendmessage
					 commonMethod.sendmessage(outputMessage, 
					 		channelNo, botNo);
					 if (outputMessage.matches("[a-z|A-Z]*") 
					 	|| outputMessage.matches("\\p{IsHan}*") 
					 		|| outputMessage.matches("[ㄱ-ㅎㅏ-ㅣ가-힣]*") 
					 			|| inputMessage.matches("[\\p{InHiragana} || \\p{InKatakana} || \\p{IsHan}]*")) {
						 	//dic테이블에도 저장하고
					 		translateBO.addDic(inputMessage.toLowerCase(), 
					 				outputMessage.toLowerCase(), botType);
					 		// dic에서 output select 해서 
					 		selectResult = translateBO.selectDicL(botType, 
					 				inputMessage);  
					 		//dic에도 넣고 translate hys에 저장
					 		translateBO.addTranslate(writerUserNo, Integer.
					 				parseInt(selectResult.get(0).get("id").
					 						toString()), botType, flag); 
					 }
			}
		} else if (flag % 2 == 0) {
			//dic_tb에 있는지 확인
			dicResult = translateBO.confirmDicR(botType, inputMessage);
			if (dicResult != 0) { //번역데이터가 이미  데이터로 있으면
				// dic에서 output select 해준다.
				selectResult = translateBO.selectDicR(botType, inputMessage);  
				for (int j = 0; j < selectResult.size(); j++) {
				  outputMessage += selectResult.get(j).get("lang1").toString();
				  if (j != selectResult.size() - 1) {
						outputMessage += "\n";
				  // 해당 단어 translate hys에 내역이 없으면 저장		
				  } else if (translateBO.confirmTrans(writerUserNo, 
						Integer.parseInt(selectResult.get(j).get("id")
							.toString()), botType, flag) == 0) {
						 translateBO.addTranslate(writerUserNo, Integer.
							parseInt(selectResult.get(j).get("id").toString()),
							botType, flag);
				   }	
			     }
				 //결과 sendmessage
				 commonMethod.sendmessage(outputMessage, channelNo, botNo); 
			} else { //번역데이터가 없으면
					//번역하고 
					 outputMessage = Translate.execute(inputMessage, 
							 detect, target);
					 //결과 sendmessage
					 commonMethod.sendmessage(outputMessage, 
					 		channelNo, botNo); 
					 if (outputMessage.matches("[a-z|A-Z]*") 
					 	|| outputMessage.matches("\\p{IsHan}*") 
					 		|| outputMessage.matches("[ㄱ-ㅎㅏ-ㅣ가-힣]*") 
					 			|| inputMessage.matches("[\\p{InHiragana} "
					 				+ "||" + " \\p{InKatakana} || \\p{IsHan}]*")) {
						 	//dic테이블에도 저장하고
					 		translateBO.addDic(outputMessage.toLowerCase(), 
					 				inputMessage.toLowerCase(), botType);
					 		// dic에서 output select 해서 
					 		selectResult = translateBO.selectDicR(botType, 
					 				inputMessage);  
					 		//dic에도 넣고 translate hys에 저장
					 		translateBO.addTranslate(writerUserNo, Integer.
					 				parseInt(selectResult.get(0).get("id").
					 						toString()), botType, flag); 
					 }
			}	
		 }
	}
	
	
	
}
