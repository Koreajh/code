package com.fnsvalue.skillshare.boimpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnsvalue.skillshare.bo.ApplyBO;
import com.fnsvalue.skillshare.dao.ApplyDAO;

@Service
public class ApplyBOImpl implements ApplyBO {

	@Autowired
	private ApplyDAO applyDAO;
	
	public int applyAdd(int APPLY_NO_PK, String USER_TB_USER_ID_PK, int BOARD_TB_BOARD_NO_PK) {
		
		return applyDAO.applyAdd(APPLY_NO_PK, USER_TB_USER_ID_PK, BOARD_TB_BOARD_NO_PK);
		
	}
	
	@Override
	public int applyCount(int BOARD_TB_BOARD_NO_PK,String USER_TB_USER_ID_PK)
	{
		return applyDAO.applyCount(BOARD_TB_BOARD_NO_PK,USER_TB_USER_ID_PK);		
	}

	@Override
	public ArrayList<HashMap> applyView(int BOARD_TB_BOARD_NO_PK) {
		
		return applyDAO.applyView(BOARD_TB_BOARD_NO_PK);
	}

	@Override
	public int applyAgree(int APPLY_NO_PK) {
		
		return applyDAO.applyAgree(APPLY_NO_PK);
	}

	@Override
	public int applyDisAgree(int APPLY_NO_PK) {
		
		return applyDAO.applyDisAgree(APPLY_NO_PK);
	}

	@Override
	public int applyDelete(String USER_TB_USER_ID_PK, int BOARD_TB_BOARD_NO_PK) {
		
		return applyDAO.applyDelete(USER_TB_USER_ID_PK, BOARD_TB_BOARD_NO_PK);
	}

	@Override
	public ArrayList<HashMap> applyPerView(String USER_TB_USER_ID_PK, int PAGE_START, int PERPAGE_NUM) {
		
		return  applyDAO.applyPerView(USER_TB_USER_ID_PK, PAGE_START, PERPAGE_NUM);
		
	}
	
	@Override
	public int countPaging() {
		
		return applyDAO.countPaging();
	}

	@Override
	public int applyAgreeDelete(int APPLY_NO_PK) {
		
		return applyDAO.applyAgreeDelete(APPLY_NO_PK);
		
	}

	@Override
	public String applyGetId(String USER_TB_USER_ID_PK, int BOARD_TB_BOARD_NO_PK) {
		return applyDAO.applyGetId(USER_TB_USER_ID_PK,BOARD_TB_BOARD_NO_PK);
	}

}
