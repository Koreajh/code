package com.fnsvalue.skillshare.boimpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnsvalue.skillshare.bo.NotifyBO;
import com.fnsvalue.skillshare.dao.NotifyDAO;

@Service
public class NotifyBOImpl implements NotifyBO {

	@Autowired
	private NotifyDAO notifyDAO;
	
	public int notifyadd(String NOTIFY_FROM_ID, String NOTIFY_TO_ID, String NOTIFY_CON_FST, String NOTIFY_CON_SCD,
			String NOTIFY_DT) {
		
		return notifyDAO.notifyadd(NOTIFY_FROM_ID, NOTIFY_TO_ID, NOTIFY_CON_FST, NOTIFY_CON_SCD, NOTIFY_DT);
		
	}

	@Override
	public ArrayList<HashMap> notifyview(String NOTIFY_TO_ID) {
		
		return notifyDAO.notifyview(NOTIFY_TO_ID);
		
	}

	@Override
	public int notifystupdate(String NOTIFY_FROM_ID, String NOTIFY_TO_ID, String NOTIFY_CON_FST) {
		// TODO Auto-generated method stub
		return notifyDAO.notifystupdate(NOTIFY_FROM_ID, NOTIFY_TO_ID, NOTIFY_CON_FST);
		
	}

}
