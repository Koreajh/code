package com.fnsvalue.skillshare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fnsvalue.skillshare.bo.LoginBO;
import com.fnsvalue.skillshare.dto.User;

@Controller
public class LoginController {
	@Autowired
	private LoginBO loginBO;
	
	// �꽭�뀡�궗�슜 �솕硫�
	@RequestMapping("page1")
	public String page1() {
		return "page1";
	}
	// �꽭�뀡 �궗�슜 �븞�븯�뒗 �솕硫�
	@RequestMapping("page2")
	public String page2() {
		return "page2";
	}
	// 濡쒓렇�씤 �솕硫�
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	// 濡쒓렇�씤 �솕硫�
	@RequestMapping("main")
	public String main() {
		return "main";
	}
	@RequestMapping("MemberJoin")
	public String MemberJoin() {
		return "MemberJoin";
	}
	// 濡쒓렇�븘�썐
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.setAttribute("userLoginInfo", null);
		return "redirect:login";
	}
	// 濡쒓렇�씤 泥섎━ 
	@RequestMapping(value="loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(User user, HttpSession session, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:main");
		System.out.println(user.getUser_id_pk() +" / "+ user.getUser_pw());
		User loginUser = loginBO.findByUserIdAndPassword(user.getUser_id_pk(), user.getUser_pw());
		
		if (loginUser != null) {
			session.setAttribute("userLoginInfo", loginUser);
		}
		return mav;
	}
}
