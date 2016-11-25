package com.fnsvalue.skillshare.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fnsvalue.skillshare.bo.ChangeinfoBO;
import com.fnsvalue.skillshare.dto.User;



@Controller
public class ChangeinfoController {
	@Autowired
	private ChangeinfoBO changeinfoBO;
	
	@RequestMapping(value="changeinfoForm", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView changeinfoForm(User user) {
		
		
		 ModelAndView mav = new ModelAndView("MemberChangeinfo");
		 
		 return mav;
	}
	
	@RequestMapping(value="changeinfo", method =  {RequestMethod.GET, RequestMethod.POST}) 
	public ModelAndView changeinfo(User user) throws IOException  {
		 ModelAndView mav = new ModelAndView();
		 MultipartFile uploadfile =user.getUploadfile();
		 if (uploadfile != null) {
		    String fileName = uploadfile.getOriginalFilename();
		    user.setUser_file_nm(fileName);
		            try {
		                // File 사용
		            	String filename="C:/upload/"+fileName;
		            	File file = new File("C:/upload/" + fileName);
		            	System.out.println("filename은"+filename);
		            	uploadfile.transferTo(file);
		                int result = changeinfoBO.changeinfoUser(user.getUser_id_pk(), user.getUser_pw(), user.getUser_nm(), user.getUser_em(),filename);
		                System.out.println("result 결과는"+result);
		                if(result > 0)
		                {
		                	mav.setViewName("redirect:login");
		                }

		            } catch (IOException e) {
		                e.printStackTrace();
		            }
			 }
		 return mav;
	}
	
	@RequestMapping(value="changeinfoBack", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView changeinfoBack() {
		
		 ModelAndView mav = new ModelAndView("redirect:main");
		 
		 return mav;
	}

}
