package com.fnsvalue.skillshare.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnsvalue.skillshare.dao.LoginDAO;
import com.fnsvalue.skillshare.dto.User;

@Service
public class LoginBOImpl implements LoginBO {
	@Autowired
	private LoginDAO loginDAO;
	
	public User findByUserIdAndPassword(String user_id_pk, String user_pw) {
		return loginDAO.findByUserIdAndPassword(user_id_pk, user_pw);
	}
}
