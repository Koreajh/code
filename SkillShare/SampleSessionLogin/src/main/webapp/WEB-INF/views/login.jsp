<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
  <!-- iCheck -->
  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
  <script type="text/javascript">
    $(function () {
      $('input').iCheck({
        checkboxClass: 'icheckbox_square-blue',
        radioClass: 'iradio_square-blue',
        increaseArea: '20%' // optional
      });
    });
  </script>
</head>
<body class="hold-transition login-page">
<c:choose>
	<c:when test="${not empty sessionScope.userLoginInfo}">
		<h2>로그인 성공 </h2>
		이름 : ${sessionScope.userLoginInfo.user_nm}<br>
		이메일 : <c:out value="${sessionScope.userLoginInfo.user_em}"/> <br>
		<br>
		<a href="logout">로그아웃</a>
		<br><br>
		<a href="page1">페이지1</a>&nbsp;&nbsp;<a href="page2">페이지2</a>
	</c:when>
	<c:otherwise>
		  <div class="login-box">
  <div class="login-logo">
    <a href="#"><b>SkillShare</b></a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">로그인을 통해 Skill을 나누세요!</p>

    <form name="form1" method="post" action="loginProcess">
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
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> 계정정보 기억하기
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">로그인</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
    <a href="MemberJoin" class="text-center">회원가입</a>
  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
	</c:otherwise>
</c:choose>
</body>
</html>