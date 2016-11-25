package com.fnsvalue.skillshare.boimpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fnsvalue.skillshare.bo.ChatBO;
import com.fnsvalue.skillshare.dao.ChatDAO;

@Service
public class ChatBOImpl implements ChatBO {

	@Autowired
	private ChatDAO chatDAO;
	
	@Override
	public int Chatadd(String CHAT_FROM, String CHAT_TO, String CHAT_MSG, String CHAT_DT) {
		
		return chatDAO.Chatadd(CHAT_FROM, CHAT_TO, CHAT_MSG, CHAT_DT);
	}

	@Override
	public ArrayList<HashMap> Chatview(String CHAT_FROM, String CHAT_TO) {
		return chatDAO.Chatview(CHAT_FROM, CHAT_TO);
		
	}

	@Override
	public Integer Chatupdate(String CHAT_FROM, String CHAT_TO) {
		
		return chatDAO.Chatupdate(CHAT_FROM, CHAT_TO);
	}

	@Override
	public Integer Chatcount(String CHAT_FROM, String CHAT_TO) {
		return chatDAO.Chatcount(CHAT_FROM, CHAT_TO);
	}

}
