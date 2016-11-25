package com.fnsvalue.skillshare.dto;

public class Apply {
	private int apply_no_pk;
	private String user_tb_user_id_pk;
	private int board_tb_board_no_pk;
	private String apply_dt;
	private int apply_st;
	private int page;
	private int perPageNum;
	
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
	
	
	public int getApply_no_pk() {
		return apply_no_pk;
	}
	public void setApply_no_pk(int apply_no_pk) {
		this.apply_no_pk = apply_no_pk;
	}
	public String getUser_tb_user_id_pk() {
		return user_tb_user_id_pk;
	}
	public void setUser_tb_user_id_pk(String user_tb_user_id_pk) {
		this.user_tb_user_id_pk = user_tb_user_id_pk;
	}
	public int getBoard_tb_board_no_pk() {
		return board_tb_board_no_pk;
	}
	public void setBoard_tb_board_no_pk(int board_tb_board_no_pk) {
		this.board_tb_board_no_pk = board_tb_board_no_pk;
	}
	public String getApply_dt() {
		return apply_dt;
	}
	public void setApply_dt(String apply_dt) {
		this.apply_dt = apply_dt;
	}
	public int getApply_st() {
		return apply_st;
	}
	public void setApply_st(int apply_st) {
		this.apply_st = apply_st;
	}
	
	//----------------------------------------------------------
	
	
	public Apply() {   //페이지 초기설정
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
	
	
	

}
