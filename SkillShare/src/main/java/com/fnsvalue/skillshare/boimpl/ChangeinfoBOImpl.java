package com.fnsvalue.skillshare.boimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnsvalue.skillshare.bo.ChangeinfoBO;
import com.fnsvalue.skillshare.dao.ChangeinfoDAO;


@Service
public class ChangeinfoBOImpl implements ChangeinfoBO {

	@Autowired
    private ChangeinfoDAO changeinfoDAO;
	
	public Integer changeinfoUser(String USER_ID_PK, String USER_PW, String USER_NM, String USER_EM,String USER_FILE_NM) {
		return changeinfoDAO.changeinfoUser(USER_ID_PK,USER_PW,USER_NM,USER_EM,USER_FILE_NM);
	}
}
