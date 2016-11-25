package com.naver.mapper;

import java.util.HashMap;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {
	int confirmIdWord(@Param("usrid")long usr_id, 
			@Param("bottype")int bottype, @Param("flag")int flag);
	HashMap sendProblem(@Param("usrid")long usrid, @Param("bottype")int bottype,
			@Param("flag")int flag);
	int addTest(@Param("usrid")long usrid, @Param("bottype") int bottype,
			@Param("question")String question);
	int updateFlag(@Param("usrid")long usrid, @Param("flag")int flag,
			@Param("bottype") int bottype);
	String[] confirmAnswerR(@Param("usrid")long usrid,
			@Param("bottype") int bottype);
	String[] confirmAnswerL(@Param("usrid")long usrid,
			@Param("bottype") int bottype);
	int confirmFlag(@Param("usrid")long usrid, @Param("bottype")int bottype);
	int updateRw(@Param("usrid")long usrid, @Param("bottype")int bottype, 
			@Param("rw") int rw);	
}
