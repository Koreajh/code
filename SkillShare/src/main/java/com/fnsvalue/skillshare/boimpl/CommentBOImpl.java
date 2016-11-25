package com.fnsvalue.skillshare.boimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnsvalue.skillshare.bo.CommentBO;
import com.fnsvalue.skillshare.dao.CommentDAO;
import com.fnsvalue.skillshare.dto.Comment;

@Service
public class CommentBOImpl implements CommentBO{
	
	@Autowired
	private CommentDAO dao;
	
	@Override
	public ArrayList<HashMap> commentList(Integer ask_tb_ask_no_pk) {
		// TODO Auto-generated method stub
		return dao.commentList(ask_tb_ask_no_pk);
	}

	@Override
	public int commentCreate(Comment comment) {
		// TODO Auto-generated method stub
		
		return dao.commentCreate(comment);
	}

	@Override
	public int commentUpdate(Comment comment) {
		// TODO Auto-generated method stub
	
		return dao.commentUpdate(comment);
	}

	@Override
	public int commentDelete(Comment comment) {
		// TODO Auto-generated method stub
		
		return dao.commentDelete(comment);
	}

}
