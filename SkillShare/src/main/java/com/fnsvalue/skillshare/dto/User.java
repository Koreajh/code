package com.fnsvalue.skillshare.dto;

import org.springframework.web.multipart.MultipartFile;

public class User {
	private String user_id_pk;
	private String user_pw;
	private String user_nm;
	private String user_em;
	private String user_file_nm;
	private MultipartFile uploadfile;
	private int access;
	private String create_dt;
	private String change_dt;
	private String loginlog_user_id;
	private String loginlog_user_ip;
	private String loginlog_dt;	
	private String user_out_rs;
	private String user_out_dt;
	private String acclog_sq_pk;
	private String acclog_user_id;
	private String acclog_dt;
	private String acclog_user_ip;
		private String acclog_page;
	private String acclog_inf;
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
	
	//----------------user-------------------------------------------------
	
	public String getAcclog_dt() {
		return acclog_dt;
	}
	public void setAcclog_dt(String acclog_dt) {
		this.acclog_dt = acclog_dt;
	}


	
	public String getAcclog_user_id() {
		return acclog_user_id;
	}
	public void setAcclog_user_id(String acclog_user_id) {
		this.acclog_user_id = acclog_user_id;
	}
	public String getAcclog_user_ip() {
		return acclog_user_ip;
	}
	public void setAcclog_user_ip(String acclog_user_ip) {
		this.acclog_user_ip = acclog_user_ip;
	}

	
	public String getAcclog_sq_pk() {
		return acclog_sq_pk;
	}
	public void setAcclog_sq_pk(String acclog_sq_pk) {
		this.acclog_sq_pk = acclog_sq_pk;
	}
	
	public String getAcclog_page() {
		return acclog_page;
	}
	public void setAcclog_page(String acclog_page) {
		this.acclog_page = acclog_page;
	}
	public String getAcclog_inf() {
		return acclog_inf;
	}
	public void setAcclog_inf(String acclog_inf) {
		this.acclog_inf = acclog_inf;
	}

	
	public String getUser_out_rs() {
		return user_out_rs;
	}
	public void setUser_out_rs(String user_out_rs) {
		this.user_out_rs = user_out_rs;
	}
	public String getUser_out_dt() {
		return user_out_dt;
	}
	public void setUser_out_dt(String user_out_dt) {
		this.user_out_dt = user_out_dt;
	}

	public String getLoginlog_user_ip() {
		return loginlog_user_ip;
	}
	public void setLoginlog_user_ip(String loginlog_user_ip) {
		this.loginlog_user_ip = loginlog_user_ip;
	}
	public String getLoginlog_dt() {
		return loginlog_dt;
	}
	public void setLoginlog_dt(String loginlog_dt) {
		this.loginlog_dt = loginlog_dt;
	}

	
	
	public String getLoginlog_user_id() {
		return loginlog_user_id;
	}
	public void setLoginlog_user_id(String loginlog_user_id) {
		this.loginlog_user_id = loginlog_user_id;
	}

	
	public String getUser_id_pk() {
		return user_id_pk;
	}
	public void setUser_id_pk(String user_id_pk) {
		this.user_id_pk = user_id_pk;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	public String getUser_em() {
		return user_em;
	}
	public void setUser_em(String user_em) {
		this.user_em = user_em;
	}
	public int getAccess() {
		return access;
	}
	public void setAccess(int access) {
		this.access = access;
	}
	public String getCreate_dt() {
		return create_dt;
	}
	public void setCreate_dt(String create_dt) {
		this.create_dt = create_dt;
	}
	public String getChange_dt() {
		return change_dt;
	}
	public void setChange_dt(String change_dt) {
		this.change_dt = change_dt;
	}
	
	
	public String getUser_file_nm() {
		return user_file_nm;
	}
	public void setUser_file_nm(String user_file_nm) {
		this.user_file_nm = user_file_nm;
	}
	
	public MultipartFile getUploadfile() {
        return uploadfile;
    }
 
    public void setUploadfile(MultipartFile uploadfile) {
        this.uploadfile = uploadfile;
    }

	
	//-------------paging-------------------------------------------------
	
	public User() {   //페이지 초기설정
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
