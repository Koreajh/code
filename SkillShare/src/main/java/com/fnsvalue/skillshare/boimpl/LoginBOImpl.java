package com.fnsvalue.skillshare.boimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnsvalue.skillshare.bo.LoginBO;
import com.fnsvalue.skillshare.dao.LoginDAO;
import com.fnsvalue.skillshare.dto.User;

@Service
public class LoginBOImpl implements LoginBO {
	@Autowired
	private LoginDAO loginDAO;
	
	public User findByUserIdAndPassword(User user) {
		return loginDAO.findByUserIdAndPassword(user);
	}
	
	public int checkLogin(String IP,String USER_ID_PK){
		return loginDAO.checkLogin(IP,USER_ID_PK);
	}
	
	public int checkDetail(String USER_ID_PK,String ACCLOG_SQ_PK,String IP,String ACCLOG_PAGE,String ACCLOG_INF)
	{
		return loginDAO.checkDetail(USER_ID_PK,ACCLOG_SQ_PK,IP,ACCLOG_PAGE,ACCLOG_INF);

	}
	
	
	@Override
	public User getUsersByID(String user_id_pk) {
		// TODO Auto-generated method stub
		return loginDAO.getUsersByID(user_id_pk);
	}
	
}
