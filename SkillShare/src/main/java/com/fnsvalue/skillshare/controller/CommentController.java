package com.fnsvalue.skillshare.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fnsvalue.skillshare.bo.CommentBO;
import com.fnsvalue.skillshare.dto.Comment;
import com.fnsvalue.skillshare.dto.Question;
@Controller
public class CommentController {
	@Autowired
	private CommentBO commentBO;
	
	@RequestMapping(value="commentAdd", method =  RequestMethod.POST)
	public String CommentAdd(Comment comment, HttpServletRequest Request) {
		int ask_no_pk = comment.getAsk_tb_ask_no_pk();
		System.out.println(comment.toString());
		int result = commentBO.commentCreate(comment);
		return "redirect:questiondetails?id="+ask_no_pk+"&user="+comment.getUser_tb_user_id_pk();
	}
	@RequestMapping(value="commentDelete", method =  RequestMethod.POST)
	public ModelAndView CommentDelete(Comment comment, HttpServletRequest Request) {
		int ask_no_pk = comment.getAsk_tb_ask_no_pk();
		Request.setAttribute("id",ask_no_pk);
		int result = commentBO.commentDelete(comment);
		ModelAndView mav = new ModelAndView("foward:/questionBoard");
		return mav;
	}	
	@RequestMapping(value="commentUpdate", method =  RequestMethod.POST)
	@ResponseBody
	public Map<String, String> CommentUpdate(Comment comment, HttpServletRequest Request) {
		Map<String, String> resultMap = new HashMap<String, String>();
		int ask_no_pk = comment.getAsk_tb_ask_no_pk();
		Request.setAttribute("id",ask_no_pk);
		System.out.println(comment.toString());
		int result = commentBO.commentUpdate(comment);
		return resultMap;
	}
	
}
