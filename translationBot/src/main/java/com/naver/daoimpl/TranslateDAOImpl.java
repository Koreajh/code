package com.naver.daoimpl;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.naver.dao.TranslateDAO;
import com.naver.mapper.TranslateMapper;

@Component
public class TranslateDAOImpl implements TranslateDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public final  int confirmId(final long usrid, final int bottype) {
		int result;
		TranslateMapper translateMapper = sqlSession.
				getMapper(TranslateMapper.class);
		result = translateMapper.confirmId(usrid, bottype);
		return result;	
	}
	@Override
	public final  int confirmDicR(final int bottype, final String lang) {
		int result;
		TranslateMapper translateMapper = sqlSession.
				getMapper(TranslateMapper.class);
		result = translateMapper.confirmDicR(bottype, lang);	
		return result;	
	}
	@Override
	public final  int confirmDicL(final int bottype, final String lang) {
		int result;
		TranslateMapper translateMapper = sqlSession.
				getMapper(TranslateMapper.class);
		result = translateMapper.confirmDicL(bottype, lang);	
		return result;	
	}
	@Override
	public final  ArrayList<HashMap> selectDicL(final int bottype,
			final String lang) {
		ArrayList<HashMap> result;
		TranslateMapper translateMapper = sqlSession.
				getMapper(TranslateMapper.class);
		result = translateMapper.selectDicL(bottype, lang);	
		return result;		
	}
	@Override
	public final  ArrayList<HashMap> selectDicR(final int bottype,
			final String lang) {
		ArrayList<HashMap> result;
		TranslateMapper translateMapper = sqlSession.
				getMapper(TranslateMapper.class);
		result = translateMapper.selectDicR(bottype, lang);	
		return result;	
	}
	@Override
	public final  int confirmTrans(final long usrid, final int dicid,
			final int bottype, final int flag) {
		int result;
		TranslateMapper translateMapper = sqlSession.
				getMapper(TranslateMapper.class);
		result = translateMapper.confirmTrans(usrid, dicid, bottype, flag);	
		return result;	
	}
	@Override
	public final  int addDic(final String lang1, final String lang2,
			final int bottype) {
		int result;
		TranslateMapper translateMapper = sqlSession.
				getMapper(TranslateMapper.class);
		result = translateMapper.addDic(lang1, lang2, bottype);	
		return result;	
	}
	@Override
	public final  int addTranslate(final long usrid, final int dicid,
			final int bottype, final int flag) {
		int result;
		TranslateMapper translateMapper = sqlSession.
				getMapper(TranslateMapper.class);
		result = translateMapper.addTranslate(usrid, dicid, bottype, flag);	
		return result;	
	}
}