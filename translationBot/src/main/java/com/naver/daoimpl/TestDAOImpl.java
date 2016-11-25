package com.naver.daoimpl;

import java.util.HashMap;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.naver.dao.TestDAO;
import com.naver.mapper.TestMapper;

@Component
public class TestDAOImpl implements TestDAO {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public final  int confirmIdWord(final long id, 
			final int bottype, final int flag) {
		int result;
		TestMapper testMapper = sqlSession.
				getMapper(TestMapper.class);
		result = testMapper.confirmIdWord(id, bottype, flag);
		return result;	
	}
	@Override
	public final  HashMap sendProblem(final long usrid, 
			final int bottype, final int flag) {
		HashMap result;
		TestMapper testMapper = sqlSession.
				getMapper(TestMapper.class);
		result = testMapper.sendProblem(usrid, bottype, flag);
		return result;	
	}
	@Override
	public final  int addTest(final long usrid, final int bottype,
			final String question) {
		int  result;
		TestMapper testMapper = sqlSession.
				getMapper(TestMapper.class);
		result = testMapper.addTest(usrid, bottype, question);
		return result;	
	}
	@Override
	public final  int updateFlag(final long usrid, final int flag,
			final int bottype) {
		int result;
		TestMapper testMapper = sqlSession.
				getMapper(TestMapper.class);
		result = testMapper.updateFlag(usrid, flag, bottype);
		return result;	
	}
	@Override
	public final  int confirmFlag(final long usrid , final int bottype) {
		int result;
		TestMapper testMapper = sqlSession.
				getMapper(TestMapper.class);
		result = testMapper.confirmFlag(usrid, bottype);
		return result;	
	}
	@Override
	public final  String[] confirmAnswerR(final long usrid, final int bottype) {
		String[] result;
		TestMapper testMapper = sqlSession.
				getMapper(TestMapper.class);
		result = testMapper.confirmAnswerR(usrid, bottype);
		return result;		
	}
	@Override
	public final  String[] confirmAnswerL(final long usrid, final int bottype) {
		String[] result;
		TestMapper testMapper = sqlSession.
				getMapper(TestMapper.class);
		result = testMapper.confirmAnswerL(usrid, bottype);
		return result;		
	}
	@Override
	public final  int updateRw(final long usrid, final int bottype,
			final int rw) {
		int result;
		TestMapper testMapper = sqlSession.
				getMapper(TestMapper.class);
		result = testMapper.updateRw(usrid, bottype, rw);
		return result;			
	}
}