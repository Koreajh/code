package com.naver.boimpl;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.naver.bo.TranslateBO;
import com.naver.dao.TranslateDAO;

@Service
public class TranslateBOImpl implements TranslateBO {

	@Autowired
	private TranslateDAO translateDAO;
	
	@Override
	public final  int confirmId(final long usrid, final int bottype) {
		return translateDAO.confirmId(usrid, bottype);		
	}
	@Override
	public final  int confirmDicR(final int bottype, final String lang) {
		return translateDAO.confirmDicR(bottype, lang);
	}
	@Override
	public final  int confirmDicL(final int bottype, final String lang) {
		return translateDAO.confirmDicL(bottype, lang);
	}
	@Override
	public final  ArrayList<HashMap> selectDicL(final int bottype,
			final String lang) {
		return translateDAO.selectDicL(bottype, lang);	
	}
	@Override
	public final  ArrayList<HashMap> selectDicR(final int bottype,
			final String lang) {
		return translateDAO.selectDicR(bottype, lang);
	}
	@Override
	public final  int confirmTrans(final long usrid, final int dicid, 
			final int bottype, final int flag) {
		return translateDAO.confirmTrans(usrid, dicid, bottype, flag);	
	}
	@Override
	public final  int addDic(final String lang1, final String lang2,
			final int bottype) {
		return translateDAO.addDic(lang1, lang2, bottype);	
	}
	@Override
	public final  int addTranslate(final long usrid, final int dicid,
			 final int bottype , final int flag) {
		return translateDAO.addTranslate(usrid, dicid, bottype, flag);	
	}
}