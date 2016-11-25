package com.fnsvalue.skillshare.bo;

import java.util.ArrayList;
import java.util.HashMap;

import com.fnsvalue.skillshare.dto.User;

public interface RootManagerBO {
	public ArrayList<HashMap> UserView(int PAGE_START,int PERPAGE_NUM);
	public int countPaging();
	
	
}