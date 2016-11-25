package com.fnsvalue.skillshare.mapper;

import org.apache.ibatis.annotations.Param;

public interface ChangeInfoMapper {
	Integer changeinfoUser(@Param("user_id_pk")String USER_ID_PK, @Param("user_pw")String USER_PW,@Param("user_nm")String USER_NM,@Param("user_em")String USER_EM,@Param("user_file_nm")String USER_FILE_NM);
}

