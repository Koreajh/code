package com.fnsvalue.skillshare.bo;

import java.util.ArrayList;
import java.util.HashMap;

public interface ChatBO {
	public int Chatadd(String CHAT_FROM, String CHAT_TO, String CHAT_MSG, String CHAT_DT);
	public ArrayList<HashMap> Chatview(String CHAT_FROM, String CHAT_TO);
	public Integer Chatupdate(String CHAT_FROM, String CHAT_TO);
	public Integer Chatcount(String CHAT_FROM, String CHAT_TO);
}
