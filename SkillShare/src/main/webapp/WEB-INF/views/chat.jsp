<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/sockjs-0.3.4.js"></script>
<script type="text/javascript">


$(document).ready(function(){
    $("#sendBtn").click(function(){
    	
        sendMessage();
    });
});

//websocket을 지정한 URL로 연결
var sock= new SockJS("<c:url value="/echo"/>");
//websocket 서버에서 메시지를 보내면 자동으로 실행된다.
sock.onopen= onOpen;
sock.onmessage = onMessage;
//websocket 과 연결을 끊고 싶을때 실행하는 메소드
sock.onclose = onClose;


function sendMessage(){
		var send_message={
				from : $("#messageuser_id").val(),
				to : $("#message_to").val(),
				message : $("#message").val()

		}
		var send_message_str = JSON.stringify(send_message);
    
        //websocket으로 메시지를 보내겠다.
        //sock.send($("#messageuser_id").val()+":"+$("#message").val());
		sock.send(send_message_str);
}
        
//evt 파라미터는 websocket이 보내준 데이터다.
function onOpen(evt){  //변수 안에 function자체를 넣음.
    //var data = evt.data;
	var send_message={
			from : $("#messageuser_id").val(),
			to : "All",
			message : $("#messageuser_id").val()+"님이 접속하였습니다."

	}
	var send_message_str = JSON.stringify(send_message);
    sock.send(send_message_str);
    /* sock.close(); */
}

function onMessage(evt){  //변수 안에 function자체를 넣음.
    //var data = evt.data;
	var data = JSON.parse(evt.data);
	
	var data_to = data.to;
	var data_from = data.from;
	var data_message = data.message;
	var data_me = $("#messageuser_id").val();
	
	console.log("to:"+data_to);
	console.log("from:"+data_from);
	console.log("me:"+data_me);
	console.log("message:"+data_message);
	
	if(data_me == data_to || data_me == data_from || data_to == "All"){
	$("#data").append(data_from+":"+data_message+"<br/>");
	}
	

    /* sock.close(); */
}

function onClose(evt){
	sock.send($("#messageuser_id").val()+"연결 끊김");
}
</script>
</head>
<body>
${sessionScope.userLoginInfo.user_id_pk}
    <input type="text" id="message_to" value=""/>
    <input type="text" id="message" /> 
    <input type="hidden" id="messageuser_id" value="${sessionScope.userLoginInfo.user_id_pk}"/>
    <input type="button" id="sendBtn" value="전송" />
    <div id="data"></div>
    
    
</body>
</html>
