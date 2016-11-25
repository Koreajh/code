package com.fnsvalue.skillshare.daoimpl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnsvalue.skillshare.dao.LoginDAO;
import com.fnsvalue.skillshare.dto.User;
import com.fnsvalue.skillshare.mapper.BoardMapper;
import com.fnsvalue.skillshare.mapper.LoginMapper;

@Component
public class LoginDAOImpl implements LoginDAO {
    
	@Autowired
    private SqlSession sqlSession;

	public User findByUserIdAndPassword(User user) {
		User result = new User();
        LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
        result = loginMapper.findByUserIdAndPassword(user);
        return result;
	}
	
		public int checkLogin(String IP,String USER_ID_PK)
	{
		int result;
		LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
		result=loginMapper.checkLogin(IP,USER_ID_PK);
				
		return result;
	}
		

		public int checkDetail(String USER_ID_PK,String ACCLOG_SQ_PK,String IP,String ACCLOG_PAGE,String ACCLOG_INF)
		{
			int result;
			LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
			result=loginMapper.checkDetail(USER_ID_PK,ACCLOG_SQ_PK,IP,ACCLOG_PAGE,ACCLOG_INF);
					
			return result;
			
		}

	@Override
	public User getUsersByID(String user_id_pk) {
		User result = new User();
        LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
        result = loginMapper.getUsersByID(user_id_pk);
		return null;
	}

}
