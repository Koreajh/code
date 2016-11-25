package com.fnsvalue.skillshare.bo;

import java.util.ArrayList;
import java.util.HashMap;

import com.fnsvalue.skillshare.dto.Board;

public interface NoticeDetailBO {

	
	public ArrayList<HashMap> NoticeDetailsView(Board board);
	public Integer NoticeDelete(int BOARD_NO_PK);
}
