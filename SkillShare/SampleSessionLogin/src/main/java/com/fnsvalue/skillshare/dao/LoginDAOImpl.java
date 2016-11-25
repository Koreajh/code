package com.fnsvalue.skillshare.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Component;

import com.fnsvalue.skillshare.dto.User;

@Component
public class LoginDAOImpl implements LoginDAO {
    
    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;

	public User findByUserIdAndPassword(String user_id_pk, String user_pw) {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("user_id_pk", user_id_pk);
        paramMap.put("user_pw", user_pw);

        return (User) sqlMapClientTemplate.queryForObject("login.selectLoginUser", paramMap);
	}

}
