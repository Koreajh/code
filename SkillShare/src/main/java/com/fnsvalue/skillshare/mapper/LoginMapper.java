package com.fnsvalue.skillshare.mapper;


import org.apache.ibatis.annotations.Param;

import com.fnsvalue.skillshare.dto.User;

public interface LoginMapper {

	User findByUserIdAndPassword(User user);
	int checkLogin(@Param("loginlog_user_ip") String IP,@Param("user_id_pk") String USER_ID_PK);
	int checkDetail(@Param("user_id_pk") String USER_ID_PK,@Param("acclog_sq_pk")String ACCLOG_SQ_PK,@Param("loginlog_user_ip")String IP,@Param("acclog_page")String ACCLOG_PAGE,@Param("acclog_inf")String ACCLOG_INF);
	User getUsersByID(String user_id_pk);
}

