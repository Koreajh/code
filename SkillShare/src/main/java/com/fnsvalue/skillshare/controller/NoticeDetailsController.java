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
public class NoticeDetailsController {
	
	@Autowired
	private NoticeDetailBO noticedetailBO;
	
	@RequestMapping(value="noticedetails", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView noticeDetailView(Board board,HttpSession session) {
		ArrayList<HashMap> NoticeDetails=noticedetailBO.NoticeDetailsView(board);
		session.setAttribute("NoticeDetails",NoticeDetails);
		ModelAndView mav = new ModelAndView("noticedetails");
		//mav.setViewName("redirect:usermanagerCri");
		//model.addAttribute("list",rootmanagerBO.listCriteria(cri));
		
		return mav;
	}
	
	
	@RequestMapping(value="noticedelete", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView delete(Board board) {
		 ModelAndView mav = new ModelAndView();

			 int result = noticedetailBO.NoticeDelete(board.getBoard_no_pk());
		 
		 System.out.println("result = "+result);
		 
		 if(result > 0){
			mav.setViewName("redirect:notice");
		 }
		 else{
			 System.out.println("실패");
		 }
		

		 return mav;
	}
	

}
