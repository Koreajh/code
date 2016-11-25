<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./include/header.jsp"%>

  <section class="content-header">
    <h1>
  	 사용자 정보  
    </h1>
    <ol class="breadcrumb">
    <li><a href="#"><i class="fa fa-dashboard"></i>Home</a></li>
    <li class="active">사용자정보</li>
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
    <c:forEach var="row" items="${UserDetails}">
    <section class="content">
      <div class="row">
<div class="col-md-12">
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">${row.user_id_pk}</h3>

            
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <div class="mailbox-read-info">
                <h3>${row.user_nm}</h3>
              <h3>
              <span class="mailbox-read-time pull-right">
              
              </span>
              </h3>
              </div>
              
                
              <!-- /.mailbox-read-info -->
              
              <!-- /.mailbox-controls -->
              <div class="mailbox-read-message">
           ${row.user_em} / 생성일 ${row.create_dt} / 최근 수정일 ${row.change_dt}  ${id}
      	     
      	      </div>
              <!-- /.mailbox-read-message -->
            </div>
            
          <!-- /.box-body -->
            <div class="box-footer">
            <form name="${row.user_id_pk}">
            <a data-toggle="modal" href="#user_del" class="btn btn-danger fa fa-trash-o">계정삭제</a>
              <a href="userBack" class="btn btn-warning fa fa-arrow-left">뒤로</a>
           
           <c:choose>
			<c:when test="${row.access==2}">
			<a data-toggle="modal" href="#BancancelModal" id="userBancancel" class="btn btn-default fa fa-ban">Ban해제</a>
            
            </c:when>
            <c:otherwise>
            <a data-toggle="modal" href="#BanModal" id="userBan" class="btn btn-default fa fa-ban">Ban</a>
            </c:otherwise>
            </c:choose>  
            
            
             <!-- Modal -->
  <div class="modal fade" id="user_del" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">     
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">유저삭제메세지</h4>
        </div>
        <div class="modal-body">
    <p>정말 삭제하시겠습니까?</p>
        </div>
        <div class="modal-footer">
        <a href="userdelete?id=${row.user_id_pk}" class="btn btn-danger fa fa-trash-o" >삭제</a>
        <a class="btn btn-warning fa fa-arrow-left" data-dismiss="modal">취소</a>
        </div>
      </div>
    </div>
   </div>
<!-- /.Modal -->    
            </form>  
            <!-- /.box-footer -->
         </c:forEach>
       
   <br>
   <br>         
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        	Login Log
      </h1>
      
    </section>
    
    <!-- Main content -->
    <section class="content">
      <!-- Main row -->
      <div class="row">
        <!-- Left col -->
        <div class="col-md-12">
          <!-- TABLE: LATEST ORDERS -->
          <div class="box box-info">
            <div class="box-header with-border">
             
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <div class="table-responsive">
                <table class="table no-margin">
                  <thead>
                  <tr>
                    <th>IP</th>
                    <th>접속시간</th>
                  </tr>
                  </thead>
                  <tbody>
<!-- for문 boardList 반복 --> 
 <!-- for문 boardList 반복 --> 
  
 <c:forEach var="row" items="${CheckLoginView}">
   <tr>
    <td width='120px' >${row.loginlog_user_ip}
    </td>
    <td width='120px' >${row.loginlog_dt}
    </td>
 </c:forEach>
 
 
  

                  </tbody>
                </table>
              </div>
              <!-- /.table-responsive -->
            </div>
            
            
  <div class="text-center">
  	<ul class="pagination">
  
  <c:if test="${logcount.prev}">
  		<li><a href="userdetails?id=${id}&page1=${logcount.startPage-1}&page2=${logDetailcount.page}">&laquo;</a></li>
  </c:if>
  
  <c:forEach begin="${logcount.startPage}"
             end="${logcount.endPage}" var="idx1">
  
  		<li
  			<c:out value="${logcount.page == idx1?'class= active':''}"/>>
  			<a href="userdetails?id=${id}&page1=${idx1}&page2=${logDetailcount.page}">${idx1}</a>
  		</li>
  </c:forEach>
  
  <c:if  test="${logcount.next && logcount.endPage>0}">
  		<li><a href="userdetails?id=${id}&page1=${logcount.endPage+1}&page2=${logDetailcount.page}">&raquo;</a></li>
  </c:if>
 </ul>
 </div> 
  
            <!-- /.box-body -->
            
            <!-- /.box-footer -->
              <div class="text-center">
 
 </div>


<br>
<br>
<!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        	Connection Log
      </h1>
      
    </section>
    
    <!-- Main content -->
    <section class="content">
      <!-- Main row -->
      <div class="row">
        <!-- Left col -->
        <div class="col-md-12">
          <!-- TABLE: LATEST ORDERS -->
          <div class="box box-info">
            <div class="box-header with-border">
             
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <div class="table-responsive">
                <table class="table no-margin">
                  <thead>
                  <tr>
                    <th>ID</th>
                    <th>IP</th>
                    <th>접속페이지</th>
                    <th>접속정보</th>
                    <th>접속일자</th>
                    
                  </tr>
                  </thead>
                  <tbody>
<!-- for문 boardList 반복 --> 
 <!-- for문 boardList 반복 --> 
  
 <c:forEach var="row" items="${checkLogDetailView}">
   <tr>
    <td width='120px' >${row.acclog_user_id} 
    </td>
    <td width='120px' >${row.acclog_user_ip}  
    </td>
    <td width='120px' >${row.acclog_page}    
    </td>
    <td width='120px' >${row.acclog_inf}  
    </td>
    <td width='120px' >${row.acclog_dt}  
    </td>
    
 </c:forEach>
  

                  </tbody>
                </table>
              </div>
              <!-- /.table-responsive -->
            </div>
            <!-- /.box-body -->
            
            <!-- /.box-footer -->
              <div class="text-center">
              
 </div>
        <div class="text-center">
  	<ul class="pagination">
  
  <c:if test="${logDetailcount.prev}">
  		<li><a href="userdetails?id=${id}&page1=${logcount.page}&page2=${logDetailcount.startPage-1}">&laquo;</a></li>
  </c:if>
  
  <c:forEach begin="${logDetailcount.startPage}"
             end="${logDetailcount.endPage}" var="idx1">
  
  		<li
  		     
  			<c:out value="${logDetailcount.page==idx1?'class= active':''}"/>>
  			<a href="userdetails?id=${id}&page1=${logcount.page}&page2=${idx1}">${idx1}</a>
  		</li>
  </c:forEach>
  
  <c:if  test="${logDetailcount.next && logDetailcount.endPage>0}">
  		<li><a href="userdetails?id=${id}&page1=${logcount.page}&page2=${logDetailcount.endPage+1}">&raquo;</a></li>
  </c:if>
 </ul>
 </div> 
  

 </ul>
 </div>
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
            
          </div>
          
          
          
          <!-- /. box -->
        </div>
        <!-- /.col -->     
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
<%@include file="./include/footer.jsp"%>


<div class="modal fade" id="BanModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">     
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">사용자 계정중지</h4>
        </div>
        <div class="modal-body">
    <form action="UserBan" method="post" id="frm">
    <c:forEach var="row" items="${UserDetails}">
    <input type="hidden" name="user_id_pk" id="user_id_pk" value="${row.user_id_pk}">
    </c:forEach>
    <br>
    <br>
    <p>정말 계정을 중지시키겠습니까?</p>
        <div class="modal-footer">
        <button type="submit" class="btn btn-default btn-flat">네</button>
        <a class="btn btn-default btn-flat" data-dismiss="modal">아니요</a>
    	</div>
    </form>
    </div>
   </div>
  </div>
 </div>
  
<div class="modal fade" id="BancancelModal" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">     
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">사용자 계정중지해제</h4>
        </div>
        <div class="modal-body">
    <form action="UserBanCancel" method="post" id="frm">
    <c:forEach var="row" items="${UserDetails}">
    <input type="hidden" name="user_id_pk" id="user_id_pk" value="${row.user_id_pk}">
    </c:forEach>
    <br>
    <br>
    <p>계정중지를 해제하시겠습니까?</p>
        <div class="modal-footer">
        <button type="submit" class="btn btn-default btn-flat">네</button>
        <a class="btn btn-default btn-flat" data-dismiss="modal">아니요</a>
    	</div>
    </form>
		</div>
      </div>
    </div>
   </div>

</body>
</html>