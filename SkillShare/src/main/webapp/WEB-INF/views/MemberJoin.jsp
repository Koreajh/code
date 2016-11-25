<%@page import="java.io.File"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import= "java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String SourceURL=(String)request.getAttribute("javax.servlet.forward.request_uri");
	session.setAttribute("sourceURL",SourceURL);%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
  <meta charset="UTF-8">
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
    	  if(document.join_form.user_id_pk.value=="")
    	  {
    	    alert("아이디를 입력하지 않았습니다.")
    		document.join_form.user_id_pk.focus()
    		return false
    	  }
          //아이디 유효성 검사 (영문소문자, 숫자만 허용)
    	  for (i=0;i<document.join_form.user_id_pk.value.length ;i++ )
    	  {
            ch=document.join_form.user_id_pk.value.charAt(i)
            if (!(ch>='0' && ch<='9') && !(ch>='a' && ch<='z'))
    		{
    		  alert ("아이디는 소문자, 숫자만 입력가능합니다.")
    		  document.join_form.user_id_pk.focus()
    		  document.join_form.user_id_pk.select()
    		  return false
    		}
          }
          //아이디에 공백 사용하지 않기
    	  if (document.join_form.user_id_pk.value.indexOf(" ")>=0)
    	  {
    		alert("아이디에 공백을 사용할 수 없습니다.")
    		document.join_form.user_id_pk.focus()
    		document.join_form.user_id_pk.select()
    		return false
    	  }
          //아이디 길이 체크 (4~20자)
    	  if (document.join_form.user_id_pk.value.length<4 || document.join_form.user_id_pk.value.length>20)
    	  {
    		alert ("아이디를 4~20자까지 입력해주세요.")
    		document.join_form.user_id_pk.focus()
    		document.join_form.user_id_pk.select()
    		return false
    	  }
    	  //이름 입력여부 검사
    	  if(document.join_form.user_nm.value=="")
    	  {
    	    alert("이름을 입력하지 않았습니다.")
    		document.join_form.user_nm.focus()
    		return false
    	  }
    	  //이메일 입력여부 검사
    	  if(document.join_form.user_em.value=="")
    	  {
    	    alert("이메일을 입력하지 않았습니다.")
    		document.join_form.user_em.focus()
    		return false
    	  }
    	  //비밀번호 입력여부 체크
    	  if(document.join_form.user_pw.value=="")
    	  {
    		alert("비밀번호를 입력하지 않았습니다.")
    		document.join_form.user_pw.focus()
    		return false
          }
          //비밀번호 길이 체크(4~20자 까지 허용)
    	  if (document.join_form.user_pw.value.length<4 || document.join_form.user_pw.value.length>20)
          {
    	    alert ("비밀번호를 4~20자까지 입력해주세요.")
    		document.join_form.user_pw.focus()
    		document.join_form.user_pw.select()
    		return false
    	  }
          //비밀번호와 비밀번호 확인 일치여부 체크
    	  if (document.join_form.user_pw.value!=document.join_form.user_repw.value)
    	  {
    		alert("비밀번호가 일치하지 않습니다")
    		document.join_form.user_pw.value=""
    		document.join_form.user_repw.value=""
    		document.join_form.user_pw.focus()
    		return false
          }
    	  //약관 동의여부 검사
    	  if(document.join_form.user_ck.checked == false)
    	  {
    	    alert("약관에 동의하지 않았습니다.")
    		document.join_form.user_ck.focus()
    		return false
    	  }
    	});
    });
  </script>
  
 <script type="text/javascript">
 function doubleCheck(){
  $.ajax({
   url : "doubleCheck",
   type : "post",
   data : {
   user_id_pk : $("#user_id_pk").val()
   },
   dataType : "json",
   success : function(data){
    
	   var val=data.result;
	   
  	   if ( val == "success") 
       {
    	   alert('사용가능한 ID입니다.');
       } 
       else 
       {
       	   alert('이미 사용중인 ID입니다.');       
       }
      }
           });
 }
 </script>
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="login"><b>SkillShare</b></a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg">회원이 되어 스킬을 나누세요!</p>

    <form action="join" name="join_form" id="join_form" enctype="multipart/form-data" method="post" >
      <div class="form-group has-feedback">
       
         <input type="text" name="user_id_pk" id="user_id_pk" title="사용자ID" class="form-control" placeholder="ID"/>
         <input type="button" value="중복 체크" onclick="doubleCheck();">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="text" name="user_nm" id="user_nm" title="사용자이름" class="form-control" placeholder="Full name">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="email" name="user_em" id="user_em" title="사용자EMAIL" class="form-control" placeholder="Email">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="user_pw" id="user_pw" title="사용자PW" class="form-control" placeholder="Password">
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
            <label>
              <input type="checkbox" id="user_ck" name="user_ck"> <a data-toggle="modal" href="#myModal">약관</a>에 동의합니다.
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat submit">가입</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
    <a href="login.html" class="text-center">전 이미 회원입니다.</a>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">가입 약관</h4>
        </div>
        <div class="modal-body">
    <p>본사이트 'SkillShare'는 서비스 이용을 위해 아이디, 이름, 이메일, 비밀번호의 개인정보 수집을 합니다.</p>
    <p>본사이트 'SkillShare'는 개인정보 제공자의 동의 없이 타 3자에게 정보를 넘기지 않습니다.</p>
    <p>본사이트 'SkillShare'에의해 수집된 개인정보는 사용자의 삭제 요청이 있기 전까지는 보관됩니다.
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- /.Modal -->
</body>
</html>