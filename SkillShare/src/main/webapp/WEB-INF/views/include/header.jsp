<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>메인 | SkillShare main</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.5 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminLTE2/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminLTE2/skins/_all-skins.min.css">
  
  <link href="${pageContext.request.contextPath}/resources/js/lib/toastr.css" rel="stylesheet"/>

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  
  <!-- jQuery 2.1.4 -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
  <!-- Bootstrap 3.3.5 -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/bootstrap.min.js"></script>
  <!-- FastClick -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/fastclick/fastclick.js"></script>
  <!-- AdminLTE App -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/adminLTE2/app.min.js"></script>
  <!-- Sparkline -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/sparkline/jquery.sparkline.min.js"></script>
  <!-- jvectormap -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
  <!-- SlimScroll 1.3.0 -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
  <!-- ChartJS 1.0.1 -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/chartjs/Chart.min.js"></script>
  <!-- AdminLTE dashboard demo (This is only for demo purposes)
  jquery 오류에 의해 잠시 주석 처리
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/adminLTE2/pages/dashboard2.js"></script>
   -->
  <!-- AdminLTE for demo purposes -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/adminLTE2/demo.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/sockjs-0.3.4.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/stomp.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lib/toastr.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/common/headerNavController.js"></script>
  <script type="text/javascript">
  toastr.options = {
		  "closeButton": true,
		  "debug": false,
		  "newestOnTop": false,
		  "progressBar": true,
		  "positionClass": "toast-bottom-left",
		  "preventDuplicates": false,
		  "onclick": null,
		  "showDuration": "300",
		  "hideDuration": "1000",
		  "timeOut": "5000",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
        };
  
  Date.prototype.format = function(f) {
	    if (!this.valueOf()) return " ";
	 
	    var weekName = ["일", "월", "화", "수", "목", "금", "토"];
	    var d = this;
	     
	    return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1) {
	        switch ($1) {
	            case "yyyy": return d.getFullYear();
	            case "yy": return (d.getFullYear() % 1000).zf(2);
	            case "MM": return (d.getMonth() + 1).zf(2);
	            case "dd": return d.getDate().zf(2);
	            case "E": return weekName[d.getDay()];
	            case "HH": return d.getHours().zf(2);
	            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2);
	            case "mm": return d.getMinutes().zf(2);
	            case "ss": return d.getSeconds().zf(2);
	            case "a/p": return d.getHours() < 12 ? "오전" : "오후";
	            default: return $1;
	        }
	    });
	};

	String.prototype.string = function(len){var s = '', i = 0; while (i++ < len) { s += this; } return s;};
	String.prototype.zf = function(len){return "0".string(len - this.length) + this;};
	Number.prototype.zf = function(len){return this.toString().zf(len);};
  
  var stompClient = null;

  
  $(document).ready(function(){
      connect();
      $("#sendBtn").click(function(){
  	    sendMessage();
  	  });
      $("#message").keydown(function (key) {
          if (key.keyCode == 13) {
              sendMessage();
              return false;
          }
      });
      $("#notifyevent").click(function(){
    	  notifyF();
      });
  });
  $(document).ready(function () {
	  var nowURL=document.location.href;
	  var user_id = $("#from").val();
	$.ajax({
	   url : "checkDetail",
	   type : "post",
	   data : {
		   nowURL : nowURL,
		   user_id_pk : user_id
		   },
	   dataType : "json",
	});
});


  $(window).bind('beforeunload', function() {
      if ((event.clientY < 0) ||(event.altKey) ||(event.ctrlKey)||((event.clientY < 129) && (event.clientY>107))) { 
      disconnect()
      }
  });

  $(document).on("click", ".user_list", function() {
      var user = $(this).attr('id');
      if (user != $("#to").val()) { 
      $("#chat_messages").empty();
      $("#chat_messages").val("loading");
      $("#to").val(user)
      var from= $("#from").val();
      stompClient.send("/app/load", {}, JSON.stringify({ 'loadfrom':from, 'loadto':user }));
      }
  });
  
  function connect() {
      var socket = new SockJS('<c:url value="/hello"/>');
      
      var from= $("#from").val();
      var to= $("#to").val();
      //var message= $("#from").val()+"님이 접속하였습니다.";

      stompClient = Stomp.over(socket);
      stompClient.connect({}, function(frame) {
          console.log('Connected: ' + frame);
          stompClient.subscribe('/topic/testings', function(testing){
              showTesting(JSON.parse(testing.body).content);
          });
          stompClient.subscribe('/topic/greetings', function(greeting){
              showGreeting(JSON.parse(greeting.body).content);
          });
          stompClient.subscribe('/topic/logings', function(loging){
              showLoging(JSON.parse(loging.body).content);
          });
          stompClient.subscribe('/topic/loadings', function(loading){
              showLoading(JSON.parse(loading.body).content);
          });          
          stompClient.subscribe('/topic/chatupdates', function(updating){
              showUpdating(JSON.parse(updating.body).content);
          });
          stompClient.subscribe('/topic/chatcounts', function(counting){
              showCounting(JSON.parse(counting.body).content);
          });
          stompClient.subscribe('/topic/notifyings', function(notifying){
              showNotifying(JSON.parse(notifying.body).content);
          });
          stompClient.subscribe('/topic/notifyloadings', function(notifyloading){
              showNotifyLoading(JSON.parse(notifyloading.body).content);
          });
          stompClient.subscribe('/topic/reportnotifyings', function(reportnotifying){
              showReportNotifying(JSON.parse(reportnotifying.body).content);
          });
          stompClient.subscribe('/topic/reportnotifyloadings', function(reportnotifyloading){
              showNReportotifyLoading(JSON.parse(reportnotifyloading.body).content);
          });
      console.log('give me some good : '+stompClient.connectCallback);
      //stompClient.send("/app/hello", {}, JSON.stringify({ 'from':from, 'to':to, 'message':message }));
      stompClient.send("/app/loginuser", {}, JSON.stringify({ 'loginuser':from, 'loginuserst':0}));
      });
  }

  function disconnect() {
      if (stompClient != null) {
          var from= $("#from").val();
          stompClient.send("/app/loginuser", {}, JSON.stringify({ 'loginuser':from, 'loginuserst':1}));
          stompClient.disconnect();
      }
      console.log("Disconnected");
  }
  function sendMessage() {
      var from= $("#from").val();
      var to= $("#to").val();
      var message= $("#message").val();
      var dt =new Date().format("yyyy-MM-dd E a/p hh시 mm분");
      console.log("생으로"+new Date().format("yyyy-MM-dd E a/p hh시 mm분 ss초"));
      console.log("변해서"+dt);
      
      stompClient.send("/app/hello", {}, JSON.stringify({ 'from':from, 'to':to, 'message':message, 'dt':dt }));
      var message= $("#message").val("");
  }
  function showTesting(message) {
  alert("massege test = "+message);
  }
  function showGreeting(message) {
      var str = message.split(':');
      var from = str[0];
      var to = str[1];
      var msg = str[2];
      var dt = str[3]
      var me = $('#from').val();
      var me_to = $('#to').val();
      console.log("from:"+ str[0]);
      console.log("to:"+ str[1]);
      console.log("msg:"+ str[2]);
      console.log("me:"+ me);

      if(me == to) {
          if(me_to == from) {
              $("#chat_messages").append(""
                  +"<div class=\"direct-chat-msg\">"
            		+"<div class=\"direct-chat-info clearfix\">"
                	+"<span class=\"direct-chat-name pull-left\">"+from+"</span>"
                	+"<span class=\"direct-chat-timestamp pull-right\">"+dt+"</span>"
                	+"</div>"
                	+"<img class=\"direct-chat-img\" src=\"\" alt=\"message user image\">"
                	+"<div class=\"direct-chat-text\">"
                	+msg
                	+"</div>"
                	+"</div>"
              );
              stompClient.send("/app/chatupdate", {}, JSON.stringify({ 'from':from, 'to':me}));
          } else {
        	  toastr["success"](from+"님의 쪽지 왔어요:"+msg);
              $("."+from).text(msg);
              stompClient.send("/app/chatcount", {}, JSON.stringify({ 'from':from, 'to':me}));
              
          }
    	}else if(me == from) {
    		$("#chat_messages").append(""
    			+"<div class=\"direct-chat-msg right\">"
    			+"<div class=\"direct-chat-info clearfix\">"
    			+"<span class=\"direct-chat-name pull-right\">"+from+"</span>"
    			+"<span class=\"direct-chat-timestamp pull-left\">"+dt+"</span>"
    			+"</div>"
    			+"<img class=\"direct-chat-img\" src=\"\" alt=\"message user image\">"
    			+"<div class=\"direct-chat-text\">"
    			+msg
    			+"</div>"
    			+"</div>"
    		);
      }
      $('#chat_messages').scrollTop($('#chat_messages').prop('scrollHeight'));
      
          
  }
  
  function notifyF() {
	  var me = $("#from").val();
	  stompClient.send("/app/notifyload", {}, JSON.stringify({ 'to_id' : me }));
	  
  }

  function showNReportotifyLoading(message){
	  
  }
  
  function showReportNotifying(message){
	  var str = message.split(':');
	  var to = str[0];
      var board_no = str[1];
      var board_user = str[2];
      var cnt = str[3];
      var me = $("#from").val();
      if(me == to){
        toastr["info"]("관리자님 "+board_user+"님의 "+board_no+"번 글이 "+cnt+"번 신고당했습니다.");
        $("#Notifying").prepend(""
  	            +"<li>"
  	            +"<a href=notifystUpdate?from_id="+board_user+"&to_id="+to+"&sq="+board_no+">"
  				+"<span class=\"handle ui-sortable-handle\">"
  				+"<i class=\"fa fa-users text-aqua\"></i>"
  	            +"</span>"
  	            +"관리자님 "+board_user+"님의 "+board_no+"번 글이 "+cnt+"번 신고당했습니다."
  	            +"</a>"
  	            +"</li>"
		);
      }
  }
  function showNotifyLoading(message){
	  $("#Notifying").empty();
	  jQuery.each(message, function(i, message_val) {
		  var jsonString = JSON.stringify(message_val);
		  var data = JSON.parse(jsonString);
		  var me = $('#from').val();
		  var from_id = data.NOTIFY_FROM_ID;
		  var to_id = data.NOTIFY_TO_ID;
		  var sq = data.NOTIFY_CON_FST;
		  var tit = data.NOTIFY_CON_SCD;
		  
		  if(to_id==me){
		  $("#Notifying").append(""
	  	            +"<li>"
	  	            +"<input id=\""+from_id+"_"+sq+"_from_id\" type=\"hidden\" value=\""+from_id+"\">"
	  		        +"<input id=\""+from_id+"_"+sq+"_to_id\" type=\"hidden\" value=\""+to_id+"\">"
	  	            +"<a href=notifystUpdate?from_id="+from_id+"&to_id="+to_id+"&sq="+sq+">"
	  				+"<span class=\"handle ui-sortable-handle\">"
	  				+"<i class=\"fa fa-users text-aqua\"></i>"
	  	            +"</span>"
	  	            +""+from_id+"님이 글"+sq+"호 글:'"+tit+"'에 신청하셨습니다."
	  	            +"</a>"
	  	            +"<div class=\"tools\">"
	  	            +"<i id=\""+from_id+"_"+sq+"\" class=\"fa fa-thumbs-o-up accept_apply\"></i>"
	  	            +"<i id=\""+from_id+"_"+sq+"\" class=\"fa fa-thumbs-o-down unaccept_apply\"></i>"
	  	          	+"<i id=\""+from_id+"_"+sq+"\" class=\"fa fa-check-square-o notifystUpdate\"></i>"
	  	        	+"</div>"
	  	            +"</li>"
			);
		  }
		  
	  });
	  
  }

  function showLoading(message) {
      if ( $("#chat_messages").val() == "loading" ) {
		  var me = $('#from').val();
		  var me_to = $('#to').val();
	  jQuery.each(message, function(i, message_val) {
		  var jsonString = JSON.stringify(message_val);
		  var data = JSON.parse(jsonString);
		  var from = data.CHAT_FROM;
		  var to = data.CHAT_TO;
		  var msg = data.CHAT_MSG;
		  var dt = data.CHAT_DT;
		  if(me == to && me_to == from) {
              $("#chat_messages").append(""
                  +"<div class=\"direct-chat-msg\">"
            		+"<div class=\"direct-chat-info clearfix\">"
                	+"<span class=\"direct-chat-name pull-left\">"+from+"</span>"
                	+"<span class=\"direct-chat-timestamp pull-right\">"+dt+"</span>"
                	+"</div>"
                	+"<img class=\"direct-chat-img\" src=\"\" alt=\"message user image\">"
                	+"<div class=\"direct-chat-text\">"
                	+msg
                	+"</div>"
                	+"</div>"
              );
    	}else if(me == from && me_to == to) {
    		$("#chat_messages").append(""
    			+"<div class=\"direct-chat-msg right\">"
    			+"<div class=\"direct-chat-info clearfix\">"
    			+"<span class=\"direct-chat-name pull-right\">"+from+"</span>"
    			+"<span class=\"direct-chat-timestamp pull-left\">"+dt+"</span>"
    			+"</div>"
    			+"<img class=\"direct-chat-img\" src=\"\" alt=\"message user image\">"
    			+"<div class=\"direct-chat-text\">"
    			+msg
    			+"</div>"
    			+"</div>"
    		);
	      }
		  /*
		  jQuery.each(message_val, function(j, message_val_val) {
			  console.log(j+":: "+ message_val_val);
		  });
		  */
	  });
	  console.log('update set = '+me_to+" / "+me);
	  $("#chat_messages").val("")
      $('#chat_messages').scrollTop($('#chat_messages').prop('scrollHeight'));
	  stompClient.send("/app/chatupdate", {}, JSON.stringify({ 'from':me_to, 'to':me}));
      }
  }
  
  function showLoging(message) {
      var myId = $("#from").val();
      $("#contacts-list").empty();
  	jQuery.each(message, function(i, message_val) {
  	    if(myId != message_val){
  	        $("#contacts-list").append(
  	            $('<li/>', {
  	                id: message_val,
  	                class: 'user_list'
  	            })
  	        );
  	        $("#"+message_val).append(""
  	            +"<a href=\"#\" data-toggle=\"tooltip\" data-widget=\"chat-pane-toggle\">"
  	            +"<img class=\"contacts-list-img\" src=\"\">"
  	            +"<div class=\"contacts-list-info\">"
  	            +"<span class=\"contacts-list-name\">"
  	            +message_val
  	            +"<span id=\""+message_val+"_count\" class=\"label label-warning chat_count\"></span>"
  	            +"<small class=\"contacts-list-date pull-right\">2/28/2015</small>"
  	            +"</span>"
  	            +"<span class=\"contacts-list-msg "+message_val+"\"></span>"
  	            +"</div>"
  	            +"</a>"
  	        );
  	  	  stompClient.send("/app/chatcount", {}, JSON.stringify({ 'from':message_val, 'to':myId}));
  	    }
  	});
  }
  function showUpdating(message) {
	  var jsonString = JSON.stringify(message);
	  var data = JSON.parse(jsonString);
	  console.log("update data = "+data.form+ " and "+data.to);
	  stompClient.send("/app/chatcount", {}, JSON.stringify({ 'from':data.form, 'to':data.to}));
  }
  function showCounting(message) {
      var myId = $("#from").val();
	  var jsonString = JSON.stringify(message);
	  var data = JSON.parse(jsonString);
	  var alarm = 0;
	  if(myId == data.CHAT_TO) {
	      console.log("showCounting date.from :"+ data.CHAT_FROM);
	      console.log("showCounting date.to :"+ data.CHAT_TO);
	      console.log("showCounting date.count :"+ data.COUNT);
	      if(data.COUNT != ""){
	          $("#"+data.CHAT_FROM+"_count").text(" "+data.COUNT);
	      }else{
	          $("#"+data.CHAT_FROM+"_count").text(" 0");
	      }
	      var all_count = $(".chat_count").text().split(' ');
	      jQuery.each(all_count, function(i, count) {
	          if(i>0){
	              alarm += parseInt(count);
	          }
	      });
		      $("#chat_alarm").text(alarm);
	  }
  }
  
  onbeforeunload = function() {
  	disconnect();   
  }
  
  function showNotifying(message){
	  var str = message.split(':');
	  var from_id = str[0];
      var to_id = str[1];
      var sq = str[2];
      var tit = str[3];
      var me = $("#from").val();
	 
      if(me == to_id){
        toastr["info"](from_id+"님이"+to_id+"님의 글"+sq+"호 글:'"+tit+"'에 신청되었습니다.");
        $("#Notifying").prepend(""
  	            +"<li>"
  	            +"<input id=\""+from_id+"_"+sq+"_from_id\" type=\"hidden\" value=\""+from_id+"\">"
  		        +"<input id=\""+from_id+"_"+sq+"_to_id\" type=\"hidden\" value=\""+to_id+"\">"
  	            +"<a href=notifystUpdate?from_id="+from_id+"&to_id="+to_id+"&sq="+sq+">"
  				+"<span class=\"handle ui-sortable-handle\">"
  				+"<i class=\"fa fa-users text-aqua\"></i>"
  	            +"</span>"
  	            +""+from_id+"님이 글"+sq+"호 글:'"+tit+"'에 신청하셨습니다."
  	            +"</a>"
  	            +"<div class=\"tools\">"
  	            +"<i id=\""+from_id+"_"+sq+"\" class=\"fa fa-thumbs-o-up accept_apply\"></i>"
  	            +"<i id=\""+from_id+"_"+sq+"\" class=\"fa fa-thumbs-o-down unaccept_apply\"></i>"
  	          	+"<i id=\""+from_id+"_"+sq+"\" class=\"fa fa-check-square-o notifystUpdate\"></i>"
  	        	+"</div>"
  	            +"</li>"
		);
      }
  }
  $(document).on("click", ".accept_apply", function() {
      var sq = $(this).attr('id');
      var from_id = $("#"+sq+"_from_id").val();
      var to_id = $("#"+sq+"_to_id").val();
      var temp = sq.split("_");
      sq = temp[1];
      	$.ajax({
      		   url : "applyAgreeAjax",
      		   type : "post",
      		   data : {
      		     user_tb_user_id_pk : from_id,
      		   board_tb_board_no_pk : sq
      			   },
      		   dataType : "json",
      		   success : function(data){
      		     $.ajax({
            		   url : "notifystUpdateAjax",
            		   type : "post",
            		   data : {
            		       notify_from_id : from_id,
            		       notify_to_id : to_id,
            		       notify_con_fst : sq
            			   },
            		   dataType : "json",
            		   success : function(data){
            		       notifyF();
            	      	}
            	});
      	      	}
      	});
  });
  $(document).on("click", ".unaccept_apply", function() {
      var sq = $(this).attr('id');
      var from_id = $("#"+sq+"_from_id").val();
      var to_id = $("#"+sq+"_to_id").val();
      var temp = sq.split("_");
      sq = temp[1];
      	$.ajax({
      		   url : "applyUnAgreeAjax",
      		   type : "post",
      		   data : {
      		     user_tb_user_id_pk : from_id,
      		   board_tb_board_no_pk : sq
      			   },
      		   dataType : "json",
      		   success : function(data){
      		     $.ajax({
            		   url : "notifystUpdateAjax",
            		   type : "post",
            		   data : {
            		       notify_from_id : from_id,
            		       notify_to_id : to_id,
            		       notify_con_fst : sq
            			   },
            		   dataType : "json",
            		   success : function(data){
            		       notifyF();
            	      	}
            	});
      	     }
      	});
  });
  $(document).on("click", ".notifystUpdate", function() {
      var sq = $(this).attr('id');
      var from_id = $("#"+sq+"_from_id").val();
      var to_id = $("#"+sq+"_to_id").val();
      var temp = sq.split("_");
      sq = temp[1];
      $.ajax({
		   url : "notifystUpdateAjax",
		   type : "post",
		   data : {
		       notify_from_id : from_id,
		       notify_to_id : to_id,
		       notify_con_fst : sq
			   },
		   dataType : "json",
		   success : function(data){
		       notifyF();
	      	}
	});
  });
  
    /* 코드 보존 기존 websocket 방식
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
  \
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
        //sock.close();
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
    	
    	if(data_me == data_to || data_to =="All"){
      	$("#chat_messages").append(""
      		+"<div class=\"direct-chat-msg\">"
      		+"<div class=\"direct-chat-info clearfix\">"
          	+"<span class=\"direct-chat-name pull-left\">"+data_from+"</span>"
          	+"<span class=\"direct-chat-timestamp pull-right\">23 Jan 2:00 pm</span>"
          	+"</div>"
          	+"<img class=\"direct-chat-img\" src=\"\" alt=\"message user image\">"
          	+" <div class=\"direct-chat-text\">"
          	+data_message
          	+"</div>"
          	+"</div>"
          );

  	}else if(data_me == data_from){
  		$("#chat_messages").append(""
  			+"<div class=\"direct-chat-msg right\">"
  			+"<div class=\"direct-chat-info clearfix\">"
  			+"<span class=\"direct-chat-name pull-right\">"+data_from+"</span>"
  			+"<span class=\"direct-chat-timestamp pull-left\">23 Jan 2:00 pm</span>"
  			+"</div>"
  			+"<img class=\"direct-chat-img\" src=\"\" alt=\"message user image\">"
  			+" <div class=\"direct-chat-text\">"
  			+data_message
  			+"</div>"
  			+"</div>"
  		);
      }
        //sock.close();
    }

    function onClose(evt){
    	sock.send($("#messageuser_id").val()+"연결 끊김");
    }
    */
  </script>
  <script>
  
  </script>
</head>
<body class="hold-transition skin-blue sidebar-mini" onunload="disconnect()">
<c:if test="${empty sessionScope.userLoginInfo}">
<script>
$(location).attr('href',"login");
</script>
</c:if>
<div class="wrapper">
  <header class="main-header">
    <!-- Logo -->
    <a href="main" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>S</b>S</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Skill</b>Share</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <li class="dropdown messages-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-envelope-o"></i>
              <span id="chat_alarm" class="label label-warning"></span>
            </a>
            <ul class="dropdown-menu">
              <div class="box box-warning direct-chat direct-chat-warning">
                <div class="box-header with-border">
                  <form action="#" method="post">
                  <h3 class="box-title">Direct Chat</h3>
                  <div class="box-tools pull-right">
                    <button type="button" class="btn btn-box-tool" data-toggle="tooltip" title="Contacts" data-widget="chat-pane-toggle">
                      <i class="fa fa-comments"></i></button>
                  </div>
                  </form>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                  <!-- Conversations are loaded here -->
                  <div id="chat_messages" class="direct-chat-messages">
                  </div>
                  <!--/.direct-chat-messages-->

                  <!-- Contacts are loaded here -->
                  <form>
                  <div class="direct-chat-contacts">
                    <ul id="contacts-list" class="contacts-list">
                    </ul>
                    <!-- /.contatcts-list -->
                  </div>
                  </form>
                  <!-- /.direct-chat-pane -->
                </div>
                <!-- /.box-body -->
                <div class="box-footer">
                  <form action="#" method="post">
                    <div class="input-group">
                      <input type="text" id="message" placeholder="Type Message ..." class="form-control">
                          <span class="input-group-btn">
                              <input type="hidden" id="to" value="no"/>
                              <input type="hidden" id="from" value="${sessionScope.userLoginInfo.user_id_pk}"/>
                            <button type="button" id="sendBtn" class="btn btn-warning btn-flat">Send</button>
                          </span>
                    </div>
                  </form>
                </div>
                <!-- /.box-footer-->
              </div>
            </ul>
          </li>
          <!-- Notifications: style can be found in dropdown.less -->
          <li class="dropdown notifications-menu">
            <a id="notifyevent" href="#" class="dropdown-toggle" data-toggle="dropdown" >
              <i class="fa fa-bell-o"></i>
              <span id="notif_alarm" class="label label-warning">10</span>
            </a>
            <ul class="dropdown-menu">
          <form>
            <div class="box box-primary">
            <div class="box-header ui-sortable-handle" style="cursor: move;">
              <i class="ion ion-clipboard"></i>

              <h3 class="box-title">Notifications</h3>

              <div class="box-tools pull-right">
                <ul class="pagination pagination-sm inline">
                  <li><a href="#">«</a></li>
                  <li><a href="#">»</a></li>
                </ul>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <ul id="Notifying" class="todo-list ui-sortable">
              </ul>
            </div>
            <!-- /.box-body -->
          </div>
          </form>
            </ul>
          </li>
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="${pageContext.request.contextPath}/resources/img/user/${sessionScope.userLoginInfo.user_file_nm}" class="user-image" alt="User Image">
              <span class="hidden-xs">${sessionScope.userLoginInfo.user_nm}</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="${pageContext.request.contextPath}/resources/img/user/${sessionScope.userLoginInfo.user_file_nm}" class="img-circle" alt="User Image">
                <p>
                  ${sessionScope.userLoginInfo.user_nm}
                  <small>${sessionScope.userLoginInfo.create_dt}</small>
                </p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="changeinfoForm" class="btn btn-default btn-flat">정보수정</a>
                  <a data-toggle="modal" href="#deleteModal" class="btn btn-default btn-flat">회원삭제</a>
                  <a href="login" class="btn btn-default btn-flat">로그아웃</a>
                </div>
                 </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <!--<li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>-->
        </ul>
      </div>
    </nav>
  </header>
    <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
         <img src="${pageContext.request.contextPath}/resources/img/user/${sessionScope.userLoginInfo.user_file_nm}" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${sessionScope.userLoginInfo.user_nm}</p>
        </div>
      </div>
       
      <!-- search form --
     <!--   
     <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      -->
      <!-- /.search form -->
     
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <c:if test="${sessionScope.userLoginInfo.access == 1}">
        <li id="usermanager" class="treeview">
          <a href="usermanagerCri?page=1">
            <i class="fa fa-pie-chart"></i>
            <span>사용자 관리</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
        </li>
        </c:if>
        <li id="boardview" class="treeview">
          <a href="boardviewCri?page=1">
            <i class="fa fa-pie-chart"></i>
            <span>SkillShare 게시판</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
        </li>
         <c:if test="${sessionScope.userLoginInfo.access == 1}">
        <li id="notice" class="treeview">
          <a href="notice?page=1">
            <i class="fa fa-laptop"></i>
            <span>공지사항</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
        </li>
         </c:if>
        <li id="questionboard" class="treeview">
          <a href="questionboard?page=1">
            <i class="fa fa-laptop"></i>
            <span>문의사항</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
        </li>
        <c:if test="${sessionScope.userLoginInfo.access == 0}">
        <li id="applyView" class="treeview">
          <a href="applyPerView?user_id=${sessionScope.userLoginInfo.user_id_pk}">
            <i class="fa fa-laptop"></i>
            <span>신청 목록</span>
            <i class="fa fa-angle-left pull-right"></i>
          </a>
        </li>
         </c:if>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
  
  
  <!-- Modal -->
  <div class="modal fade" id="deleteModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">     
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">삭제메세지</h4>
        </div>
        <div class="modal-body">
    <form action="Userdelete" method="post" id="frm">
    <p>탈퇴사유<p>
    <input type="radio" name=user_out_rs id="user_out_rs" value="기능상불만">기능상불만
    <input type="radio" name=user_out_rs id="user_out_rs" value="운영상불만">운영상불만
    <input type="radio" name=user_out_rs id="user_out_rs" value="단순탈퇴">단순탈퇴
    <input type="hidden" name="user_id_pk" id="user_id_pk" value="${sessionScope.userLoginInfo.user_id_pk}">
    <br>
    <br>
    <p>정말 삭제하시겠습니까?</p>
        <div class="modal-footer">
        <button type="submit" class="btn btn-default btn-flat">네</button>
        <a class="btn btn-default btn-flat" data-dismiss="modal">취소</a>
    	</div>
    </form>
        
        <!--  &reason= -->
        </div>
      </div>
    </div>
   </div>
<!-- /.Modal -->
      