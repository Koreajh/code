package com.fnsvalue.skillshare.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnsvalue.skillshare.dao.NoticeDAO;
import com.fnsvalue.skillshare.dto.Board;
import com.fnsvalue.skillshare.mapper.BoardMapper;
import com.fnsvalue.skillshare.mapper.NoticeMapper;



@Component
public class NoticeDAOImpl implements NoticeDAO {

	@Autowired
    private SqlSession sqlSession;
	
	public ArrayList<HashMap> NoticeView(int PAGE_START,int PERPAGE_NUM)
	{
		ArrayList<HashMap> result;
	    NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
        result = noticeMapper.NoticeView(PAGE_START,PERPAGE_NUM);
        return result;
		
	}
	
	
	public int noticeAdd(int BOARD_NO_PK, String USER_TB_USER_ID_PK, 
			String BOARD_TIT, String BOARD_CON)
	{
		
		int result;
		NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
        result = noticeMapper.noticeAdd(BOARD_NO_PK, USER_TB_USER_ID_PK, BOARD_TIT, BOARD_CON);
        return result;
	}
	
	
	public int noticeChange(int BOARD_NO_PK, String USER_TB_USER_ID_PK, 
			String BOARD_TIT, String BOARD_CON)
	{
		int result;
		NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
        result = noticeMapper.noticeChange(BOARD_NO_PK, USER_TB_USER_ID_PK, BOARD_TIT, BOARD_CON);
        return result;
		
	}

	public int countPaging()  
	{
		int result;
		NoticeMapper noticeMapper = sqlSession.getMapper(NoticeMapper.class);
		result=noticeMapper.countPaging();
		return result;
	}
	
	
	
}
