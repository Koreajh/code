package com.fnsvalue.skillshare.boimpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnsvalue.skillshare.bo.UserQuestionBoardBo;
import com.fnsvalue.skillshare.dao.RootManagerDAO;
import com.fnsvalue.skillshare.dao.UserQuestionBoardDAO;
import com.fnsvalue.skillshare.dto.Question;
@Service
public class UserQuestionBoardBoImpl implements UserQuestionBoardBo {

	@Autowired
	public UserQuestionBoardDAO userQuestionBoardDAO;
	

	public int QuestionAdd(String USER_TB_USER_ID_PK, String ASK_TIT, String ASK_CON) {
		// TODO Auto-generated method stub
		return userQuestionBoardDAO.QuestionAdd(USER_TB_USER_ID_PK, ASK_TIT, ASK_CON);
		
	}
	public ArrayList<HashMap> QuestionView(int PAGE_START,int PERPAGE_NUM) 
	{
		// TODO Auto-generated method stub
		return userQuestionBoardDAO.QuestionView(PAGE_START, PERPAGE_NUM);
	}

	public int countPaging() 
	{
		// TODO Auto-generated method stub
		return userQuestionBoardDAO.countPaging();
	}

	public ArrayList<HashMap> QuestionDetailView(int ASK_NO_PK) {
		// TODO Auto-generated method stub
		return userQuestionBoardDAO.QuestionDetailView(ASK_NO_PK);
	}

	
	public int QuestionDelete(int ASK_NO_PK) {
		
		return userQuestionBoardDAO.QuestionDelete(ASK_NO_PK);
		
	}
	@Override
	public int QuestionChange(int ASK_NO_PK, String ASK_TIT, String ASK_CON) {
		
		return userQuestionBoardDAO.QuestionChange(ASK_NO_PK, ASK_TIT, ASK_CON);
		
	}
	@Override
	public ArrayList<HashMap> dashboardView() {
		// TODO Auto-generated method stub
		return userQuestionBoardDAO.dashboardView();
	}
	
	@Override
	public int viewOk(String USER_TB_USER_ID_PK)
	{
		return userQuestionBoardDAO.viewOk(USER_TB_USER_ID_PK);
		
	}
	
	

	

}
