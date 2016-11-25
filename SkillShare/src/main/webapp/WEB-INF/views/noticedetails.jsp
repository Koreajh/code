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

    <!-- Main content -->
    <c:forEach var="row" items="${NoticeDetails}">
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
     
     <br>
    ${row.board_con}
              </div>
              <!-- /.mailbox-read-message -->
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
 <c:choose>
 <c:when test="${row.user_tb_user_id_pk==sessionScope.userLoginInfo.user_id_pk || sessionScope.userLoginInfo.access == 1}">
            
    <a data-toggle="modal" href="#boarddeleteModal" class="btn btn-danger fa fa-trash-o" >삭제</a>
    <a href="boardChangeForm?board_id=${row.board_no_pk}&user_id=${row.user_tb_user_id_pk}" class="btn btn-info fa fa-retweet">게시물 수정</a>
    
              
              </c:when>
                  <c:otherwise>
    <a href="applyForm?board_id=${row.board_no_pk}&user_id=${sessionScope.userLoginInfo.user_id_pk}" class="btn btn-primary fa fa-paper-plane">신청</a>
    </c:otherwise>
    
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
        <a href="boardDelete?board_id=${row.board_no_pk}&user_id=${sessionScope.userLoginInfo.user_id_pk}" class="btn btn-danger fa fa-trash-o" >삭제</a>
        <a class="btn btn-warning fa fa-arrow-left" data-dismiss="modal">취소</a>
        </div>
      </div>
    </div>
   </div>
<!-- /.Modal -->
    </c:forEach>
  </div>
  <!-- /.content-wrapper -->
<%@include file="./include/footer.jsp"%>
</body>
</html>





