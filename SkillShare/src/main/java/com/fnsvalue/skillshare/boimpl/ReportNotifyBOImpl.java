package com.fnsvalue.skillshare.boimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnsvalue.skillshare.bo.ReportNotifyBO;
import com.fnsvalue.skillshare.dao.ReportNotifyDAO;
@Service
public class ReportNotifyBOImpl implements ReportNotifyBO {
	
	@Autowired
	private ReportNotifyDAO reportNotifyDAO;

	@Override
	public int reportnotifyadd(String REPORTNOTIFY_TO, String REPORTNOTIFY_BOARD_NO, String REPORTNOTIFY_BOARD_USER,
			int REPORTNOTIFY_CNT, String REPORTNOTIFY_DT) {
		// TODO Auto-generated method stub
		return 0;
	}

}
