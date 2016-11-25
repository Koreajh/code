package com.fnsvalue.skillshare.boimpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnsvalue.skillshare.bo.RootManagerBO;
import com.fnsvalue.skillshare.dao.LoginDAO;
import com.fnsvalue.skillshare.dao.RootManagerDAO;
import com.fnsvalue.skillshare.dto.User;

@Service
public class RootManagerBOImpl implements RootManagerBO {
	@Autowired
	
	public RootManagerDAO rootmanagerDAO;
	public ArrayList<HashMap> UserView(int PAGE_START,int PERPAGE_NUM)
	{
		return rootmanagerDAO.UserView(PAGE_START,PERPAGE_NUM);
	}
	
	public int countPaging()
	{
		return rootmanagerDAO.countPaging();
	}
	
	
	
	
	
}
