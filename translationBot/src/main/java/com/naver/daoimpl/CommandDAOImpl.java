package com.naver.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.naver.dao.CommandDAO;
import com.naver.mapper.CommandMapper;

@Component
public class CommandDAOImpl implements CommandDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public final  int deleteDateWords(final long id, 
			final int date, final int bottype) {
		int result;
		CommandMapper commandMapper = sqlSession.
				getMapper(CommandMapper.class);
		result = commandMapper.deleteDateWords(id, date, bottype);
		return result;		
	}
	@Override
	public final  int deleteWords(final long id,
			final String word, final int bottype) {
		int result;
		CommandMapper commandMapper = sqlSession.
				getMapper(CommandMapper.class);
		result = commandMapper.deleteWords(id, word, bottype);
		return result;	
	}
	@Override
	public final  ArrayList<HashMap> selectPeriodWords(final long id,
			final String predate, final String afterdate, final int bottype) {
		ArrayList<HashMap> result;
		CommandMapper commandMapper = sqlSession.
				getMapper(CommandMapper.class);
		result = commandMapper.selectPeriodWords(id,
				predate, afterdate, bottype);
		return result;		
	}
	@Override
	public final  ArrayList<HashMap> selectWrongWords(final long id,
			final String predate, final String afterdate, final int bottype) {
		ArrayList<HashMap> result;
		CommandMapper commandMapper = sqlSession.
				getMapper(CommandMapper.class);	
		result = commandMapper.selectWrongWords(id,
				predate, afterdate, bottype);
		return result;		
	}
}