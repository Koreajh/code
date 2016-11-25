package com.fnsvalue.skillshare.boimpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnsvalue.skillshare.bo.BoardBO;
import com.fnsvalue.skillshare.dao.BoardDAO;
import com.fnsvalue.skillshare.dto.Board;

@Service
public class BoardBOImpl implements BoardBO {
	
	@Autowired
	private BoardDAO boardDAO;

	
	public int boardAdd(int BOARD_NO_PK, String USER_TB_USER_ID_PK, String BOARD_TIT, String BOARD_CON, String MY_SK,
			String WANT_SK, String BOARD_DUR) {
		// TODO Auto-generated method stub
		return boardDAO.boardAdd(BOARD_NO_PK, USER_TB_USER_ID_PK, BOARD_TIT, BOARD_CON, MY_SK, WANT_SK, BOARD_DUR);
	}



	public int cntPlus(int BOARD_NO_PK)
	{
		return boardDAO.cntPlus(BOARD_NO_PK);
		
	}
	
	public ArrayList<HashMap> boardView(int PAGE_START,int PERPAGE_NUM) {
		// TODO Auto-generated method stub
		return boardDAO.boardView(PAGE_START, PERPAGE_NUM);
	}

	public int reportAdd(int REPORT_NUM,String REPORT_USER_ID,String REPORT_RS,String REPORT_CON)
	{
		return boardDAO.reportAdd(REPORT_NUM,REPORT_USER_ID,REPORT_RS,REPORT_CON);
	}
	
	
	
	public int reportCheck(int REPORT_NUM)
	{
		return boardDAO.reportCheck(REPORT_NUM);
		
	}

	public int countPaging() {
		// TODO Auto-generated method stub
		return boardDAO.countPaging();
	}
	
	public int viewOk(String USER_ID_PK)
	{
		return boardDAO.viewOk(USER_ID_PK);
	}



	public ArrayList<HashMap> boardDetails(int BOARD_NO_PK) {
		
		return boardDAO.boardDetails(BOARD_NO_PK);
	}



	public Integer boardDelete(int BOARD_NO_PK, String USER_TB_USER_ID_PK) {
		
		return boardDAO.boardDelete(BOARD_NO_PK, USER_TB_USER_ID_PK);
	}




	public int boardChange(int BOARD_NO_PK, String USER_TB_USER_ID_PK, String BOARD_TIT, String BOARD_CON, String MY_SK,
			String WANT_SK, String BOARD_DUR) {
		
		return boardDAO.boardChange(BOARD_NO_PK, USER_TB_USER_ID_PK, BOARD_TIT, BOARD_CON, MY_SK, WANT_SK, BOARD_DUR);
	}



	
	public ArrayList<HashMap> dashboardView() {
		// TODO Auto-generated method stub
		return boardDAO.dashboardView();
	}




	public Board perView(String USER_TB_USER_ID_PK) {
		// TODO Auto-generated method stub
		return boardDAO.perView(USER_TB_USER_ID_PK);
	}
	
	

}
