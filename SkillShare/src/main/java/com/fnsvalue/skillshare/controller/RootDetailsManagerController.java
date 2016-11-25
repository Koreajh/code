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

import com.fnsvalue.skillshare.bo.RootDetailsManagerBO;
import com.fnsvalue.skillshare.bo.RootManagerBO;
import com.fnsvalue.skillshare.dto.Apply;
import com.fnsvalue.skillshare.dto.Question;
import com.fnsvalue.skillshare.dto.User;

@Controller
public class RootDetailsManagerController 
{
	@Autowired
	private RootDetailsManagerBO rootdetailsmanager;
	
	@RequestMapping(value="userdetails", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Userdetails(User user, HttpSession session,HttpServletRequest request) {
		
		//id=${row.board_no_pk}&user=${row.user_tb_user_id_pk}
	//	int board_no_pk = Integer.parseInt(request.getParameter("id"));
	//	String board_user= request.getParameter("user");
		String id=request.getParameter("id");
		user.setUser_id_pk(id);
		int page1= Integer.parseInt(request.getParameter("page1"));
		int page2= Integer.parseInt(request.getParameter("page2"));
		System.out.println("value check 1 = "+page1);
		System.out.println("value check 2 = "+page2);
		ArrayList<HashMap> UserDetails=rootdetailsmanager.UserDetailsView(id);
		ArrayList<HashMap> CheckLoginView=rootdetailsmanager.checkLoginView(id,page1,user.getPerPageNum());
		ArrayList<HashMap> checkLogDetailView=rootdetailsmanager.checkLogDetailView(id,page2,user.getPerPageNum());
		User logcount = new User();
		User logDetailcount = new User();		
		logcount.setPage(page1);
		logDetailcount.setPage(page2);
		logcount.setTotalCount(rootdetailsmanager.countLogPaging(id));
		logDetailcount.setTotalCount(rootdetailsmanager.countLogDetailPaging(id));
		System.out.println("value check 1 = "+rootdetailsmanager.countLogPaging(id));
		System.out.println("value check 2 = "+rootdetailsmanager.countLogDetailPaging(id));
		//System.out.println("value check 3 = "+user.getUser_id_pk());
		request.setAttribute("id", id);
		request.setAttribute("page1", page1);
		request.setAttribute("page2", page2);
		
		request.setAttribute("CheckLoginView",CheckLoginView);
		session.setAttribute("logcount", logcount);
		request.setAttribute("checkLogDetailView",checkLogDetailView);
		request.setAttribute("logDetailcount", logDetailcount);
		request.setAttribute("UserDetails",UserDetails);
		ModelAndView mav = new ModelAndView("userdetails");
		
		return mav;
	}
	//
	
	@RequestMapping(value="userdelete", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView changeinfo(User user,HttpServletRequest Request) {
		 ModelAndView mav = new ModelAndView();
		 String user_id_pk=Request.getParameter("id");
		 
		 int result = rootdetailsmanager.UserDelete(user_id_pk);
		 int result2 = rootdetailsmanager.insertOutMem(user_id_pk,"관리자의 강퇴");
		 
		 
		 System.out.println("userdeleteresult = "+result);
		 
		 if(result > 0){
			mav.setViewName("redirect:usermanagerCri?page=1");
		 }
		 else{
			 System.out.println("실패");
		 }
		

		 return mav;
	}
	
	
	@RequestMapping(value="Userdelete", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView userdelete(User user,HttpServletRequest Request) {
		 ModelAndView mav = new ModelAndView();
		 
		 int result = rootdetailsmanager.UserDelete(user.getUser_id_pk());
		 int result2 = rootdetailsmanager.insertOutMem(user.getUser_id_pk(),user.getUser_out_rs());
		 
		 System.out.println(user.getUser_id_pk()+"/"+user.getUser_out_rs());
			
		 
		 if(result > 0){
			mav.setViewName("redirect:login");
		 }
		 else{
			 System.out.println("실패");
		 }
		

		 return mav;
	}
	
	@RequestMapping(value="UserBan", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView UserBan(User user,HttpServletRequest Request) {
		 ModelAndView mav = new ModelAndView();
		 
		 int result = rootdetailsmanager.UserBan(user.getUser_id_pk());
		 if(result > 0){
			System.out.println("result = "+ result);
			mav.setViewName("redirect:usermanagerCri?page=1");
		 }
		 else{
			 System.out.println("실패");
		 }
		

		 return mav;
	}
	
	@RequestMapping(value="UserBanCancel", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView UserBanCancel(User user,HttpServletRequest Request) {
		 ModelAndView mav = new ModelAndView();
		 
		 int result = rootdetailsmanager.UserBanCancel(user.getUser_id_pk());
		 
		 if(result > 0){
			mav.setViewName("redirect:usermanagerCri?page=1");
		 }
		 else{
			 System.out.println("실패");
		 }
		 return mav;
	}
	
	@RequestMapping(value="userBack", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView userBack(User user,HttpServletRequest Request) {

		ModelAndView mav = new ModelAndView("redirect:usermanagerCri");

		 return mav;
	}
	
	

	
}
