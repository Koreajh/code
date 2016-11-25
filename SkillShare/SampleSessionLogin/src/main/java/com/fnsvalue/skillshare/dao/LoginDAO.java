package com.fnsvalue.skillshare.dao;

import com.fnsvalue.skillshare.dto.User;

public interface LoginDAO {
	public User findByUserIdAndPassword(String user_id_pk, String user_pw);
}
