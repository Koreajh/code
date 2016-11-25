package com.fnsvalue.skillshare.dto;

public class Notice {
	private int notice_id_pk;
	private String user_tb_user_id_pk;
	private String notice_tit;
	private String notice_con;
	private String notice_dt;
	private int page;
	private int perPageNum;
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	
	public int getNotice_id_pk() {
		return notice_id_pk;
	}
	public void setNotice_id_pk(int notice_id_pk) {
		this.notice_id_pk = notice_id_pk;
	}
	public String getUser_tb_user_id_pk() {
		return user_tb_user_id_pk;
	}
	public void setUser_tb_user_id_pk(String user_tb_user_id_pk) {
		this.user_tb_user_id_pk = user_tb_user_id_pk;
	}
	public String getNotice_tit() {
		return notice_tit;
	}
	public void setNotice_tit(String notice_tit) {
		this.notice_tit = notice_tit;
	}
	public String getNotice_con() {
		return notice_con;
	}
	public void setNotice_con(String notice_con) {
		this.notice_con = notice_con;
	}
	public String getNotice_dt() {
		return notice_dt;
	}
	public void setNotice_dt(String notice_dt) {
		this.notice_dt = notice_dt;
	}
	
	
	//-----------------------------page
	public Notice() {   //페이지 초기설정
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
	

}
