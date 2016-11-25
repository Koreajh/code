package com.fnsvalue.skillshare.dto;

public class Comment {

	private int comment_no_pk;
	private String user_tb_user_id_pk;
	private int ask_tb_ask_no_pk;
	private String comment_con;
	private String comment_dt;
	public int getComment_no_pk() {
		return comment_no_pk;
	}
	public void setComment_no_pk(int comment_no_pk) {
		this.comment_no_pk = comment_no_pk;
	}
	public String getUser_tb_user_id_pk() {
		return user_tb_user_id_pk;
	}
	public void setUser_tb_user_id_pk(String user_tb_user_id_pk) {
		this.user_tb_user_id_pk = user_tb_user_id_pk;
	}
	public int getAsk_tb_ask_no_pk() {
		return ask_tb_ask_no_pk;
	}
	public void setAsk_tb_ask_no_pk(int ask_tb_ask_no_pk) {
		this.ask_tb_ask_no_pk = ask_tb_ask_no_pk;
	}
	public String getComment_con() {
		return comment_con;
	}
	public void setComment_con(String comment_con) {
		this.comment_con = comment_con;
	}
	public String getComment_dt() {
		return comment_dt;
	}
	public void setComment_dt(String comment_dt) {
		this.comment_dt = comment_dt;
	}
	@Override
	public String toString() {
		return "Comment [comment_no_pk=" + comment_no_pk + ", user_tb_user_id_pk=" + user_tb_user_id_pk
				+ ", ask_tb_ask_id_pk=" + ask_tb_ask_no_pk + ", comment_con=" + comment_con + ", comment_dt="
				+ comment_dt + "]";
	}
	
	
	
}
