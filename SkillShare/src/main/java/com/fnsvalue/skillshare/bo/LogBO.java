//package com.fnsvalue.skillshare.bo;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.fnsvalue.skillshare.dto.Log;
//import com.fnsvalue.skillshare.mapper.LogMapper;
//
//
//@Service
//public class LogBO {
//
//	@Autowired
//	private LogMapper logMapper;
//
//	/**
//	 * 신규
//	 * @param log
//	 */
//	@Transactional("transactionManager")
//	public void insertLog(Log log){
//		logMapper.insert(log);
//	}
//	
//}
