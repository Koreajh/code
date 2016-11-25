<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("UTF-8");%>
<%  String SourceURL=(String)request.getAttribute("javax.servlet.forward.request_uri");
	session.setAttribute("sourceURL",SourceURL);%>  
<script src="//cdn.ckeditor.com/4.5.7/basic/ckeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/editor/js/HuskyEZCreator.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
    //전역변수
    var obj = [];               
    //스마트에디터 프레임생성
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: obj,
        elPlaceHolder: "board_con",
        sSkinURI: "${pageContext.request.contextPath}/resources/editor/SmartEditor2Skin.html", 
        htParams : {
            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseToolbar : true,             
            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseVerticalResizer : true,     
            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
            bUseModeChanger : true, 
        }
    });
    //전송버튼
    $("#savebutton").click(function(){
        //id가 smarteditor인 textarea에 에디터에서 대입
        obj.getById["board_con"].exec("UPDATE_CONTENTS_FIELD", []);
        //폼 submit
        $("#frm").submit();
    })
})
</script>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${requestScope.NoticeDetails}

<c:forEach var="row" items="${NoticeDetails}">
<form action="noticeChange" method="post" id="frm">
<input type="hidden" name="board_no_pk" id="board_no_pk" value="${row.board_no_pk}">
<input type="hidden" name="user_tb_user_id_pk" id="user_tb_user_id_pk" value="${row.user_tb_user_id_pk}">
<table border="1">
	<tr>
		<td colspan="2">title:<input type="text" name="board_tit" id="board_tit" value="${row.board_tit}"></td>
	</tr>
	
	<tr>
	content:<textarea name="board_con" id="board_con" rows="10" cols="100" style="width:766px; height:412px;">${row.board_con}</textarea>		
    </tr> 
	
<!--  	  <tr>
		<td colspan="2">content:<textarea name="board_con" id="board_con" >${row.board_con}</textarea>
		</td>
	</tr>
	<tr>-->
	<td colspan="2"><input type="submit" value="수정하기" id="savebutton"></td>
	</tr>	
</table>
</form>
</c:forEach>

</body>
</html>