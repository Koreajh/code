package com.fnsvalue.skillshare.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fnsvalue.skillshare.bo.ApplyBO;
import com.fnsvalue.skillshare.dto.Apply;
import com.fnsvalue.skillshare.dto.Board;

@Controller
public class ApplyController {
	
	@Autowired
	private ApplyBO applyBO;
	
	@RequestMapping(value="applyForm", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView applyForm(Apply apply, HttpServletRequest request){
		ModelAndView mav= new ModelAndView();
		
		int board_tb_board_no_pk = Integer.parseInt(request.getParameter("board_id"));
		String write_id = request.getParameter("write_id");
		String user_tb_user_id_pk = request.getParameter("user_id");
		
		System.out.println("왜 안나와? :"+user_tb_user_id_pk);
		
		int result2 = applyBO.applyCount(board_tb_board_no_pk,user_tb_user_id_pk);
		
		if(result2==0)
		{
			int result = applyBO.applyAdd(apply.getApply_no_pk(), user_tb_user_id_pk, board_tb_board_no_pk);
			mav.setViewName("redirect:boardviewCri?page=1");
		}
		
		else
		{
			request.setAttribute("warning",1);
			mav.setViewName("redirect:boardDetails?id="+board_tb_board_no_pk+"&user="+write_id);
		}
		
		return mav;
		
	}
	
	@RequestMapping(value="applyviewCri", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView ApplyView(Apply apply, HttpServletRequest request){
		
		int board_tb_board_no_pk = Integer.parseInt(request.getParameter("board_id"));
		
		ArrayList<HashMap> ApplyView = applyBO.applyView(board_tb_board_no_pk);
		
		request.setAttribute("ApplyView", ApplyView);
		
		ModelAndView mav = new ModelAndView("applyviewCri");
		
		return mav;
		
	}
	
	
	@RequestMapping(value="applyAgree", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView applyAgree(Apply apply, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		int apply_no_pk = Integer.parseInt(request.getParameter("apply_id"));
		
		int result = applyBO.applyAgree(apply_no_pk);
		
		if(result > 0){
			mav.setViewName("redirect:boardviewCri");
		}
		
		return mav;
	}
	@RequestMapping(value="applyAgreeAjax", method =  {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public int applyAgreeAjax(Apply apply, HttpServletRequest request){
		System.out.println("ID_PK = "+apply.getUser_tb_user_id_pk());
		System.out.println("NO_PK = "+apply.getBoard_tb_board_no_pk());
		String apply_no_pk_string = applyBO.applyGetId(apply.getUser_tb_user_id_pk(),apply.getBoard_tb_board_no_pk());
		System.out.println("apply_no_pk_string = "+apply_no_pk_string);
		int apply_no_pk = Integer.parseInt(apply_no_pk_string);
		System.out.println("apply_no_pk = "+apply_no_pk);
		int result = applyBO.applyAgree(apply_no_pk);
		
		return result;
	}
	@RequestMapping(value="applyUnAgreeAjax", method =  {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public int applyUnAgreeAjax(Apply apply, HttpServletRequest request){
		System.out.println("ID_PK = "+apply.getUser_tb_user_id_pk());
		System.out.println("NO_PK = "+apply.getBoard_tb_board_no_pk());
		String apply_no_pk_string = applyBO.applyGetId(apply.getUser_tb_user_id_pk(),apply.getBoard_tb_board_no_pk());
		System.out.println("apply_no_pk_string = "+apply_no_pk_string);
		int apply_no_pk = Integer.parseInt(apply_no_pk_string);
		System.out.println("apply_no_pk = "+apply_no_pk);
		int result = applyBO.applyDisAgree(apply_no_pk);
		
		return result;
	}
	@RequestMapping(value="applyDisAgree", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView applyDisAgree(Apply apply, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		int apply_no_pk = Integer.parseInt(request.getParameter("apply_id"));
		int result = applyBO.applyDisAgree(apply_no_pk);
		if(result > 0){
			mav.setViewName("redirect:boardviewCri");
		}
		return mav;	
	}
	@RequestMapping(value="applyDelete", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView applyDelete(Apply apply, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		int board_tb_board_no_pk = Integer.parseInt(request.getParameter("board_id"));
		String user_tb_user_id_pk = request.getParameter("user_id");
		
		int result = applyBO.applyDelete(user_tb_user_id_pk, board_tb_board_no_pk);
		
		if(result > 0){
			mav.setViewName("redirect:main");
		}
		
		return mav;
		
	}
	
	@RequestMapping(value="applyPerView", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView applyPerView(Apply apply, HttpServletRequest request){
		
		String user_tb_user_id_pk = request.getParameter("user_id");
		
		System.out.println("누구 받아오니?:"+user_tb_user_id_pk);
		
		ArrayList<HashMap> ApplyPerView =applyBO.applyPerView(user_tb_user_id_pk, apply.getPageStart(), apply.getPerPageNum());
		
		Apply Applycount = new Apply();
		//int page= Integer.parseInt(request.getParameter("page"));
		Applycount.setTotalCount(applyBO.countPaging());
		//Applycount.setPage(page);
		request.setAttribute("ApplyPerView", ApplyPerView);
		//request.setAttribute("page", page);
		request.setAttribute("Applycount", Applycount);
		
		ModelAndView mav = new ModelAndView("applyperview");
		
		return mav;
		
		
	}
	
	@RequestMapping(value="applyAgreeDelete", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView applyAgreeDelete(Apply apply, HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		int apply_no_pk = Integer.parseInt(request.getParameter("apply_id"));
		
		int result = applyBO.applyAgreeDelete(apply_no_pk);
		
		if(result > 0){
			mav.setViewName("redirect:main");
		}
		
		return mav;
		
	}
	

}
