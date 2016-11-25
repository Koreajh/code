package com.fnsvalue.skillshare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fnsvalue.skillshare.bo.JoinBO;
import com.fnsvalue.skillshare.dto.User;



@Controller
public class JoinController {
	@Autowired
	private JoinBO joinBO;
	
	@RequestMapping(value="joinForm", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView joinForm(User user) {
		
		
		 ModelAndView mav = new ModelAndView("MemberJoin");
		 
		 return mav;
	}
	
	@RequestMapping(value="join", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView join(User user) {
		 ModelAndView mav = new ModelAndView();

			System.out.println(user.getUser_id_pk()+ " / " + user.getUser_pw()+ " / " + user.getUser_nm()+ " / " + user.getUser_em());
		 int result = joinBO.findByUserJoin(user.getUser_id_pk(), user.getUser_pw(), user.getUser_nm(), user.getUser_em());
		 System.out.println("result = "+result);
		 if(result > 0){
			mav.setViewName("redirect:login");
		 }
		 
		 return mav;
	}

}
