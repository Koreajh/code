package com.naver.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.annotations.Param;

public interface CommandMapper {
	
	int deleteDateWords(@Param("usrid")long id, @Param("date")int date,
			@Param("bottype") int bottype);
	int deleteWords(@Param("usrid")long id, @Param("word")String word,
			@Param("bottype") int bottype);
	ArrayList<HashMap> selectWrongWords(@Param("usrid")long usrid, 
	@Param("predate")String predate, @Param("afterdate")String afterdate,
		@Param("bottype") int bottype);
	ArrayList<HashMap> selectPeriodWords(@Param("usrid")long usrid, 
			@Param("predate")String predate, 
			@Param("afterdate")String afterdate, @Param("bottype") int bottype);	
}