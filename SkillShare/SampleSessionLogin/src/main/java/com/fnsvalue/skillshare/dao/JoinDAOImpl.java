package com.fnsvalue.skillshare.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;

@Component
public class JoinDAOImpl implements JoinDAO{

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public Integer findByUserJoin(String USER_ID_PK, String USER_PW,String USER_NM,String USER_EM)
	{
		 Map<String, String> paramMap = new HashMap<String, String>();
		 
		 paramMap.put("user_id_pk", USER_ID_PK);
	     paramMap.put("user_pw", USER_PW);
	     paramMap.put("user_nm", USER_NM);
	     paramMap.put("user_em", USER_EM);
	     return sqlMapClientTemplate.update("join.joinUser", paramMap);
	    		 
	}
	
	
}
