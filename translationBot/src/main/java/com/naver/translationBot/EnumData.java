package com.naver.translationBot;

import com.memetix.mst.language.Language;




public class EnumData {

	//botNo구분을 위한 enum
	//명령어 수행을 위한 enum	
	enum BotNo {
		BOTNO_KE(16), BOTNO_KJ(29), BOTNO_KC(30), BOTNO_EJ(31);
		
		BotNo(final int botno) { //생성자
				BOTNO = botno;
		}
		private int BOTNO;
		
		public int getBOTNO() {
			return BOTNO;
		}
	}	

	
	
	//번역을 위한 enum
	enum LangK { //들어오는 v1,v2에 매치되는 번역 시 각각의 Language 인자값  
        ko(Language.KOREAN), en(Language.ENGLISH), ja(Language.JAPANESE),
        	zh(Language.CHINESE_SIMPLIFIED);
        
		LangK(final Language lang) { //생성자
        	LANG_E = lang;
        }
        private Language LANG_E;
        			
        public Language getLangE() {
        	return LANG_E;
        }

	}	

//명령어 수행을 위한 enum	
	enum BotType {
		BOTNO_KE("한영", "영한", 0), BOTNO_KJ("한일", "일한", 1),
				BOTNO_KC("한중", "중한", 2), BOTNO_EJ("영일", "일한", 3);
		
		BotType(final String commandLW,final String CommandWL,
					final int bottype) { //생성자
		   this.commandLW = commandLW;
		   this.CommandWL = CommandWL;
		   BOTTYPE = bottype;
		}
		public String commandLW;
		public String CommandWL;
		public int BOTTYPE;
		public String getCOMMANDLW() {
			return commandLW;
		}
		public String getCOMMANDWL() {
			return CommandWL;
		}
		public int getBOTTYPE() {
			return BOTTYPE;
		}      
	}	

}
