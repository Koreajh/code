<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="./include/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<link href="${pageContext.request.contextPath}/resources/plugins/daterangepicker/daterangepicker-bs3.css">
<link href="${pageContext.request.contextPath}/resources/plugins/datepicker/datepicker3.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.5.7/basic/ckeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/editor/js/HuskyEZCreator.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/daterangepicker/daterangepicker.js"></script>
 
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

<script>
    $(function () {
        $('#board_dur').daterangepicker();
   	});
</script>

  <section class="content-header">
    <h1>
    SkillShare
    </h1>
    <ol class="breadcrumb">
    <li><a href="#"><i class="fa fa-dashboard"></i>Home</a></li>
    <li class="active">SkillShare</li>
    </ol>
  </section>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        
      </h1>
      
    </section>

    <!-- Main content -->
    <form action="boardadd" method="post" id="frm">
    <input type="hidden" name="user_tb_user_id_pk" id="user_tb_user_id_pk" value="${sessionScope.userLoginInfo.user_id_pk}">
    
    <section class="content">
      <div class="row">
<div class="col-md-12">
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">글제목 <input type="text" name="board_tit" id="board_tit"></h3>

            
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">

              <!-- /.mailbox-controls -->
              <div class="mailbox-read-message">
      
        
                나의기술 <input type="text" name="my_sk" id="my_sk">
                요구기술 <input type="text" name="want_sk" id="want_sk">
                
  <!-- Date range -->
  		<div class="form-group">
                <label>기간</label>
                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <input type="text" class="form-control pull-right" name="board_dur" id="board_dur">
                </div>
                <!-- /.input group -->
              </div>
        <br>
      <textarea name="board_con" id="board_con" rows="10" cols="100" style="width:766px; height:412px;"></textarea>		
              </div>
              <!-- /.mailbox-read-message -->
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
            
            
            <button type="submit" class="btn btn-primary fa fa-pencil" id="savebutton">올리기</button>
            <a href="boardBack" class="btn btn-warning fa fa-arrow-left">뒤로</a>
         	  
            <!-- /.box-footer -->
          </div>
          
          
          
          <!-- /. box -->
        </div>
        <!-- /.col -->     
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
    </form>
  </div>
  <!-- /.content-wrapper -->



<%@include file="./include/footer.jsp"%>
</body>
</html>