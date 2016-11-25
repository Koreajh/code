package com.fnsvalue.skillshare.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnsvalue.skillshare.dao.ApplyDAO;
import com.fnsvalue.skillshare.mapper.ApplyMapper;


@Component
public class ApplyDAOImpl implements ApplyDAO {
	@Autowired
    private SqlSession sqlSession;

	public int applyAdd(int APPLY_NO_PK, String USER_TB_USER_ID_PK, int BOARD_TB_BOARD_NO_PK) {
		int result;
		ApplyMapper applyMapper = sqlSession.getMapper(ApplyMapper.class);
		result=applyMapper.applyAdd(APPLY_NO_PK, USER_TB_USER_ID_PK, BOARD_TB_BOARD_NO_PK);
				
		return result;
	}

	public ArrayList<HashMap> applyView(int BOARD_TB_BOARD_NO_PK) {
		ArrayList<HashMap> result;
		ApplyMapper applyMapper = sqlSession.getMapper(ApplyMapper.class);
		result=applyMapper.applyView(BOARD_TB_BOARD_NO_PK);
				
		return result;
	}

	
	public int applyAgree(int APPLY_NO_PK) {
		int result;
		ApplyMapper applyMapper = sqlSession.getMapper(ApplyMapper.class);
		result=applyMapper.applyAgree(APPLY_NO_PK);
				
		return result;
	}
	

	public int applyCount(int BOARD_TB_BOARD_NO_PK,String USER_TB_USER_ID_PK)
	{
		int result;
		ApplyMapper applyMapper = sqlSession.getMapper(ApplyMapper.class);
		result=applyMapper.applyCount(BOARD_TB_BOARD_NO_PK,USER_TB_USER_ID_PK);
				
		return result;
	
		
	}

	
	public int applyDisAgree(int APPLY_NO_PK) {
		int result;
		ApplyMapper applyMapper = sqlSession.getMapper(ApplyMapper.class);
		result=applyMapper.applyDisAgree(APPLY_NO_PK);
				
		return result;
	}

	
	public int applyDelete(String USER_TB_USER_ID_PK, int BOARD_TB_BOARD_NO_PK) {
		int result;
		ApplyMapper applyMapper = sqlSession.getMapper(ApplyMapper.class);
		result=applyMapper.applyDelete(USER_TB_USER_ID_PK, BOARD_TB_BOARD_NO_PK);
				
		return result;
	}

	
	public ArrayList<HashMap> applyPerView(String USER_TB_USER_ID_PK, int PAGE_START, int PERPAGE_NUM) {
		ArrayList<HashMap> result;
		ApplyMapper applyMapper = sqlSession.getMapper(ApplyMapper.class);
		result=applyMapper.applyPerView(USER_TB_USER_ID_PK, PAGE_START, PERPAGE_NUM);
		return result;
	}
	
	public int countPaging() {
		int result;
		ApplyMapper applyMapper = sqlSession.getMapper(ApplyMapper.class);
		result=applyMapper.countPaging();
				
		return result;
	}

	
	public int applyAgreeDelete(int APPLY_NO_PK) {
		int result;
		ApplyMapper applyMapper = sqlSession.getMapper(ApplyMapper.class);
		result=applyMapper.applyAgreeDelete(APPLY_NO_PK);
				
		return result;
	}

	@Override
	public String applyGetId(String USER_TB_USER_ID_PK, int BOARD_TB_BOARD_NO_PK) {
		ApplyMapper applyMapper = sqlSession.getMapper(ApplyMapper.class);
		System.out.println(USER_TB_USER_ID_PK +" / "+BOARD_TB_BOARD_NO_PK);
		return applyMapper.applyGetId(USER_TB_USER_ID_PK,BOARD_TB_BOARD_NO_PK);
	}



}
