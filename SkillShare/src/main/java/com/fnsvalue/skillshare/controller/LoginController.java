package com.fnsvalue.skillshare.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.ConsoleHandler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.CookieGenerator;

import com.fnsvalue.skillshare.bo.BoardBO;
import com.fnsvalue.skillshare.bo.LoginBO;
import com.fnsvalue.skillshare.bo.UserQuestionBoardBo;
import com.fnsvalue.skillshare.dto.Board;
import com.fnsvalue.skillshare.dto.User;


@Controller
public class LoginController {
	@Autowired
	private LoginBO loginBO;
	@Autowired
	private BoardBO boardBO;
	@Autowired
	private UserQuestionBoardBo userQuestionBoardBo;
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
	@RequestMapping(value="main", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView DashboardView(Board board, HttpServletRequest request){
		
		ArrayList<HashMap> boardDashBoardView= boardBO.dashboardView();
		ArrayList<HashMap> questionDashBoardView =userQuestionBoardBo.dashboardView();
		request.setAttribute("boardDashBoardView", boardDashBoardView);
		request.setAttribute("questionDashBoardView", questionDashBoardView);
		
		ModelAndView mav = new ModelAndView("main");
		return mav;
		
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
	public ModelAndView loginProcess(User user, HttpSession session, HttpServletRequest request,@RequestHeader(value="Accept-Language") String acceptLanguage,
			@RequestHeader(value="User-Agent", defaultValue="foo") String userAgent,HttpServletResponse response) throws IOException {
		ModelAndView mav = new ModelAndView();
		//mav.setViewName("redirect:main");
		//System.out.println(user.getUser_id_pk() +" / "+ user.getUser_pw());
		User loginUser = loginBO.findByUserIdAndPassword(user);
		if(loginUser ==null)
		{
			mav.setViewName("redirect:login");
		}
		else if(loginUser.getAccess()== 3 )
		{
			System.out.println("access: "+loginUser.getAccess());
			
			request.setAttribute("accessnotify", loginUser.getAccess());
			mav.setViewName("login");
		}
		
		else if(loginUser.getAccess()== 2 )
		{
			System.out.println("access: "+loginUser.getAccess());
			
			request.setAttribute("accessnotify", loginUser.getAccess());
			mav.setViewName("login");
			
		}
		
		
		else  
		{
			String ip = request.getHeader("X-FORWARDED-FOR");
			  
				if (ip == null || ip.length() == 0) {
			         ip = request.getHeader("Proxy-Client-IP");
			     }

			     if (ip == null || ip.length() == 0) {
			         ip = request.getHeader("WL-Proxy-Client-IP");  // 웹로직
			     }

			     if (ip == null || ip.length() == 0) {
			         ip = request.getRemoteAddr() ;
			     }
			
			     session.setAttribute("userLoginInfo", loginUser);
			int checkUser = loginBO.checkLogin(ip,user.getUser_id_pk());
			String nowURL= (String)session.getAttribute("sourceURL");
			String server=request.getServerName();
			String port= String.valueOf(request.getServerPort());
			
			CookieGenerator cookieGer = new CookieGenerator();

			cookieGer.setCookieName("cookie_value_test");
			cookieGer.addCookie(response, "suromind");
			
			Cookie[] cookies = request.getCookies();

			System.out.println("cookies: " + cookies);
			System.out.println("acceptLanguage: " + acceptLanguage);
			System.out.println("userAgent: " + userAgent);
			System.out.println("serverAddress: " + server);
			System.out.println("serverPort: " + port);

			String info="acceptLanguage: " +acceptLanguage+"\n"+"userAgent: "+userAgent+"\n"+"host: "+server+":"+port+"\n"+"cookie:"+cookies;
			int checkDetail= loginBO.checkDetail(user.getUser_id_pk(),user.getAcclog_sq_pk(),ip,nowURL,info);

			//int checkDetail= loginBO.checkDetail(user.getUser_id_pk(),user.getAcclog_sq_pk(),ip, sourceURL,"dsjfkslfj");
			
			mav.setViewName("redirect:main");
		}
		return mav;
	}
	
	@RequestMapping(value="checkDetail", method =  {RequestMethod.GET, RequestMethod.POST})
	 @ResponseBody
	 public Map<String, String> checkDetail(User user,HttpServletRequest request,HttpSession session,
			 @RequestHeader(value="Accept-Language") String acceptLanguage,
				@RequestHeader(value="User-Agent", defaultValue="foo") String userAgent,
				HttpServletResponse response,HttpServletRequest Request) throws Exception {
		//,@CookieValue("foo") String Cookie
		Map<String, String> resultMap = new HashMap<String, String>();
		String ip = request.getHeader("X-FORWARDED-FOR");
		String server=request.getServerName();
		String port= String.valueOf(request.getServerPort());
		  
		if (ip == null || ip.length() == 0) {
	         ip = request.getHeader("Proxy-Client-IP");
	     }

	     if (ip == null || ip.length() == 0) {
	         ip = request.getHeader("WL-Proxy-Client-IP");  // 웹로직
	     }

	     if (ip == null || ip.length() == 0) {
	         ip = request.getRemoteAddr() ;
	     }
	
	String nowURL= request.getParameter("nowURL");
	
	CookieGenerator cookieGer = new CookieGenerator();

	cookieGer.setCookieName("cookie_value_test");
	cookieGer.addCookie(response, "suromind");
	
	Cookie[] cookies = request.getCookies();

	System.out.println("cookies: " + cookies);
	System.out.println("acceptLanguage: " + acceptLanguage);
	System.out.println("userAgent: " + userAgent);
	System.out.println("serverAddress: " + server);
	System.out.println("serverPort: " + port);

	String info="acceptLanguage: " +acceptLanguage+"\n"+"userAgent: "+userAgent+"\n"+"host: "+server+":"+port+"\n"+"cookie:"+cookies;
	int checkDetail= loginBO.checkDetail(user.getUser_id_pk(),user.getAcclog_sq_pk(),ip, nowURL,info);
	String result = "";
	  String resultMsg = "";
	  
	 if ( checkDetail == 0 ){
	   
		 result = "success";
		 resultMsg = "사용가능한 아이디입니다.";
	  } 
	  else 
	  {	  
	   result = "failure";
	   resultMsg = "이미 사용중인 아이디입니다.";
	  }
	  
	  resultMap.put("result", result);
	  resultMap.put("resultMsg", resultMsg);
	  
	  
	  return resultMap;
	}

	

	
}
