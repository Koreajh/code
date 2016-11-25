package com.fnsvalue.skillshare.daoimpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fnsvalue.skillshare.dao.ChatDAO;
import com.fnsvalue.skillshare.mapper.ChatMapper;

@Component
public class ChatDAOImpl implements ChatDAO {

	@Autowired
    private SqlSession sqlSession;
	
	
	public int Chatadd(String CHAT_FROM, String CHAT_TO, String CHAT_MSG, String CHAT_DT) {
		int result;
		ChatMapper chatMapper = sqlSession.getMapper(ChatMapper.class);
		result=chatMapper.Chatadd(CHAT_FROM, CHAT_TO, CHAT_MSG, CHAT_DT);
				
		return result;
	}
	
	public ArrayList<HashMap> Chatview(String CHAT_FROM, String CHAT_TO) {
		ArrayList<HashMap> result;
		ChatMapper chatMapper = sqlSession.getMapper(ChatMapper.class);
		result=chatMapper.Chatview(CHAT_FROM, CHAT_TO);
		return result;
	}

	@Override
	public Integer Chatupdate(String CHAT_FROM, String CHAT_TO) {
		System.out.println("update parameter = "+CHAT_FROM+" / "+CHAT_TO);
		Integer result;
		ChatMapper chatMapper = sqlSession.getMapper(ChatMapper.class);
		result=chatMapper.Chatupdate(CHAT_FROM, CHAT_TO);
		System.out.println("update return = "+result);
		return result;
	}

	@Override
	public Integer Chatcount(String CHAT_FROM, String CHAT_TO) {
		ChatMapper chatMapper = sqlSession.getMapper(ChatMapper.class);
		chatMapper.Chatcount(CHAT_FROM, CHAT_TO);
		return chatMapper.Chatcount(CHAT_FROM, CHAT_TO);
	}

}
