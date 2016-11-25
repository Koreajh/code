package com.fnsvalue.skillshare.chat;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;
 
public class EchoHandler extends TextWebSocketHandler {

//	아래방법은 일대 일 방식	
	Map<String, WebSocketSession> sessions  = new HashMap<String, WebSocketSession>();
	
//	아래방법은 일대 다 방식	
//	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
    private static Logger logger = LoggerFactory.getLogger(EchoHandler.class);
    
    
    /**
     * 클라이언트 연결 이후에 실행되는 메소드
     */
    
    public void afterConnectionEstablished(WebSocketSession session)
            throws Exception {
//		아래방법은 일대 일 방식
    	sessions.put(session.getId(), session);
    	logger.info(" 현재 연결자 수 {"+sessions.size()+"}");
    	
    	
//    	아래방법은 일대 다 방식	   	
//    	sessionList.add(session);
        logger.info("{"+session.getId()+"} 연결됨.");
        logger.info("{"+sessions.get(session.getId())+"} 연결됨.");
        
    }
    /**
     * 클라이언트가 웹소켓 서버로 메시지를 전송했을 때 실행되는 메소드
     */
    @Override
    protected void handleTextMessage(WebSocketSession session,
            TextMessage message) throws Exception {
        logger.info("{"+session.getId()+"}로 부터 {"+message.getPayload()+"} 받음", session.getId(), message.getPayload());
        // 연결되어 있는 모든 클라이언트들에게 메세지를 전송한다

//        아래방법은 일대 일 방식
        Iterator<String> sessionIds = sessions.keySet().iterator();
        String sessionId = "";
        while (sessionIds.hasNext()) {
            sessionId = sessionIds.next();
            sessions.get(sessionId).sendMessage(new TextMessage(message.getPayload()));
            
        }
       
        
//        아래방법은 일대 다 방식
//      for(WebSocketSession sess : sessionList){
//            sess.sendMessage(new TextMessage(message.getPayload()));
//            
//        }
               
//        연결되어 있는 모든 클라이언트들에게 메시지를 전송한다.
//        session.sendMessage(new TextMessage(message.getPayload()));
    }
    
    /**
     * 클라이언트가 연결을 끊었을 때 실행되는 메소드
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session,
            CloseStatus status) throws Exception {
    	
        //일대 다 방식
//        sessionList.remove(session);
        
        //일대 일 방식
        sessions.remove(session.getId());
    	
    	
        logger.info("{"+session.getId()+"} 연결 끊김.", session.getId());
    }
    
    
}

