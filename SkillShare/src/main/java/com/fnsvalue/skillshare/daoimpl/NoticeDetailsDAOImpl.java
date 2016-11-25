package com.fnsvalue.skillshare.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnsvalue.skillshare.dao.NoticeDetailsDAO;
import com.fnsvalue.skillshare.dto.Board;
import com.fnsvalue.skillshare.mapper.NoticeDetailMapper;


@Component
public class NoticeDetailsDAOImpl implements NoticeDetailsDAO {

	@Autowired
    private SqlSession sqlSession;
	
	public ArrayList<HashMap> NoticeDetailsView(Board board)
	{
		ArrayList<HashMap> result;
		NoticeDetailMapper noticeDetailMapper = sqlSession.getMapper(NoticeDetailMapper.class);
        result = noticeDetailMapper.NoticeDetailsView(board);
        return result;
		
	}
	
	public Integer NoticeDelete(int BOARD_NO_PK)
	{
		int result;
		NoticeDetailMapper noticeDetailMapper = sqlSession.getMapper(NoticeDetailMapper.class);
		result=noticeDetailMapper.NoticeDelete(BOARD_NO_PK);
		return result;
	}
}
