package com.naver.dao;
import java.util.ArrayList;
import java.util.HashMap;
public interface TranslateDAO {
	int confirmId(long id, int bottype);
	int confirmDicR(int bottype, String lang);
	int confirmDicL(int bottype, String lang);
	ArrayList<HashMap> selectDicL(int bottype, String lang);
	ArrayList<HashMap> selectDicR(int bottype, String lang);
	int confirmTrans(long usrid, int dicid, int bottype, int flag);
	int addDic(String lang1, String lang2, int bottype);
	int addTranslate(long usrid, int dicid, int bottype, int flag);
}