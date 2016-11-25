package com.fnsvalue.skillshare.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.fnsvalue.skillshare.dto.User;

public interface RootDetailsManagerDAO {

	public ArrayList<HashMap> UserDetailsView(String USER_ID_PK);
	
	public Integer UserDelete(String uSER_ID_PK);
	
	public ArrayList<HashMap> checkLoginView(String USER_ID_PK,int PAGE_START, int PERPAGE_NUM);
	
	public ArrayList<HashMap> checkLogDetailView(String USER_TB_USER_ID_PK,int PAGE_START, int PERPAGE_NUM);
	
	public int countLogPaging(String USER_ID_PK);
	
	public int countLogDetailPaging(String USER_ID_PK);
	
	public Integer UserBan(String USER_ID_PK);
	
	public Integer UserBanCancel(String USER_ID_PK);
	
	
	public Integer insertOutMem(String OUTUSER_ID,String OUTUSER_RS);
	
	
}
