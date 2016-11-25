package com.fnsvalue.skillshare.bo;

import java.util.ArrayList;
import java.util.HashMap;

public interface ApplyBO {
	public int applyAdd(int APPLY_NO_PK, String USER_TB_USER_ID_PK, int BOARD_TB_BOARD_NO_PK);
	public String applyGetId(String USER_TB_USER_ID_PK, int BOARD_TB_BOARD_NO_PK);
	public ArrayList<HashMap> applyView(int BOARD_TB_BOARD_NO_PK);
	public int applyAgree(int APPLY_NO_PK);
	public int applyDisAgree(int APPLY_NO_PK);
	public int applyDelete(String USER_TB_USER_ID_PK, int BOARD_TB_BOARD_NO_PK);
	public ArrayList<HashMap> applyPerView(String USER_TB_USER_ID_PK, int PAGE_START, int PERPAGE_NUM);
	public int countPaging();
	public int applyAgreeDelete(int APPLY_NO_PK);
	
	public int applyCount(int BOARD_TB_BOARD_NO_PK,String USER_TB_USER_ID_PK);
}
