package com.fnsvalue.skillshare.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

public interface QuestionMapper {

	
	
	 int QuestionAdd(@Param("user_tb_user_id_pk")String USER_TB_USER_ID_PK, @Param("ask_tit")String ASK_TIT,@Param("ask_con") String ASK_CON);
	 ArrayList<HashMap> QuestionView(@Param("page_start")int PAGE_START,@Param("perpage_num")int PERPAGE_NUM);
	 ArrayList<HashMap> QuestionDetailView(int ASK_NO_PK);
	 int countPaging();
	 int QuestionDelete(int ASK_NO_PK);
	 int QuestionChange(@Param("ask_no_pk")int ASK_NO_PK, @Param("ask_tit")String ASK_TIT, @Param("ask_con")String ASK_CON);
	 ArrayList<HashMap> dashboardView();
	 int viewOk(String USER_TB_USER_ID_PK);
		
}
