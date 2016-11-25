package com.fnsvalue.skillshare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.*;
import java.text.*;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
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
	
	@RequestMapping(value="doubleCheck", method =  {RequestMethod.GET, RequestMethod.POST})
	 @ResponseBody
	 public Map<String, String> doubleCheck(User user) throws Exception {
		
	  Map<String, String> resultMap = new HashMap<String, String>();
	  int resultCnt = joinBO.doubleCheck(user.getUser_id_pk());
	  String result = "";
	  String resultMsg = "";
	  
	  if ( resultCnt == 0 ){
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
	
	
	
	@RequestMapping(value="join", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView join(User user ,HttpServletRequest request) throws IOException  {
		 ModelAndView mav = new ModelAndView();
		 MultipartFile uploadfile =user.getUploadfile();
		 if (uploadfile != null) {
	            String fileName = uploadfile.getOriginalFilename();
	            user.setUser_file_nm(fileName);
	            try {
	                // File 사용
	            	String filename=fileName;
	            	File file = new File("C:/Users/FNS_Class/Documents/workspace-sts-3.7.3.RELEASE/SkillShare/src/main/webapp/resources/img/user/"+fileName);
	            	uploadfile.transferTo(file);
	                int result = joinBO.findByUserJoin(user.getUser_id_pk(), user.getUser_pw(), user.getUser_nm(), user.getUser_em(),filename);
	       		 System.out.println("result = "+result);
	       		 if(result > 0){
	       			mav.setViewName("redirect:login");
	       		 }
	       		
	            } catch (IOException e) {
	                e.printStackTrace();
	            } // try - catch
	        } // if
		 return mav;
	}

}
