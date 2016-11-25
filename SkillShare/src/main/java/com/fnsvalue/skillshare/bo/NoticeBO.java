package com.fnsvalue.skillshare.bo;

import java.util.ArrayList;
import java.util.HashMap;

import com.fnsvalue.skillshare.dto.Board;

public interface NoticeBO {

	public ArrayList<HashMap> NoticeView(int PAGE_START,int PERPAGE_NUM);
	
	public int noticeAdd(int BOARD_NO_PK, String USER_TB_USER_ID_PK, 
			String BOARD_TIT, String BOARD_CON);
	
	
	public int noticeChange(int BOARD_NO_PK, String USER_TB_USER_ID_PK, 
			String BOARD_TIT, String BOARD_CON);

	
	public int countPaging();
	
	
}
