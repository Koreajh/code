package com.fnsvalue.skillshare.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnsvalue.skillshare.dao.UserQuestionBoardDAO;
import com.fnsvalue.skillshare.dto.Question;
import com.fnsvalue.skillshare.mapper.BoardMapper;
import com.fnsvalue.skillshare.mapper.QuestionMapper;

@Component
public class UserQuestionBoardDAOImpl implements UserQuestionBoardDAO {

	@Autowired
    private SqlSession sqlSession;
	
	
	public int QuestionAdd(String USER_TB_USER_ID_PK, String ASK_TIT, String ASK_CON) {
		int result;
		QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
		result=questionMapper.QuestionAdd(USER_TB_USER_ID_PK, ASK_TIT, ASK_CON);
				
		return result;
		
	}

	public ArrayList<HashMap> QuestionView(int PAGE_START,int PERPAGE_NUM) {
		ArrayList<HashMap> result;
		QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
		result=questionMapper.QuestionView(PAGE_START, PERPAGE_NUM);
				
		return result;
	}

	public int countPaging() {
		// TODO Auto-generated method stub
		int result;
		QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
		result=questionMapper.countPaging();
		return result;
	}

	public ArrayList<HashMap> QuestionDetailView(int ASK_NO_PK) {
		ArrayList<HashMap> result;
		QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
		result=questionMapper.QuestionDetailView(ASK_NO_PK);
				
		return result;
	}


	public int QuestionDelete(int ASK_NO_PK) {
		int result;
		QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
		result=questionMapper.QuestionDelete(ASK_NO_PK);
				
		return result;
	}

	@Override
	public int QuestionChange(int ASK_NO_PK, String ASK_TIT, String ASK_CON) {
		int result;
		QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
		result=questionMapper.QuestionChange(ASK_NO_PK, ASK_TIT, ASK_CON);
				
		return result;
	}
	
	
	
	
	public int viewOk(String USER_TB_USER_ID_PK){
		int result;
		QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
		result=questionMapper.viewOk(USER_TB_USER_ID_PK);
		
		return result;
	}

	@Override
	public ArrayList<HashMap> dashboardView() {
		ArrayList<HashMap> result;
		QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
		result=questionMapper.dashboardView();
		
		return result;
	}

	
}
