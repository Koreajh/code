package com.fnsvalue.skillshare.bo;


public interface JoinBO {
	public Integer findByUserJoin(String USER_ID_PK, String USER_PW,String USER_NM,String USER_EM,String USER_FILE_NM);
	public int doubleCheck (String USER_ID_PK); 
	
}
