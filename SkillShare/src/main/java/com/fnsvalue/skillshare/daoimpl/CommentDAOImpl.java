package com.fnsvalue.skillshare.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnsvalue.skillshare.dao.CommentDAO;
import com.fnsvalue.skillshare.dto.Comment;
import com.fnsvalue.skillshare.mapper.CommentMapper;

@Component
public class CommentDAOImpl implements CommentDAO {
	
	@Autowired
    private SqlSession sqlSession;
	
	@Override
	public ArrayList<HashMap> commentList(Integer ask_tb_ask_no_pk) {
		
		ArrayList<HashMap> result;
		CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
		result=commentMapper.commentList(ask_tb_ask_no_pk);
		return result;
	}

	@Override
	public int commentCreate(Comment comment) {
		
		int result;
		CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
		result=commentMapper.commentCreate(comment);
		return result;
	}

	@Override
	public int commentUpdate(Comment comment) {
		int result;
		CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
		result=commentMapper.commentUpdate(comment);
		return result;
	}

	@Override
	public int commentDelete(Comment comment) {
		int result;
		CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
		result=commentMapper.commentDelete(comment);
		return result;
	}

}
