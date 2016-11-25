package com.fnsvalue.skillshare.bo;

import java.util.ArrayList;
import java.util.HashMap;

import com.fnsvalue.skillshare.dto.Board;

public interface BoardBO {
	
	public int boardAdd(int BOARD_NO_PK, String USER_TB_USER_ID_PK, 
			String BOARD_TIT, String BOARD_CON, String MY_SK, String WANT_SK, String BOARD_DUR);
	
	public ArrayList<HashMap> boardView(int PAGE_START,int PERPAGE_NUM);
	public int countPaging();
	
	public int viewOk(String USER_ID_PK);
	
	public ArrayList<HashMap> boardDetails(int BOARD_NO_PK);
	
	public Integer boardDelete(int BOARD_NO_PK, String USER_TB_USER_ID_PK);
	
	public int cntPlus(int BOARD_NO_PK);
	
	
	public int boardChange(int BOARD_NO_PK, String USER_TB_USER_ID_PK, 
			String BOARD_TIT, String BOARD_CON, String MY_SK, String WANT_SK, String BOARD_DUR);
	public ArrayList<HashMap> dashboardView();

	
	
	public int reportAdd(int REPORT_NUM,String REPORT_USER_ID,String REPORT_RS,String REPORT_CON);
	
	
	public int reportCheck(int REPORT_NUM);
  
	
	public Board perView(String USER_TB_USER_ID_PK);


}
