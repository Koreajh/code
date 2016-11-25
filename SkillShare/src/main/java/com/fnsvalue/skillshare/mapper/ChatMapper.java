package com.fnsvalue.skillshare.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

public interface ChatMapper {
	 int Chatadd(@Param("chat_from")String CHAT_FROM, @Param("chat_to")String CHAT_TO, @Param("chat_msg")String CHAT_MSG, @Param("chat_dt")String CHAT_DT);
	 ArrayList<HashMap> Chatview(@Param("chat_from")String CHAT_FROM, @Param("chat_to")String CHAT_TO);
	 Integer Chatupdate(@Param("chat_from")String CHAT_FROM, @Param("chat_to")String CHAT_TO);
	 Integer Chatcount(@Param("chat_from")String CHAT_FROM, @Param("chat_to")String CHAT_TO);
}
