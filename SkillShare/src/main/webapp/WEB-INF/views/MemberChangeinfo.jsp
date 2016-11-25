<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*"%>
    <%request.setCharacterEncoding("UTF-8");%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%  String SourceURL=(String)request.getAttribute("javax.servlet.forward.request_uri");
	session.setAttribute("sourceURL",SourceURL);%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>메인 :: SkillShare register</title>
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
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
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
        //이름 입력여부 검사
		  if(document.change_Info.user_nm.value=="")
		  {
		    alert("이름을 입력하지 않았습니다.")
			document.change_Info.user_nm.focus()
			return false
		  }
		  //이메일 입력여부 검사
		  if(document.change_Info.user_em.value=="")
		  {
		    alert("이메일을 입력하지 않았습니다.")
			document.change_Info.user_em.focus()
			return false
		  }
		  //비밀번호 입력여부 체크
		  if(document.change_Info.user_pw.value=="")
		  {
			alert("비밀번호를 입력하지 않았습니다.")
			document.change_Info.user_pw.focus()
			return false
	      }
	      //비밀번호 길이 체크(4~20자 까지 허용)
		  if (document.change_Info.user_pw.value.length<4 || document.change_Info.user_pw.value.length>20)
	      {
		    alert ("비밀번호를 4~20자까지 입력해주세요.")
			document.change_Info.user_pw.focus()
			document.change_Info.user_pw.select()
			return false
		  }
	      //비밀번호와 비밀번호 확인 일치여부 체크
		  if (document.change_Info.user_pw.value!=document.change_Info.user_repw.value)
		  {
			alert("비밀번호가 일치하지 않습니다")
			document.change_Info.user_pw.value=""
			document.change_Info.user_repw.value=""
			document.change_Info.user_pw.focus()
			return false
	      }
		  //약관 동의여부 검사
		  if(document.change_Info.user_ck.checked = false)
		  {
		    alert("약관에 동의하지 않았습니다.")
			document.change_Info.user_ck.focus()
			return false
		  }
    });
    });
  </script>
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="login"><b>SkillShare</b></a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg">원하는 정보로 수정하세요!</p>

    <form action="changeinfo" name="change_Info" id="change_Info" method="post" enctype="multipart/form-data">
    	<input type="hidden" name="user_id_pk" id="user_id_pk" value="${sessionScope.userLoginInfo.user_id_pk}">
    	
    	
      
      <div class="form-group has-feedback">
        <input type="email" name="user_em" id="user_em" title="사용자EMAIL" value="${sessionScope.userLoginInfo.user_em}" class="form-control" placeholder="Email">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="text" name="user_nm" id="user_nm" title="사용자이름" value="${sessionScope.userLoginInfo.user_nm}" class="form-control" placeholder="Full name">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="user_pw" id="user_pw" title="사용자PW" value="${sessionScope.userLoginInfo.user_pw}" class="form-control" placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="user_repw" id="user_repw" title="사용자REPW" class="form-control" placeholder="Retype password">
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
      </div>
      
      <div class="form-group has-feedback">
        <input type="file" name="uploadfile" id="uploadfile" title="사용자사진" class="form-control"  required="required" placeholder="Picture">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
           
          </div>
        </div>
        <!-- /.col -->
        <div >
          <a href="changeinfoBack"><button type="button" class="btn btn-warning">뒤로</button></a>
          <button type="submit" class="btn btn-primary submit">수정</button>
          
        </div>
        <!-- /.col -->
      </div>
    </form>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->
</body>
</html>