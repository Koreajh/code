<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="./include/header.jsp"%>
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
    
    <c:set var="var" value="${param.warning}"/>
	<script>
	alert (warning);
	</script>
	
    
    
    <c:set var="var" value="${param.warning}"/>
	<c:if test="${warning==1}">
	<script>
	alert ("이미 신청된 게시물입니다.");
	</script>
	</c:if>

    <!-- Main content -->


    <c:forEach var="row" items="${BoardDetails}">
    <section class="content">
    <div class="row">
<div class="col-md-12">
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">${row.board_tit}</h3>

            
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <div class="mailbox-read-info">
                <h3>${row.user_tb_user_id_pk}</h3>
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
                나의기술 : ${row.my_sk} /
                요구기술 : ${row.want_sk} /
     예상소요기간 : ${row.board_dur}
     </c:if> 
     
     <br><br>
   ${row.board_con}
              </div>
              <!-- /.mailbox-read-message -->
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
 <c:choose>
 <c:when test="${row.user_tb_user_id_pk==sessionScope.userLoginInfo.user_id_pk}">
            
    <a data-toggle="modal" href="#boarddeleteModal" class="btn btn-danger fa fa-trash-o" >삭제</a>
    <a href="boardChangeForm?board_id=${row.board_no_pk}&user_id=${row.user_tb_user_id_pk}" class="btn btn-info fa fa-retweet">수정</a>
    <a href="applyviewCri?board_id=${row.board_no_pk}" class="btn btn-success fa fa-reorder">신청리스트</a>
    
              
 </c:when>
 
 <c:when test="${sessionScope.userLoginInfo.access == 1}">
    <a data-toggle="modal" href="#boarddeleteModal" class="btn btn-danger fa fa-trash-o" >삭제</a>
               
 </c:when>
 <c:when test="${row.board_fl==0}">
    <a id="applybutton" href="applyForm?board_id=${row.board_no_pk}&user_id=${sessionScope.userLoginInfo.user_id_pk}&write_id=${row.user_tb_user_id_pk}" class="btn btn-primary fa fa-paper-plane">신청</a>
 	<a data-toggle="modal" href="#reportModal" class="btn btn-danger fa fa-exclamation" >신고</a>
 
 </c:when>
 
 
</c:choose>
   
            <!-- /.box-footer -->
          </div>

          <!-- /. box -->
        </div>
        <!-- /.col -->     
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
    
    <!-- Modal -->
  <div class="modal fade" id="boarddeleteModal" role="dialog">
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
        <a href="boardDelete?board_id=${row.board_no_pk}&user_id=${row.user_tb_user_id_pk}" class="btn btn-danger fa fa-trash-o" >삭제</a>
        <a class="btn btn-warning fa fa-arrow-left" data-dismiss="modal">취소</a>
        </div>
      </div>
    </div>
   </div>
<!-- /.Modal -->

<!-- Modal -->
  <div class="modal fade" id="reportModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">     
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">신고하기</h4>
        </div>
        <div class="modal-body">
    <form>
    <p>신고사유<p>
    <input type="radio" name=report_rs id="report_rs" value="게시판 목적에 맞지 않은글">게시판 목적에 맞지 않은글
    <input type="radio" name=report_rs id="report_rs" value="부적절한 내용">부적절한 내용
    <br>
    <br>
    <textarea name="report_con" id="report_con" rows="10" cols="40" style="width:100%; height:412px;"></textarea>		
    <input type="hidden" name="report_id" id="report_id" value="${sessionScope.userLoginInfo.user_id_pk}">
	<c:forEach var="row" items="${BoardDetails}">
    <input type="hidden" name="board_no_pk" id="board_no_pk" value="${row.board_no_pk}">
    <input type="hidden" name="user_tb_user_id_pk" id="user_tb_user_id_pk" value="${row.user_tb_user_id_pk}">
    <input type="hidden" name="board_tit" id="board_tit" value="${row.board_tit}">                
    </c:forEach>
    <p>정말 신고하시겠습니까?</p>
        <div class="modal-footer">
        <a id="report_button" class="btn btn-default btn-flat">네</a>
        <a class="btn btn-default btn-flat" data-dismiss="modal">취소</a>
    	</div>
    </form>
        
        <!--  &reason= -->
        </div>
      </div>
    </div>
   </div>
<!-- /.Modal -->
    </c:forEach>
  </div>
  <!-- /.content-wrapper -->
<script type="text/javascript">

$("#applybutton").click(function(){
	console.log("난 되는데? !!");
	var user_id_pk = $('#report_id').val();
	var user_tb_user_id_pk = $('#user_tb_user_id_pk').val();
	var board_no_pk = $('#board_no_pk').val();
	var board_tit = $('#board_tit').val();
	var dt =new Date().format("yyyy-MM-dd E a/p hh시 mm분");
	stompClient.send("/app/notify", {}, JSON.stringify({ 'from_id':user_id_pk, 'to_id':user_tb_user_id_pk, 'sq':board_no_pk, 'tit':board_tit, 'dt':dt }));
});
$("#report_button").click(function(){
    var report_rs = $("#report_rs").val();
    var report_con = $("#report_con").val();
    var report_id = $("#report_id").val();
    var board_no_pk = $("#board_no_pk").val();
    var user_tb_user_id_pk = $("#user_tb_user_id_pk").val();
    var board_tit = $("#board_tit").val();
  	$.ajax({
		   url : "reportAdd",
		   type : "post",
		   data : {
		       report_rs : report_rs,
		       report_con : report_con,
		       report_id : report_id,
		       board_no_pk : board_no_pk,
		       user_tb_user_id_pk : user_tb_user_id_pk,
		       board_tit : board_tit
			   },
		   dataType : "json",
		   success : function(data){
		       var report_count = parseInt(data.report_check);
		       alert("RND IF == "+(report_count >= 5));
		       if(report_count >= 5) {
		   	    var to="sugartoast";
			    var board_no=$('#board_no_pk').val();
			    var board_user=$('#user_tb_user_id_pk').val();
			    var cnt= report_count;
			    var dt =new Date().format("yyyy-MM-dd E a/p hh시 mm분");
			    alert("date set check = "+to+"/"+board_no+"/"+board_user+"/"+cnt+"/"+dt);
			    stompClient.send("/app/reportnotify", {}, JSON.stringify({ 'to':to, 'board_no':board_no, 'board_user':board_user, 'cnt':cnt, 'dt':dt }));
	      	}
		   }
});
});
function sendReport () {
	    var to="sugartoast";
	    var board_no=$('#board_no_pk').val();
	    var board_user=$('#user_tb_user_id_pk').val();
	    var cnt= data;
	    var dt =new Date().format("yyyy-MM-dd E a/p hh시 mm분");
	    alert(to+"/"+board_no+"/"+board_user+"/"+cnt+"/"+dt);
		alert("gkgkgkgkg"+RCN);
		stompClient.send("/app/test", {}, JSON.stringify({ 'from':"from", 'to':"to",'message': "message", 'dt' :"dt"}));
	    stompClient.send("/app/reportnotify", {}, JSON.stringify({ 'to':to, 'board_no':board_no, 'board_user':board_user, 'cnt':cnt, 'dt':dt }));
	    /*
	    테스트용 샘플 소켓문
	    stompClient.send("/app/test", {}, JSON.stringify({ 'from':"from", 'to':"to",'message': "message", 'dt' :"dt"}));
	    */
}
</script>
<%@include file="./include/footer.jsp"%>
</body>
</html>