package com.fnsvalue.skillshare.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fnsvalue.skillshare.dao.RootDetailsManagerDAO;
import com.fnsvalue.skillshare.dto.User;
import com.fnsvalue.skillshare.mapper.ApplyMapper;
import com.fnsvalue.skillshare.mapper.LoginMapper;
import com.fnsvalue.skillshare.mapper.RootDetailMapper;
import com.fnsvalue.skillshare.mapper.RootManagerMapper;

@Component
public class RootDetailsManagerDAOImpl implements RootDetailsManagerDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public ArrayList<HashMap> UserDetailsView(String USER_ID_PK)
	{
		
		ArrayList<HashMap> result;
        RootDetailMapper rootDetailMapper=sqlSession.getMapper(RootDetailMapper.class);
        result = rootDetailMapper.UserDetailsView(USER_ID_PK);
        return result;
		
	}
	
	public Integer UserDelete(String USER_ID_PK) {
		
		int result;
		RootDetailMapper rootDetailMapper = sqlSession.getMapper(RootDetailMapper.class);
		result = rootDetailMapper.UserDelete(USER_ID_PK);
		return result;
	}
	
	public Integer UserBan(String USER_ID_PK){
	int result;
	RootDetailMapper rootDetailMapper = sqlSession.getMapper(RootDetailMapper.class);
	result = rootDetailMapper.UserBan(USER_ID_PK);
	return result;
	}
	
	public Integer UserBanCancel(String USER_ID_PK)
	{
		int result;
		RootDetailMapper rootDetailMapper = sqlSession.getMapper(RootDetailMapper.class);
		result = rootDetailMapper.UserBanCancel(USER_ID_PK);
		return result;
		
	}

	
	

	public ArrayList<HashMap> checkLoginView(String USER_ID_PK,int PAGE_START, int PERPAGE_NUM)
	{
		ArrayList<HashMap> result;
        RootDetailMapper rootDetailMapper=sqlSession.getMapper(RootDetailMapper.class);
        result = rootDetailMapper.checkLoginView(USER_ID_PK,PAGE_START,PERPAGE_NUM);
        return result;
		
	}
	
	public int countLogPaging(String USER_ID_PK)
	{
		int result;
		RootDetailMapper rootDetailMapper = sqlSession.getMapper(RootDetailMapper.class);
		result=rootDetailMapper.countLogPaging(USER_ID_PK);
		return result;
	}
	

	public int countLogDetailPaging(String USER_ID_PK)
	{
		int result;
		RootDetailMapper rootDetailMapper = sqlSession.getMapper(RootDetailMapper.class);
		result=rootDetailMapper.countLogDetailPaging(USER_ID_PK);
		return result;

	}
	

	public ArrayList<HashMap> checkLogDetailView(String USER_TB_USER_ID_PK,int PAGE_START, int PERPAGE_NUM)
	{
		ArrayList<HashMap> result;
        RootDetailMapper rootDetailMapper=sqlSession.getMapper(RootDetailMapper.class);
        result = rootDetailMapper.checkLogDetailView(USER_TB_USER_ID_PK,PAGE_START,PERPAGE_NUM);
        return result;
	
		
	}
	


	public Integer insertOutMem(String OUTUSER_ID,String OUTUSER_RS)
	{
		int result;
		RootDetailMapper rootDetailMapper = sqlSession.getMapper(RootDetailMapper.class);
		result=rootDetailMapper.insertOutMem(OUTUSER_ID,OUTUSER_RS);
				
		return result;
		
	}
}
