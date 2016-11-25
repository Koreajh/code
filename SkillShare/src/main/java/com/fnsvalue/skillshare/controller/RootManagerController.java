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
import com.fnsvalue.skillshare.dto.User;

@Controller
public class RootManagerController 
{
	@Autowired
	private RootManagerBO rootmanagerBO;
	@RequestMapping(value="usermanagerCri", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView UserManager(User user,HttpSession session,HttpServletRequest request) {
		ArrayList<HashMap> UserManager=rootmanagerBO.UserView(user.getPageStart(),user.getPerPageNum());
		User Usercount =new User();
		int page= Integer.parseInt(request.getParameter("page"));
		Usercount.setPage(page);
		Usercount.setTotalCount(rootmanagerBO.countPaging());
		request.setAttribute("UserManager",UserManager);
		request.setAttribute("Usercount",Usercount);
		request.setAttribute("page", page);
		ModelAndView mav = new ModelAndView("usermanagerCri");
		//mav.setViewName("redirect:usermanagerCri");
		//model.addAttribute("list",rootmanagerBO.listCriteria(cri));
		
		return mav;
	}
}
