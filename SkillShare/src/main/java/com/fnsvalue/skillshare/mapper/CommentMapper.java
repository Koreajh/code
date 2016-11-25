package com.fnsvalue.skillshare.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import com.fnsvalue.skillshare.dto.Comment;

public interface CommentMapper {
	ArrayList<HashMap> commentList(Integer ask_tb_ask_no_pk);
	
	 int commentCreate(Comment comment);
	
	 int commentUpdate(Comment comment);
	
	 int commentDelete(Comment comment);
}
