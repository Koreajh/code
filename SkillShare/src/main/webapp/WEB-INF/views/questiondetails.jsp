<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./include/header.jsp"%>
<script src="//cdn.ckeditor.com/4.5.7/basic/ckeditor.js"></script>
<script>
$(document).on("click", ".replyChange", function() {
    var replyID = $(this).attr('id');
    if($("#"+replyID+"_input").css('display') == "none" )
    {
        $("#"+replyID+"_input").css('display', 'inline');
        $("#"+replyID+"_content").css('display', 'none');
        $("#"+replyID+"_").css('display', 'inline');
    }
    else
    {
    	$.ajax({
    		   url : "commentUpdate",
    		   type : "post",
    		   data : {
    		       ask_tb_ask_no_pk : $("#ask_no_pk").val(),
    		       comment_no_pk : replyID,
    		       user_tb_user_id_pk : $("#user_id_pk").val(),
    		       comment_con : $("#"+replyID+"_input").val()
    			   },
    		   dataType : "json",
    		   success : function(data){
    		       $("#"+replyID+"_content").text($("#"+replyID+"_input").val());
    		       $("#"+replyID+"_input").css('display', 'none');
    		       $("#"+replyID+"_content").css('display', 'inline');
    		       $("#"+replyID+"_").css('display', 'none');
    	      	}
    	});
    }
});

$(document).on("click", ".changeReset", function() {
    var replyID = $(this).attr('id');
    $("#"+replyID+"input").css('display', 'none');
    $("#"+replyID+"content").css('display', 'inline');
    $("#"+replyID).css('display', 'none');
});
$(document).on("click", ".replyDel", function() {
    $.ajax({
		   url : "CommentDelete",
		   type : "post",
		   data : {
		       ask_tb_ask_no_pk : $("#ask_no_pk").val(),
		       comment_no_pk : replyID,
		       user_tb_user_id_pk : $("#user_id_pk").val()
			   },
		   dataType : "json",
		   success : function(data){
		       $("#"+replyID+"_content").text($("#"+replyID+"_input").val());
		       $("#"+replyID+"_input").css('display', 'none');
		       $("#"+replyID+"_content").css('display', 'inline');
		       $("#"+replyID+"_").css('display', 'none');
	      	}
	});
});
</script>
  <section class="content-header">
    <h1>
      사용자 정보
    </h1>
    <ol class="breadcrumb">
    <li><a href="#"><i class="fa fa-dashboard"></i>Home</a></li>
    <li class="active">질문 답변</li>
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

    <section class="content">
      <div class="row">
        <div class="col-md-12">
          <div class="box box-primary">
            <c:forEach var="row" items="${QuestionDetailView}">
            <input type="hidden" id="user_id_pk" value="${row.user_tb_user_id_pk}">
            <input type="hidden" id="ask_no_pk" value="${row.ask_no_pk}">
              <div class="box-header with-border">
                <h3 class="box-title">${row.user_tb_user_id_pk}</h3>
              </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <div class="mailbox-read-info">
                <h3>${row.ask_tit}</h3>
              <h3>
              <span class="mailbox-read-time pull-right">
              ${row.ask_dt}
              </span>
              </h3>
              </div>
              <!-- /.mailbox-read-info -->

              <!-- /.mailbox-controls -->
              <div class="mailbox-read-message">
                ${row.ask_con}
              </div>
              <!-- /.mailbox-read-message -->
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
              <c:choose>
     		  <c:when test="${row.user_tb_user_id_pk==sessionScope.userLoginInfo.user_id_pk || sessionScope.userLoginInfo.access == 1}">
              <a data-toggle="modal" href="#questiondeleteModal" class="btn btn-danger fa fa-trash-o">삭제</a>
              </c:when>
               </c:choose> 
               <c:choose>
              <c:when test="${row.user_tb_user_id_pk==sessionScope.userLoginInfo.user_id_pk}">
       		  <a href="questionChangeForm?ask_id=${row.ask_no_pk}" class="btn btn-info fa fa-retweet">수정</a>
       		  </c:when>
       		  </c:choose>    
            <!-- /.box-footer -->
          </div>
             <!-- Modal -->
  <div class="modal fade" id="questiondeleteModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">     
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">삭제메세지</h4>
        </div>
        <div class="modal-body">
    <p>정말 삭제하시겠습니까?</p>
        </div>
        <div class="modal-footer">
        <a href="questionDelete?ask_id=${row.ask_no_pk}" class="btn btn-danger fa fa-trash-o">삭제</a>
        <a class="btn btn-warning fa fa-arrow-left" data-dismiss="modal">취소</a>
        </div>
      </div>
    </div>
   </div>
<!-- /.Modal -->
          <div>
          <form action="commentAdd" method="post">
          <input type="hidden" name='user_tb_user_id_pk' id='user_tb_user_id_pk' value="${sessionScope.userLoginInfo.user_id_pk}"><br>
          <input type='hidden' name='ask_tb_ask_no_pk' id='ask_tb_ask_no_pk' value="${row.ask_no_pk}"><br>
          <input name='comment_con' id='comment_con'>
          <button id="comment" class=".comment" name="comment">댓글 달기</button>
          </form>
          </div>
          <ul id="comment_data">
          </ul>
          </c:forEach>
          <!-- /. box -->
          <ul class="timeline">
            <!-- timeline time label -->
            <li class="time-label">
            </li>
            <!-- /.timeline-label -->
            <c:forEach var="row" items="${CommentView}">
            <!-- timeline item -->
            <li>
              <i class="fa fa-comments bg-aqua"></i>
              <div class="timeline-item">
                <span class="time"><i class="fa fa-clock-o"></i> 5 mins ago</span>
                <h3 class="timeline-header no-border"><b> ${row.user_tb_user_id_pk}</b><br><a id="${row.comment_no_pk}_content">${row.comment_con}</a></h3>
         	 <c:choose>
     	     <c:when test="${row.user_tb_user_id_pk==sessionScope.userLoginInfo.user_id_pk}">
     	     <input name='comment_con' id='${row.comment_no_pk}_input' type="text" style="display:none" >
     	     <button id="${row.comment_no_pk}" class="btn btn-info fa fa-retweet replyChange">수정</button>
     	     <button id="${row.comment_no_pk}_" class="btn btn-warning fa fa-arrow-left changeReset" style="display:none">취소</button>
     	     </c:when>
     	     </c:choose>
              </div>
            </li>
            <!-- END timeline item -->
            </c:forEach>
            <li>
              <i class="fa fa-clock-o bg-gray"></i>
            </li>
          </ul>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
<!-- /.content-wrapper -->
<%@include file="./include/footer.jsp"%>

</body>
</html>