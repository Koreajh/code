package com.fnsvalue.skillshare.bo;

import java.util.ArrayList;
import java.util.HashMap;

import com.fnsvalue.skillshare.dto.Question;

public interface UserQuestionBoardBo {
	public int QuestionAdd(String USER_TB_USER_ID_PK, String ASK_TIT, String ASK_CON);
	public ArrayList<HashMap> QuestionView(int PAGE_START,int PERPAGE_NUM);
	public ArrayList<HashMap> QuestionDetailView(int ASK_NO_PK);
	public int viewOk(String USER_TB_USER_ID_PK);
	public int countPaging();
	public int QuestionDelete(int ASK_NO_PK);
	public int QuestionChange(int ASK_NO_PK, String ASK_TIT, String ASK_CON);
	public ArrayList<HashMap> dashboardView();
}
