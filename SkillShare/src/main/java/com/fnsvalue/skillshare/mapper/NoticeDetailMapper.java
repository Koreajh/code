package com.fnsvalue.skillshare.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.annotation.MapperScan;

import com.fnsvalue.skillshare.dto.Board;

public interface NoticeDetailMapper {
	ArrayList<HashMap> NoticeDetailsView(Board board);
	Integer NoticeDelete(int BOARD_NO_PK);
}
