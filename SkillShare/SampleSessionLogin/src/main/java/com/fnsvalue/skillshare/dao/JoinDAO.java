package com.fnsvalue.skillshare.dao;

public interface JoinDAO {
	public Integer findByUserJoin(String USER_ID_PK, String USER_PW,String USER_NM,String USER_EM);
}
