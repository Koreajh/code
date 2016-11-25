package com.fnsvalue.skillshare.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.ibatis.session.SqlSession;
import com.fnsvalue.skillshare.dao.RootManagerDAO;
import com.fnsvalue.skillshare.dto.User;
import com.fnsvalue.skillshare.mapper.RootManagerMapper;

@Component
public class RootManagerDAOImpl implements RootManagerDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public ArrayList<HashMap> UserView(int PAGE_START,int PERPAGE_NUM)
	{
		ArrayList<HashMap> result;
		
		 RootManagerMapper rootmanagerMapper = sqlSession.getMapper(RootManagerMapper.class);
		 result=rootmanagerMapper.UserView(PAGE_START, PERPAGE_NUM);
        return result;
		
	}
	
	public int countPaging()  
	{
		int result;
		RootManagerMapper rootManagerMapper = sqlSession.getMapper(RootManagerMapper.class);
		result=rootManagerMapper.countPaging();
		return result;
	}
	
	
	
	
}
