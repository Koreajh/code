<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello WebSocket</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/sockjs-0.3.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/stomp.js"></script>
    <script type="text/javascript">
    
    $(document).ready(function(){
        $("#sendTo").click(function(){
        	
        	sendName();
        });
    });
    
    
var stompClient = null;
        function setConnected(connected) {
            document.getElementById('connect').disabled = connected;
            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }
        function connect() {
            var socket = new SockJS('<c:url value="/hello"/>');
            
            var from= $("#from").val();
            var to= $("#to").val();
            var message= "님이 접속하였습니다.";
          
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/greetings', function(greeting){
                    showGreeting(JSON.parse(greeting.body).content);
                    
                });
                stompClient.subscribe('/topic/logings', function(loging){
                    showLoging(JSON.parse(loging.body).content);
                    
                });
                //여기에 코딩해요
            console.log('give me some good : '+stompClient.connectCallback);
            stompClient.send("/app/hello", {}, JSON.stringify({ 'from':from, 'to':to, 'message':message }));
            stompClient.send("/app/loginuser", {}, JSON.stringify({ 'loginuser':from, 'loginuserst':0}));
            });
        }
        
        
        function disconnect() {
        	if (stompClient != null) {
        		var from= $("#from").val();
        		stompClient.send("/app/loginuser", {}, JSON.stringify({ 'loginuser':from, 'loginuserst':1}));
                stompClient.disconnect();
            }
            setConnected(false);
            console.log("Disconnected");
        }
        function sendName() {
            var from= $("#from").val();
            var to= $("#to").val();
            var message= $("#message").val();
            stompClient.send("/app/hello", {}, JSON.stringify({ 'from':from, 'to':to, 'message':message }));
        }

        function showGreeting(message) {
            var response = document.getElementById('response');
            var p = document.createElement('p');
            var me= $('#from').val();
            var str =message.split(':');
            console.log("from:"+ str[0]);
            console.log("to:"+ str[1]);
            console.log("msg:"+ str[2]);
            console.log("me:"+ me);
            
            if(str[1]==me || str[0]==me){
            p.style.wordWrap = 'break-word';
            p.appendChild(document.createTextNode(str[0]+":"+str[2]));
            response.appendChild(p);
            }
        }
         function showLoging(message) {
        	 var response = document.getElementById('userresponse');
             var p = document.createElement('p');
             p.style.wordWrap = 'break-word';
             console.log("ddddd:"+message);
             p.appendChild(document.createTextNode(message));
             response.appendChild(p);     
        }
         
         onbeforeunload = function() { 
            	 disconnect();   
       } 
    </script>
</head>
<body onload="disconnect()">
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being enabled. Please enable
    Javascript and reload this page!</h2></noscript>
    <table>
    <tr>
    <td>
<div>
    <div>
        <button id="connect" onclick="connect();">Connect</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
    </div>
    <div id="conversationDiv">
   		<input type="hidden" id="from" value="${sessionScope.userLoginInfo.user_id_pk}"/><br>
   		<input type="text" id="to" value=""/><br>
        <input type="text" id="message" />
        <button id="sendTo">Send</button> 
        <p id="response"></p>
    </div> 
</div>
</td>
<td>
<p id="userresponse"></p>
</td>
</tr>
</table>
</body>
</html>