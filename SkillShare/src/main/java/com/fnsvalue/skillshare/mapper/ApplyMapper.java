package com.fnsvalue.skillshare.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

public interface ApplyMapper {
	 int applyAdd(int APPLY_NO_PK, @Param("user_tb_user_id_pk")String USER_TB_USER_ID_PK, @Param("board_tb_board_no_pk")int BOARD_TB_BOARD_NO_PK );
	 String applyGetId(@Param("user_tb_user_id_pk")String USER_TB_USER_ID_PK, @Param("board_tb_board_no_pk")int BOARD_TB_BOARD_NO_PK );
	 ArrayList<HashMap> applyView(int BOARD_TB_BOARD_NO_PK);
	 int applyAgree(int APPLY_NO_PK);
	 int applyDisAgree(int APPLY_NO_PK);
	 int applyDelete(@Param("user_tb_user_id_pk")String USER_TB_USER_ID_PK, @Param("board_tb_board_no_pk")int BOARD_TB_BOARD_NO_PK);
	 ArrayList<HashMap> applyPerView(@Param("user_tb_user_id_pk")String USER_TB_USER_ID_PK, @Param("page_start") int PAGE_START, @Param("perpage_num") int PERPAGE_NUM);
	 int countPaging();
	 int applyAgreeDelete(int APPLY_NO_PK);
	 int applyCount(@Param("board_tb_board_no_pk")int BOARD_TB_BOARD_NO_PK,@Param("user_tb_user_id_pk")String USER_TB_USER_ID_PK);
		

}
