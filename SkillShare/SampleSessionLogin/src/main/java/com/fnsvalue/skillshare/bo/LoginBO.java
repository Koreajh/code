package com.fnsvalue.skillshare.bo;

import com.fnsvalue.skillshare.dto.User;

public interface LoginBO {
	public User findByUserIdAndPassword(String user_id_pk, String user_pw);
}
