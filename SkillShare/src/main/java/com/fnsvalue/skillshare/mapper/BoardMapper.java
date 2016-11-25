package com.fnsvalue.skillshare.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.fnsvalue.skillshare.dto.Board;


public interface BoardMapper {
	 int boardAdd(@Param("board_no_pk") int BOARD_NO_PK,@Param("user_tb_user_id_pk") String USER_TB_USER_ID_PK, 
			 @Param("board_tit") String BOARD_TIT,@Param("board_con") String BOARD_CON,@Param("my_sk") String MY_SK,@Param("want_sk") String WANT_SK,@Param("board_dur") String BOARD_DUR);

	 ArrayList<HashMap> boardView(@Param("page_start") int PAGE_START, @Param("perpage_num") int PERPAGE_NUM);
	 
	 int countPaging();
	
	 ArrayList<HashMap> boardDetails(@Param("board_no_pk")int BOARD_NO_PK);
	 
	 int viewOk(String USER_ID_PK);
	 
	 int reportAdd(@Param("board_no_pk")int REPORT_NUM,@Param("report_id")String REPORT_USER_ID,@Param("report_rs")String REPORT_RS,@Param("report_con")String REPORT_CON);
		
		
	 int reportCheck(@Param("board_no_pk")int REPORT_NUM);
			
	
	 Integer boardDelete(@Param("board_no_pk")int BOARD_NO_PK, @Param("user_tb_user_id_pk")String USER_TB_USER_ID_PK);
	
	 int boardChange(@Param("board_no_pk")int BOARD_NO_PK, @Param("user_tb_user_id_pk")String USER_TB_USER_ID_PK, 
			 @Param("board_tit")String BOARD_TIT, @Param("board_con")String BOARD_CON, @Param("my_sk")String MY_SK, @Param("want_sk")String WANT_SK, @Param("board_dur")String BOARD_DUR);
	
	 ArrayList<HashMap> dashboardView();
	 
	 Board perView(@Param("user_tb_user_id_pk")String USER_TB_USER_ID_PK);
	 
	 int cntPlus(@Param("board_no_pk")int BOARD_NO_PK);
		


}
