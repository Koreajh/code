package com.fnsvalue.skillshare.boimpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnsvalue.skillshare.bo.RootDetailsManagerBO;
import com.fnsvalue.skillshare.dao.LoginDAO;
import com.fnsvalue.skillshare.dao.RootDetailsManagerDAO;
import com.fnsvalue.skillshare.dao.RootManagerDAO;
import com.fnsvalue.skillshare.dto.User;

@Service
public class RootDetailsManagerBOImpl implements RootDetailsManagerBO {
	@Autowired
	
	public RootDetailsManagerDAO rootdetailsmanagerDAO;

	public ArrayList<HashMap> UserDetailsView(String USER_ID_PK)
	{
		return rootdetailsmanagerDAO.UserDetailsView(USER_ID_PK);
	}

	@Override
	public Integer UserDelete(String USER_ID_PK) {
		// TODO Auto-generated method stub
		
		return rootdetailsmanagerDAO.UserDelete(USER_ID_PK);
		
	}
	
	public ArrayList<HashMap> checkLoginView(String USER_ID_PK,int PAGE_START, int PERPAGE_NUM)
	{
		return rootdetailsmanagerDAO.checkLoginView(USER_ID_PK,PAGE_START,PERPAGE_NUM);
	}
	
	public ArrayList<HashMap> checkLogDetailView(String USER_TB_USER_ID_PK,int PAGE_START, int PERPAGE_NUM)
	{
		return rootdetailsmanagerDAO.checkLogDetailView(USER_TB_USER_ID_PK,PAGE_START,PERPAGE_NUM);

	}
	
	public int countLogPaging(String USER_ID_PK)
	{
		return rootdetailsmanagerDAO.countLogPaging(USER_ID_PK);
	}
	
	public int countLogDetailPaging(String USER_ID_PK)
	{
		return rootdetailsmanagerDAO.countLogDetailPaging(USER_ID_PK);
			
	}


	

	public Integer insertOutMem(String OUTUSER_ID,String OUTUSER_RS)
	
	{
		return rootdetailsmanagerDAO.insertOutMem(OUTUSER_ID,OUTUSER_RS);
	}
	
	public Integer UserBan(String USER_ID_PK)
	{
		return rootdetailsmanagerDAO.UserBan(USER_ID_PK);
	}
	
	public Integer UserBanCancel(String USER_ID_PK)
	{
		return rootdetailsmanagerDAO.UserBanCancel(USER_ID_PK);		
	}

}
