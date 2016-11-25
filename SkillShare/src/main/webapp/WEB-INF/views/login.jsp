<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%  String SourceURL=(String)request.getAttribute("javax.servlet.forward.request_uri");
	session.setAttribute("sourceURL",SourceURL);%>  	
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>메인 :: SkillShare Login</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <meta http-equiv="Content-Script-type" content="text/javascript">
  <meta http-equiv="Content-Style-type" content="text/css">
  <!-- Bootstrap 3.3.5 -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" type="text/css" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/adminLTE2/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/iCheck/square/blue.css">

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
  <!-- iCheck -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
  <script type="text/javascript">
    $(function () {
      $('input').iCheck({
        checkboxClass: 'icheckbox_square-blue',
        radioClass: 'iradio_square-blue',
        increaseArea: '20%' // optional
      });
    $('.submit').click(function(){
    	  //아이디 입력여부 검사
    	  if(document.login_form.user_id_pk.value=="")
    	  {
    	    alert("아이디를 입력하지 않았습니다.")
    		document.login_form.user_id_pk.focus()
    		return false
    	  }
          //아이디 유효성 검사 (영문소문자, 숫자만 허용)
    	  for (i=0;i<document.login_form.user_id_pk.value.length ;i++ )
    	  {
            ch=document.login_form.user_id_pk.value.charAt(i)
            if (!(ch>='0' && ch<='9') && !(ch>='a' && ch<='z'))
    		{
    		  alert ("아이디는 소문자, 숫자만 입력가능합니다.")
    		  document.login_form.user_id_pk.focus()
    		  document.login_form.user_id_pk.select()
    		  return false
    		}
          }
          //아이디에 공백 사용하지 않기
    	  if (document.login_form.user_id_pk.value.indexOf(" ")>=0)
    	  {
    		alert("아이디에 공백을 사용할 수 없습니다.")
    		document.login_form.user_id_pk.focus()
    		document.login_form.user_id_pk.select()
    		return false
    	  }
          //아이디 길이 체크 (4~20자)
    	  if (document.login_form.user_id_pk.value.length<4 || document.login_form.user_id_pk.value.length>20)
    	  {
    		alert ("아이디를 4~20자까지 입력해주세요.")
    		document.login_form.user_id_pk.focus()
    		document.login_form.user_id_pk.select()
    		return false
    	  }
    	  //비밀번호 입력여부 체크
    	  if(document.login_form.user_pw.value=="")
    	  {
    		alert("비밀번호를 입력하지 않았습니다.")
    		document.login_form.user_pw.focus()
    		return false
          }
          //비밀번호 길이 체크(4~8자 까지 허용)
    	  if (document.login_form.user_pw.value.length<4 || document.login_form.user_pw.value.length>20)
          {
    	    alert ("비밀번호를 4~20자까지 입력해주세요.")
    		document.login_form.user_pw.focus()
    		document.login_form.user_pw.select()
    		return false
    	  }
    	});
    });
  </script>
</head>
<body class="hold-transition login-page">
<c:if test="${not empty sessionScope.userLoginInfo}">
  <%session.removeAttribute("userLoginInfo"); %>
</c:if>
<div class="login-box">
  <div class="login-logo">
    <a href="#"><b>SkillShare</b></a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">로그인을 통해 Skill을 나누세요!</p>
<c:set var="var" value="${param.accessnotify}"/>
<c:if test="${accessnotify == 2}">
<script>
alert ("현재 Ben 상태의 아이디 입니다.");
</script>
</c:if>
<c:if test="${accessnotify == 3}">    
<script>
alert ("탈퇴한 아이디 입니다.");
</script>
</c:if>
    <form name="login_form" id="login_form" method="post" action="loginProcess">
      <div class="form-group has-feedback">
        <input type="text" name="user_id_pk" id="user_id_pk" title="사용자ID" class="form-control" placeholder="Id" accesskey="1">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="user_pw" id="user_pw" title="사용자PW" class="form-control" placeholder="Password" accesskey="2">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <a href="MemberJoin" class="text-center">회원가입</a>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat submit">로그인</button>
        </div>
        <!-- /.col -->
      </div>
      
    </form>
       		
  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
</body>
</html>