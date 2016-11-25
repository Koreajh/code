package com.fnsvalue.skillshare.boimpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnsvalue.skillshare.bo.NoticeDetailBO;
import com.fnsvalue.skillshare.dao.NoticeDetailsDAO;
import com.fnsvalue.skillshare.dto.Board;

@Service
public class NoticeDetailBOImpl implements NoticeDetailBO {
	
	@Autowired
	public NoticeDetailsDAO noticedetailsDAO;

	public ArrayList<HashMap> NoticeDetailsView(Board board)
	{
		return noticedetailsDAO.NoticeDetailsView(board);
	}
	public Integer NoticeDelete(int BOARD_NO_PK)
	{
		return noticedetailsDAO.NoticeDelete(BOARD_NO_PK);
	}
}
