package com.fnsvalue.skillshare.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import com.fnsvalue.skillshare.dto.Board;

public interface NoticeMapper {

	ArrayList<HashMap> NoticeView(@Param("page_start") int PAGE_START, @Param("perpage_num") int PERPAGE_NUM);
	
	int noticeAdd(@Param("board_no_pk")int BOARD_NO_PK, @Param("user_tb_user_id_pk")String USER_TB_USER_ID_PK, 
			@Param("board_tit")String BOARD_TIT, @Param("board_con")String BOARD_CON);
	
	int noticeChange(@Param("board_no_pk")int BOARD_NO_PK, @Param("user_tb_user_id_pk")String USER_TB_USER_ID_PK, 
			@Param("board_tit")String BOARD_TIT, @Param("board_con")String BOARD_CON);

	
	int countPaging();
}
