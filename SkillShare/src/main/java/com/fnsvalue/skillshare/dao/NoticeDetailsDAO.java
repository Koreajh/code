package com.fnsvalue.skillshare.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.fnsvalue.skillshare.dto.Board;

public interface NoticeDetailsDAO {

	public ArrayList<HashMap> NoticeDetailsView(Board board);
	public Integer NoticeDelete(int BOARD_NO_PK);
	
	
}
