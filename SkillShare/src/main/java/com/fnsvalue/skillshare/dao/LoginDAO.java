package com.fnsvalue.skillshare.dao;

import com.fnsvalue.skillshare.dto.User;

public interface LoginDAO {
	public User findByUserIdAndPassword(User user);
	public int checkLogin(String IP,String USER_ID_PK);
	public User getUsersByID(String user_id_pk);
	public int checkDetail(String USER_ID_PK,String ACCLOG_SQ_PK,String IP,String ACCLOG_PAGE,String ACCLOG_INF);
	
}
