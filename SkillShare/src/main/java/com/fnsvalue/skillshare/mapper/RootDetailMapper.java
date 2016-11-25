package com.fnsvalue.skillshare.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import com.fnsvalue.skillshare.dto.User;

public interface RootDetailMapper {

	
	ArrayList<HashMap> UserDetailsView(String USER_ID_PK);
	ArrayList<HashMap> checkLoginView(@Param("user_id_pk")String USER_ID_PK,@Param("page_start")int PAGE_START,@Param("perpage_num")int PERPAGE_NUM);
	ArrayList<HashMap> checkLogDetailView(@Param("user_id_pk")String USER_TB_USER_ID_PK,@Param("page_start")int PAGE_START,@Param("perpage_num")int PERPAGE_NUM);
	Integer UserDelete(String USER_ID_PK);
	Integer UserBan(String USER_ID_PK);
	Integer UserBanCancel(String USER_ID_PK);
	Integer insertOutMem(@Param("user_id_pk") String OUTUSER_ID,@Param("user_out_rs") String OUTUSER_RS);
	int countLogPaging(String USER_ID_PK);
	int countLogDetailPaging(String USER_ID_PK);
}
