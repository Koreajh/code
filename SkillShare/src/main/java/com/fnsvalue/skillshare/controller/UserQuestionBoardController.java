package com.fnsvalue.skillshare.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fnsvalue.skillshare.bo.CommentBO;
import com.fnsvalue.skillshare.bo.UserQuestionBoardBo;
import com.fnsvalue.skillshare.dto.Comment;
import com.fnsvalue.skillshare.dto.Question;

@Controller
public class UserQuestionBoardController 
{
	@Autowired
	private UserQuestionBoardBo userQuestionBoardBo;
	
	@Autowired
	private CommentBO commentBO;
	
	@RequestMapping(value="questionForm", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView QuestionForm(Question question, HttpServletRequest Request) {
		
		ModelAndView mav = new ModelAndView("questionadd");
		
		return mav;
	}
	
	@RequestMapping(value="questionBack", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView QuestionBack(Question question, HttpServletRequest Request) {
		
		ModelAndView mav = new ModelAndView("redirect:questionboard");
		
		return mav;
	}
	
	@RequestMapping(value="questionadd", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView QuestionAdd(Question question, HttpServletRequest Request) {
		
		int result = userQuestionBoardBo.QuestionAdd(question.getUser_tb_user_id_pk(), question.getAsk_tit(), question.getAsk_con());
		System.out.println("크레스천 result는:"+result);
		ModelAndView mav = new ModelAndView("redirect:questionboard");
		
		return mav;
	}
	
	@RequestMapping(value="questionboard", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView QuestionView(Question question, HttpServletRequest Request) {
		ArrayList<HashMap> QuestionView=userQuestionBoardBo.QuestionView(question.getPageStart(), question.getPerPageNum());
		Question Questioncount =new Question();
		//int page= Integer.parseInt(Request.getParameter("page"));
		Questioncount.setTotalCount(userQuestionBoardBo.countPaging());
		//Questioncount.setPage(page);
		Request.setAttribute("QuestionView",QuestionView);
		Request.setAttribute("Questioncount",Questioncount);
		//Request.setAttribute("page", page);
		ModelAndView mav = new ModelAndView("questionboard");
		//mav.setViewName("redirect:usermanagerCri");
		//model.addAttribute("list",rootmanagerBO.listCriteria(cri));
		
		return mav;
	}
	@RequestMapping(value="questiondetails", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView QuestionDetailView(Question question, HttpServletRequest Request) {
		int ask_no_pk = Integer.parseInt(Request.getParameter("id"));
		String board_user= Request.getParameter("user");
		ArrayList<HashMap> QuestionDetailView=userQuestionBoardBo.QuestionDetailView(ask_no_pk);
		ArrayList<HashMap> CommentView=commentBO.commentList(ask_no_pk);
		int ViewOk=userQuestionBoardBo.viewOk(board_user);
		
		Request.setAttribute("QuestionDetailView",QuestionDetailView);
		
		Request.setAttribute("CommentView",CommentView);
		
		System.out.println("comment size = "+CommentView.size());
		
		ModelAndView mav = new ModelAndView("questiondetails");
		if(ViewOk==3)
		{
			/*
			JOptionPane.showMessageDialog(null, "탈퇴한 회원의 글입니다.");
			*/
			mav.setViewName("redirect:questionboard");
		}
		//mav.setViewName("redirect:usermanagerCri");
		//model.addAttribute("list",rootmanagerBO.listCriteria(cri));
		return mav;
	}
	@RequestMapping(value="questionDelete", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView QuestionDelete(Question question, HttpServletRequest Request) {
		
		int ask_no_pk = Integer.parseInt(Request.getParameter("ask_id"));
		
		int result =userQuestionBoardBo.QuestionDelete(ask_no_pk);
		
		ModelAndView mav = new ModelAndView("redirect:questionboard");
		//mav.setViewName("redirect:usermanagerCri");
		//model.addAttribute("list",rootmanagerBO.listCriteria(cri));
		
		return mav;
	}
	@RequestMapping(value="questionChangeForm", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView QuestionChangeForm(Question question, HttpServletRequest request) {
		
		int ask_no_pk = Integer.parseInt(request.getParameter("ask_id"));
		
		ArrayList<HashMap> QuestionDetail = userQuestionBoardBo.QuestionDetailView(ask_no_pk);
		
		request.setAttribute("QuestionDetail", QuestionDetail);
		
		ModelAndView mav = new ModelAndView("questionchange");
		
		return mav;
	}
	
	@RequestMapping(value="questionChange", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView QuestionChange(Question question, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		int result = userQuestionBoardBo.QuestionChange(question.getAsk_no_pk(), question.getAsk_tit(), question.getAsk_con());
	
		mav.setViewName("redirect:questionboard");
		
		return mav;
	}
}
