package com.fnsvalue.skillshare.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnsvalue.skillshare.dao.BoardDAO;
import com.fnsvalue.skillshare.dto.Board;
import com.fnsvalue.skillshare.mapper.BoardMapper;

@Component
public class BoardDAOImpl implements BoardDAO {

	@Autowired
    private SqlSession sqlSession;
	
	public int boardAdd(int BOARD_NO_PK, String USER_TB_USER_ID_PK, String BOARD_TIT, String BOARD_CON,
			String MY_SK, String WANT_SK, String BOARD_DUR) {
		
		int result;
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result=boardMapper.boardAdd(BOARD_NO_PK, USER_TB_USER_ID_PK, BOARD_TIT, BOARD_CON, MY_SK, WANT_SK, BOARD_DUR);
				
		return result;
	}


	public ArrayList<HashMap> boardView(int PAGE_START,int PERPAGE_NUM) {
		ArrayList<HashMap> result;
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result=boardMapper.boardView(PAGE_START, PERPAGE_NUM);
		
		return result;
		
	}
	
	public int cntPlus(int BOARD_NO_PK)
	{
		int result;
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result=boardMapper.cntPlus(BOARD_NO_PK);
		
		return result;
	}
	
	public int reportAdd(int REPORT_NUM,String REPORT_USER_ID,String REPORT_RS,String REPORT_CON)
	{
		int result;
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result=boardMapper.reportAdd(REPORT_NUM,REPORT_USER_ID,REPORT_RS,REPORT_CON);
		return result;
	}
	
	
	


	@Override
	public int countPaging() {
		// TODO Auto-generated method stub
		int result;
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result=boardMapper.countPaging();
		return result;
		
	}
	
	@Override
	public int reportCheck(int REPORT_NUM)
	{
		int result;
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result=boardMapper.reportCheck(REPORT_NUM);
		return result;
		
		
	}


	@Override
	public ArrayList<HashMap> boardDetails(int BOARD_NO_PK) {

		ArrayList<HashMap> result;
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result=boardMapper.boardDetails(BOARD_NO_PK);
		
		return result;
	}

	@Override
	public int viewOk(String USER_ID_PK){
		
		int result;
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result=boardMapper.viewOk(USER_ID_PK);
		
		return result;
	}
	

	@Override
	public Integer boardDelete(int BOARD_NO_PK, String USER_TB_USER_ID_PK) {
		Integer result;
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result=boardMapper.boardDelete(BOARD_NO_PK, USER_TB_USER_ID_PK);
		
		return result;
	}


	@Override
	public int boardChange(int BOARD_NO_PK, String USER_TB_USER_ID_PK, String BOARD_TIT, String BOARD_CON, String MY_SK,
			String WANT_SK, String BOARD_DUR) {
		int result;
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result=boardMapper.boardChange(BOARD_NO_PK, USER_TB_USER_ID_PK, BOARD_TIT, BOARD_CON, MY_SK, WANT_SK, BOARD_DUR);
		
		return result;
	}


	@Override
	public ArrayList<HashMap> dashboardView() {
		ArrayList<HashMap> result;
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result=boardMapper.dashboardView();
		
		return result;
	}


	@Override
	public Board perView(String USER_TB_USER_ID_PK) {
		Board result;
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		result=boardMapper.perView(USER_TB_USER_ID_PK);
		
		return result;
	}
	

}
