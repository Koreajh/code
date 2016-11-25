package com.fnsvalue.skillshare.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import com.fnsvalue.skillshare.dto.User;

public interface RootManagerMapper {
	
	
	ArrayList<HashMap> UserView(@Param("page_start") int PAGE_START, @Param("perpage_num") int PERPAGE_NUM);
	int countPaging();
	

}
