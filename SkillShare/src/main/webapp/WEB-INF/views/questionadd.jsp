<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="./include/header.jsp"%>

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
        elPlaceHolder: "ask_con",
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
        obj.getById["ask_con"].exec("UPDATE_CONTENTS_FIELD", []);
        //폼 submit
        $("#frm").submit();
    })
})
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
    <form action="questionadd" method="post" id="frm">
    <input type="hidden" name="user_tb_user_id_pk" id="user_tb_user_id_pk" value="${sessionScope.userLoginInfo.user_id_pk}">
    
    <section class="content">
      <div class="row">
<div class="col-md-12">
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">문의 제목 <input type="text" name="ask_tit" id="ask_tit"></h3>

            
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
             
              <!-- /.mailbox-controls -->
              <div class="mailbox-read-message"><br>
    <textarea name="ask_con" id="ask_con" rows="10" cols="100" style="width:766px; height:412px;"></textarea>		
    		
              </div>
              <!-- /.mailbox-read-message -->
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
            
       <button type="submit" class="btn btn-primary fa fa-pencil" id="savebutton">올리기</button>
       <a href="questionBack"><input type="button" value="뒤로" class="btn btn-warning"></a>
              
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
