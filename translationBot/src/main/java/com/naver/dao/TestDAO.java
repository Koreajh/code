package com.naver.dao;

import java.util.HashMap;

public interface TestDAO {
	HashMap sendProblem(long usrid, int bottype, int flag);
	int addTest(long usrid, int bottype, String question);	
	int updateFlag(long usrid, int flag, int bottype);
	int confirmFlag(long usrid, int bottype);
	String[] confirmAnswerR(long usrid, int bottype); 	
	String[] confirmAnswerL(long usrid, int bottype); 	
	int confirmIdWord(long id, int bottype, int flag);
	int updateRw(long usrid, int bottype, int rw);	
}
