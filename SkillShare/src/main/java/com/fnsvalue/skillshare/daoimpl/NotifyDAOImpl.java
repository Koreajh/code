package com.fnsvalue.skillshare.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnsvalue.skillshare.dao.NotifyDAO;
import com.fnsvalue.skillshare.mapper.NotifyMapper;


@Component
public class NotifyDAOImpl implements NotifyDAO {

	@Autowired
    private SqlSession sqlSession;
	
	public int notifyadd(String NOTIFY_FROM_ID, String NOTIFY_TO_ID, String NOTIFY_CON_FST, String NOTIFY_CON_SCD,
			String NOTIFY_DT) {
		int result;
		NotifyMapper notifyMapper = sqlSession.getMapper(NotifyMapper.class);
		result=notifyMapper.notifyadd(NOTIFY_FROM_ID, NOTIFY_TO_ID, NOTIFY_CON_FST, NOTIFY_CON_SCD, NOTIFY_DT);
				
		return result;
	}
	
	public ArrayList<HashMap> notifyview(String NOTIFY_TO_ID) {
		ArrayList<HashMap> result;
		NotifyMapper notifyMapper = sqlSession.getMapper(NotifyMapper.class);
		result=notifyMapper.notifyview(NOTIFY_TO_ID);
				
		return result;
	}

	
	public int notifystupdate(String NOTIFY_FROM_ID, String NOTIFY_TO_ID, String NOTIFY_CON_FST) {
		int result;
		System.out.println("NOTIFY_FROM_ID = "+NOTIFY_FROM_ID);
		System.out.println("NOTIFY_TO_ID = "+NOTIFY_TO_ID);
		System.out.println("NOTIFY_CON_FST = "+NOTIFY_CON_FST);
		NotifyMapper notifyMapper = sqlSession.getMapper(NotifyMapper.class);
		result=notifyMapper.notifystupdate(NOTIFY_FROM_ID, NOTIFY_TO_ID, NOTIFY_CON_FST);
				
		return result;
	}

}
