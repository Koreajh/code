package com.fnsvalue.skillshare.dto;

import org.springframework.web.multipart.MultipartFile;

public class Board {
	private int board_no_pk;
	private String user_tb_user_id_pk;
	private String board_tit;
	private String board_con;
	private String board_dt;
	private String my_sk;
	private String want_sk;
	private String board_dur;
	private String board_fl;
	private String read_cnt;
	
	private String report_id;
	private String report_rs;
	private String report_con;
	private int page;
	private int perPageNum;
	private int page_start;
	private int perpage_num;
	
	
	
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	//------board-----------------------------------
	public String getRead_cnt() {
		return read_cnt;
	}
	public void setRead_cnt(String read_cnt) {
		this.read_cnt = read_cnt;
	}

	
	public String getReport_id() {
		return report_id;
	}
	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}
	
	public String getReport_rs() {
		return report_rs;
	}
	public void setReport_rs(String report_rs) {
		this.report_rs = report_rs;
	}
	public String getReport_con() {
		return report_con;
	}
	public void setReport_con(String report_con) {
		this.report_con = report_con;
	}

	
	
	public int getBoard_no_pk() {
		return board_no_pk;
	}
	public void setBoard_no_pk(int board_no_pk) {
		this.board_no_pk = board_no_pk;
	}
	public String getUser_tb_user_id_pk() {
		return user_tb_user_id_pk;
	}
	
	public void setUser_tb_user_id_pk(String user_tb_user_id_pk) {
		this.user_tb_user_id_pk = user_tb_user_id_pk;
	}
	public String getBoard_tit() {
		return board_tit;
	}
	public void setBoard_tit(String board_tit) {
		this.board_tit = board_tit;
	}
	public String getBoard_con() {
		return board_con;
	}
	public void setBoard_con(String board_con) {
		this.board_con = board_con;
	}
	public String getBoard_dt() {
		return board_dt;
	}
	public void setBoard_dt(String board_dt) {
		this.board_dt = board_dt;
	}
	public String getMy_sk() {
		return my_sk;
	}
	public void setMy_sk(String my_sk) {
		this.my_sk = my_sk;
	}
	public String getWant_sk() {
		return want_sk;
	}
	public void setWant_sk(String want_sk) {
		this.want_sk = want_sk;
	}
	public String getBoard_dur() {
		return board_dur;
	}
	public void setBoard_dur(String board_dur) {
		this.board_dur = board_dur;
	}
	public String getBoard_fl() {
		return board_fl;
	}
	public void setBoard_fl(String board_fl) {
		this.board_fl = board_fl;
	}
	//----------------------------------------------------------------
	

	public Board() {   //페이지 초기설정
		this.page=1;  // 처음에는 첫페이지
		perPageNum=10;   //게시물 10개씩
	}
	
	public void setPage(int page) {   //페이지 set
		
		if(page<=0){          //페이지 오류시
		this.page =1;         //페이지번호 1로
		return;
		}
		
		this.page=page;   
	}
	
	public void setPerPageNum(int perPageNum) { //게시물갯수 set
		
		if(perPageNum <=0 || perPageNum>100){
			this.perPageNum=10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPage() {   //page get
		return page;
	}
	

	//method for MyBatis SQL Mapper-
	public int getPageStart(){   // 해당 페이지의 게시물들 get
		this.page_start = (this.page-1)*perPageNum;
		return (this.page-1)*perPageNum;
	}
	
	
	public int getStartPage() {
		return startPage;
	}
	
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public int getPerPageNum() {
		this.perpage_num = perPageNum;
		return perPageNum;
	}
	
	@Override
	public String toString(){
		return "Criteria [page="+page+","+"perPageNum"+perPageNum+"]";
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	
	public void setTotalCount(int totalCount)  //전체게시물 받음
	{
		this.totalCount=totalCount; //전체게시물 받고
		calcData();                  //끝페이지, 시작페이지, 앞으로, 뒤로 설정
	}
	
	private void calcData()
	{
		endPage=(int)(Math.ceil(this.getPage()/(double)perPageNum)*perPageNum);
		startPage=(endPage-perPageNum)+1;
		
		int tempEndPage=(int) (Math.ceil(totalCount/(double)this.getPerPageNum()));
		
	
	
	if(endPage>tempEndPage)
	{
		endPage=tempEndPage;
	}
	prev=startPage == 1?false :true;
	next=endPage * this.getPerPageNum()>=totalCount?false :true;
	}
	public int getPage_start() {
		return page_start;
	}
	public void setPage_start(int page_start) {
		this.page_start = page_start;
	}
	public int getPerpage_num() {
		return perpage_num;
	}
	public void setPerpage_num(int perpage_num) {
		this.perpage_num = perpage_num;
	}
	
	

	
	
	

}
