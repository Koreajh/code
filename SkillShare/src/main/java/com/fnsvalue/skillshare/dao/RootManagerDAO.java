package com.fnsvalue.skillshare.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.fnsvalue.skillshare.dto.User;

public interface RootManagerDAO {

	public ArrayList<HashMap> UserView(int PAGE_START,int PERPAGE_NUM);
	public int countPaging();
	
}
