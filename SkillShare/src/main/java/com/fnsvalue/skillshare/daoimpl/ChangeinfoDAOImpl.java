package com.fnsvalue.skillshare.daoimpl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.ibatis.session.SqlSession;

import com.fnsvalue.skillshare.dao.ChangeinfoDAO;
import com.fnsvalue.skillshare.mapper.ChangeInfoMapper;

@Component
public class ChangeinfoDAOImpl implements ChangeinfoDAO{

	@Autowired
	private SqlSession sqlSession;
	
	public Integer changeinfoUser(String USER_ID_PK, String USER_PW, String USER_NM, String USER_EM,String USER_FILE_NM)
	{
		int result;
		ChangeInfoMapper loginMapper = sqlSession.getMapper(ChangeInfoMapper.class);
		result = loginMapper.changeinfoUser(USER_ID_PK,USER_PW,USER_NM,USER_EM,USER_FILE_NM);
		return result;
	    		 
	}
	
	
}
