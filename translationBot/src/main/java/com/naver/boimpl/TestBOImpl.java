package com.naver.boimpl;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.naver.bo.TestBO;
import com.naver.dao.TestDAO;


@Service
public class TestBOImpl implements TestBO {

	@Autowired
	private TestDAO testDAO;
	
	@Override
	public final  int confirmIdWord(final long id, final int bottype,
			final int flag) {
		return testDAO.confirmIdWord(id, bottype, flag);								
	}
	@Override
	public final  HashMap sendProblem(final long usrid, 
			final int bottype, final int flag) {
		return testDAO.sendProblem(usrid, bottype, flag);		
	}
	@Override
	public final  int addTest(final long usrid, final int bottype,
			final String question) {
		return testDAO.addTest(usrid, bottype, question);				
	}
	@Override
	public final  int updateFlag(final long usrid, final int flag,
			final int bottype) {
		return testDAO.updateFlag(usrid, flag, bottype);				
	}
	@Override
	public final  int confirmFlag(final long usrid, final int bottype) {
		return testDAO.confirmFlag(usrid, bottype);				
	}
	@Override
	public final  String[] confirmAnswerR(final long usrid, final int bottype) {
		return testDAO.confirmAnswerR(usrid, bottype);				
	}
	@Override
	public final  String[] confirmAnswerL(final long usrid, final int bottype) {
		return testDAO.confirmAnswerL(usrid, bottype);				
	}
	@Override
	public final  int updateRw(final long usrid,
			final int bottype, final int rw) {
		return testDAO.updateRw(usrid, bottype, rw);						
	}
}
