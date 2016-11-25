package com.fnsvalue.skillshare.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fnsvalue.skillshare.bo.BoardBO;
import com.fnsvalue.skillshare.dto.Board;
import com.fnsvalue.skillshare.dto.Editor;
import com.fnsvalue.skillshare.dto.PhotoVo;


@Controller
public class BoardController {
	
	@Autowired
	private BoardBO boardBO;
	@RequestMapping(value="boardForm", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView boardForm(){
		
		ModelAndView mav = new ModelAndView("boardAdd");
		return mav;
	}
	@RequestMapping(value="boardBack", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView boardBack(){
		
		ModelAndView mav = new ModelAndView("redirect:boardviewCri?page=1");
		return mav;
	}
	
	@RequestMapping(value="boardadd", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView boardadd(Board board){
		ModelAndView mav = new ModelAndView();
		
		int result=boardBO.boardAdd(board.getBoard_no_pk(), board.getUser_tb_user_id_pk(), board.getBoard_tit(), 
				board.getBoard_con(), board.getMy_sk(), board.getWant_sk(), board.getBoard_dur());
		System.out.println("result: "+result);
		board = boardBO.perView(board.getUser_tb_user_id_pk());
		
		if(result > 0){
			mav.setViewName("redirect:boardDetails?id="+board.getBoard_no_pk()+"&user="+board.getUser_tb_user_id_pk());
		}
		
		return mav;
	}
	
	///////////////////
	@RequestMapping(value="reportAdd", method =  {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Map<String, String> reportAdd(Board board, HttpServletRequest request){
		Map<String, String> resultMap = new HashMap<String, String>();
		int result = boardBO.reportAdd(board.getBoard_no_pk(),board.getReport_id(),board.getReport_rs(),board.getReport_con());
		
		String reportchecknum = Integer.toString(boardBO.reportCheck(board.getBoard_no_pk()));
		resultMap.put("report_check", reportchecknum);
		//System.out.println("이게 뭐시다냐? "+reportchecknum+"//글작성자 아이디여!! "+board.getUser_tb_user_id_pk());

		//System.out.println("resultadd는: "+result);
		
//		
//		if(result > 0){
//			
//			mav.setViewName("redirect:boardDetails?id="+board.getBoard_no_pk()+"&user="+board.getUser_tb_user_id_pk());
//		}
		
		return resultMap;
	}
	@RequestMapping(value="boardTest", method =  {RequestMethod.GET, RequestMethod.POST})
	public Map<String, String> boardTest(Board board, HttpServletRequest request){
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("report_check", "10");
		return resultMap;
	}
//	@RequestMapping(value="reportDelete", method =  {RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView reportDelete(Board board, HttpSession session,HttpServletRequest request){
//		ModelAndView mav = new ModelAndView();
//		int board_id_pk = Integer.parseInt(request.getParameter("board_id"));
//		String user_tb_user_id_pk =request.getParameter("user_id");
//		int result = boardBO.reportDelete(board_id_pk, user_tb_user_id_pk);
//		if(result > 0){
//			mav.setViewName("redirect:boardviewCri?page=1");
//		 }
//		
//		return mav;
//		
//	}
//	
	 @RequestMapping("/file_uploader")
	 public String file_uploader(HttpServletRequest request, HttpServletResponse response, Editor editor){
		 String return1=request.getParameter("callback");
		 String return2="?callback_func=" + request.getParameter("callback_func");
		 String return3="";
		 String name = "";
		 try {
			if(editor.getFiledata() != null && editor.getFiledata().getOriginalFilename() != null && !editor.getFiledata().getOriginalFilename().equals("")) {
	             // 기존 상단 코드를 막고 하단코드를 이용
	            name = editor.getFiledata().getOriginalFilename().substring(editor.getFiledata().getOriginalFilename().lastIndexOf(File.separator)+1);
				String filename_ext = name.substring(name.lastIndexOf(".")+1);
				filename_ext = filename_ext.toLowerCase();
			   	String[] allow_file = {"jpg","png","bmp","gif"};
			   	int cnt = 0;
			   	for(int i=0; i<allow_file.length; i++) {
			   		if(filename_ext.equals(allow_file[i])){
			   			cnt++;
			   		}
			   	}
			   	if(cnt == 0) {
			   		return3 = "&errstr="+name;
			   	} else {
			   		//파일 기본경로
		    		String dftFilePath = request.getSession().getServletContext().getRealPath("/");
		    		//파일 기본경로 _ 상세경로
		    		String filePath = dftFilePath + "resources"+ File.separator + "editor" + File.separator +"upload" + File.separator;
		    		File file = new File(filePath);
		    		if(!file.exists()) {
		    			file.mkdirs();
		    		}
		    		String realFileNm = "";
		    		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
					String today= formatter.format(new java.util.Date());
					realFileNm = today+UUID.randomUUID().toString() + name.substring(name.lastIndexOf("."));
					String rlFileNm = filePath + realFileNm;
					///////////////// 서버에 파일쓰기 /////////////////
					editor.getFiledata().transferTo(new File(rlFileNm));
					///////////////// 서버에 파일쓰기 /////////////////
		    		return3 += "&bNewLine=true";
		    		return3 += "&sFileName="+ name;
		    		return3 += "&sFileURL=/resources/editor/upload/"+realFileNm;
			   	}
			}else {
				  return3 += "&errstr=error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return "redirect:"+return1+return2+return3;
 }
	
	
	 @RequestMapping("/file_uploader_html5")
	 public void file_uploader_html5(HttpServletRequest request, HttpServletResponse response){
		try {
			 //파일정보
			 String sFileInfo = "";
			 //파일명을 받는다 - 일반 원본파일명
			 String filename = request.getHeader("file-name");
			 //파일 확장자
			 String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
			 //확장자를소문자로 변경
			 filename_ext = filename_ext.toLowerCase();
			 	
			 //이미지 검증 배열변수
			 String[] allow_file = {"jpg","png","bmp","gif"};

			 //돌리면서 확장자가 이미지인지 
			 int cnt = 0;
			 for(int i=0; i<allow_file.length; i++) {
			 	if(filename_ext.equals(allow_file[i])){
			 		cnt++;
			 	}
			 }

			 //이미지가 아님
			 if(cnt == 0) {
				 PrintWriter print = response.getWriter();
				 print.print("NOTALLOW_"+filename);
				 print.flush();
				 print.close();
			 } else {
			 //이미지이므로 신규 파일로 디렉토리 설정 및 업로드	
			 //파일 기본경로
			 String dftFilePath = request.getSession().getServletContext().getRealPath("/");
			 //파일 기본경로 _ 상세경로
			 String filePath = dftFilePath + "resources" + File.separator + "editor" + File.separator +"multiupload" + File.separator;
			 File file = new File(filePath);
			 if(!file.exists()) {
			 	file.mkdirs();
			 }
			 String realFileNm = "";
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			 String today= formatter.format(new java.util.Date());
			 realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
			 String rlFileNm = filePath + realFileNm;
			 ///////////////// 서버에 파일쓰기 ///////////////// 
			 InputStream is = request.getInputStream();
			 OutputStream os=new FileOutputStream(rlFileNm);
			 int numRead;
			 byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
			 while((numRead = is.read(b,0,b.length)) != -1){
			 	os.write(b,0,numRead);
			 }
			 if(is != null) {
			 	is.close();
			 }
			 os.flush();
			 os.close();
			 ///////////////// 서버에 파일쓰기 /////////////////

			 // 정보 출력
			 sFileInfo += "&bNewLine=true";
			 // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
			 sFileInfo += "&sFileName="+ filename;;
			 sFileInfo += "&sFileURL="+"/resources/editor/multiupload/"+realFileNm;
			 PrintWriter print = response.getWriter();
			 print.print(sFileInfo);
			 print.close();
			 }	
		} catch (Exception e) {
			e.printStackTrace();
		}
 }
	
	
	@RequestMapping(value="boardviewCri", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView BoardView(Board board,HttpServletRequest request){
		System.out.println("boardcontroller1="+board.getBoard_no_pk()+"/"+ board.getUser_tb_user_id_pk()+"/"+ board.getBoard_tit()+"/"+
				board.getBoard_con()+"/"+ board.getMy_sk()+"/"+ board.getWant_sk()+"/"+ board.getBoard_dur());
		
		ArrayList<HashMap> BoardView= boardBO.boardView(board.getPageStart(),board.getPerPageNum());
		Board Boardcount = new Board();
		int page= Integer.parseInt(request.getParameter("page"));
		System.out.println("page: "+page);
		Boardcount.setTotalCount(boardBO.countPaging());
		Boardcount.setPage(page);
		request.setAttribute("BoardView", BoardView);
		request.setAttribute("Boardcount", Boardcount);
		request.setAttribute("page", page);
		ModelAndView mav = new ModelAndView("boardviewCri");
		return mav;
		
	}
	//id=${row.board_no_pk}&user=${row.user_tb_user_id_pk}
	
	@RequestMapping(value="boardDetails", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView boardDetails(Board board, HttpServletRequest request){
		
		
		int board_no_pk = Integer.parseInt(request.getParameter("id"));
		String board_user= request.getParameter("user");
		System.out.println("board_user:"+board_user);
		ArrayList<HashMap> BoardDetails = boardBO.boardDetails(board_no_pk);
		int ViewOk=boardBO.viewOk(board_user);
		System.out.println("access:"+ViewOk);
		int result = boardBO.cntPlus(board_no_pk);
		request.setAttribute("BoardDetails", BoardDetails);
		ModelAndView mav=new ModelAndView("boarddetails");
		
		if(ViewOk==3)
		{
			/*
			JOptionPane.showMessageDialog(null, "탈퇴한 회원의 글입니다.");
			*/
			mav.setViewName("redirect:boardviewCri");
		}
				
		
		
		return mav;
		
	}
	
	@RequestMapping(value="boardDelete", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView boardDelete(Board board, HttpSession session,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		int board_id_pk = Integer.parseInt(request.getParameter("board_id"));
		String user_tb_user_id_pk =request.getParameter("user_id");
		int result = boardBO.boardDelete(board_id_pk, user_tb_user_id_pk);
		if(result > 0){
			mav.setViewName("redirect:boardviewCri?page=1");
		 }
		
		return mav;
		
	}
	
	@RequestMapping(value="boardChangeForm", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView boardChangeForm(Board board, HttpServletRequest request){
		
		int board_no_pk = Integer.parseInt(request.getParameter("board_id"));
		String user_tb_user_id_pk = request.getParameter("user_id");
		System.out.println("boardChangeForm = "+board_no_pk+ " / "+ user_tb_user_id_pk);
		
		ArrayList<HashMap> BoardDetails = boardBO.boardDetails(board_no_pk);
		
		request.setAttribute("BoardDetails", BoardDetails);
		
	         System.out.println("give me the power = "+BoardDetails.size());
	         
		ModelAndView mav = new ModelAndView("boardchange");
		return mav;
		
	}
	
	@RequestMapping(value="boardChange", method =  {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView boardChange(Board board, HttpServletRequest request)
	{
		ModelAndView mav = new ModelAndView();
		
		System.out.println("System test = "+ board.getBoard_no_pk() + " / " + board.getUser_tb_user_id_pk() + " / " + board.getBoard_tit() + " / " +
				board.getBoard_con()+ " / " +board.getMy_sk()+ " / " +board.getWant_sk()+ " / " +board.getBoard_dur());
		
		int result = boardBO.boardChange(board.getBoard_no_pk(), board.getUser_tb_user_id_pk(), board.getBoard_tit(),
				board.getBoard_con(), board.getMy_sk(), board.getWant_sk(), board.getBoard_dur());
		
	    System.out.println("result는"+result);
		
		if(result > 0){
			mav.setViewName("redirect:boardviewCri?page=1");
		 }
		
		return mav;
		
	}
	
	
	@RequestMapping(value="Main", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView MainView(Board board, HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView("Dash");
		System.out.println("qq1");
		return mav;
		
	}
	@RequestMapping(value="Dash", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView DashboardView(Board board, HttpServletRequest request){
		System.out.println("qq2");
		
		ArrayList<HashMap> DashBoardView= boardBO.dashboardView();
		
		System.out.println("ssss="+DashBoardView);
		
		request.setAttribute("DashBoardView", DashBoardView);
		
		ModelAndView mav = new ModelAndView("redirect:main");
		return mav;
		
	}
	
	
	
}


















