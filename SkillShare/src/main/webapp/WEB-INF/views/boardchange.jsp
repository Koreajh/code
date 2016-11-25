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
    <c:forEach var="row" items="${BoardDetails}">
    <form action="boardChange" method="post" id="frm">
    <input type="hidden" name="board_no_pk" id="board_no_pk" value="${row.board_no_pk}">
    <input type="hidden" name="user_tb_user_id_pk" id="user_tb_user_id_pk" value="${row.user_tb_user_id_pk}">
    <section class="content">
      <div class="row">
<div class="col-md-12">
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">글제목 <input type="text" name="board_tit" id="board_tit" value="${row.board_tit}"></h3>

            
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <div class="mailbox-read-info">
                
              <h3>
              <span class="mailbox-read-time pull-right">
              ${row.board_dt}
              </span>
              </h3>
              </div>
              
                
              <!-- /.mailbox-read-info -->
              
              <!-- /.mailbox-controls -->
              <div class="mailbox-read-message">
              <c:if test="${row.board_fl ==0}">
                나의기술 <input type="text" name="my_sk" id="my_sk" value="${row.my_sk}">
                요구기술 <input type="text" name="want_sk" id="want_sk" value="${row.want_sk}">
     예상소요기간 <input type="text" name="board_dur" id="board_dur" value="${row.board_dur}">
      </c:if> <br>
    <textarea name="board_con" id="board_con" rows="10" cols="100" style="width:766px; height:412px;" >${row.board_con}</textarea>
              </div>
              <!-- /.mailbox-read-message -->
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
            
       <button type="submit" value="수정" class="btn btn-info fa fa-retweet" id="savebutton">수정</button>
              
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
    </c:forEach>
  </div>
  <!-- /.content-wrapper -->
<%@include file="./include/footer.jsp"%>
</body>
</html>
