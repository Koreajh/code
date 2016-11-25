package com.naver.bo;

import java.util.ArrayList;
import java.util.HashMap;

public interface CommandBO {
	int deleteDateWords(long id, int date, int bottype);
	int deleteWords(long id, String word, int bottype);
	ArrayList<HashMap> selectPeriodWords(long id, String predate, 
											String afterdate, int bottype);	
	ArrayList<HashMap> selectWrongWords(long id, String predate, 
											String afterdate, int bottype);	
}