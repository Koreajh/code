/**
 * <submit라는 클래스명이 지정된 버튼이 눌릴 경우 form에 이름을 체크해 login, join에 따라 유효성 검사를 실시>
 * 
 * @return false [조건 검사 결과에 따라 false, true 리턴]			
 * @author [김윤교]
 * @version [v0.1], [2016.03.11] 			 
 */
/*
$(function(){
  $('.submit').click(function(){
	if(this.form.name=="login_form")
	{
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
	}
	else if(this.form.name=="join_form")
	{
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
	  if(document.join_form.user_ck.checked = false)
	  {
	    alert("약관에 동의하지 않았습니다.")
		document.join_form.user_ck.focus()
		return false
	  }
	}
	else if(this.form.name=="change_Info")
	{
	    alert("info");
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
		}
  });
});
*/