package com.fnsvalue.skillshare.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fnsvalue.skillshare.dao.CommentDAO;
import com.fnsvalue.skillshare.dto.Comment;

public interface CommentBO {
	public ArrayList<HashMap> commentList(Integer ask_tb_ask_no_pk);
	
	public int commentCreate(Comment comment);
	
	public int commentUpdate(Comment comment);
	
	public int commentDelete(Comment comment);
}
