package com.fnsvalue.skillshare.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fnsvalue.skillshare.bo.NotifyBO;
import com.fnsvalue.skillshare.dto.Comment;
import com.fnsvalue.skillshare.dto.Notify;
import com.fnsvalue.skillshare.dto.User;

@Controller
public class NotifyController {
	
	@Autowired
	private NotifyBO notifyBO;
	
	@RequestMapping(value="notifystUpdate", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView notifystUpdate(HttpServletRequest request) {
		String from_id=request.getParameter("from_id");
		String to_id=request.getParameter("to_id");
		String sq=request.getParameter("sq");
		
		int result =  notifyBO.notifystupdate(from_id, to_id, sq);
		 ModelAndView mav = new ModelAndView("redirect:boardDetails?id="+sq+"&user="+to_id);
		 
		 return mav;
	}
	@RequestMapping(value="notifystUpdateAjax", method =  RequestMethod.POST)
	@ResponseBody
	public int notifystUpdateAjax(Notify notify, HttpServletRequest request) {
		System.out.println(notify.getNotify_from_id()+" / " + notify.getNotify_to_id()+" / " + notify.getNotify_con_fst());
			int result =  notifyBO.notifystupdate(notify.getNotify_from_id(), notify.getNotify_to_id(), notify.getNotify_con_fst());
			System.out.println("result = "+result);
		return result;
	}
	

}
