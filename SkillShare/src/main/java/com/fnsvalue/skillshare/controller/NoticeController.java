package com.fnsvalue.skillshare.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fnsvalue.skillshare.bo.NoticeBO;
import com.fnsvalue.skillshare.bo.NoticeDetailBO;
import com.fnsvalue.skillshare.dto.Board;
import com.fnsvalue.skillshare.dto.Notice;
import com.fnsvalue.skillshare.dto.User;

@Controller
public class NoticeController {

	@Autowired
	private NoticeBO noticeBO;
	
	@Autowired
	private NoticeDetailBO noticedetailBO;
	
	@RequestMapping(value="notice", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView noticeView(Board board,HttpSession session,HttpServletRequest request) {
		
		ArrayList<HashMap> Notice=noticeBO.NoticeView(board.getPageStart(),board.getPerPageNum());
		Notice Noticecount =new Notice();
		int page= Integer.parseInt(request.getParameter("page"));
		
		Noticecount.setTotalCount(noticeBO.countPaging());
		Noticecount.setPage(page);
		session.setAttribute("Notice",Notice);
		session.setAttribute("Noticecount",Noticecount);
		request.setAttribute("page", page);
		ModelAndView mav = new ModelAndView("notice");
		//mav.setViewName("redirect:usermanagerCri");
		//model.addAttribute("list",rootmanagerBO.listCriteria(cri));
		
		return mav;
	}
	
	@RequestMapping(value="addForm", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView addForm(){
		ModelAndView mav = new ModelAndView("noticeAdd");
		return mav;
	}
	
//	@RequestMapping(value="boardDelete", method =  {RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView boardDelete(Board board, HttpSession session,HttpServletRequest request){
//		ModelAndView mav = new ModelAndView();
//		int board_id_pk = Integer.parseInt(request.getParameter("bid"));
//		String user_tb_user_id_pk =request.getParameter("id");
//		
//		int result = boardBO.boardDelete(board_id_pk,user_tb_user_id_pk);
//				
//		
//		if(result > 0){
//			mav.setViewName("redirect:boardviewCri");
//		 }
//		
//		return mav;
//		
//	}
	
	
	@RequestMapping(value="noticeadd", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView noticeadd(Board board){
		ModelAndView mav = new ModelAndView();    
		int result=noticeBO.noticeAdd(board.getBoard_no_pk(), board.getUser_tb_user_id_pk(), board.getBoard_tit(), 
				board.getBoard_con());
		System.out.println("resultthat: "+result);
		if(result > 0){
			mav.setViewName("redirect:main");
		}
		
		return mav;
	}
	
	
	@RequestMapping(value="noticeChangeForm", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView noticeChangeForm(Board board, HttpServletRequest request){
		int board_no_pk = Integer.parseInt(request.getParameter("board_id"));
		
		String user_tb_user_id_pk = request.getParameter("user_id");
		
		ArrayList<HashMap> NoticeDetails = noticedetailBO.NoticeDetailsView(board);
		
		request.setAttribute("NoticeDetails", NoticeDetails);
		
	         
		ModelAndView mav = new ModelAndView("noticechange");
		return mav;
		
	}
	
	@RequestMapping(value="noticeChange", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView noticeChange(Board board, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		int result = noticeBO.noticeChange(board.getBoard_no_pk(), board.getUser_tb_user_id_pk(), board.getBoard_tit(),
				board.getBoard_con());
		
		
		if(result > 0){
			mav.setViewName("redirect:boardviewCri");
		 }
		
		return mav;
		
	}
	
	
	
}
