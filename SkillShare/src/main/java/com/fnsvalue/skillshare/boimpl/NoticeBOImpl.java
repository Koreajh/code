package com.fnsvalue.skillshare.boimpl;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnsvalue.skillshare.bo.NoticeBO;
import com.fnsvalue.skillshare.dao.NoticeDAO;
import com.fnsvalue.skillshare.dto.Board;

@Service
public class NoticeBOImpl implements NoticeBO {
	@Autowired
	private NoticeDAO noticeDAO;
	
	public ArrayList<HashMap> NoticeView(int PAGE_START,int PERPAGE_NUM)
	{
		return  noticeDAO.NoticeView(PAGE_START,PERPAGE_NUM);
	}
	
	public int noticeAdd(int BOARD_NO_PK, String USER_TB_USER_ID_PK, 
			String BOARD_TIT, String BOARD_CON)
	{
		return  noticeDAO.noticeAdd(BOARD_NO_PK,USER_TB_USER_ID_PK, 
				BOARD_TIT,BOARD_CON);
	}
	
	
	public int noticeChange(int BOARD_NO_PK, String USER_TB_USER_ID_PK, 
			String BOARD_TIT, String BOARD_CON)
	{
		return noticeDAO.noticeChange(BOARD_NO_PK,USER_TB_USER_ID_PK, 
				BOARD_TIT,BOARD_CON);
	}

	
	public int countPaging()
	{
		return noticeDAO.countPaging();
	}
}
