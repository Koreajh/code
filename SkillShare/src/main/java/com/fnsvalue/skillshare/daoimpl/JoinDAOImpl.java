package com.fnsvalue.skillshare.daoimpl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnsvalue.skillshare.dao.JoinDAO;
import com.fnsvalue.skillshare.mapper.JoinMapper;

@Component
public class JoinDAOImpl implements JoinDAO{

	@Autowired
	private SqlSession sqlSession;
	
	public Integer findByUserJoin(String USER_ID_PK, String USER_PW,String USER_NM,String USER_EM,String USER_FILE_NM)
	{
	
		int result;
		
		JoinMapper joinMapper=sqlSession.getMapper(JoinMapper.class); 
	    result= joinMapper.findByUserJoin(USER_ID_PK, USER_PW, USER_NM, USER_EM, USER_FILE_NM); 
	     return  result;
	    		 
	}
	
	public int doubleCheck (String USER_ID_PK)
	{
		int result;
		JoinMapper joinMapper=sqlSession.getMapper(JoinMapper.class); 
	    result= joinMapper.doubleCheck(USER_ID_PK); 
	     return  result;
	    
		
	}
	
	
}
