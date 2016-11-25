package com.fnsvalue.skillshare.boimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnsvalue.skillshare.bo.JoinBO;
import com.fnsvalue.skillshare.dao.JoinDAO;

@Service
public class JoinBOImpl implements JoinBO {

	@Autowired
private JoinDAO joinDAO;
	
	public Integer findByUserJoin(String USER_ID_PK, String USER_PW,String USER_NM,String USER_EM,String USER_FILE_NM) 
	{
		return joinDAO.findByUserJoin(USER_ID_PK,USER_PW,USER_NM,USER_EM,USER_FILE_NM);
	}
	
	public int doubleCheck (String USER_ID_PK)
	{
		return joinDAO.doubleCheck(USER_ID_PK);
		
	}
}
