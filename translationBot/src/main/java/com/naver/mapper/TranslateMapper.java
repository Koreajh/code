package com.naver.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.annotations.Param;
public interface TranslateMapper {
	int confirmId(@Param("id")long id, @Param("bottype")int bottype);
	int confirmDicR(@Param("bottype")int bottype, @Param("lang") String lang);
	int confirmDicL(@Param("bottype")int bottype, @Param("lang") String lang);
	ArrayList<HashMap> selectDicL(@Param("bottype")int bottype,
			@Param("lang")String lang);
	ArrayList<HashMap> selectDicR(@Param("bottype")int bottype,
			@Param("lang")String lang);
	int confirmTrans(@Param("usrid")long usrid, @Param("dicid")int dicid,
			@Param("bottype")int bottype, @Param("flag")int flag);
	int addDic(@Param("lang1")String lang1, @Param("lang2")String lang2,
			@Param("bottype")int bottype);
	int addTranslate(@Param("usrid")long usrid, @Param("dicid")int dicid,
			@Param("bottype")int bottype, @Param("flag")int flag);
}
