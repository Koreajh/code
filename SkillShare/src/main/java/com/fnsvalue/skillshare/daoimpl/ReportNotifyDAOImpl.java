package com.fnsvalue.skillshare.daoimpl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnsvalue.skillshare.dao.ReportNotifyDAO;
import com.fnsvalue.skillshare.mapper.BoardMapper;
import com.fnsvalue.skillshare.mapper.ReportNotifyMapper;
@Component
public class ReportNotifyDAOImpl implements ReportNotifyDAO {
	
	@Autowired
    private SqlSession sqlSession;

	
	public int reportnotifyadd(String REPORTNOTIFY_TO, String REPORTNOTIFY_BOARD_NO, String REPORTNOTIFY_BOARD_USER,
			int REPORTNOTIFY_CNT, String REPORTNOTIFY_DT) {
		
		int result;
		ReportNotifyMapper reportnotifyMapper = sqlSession.getMapper(ReportNotifyMapper.class);
		result=reportnotifyMapper.reportnotifyadd(REPORTNOTIFY_TO, REPORTNOTIFY_BOARD_NO, REPORTNOTIFY_BOARD_USER, REPORTNOTIFY_CNT, REPORTNOTIFY_DT);
		
		return result;
	}

}
