<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@include file="./include/header.jsp"%>
 
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        SkillShare
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
  				
  					<th align = "center">ID</th>
  					<th align = "center">게시글번호</th>
  					<th align = "center">신청날짜</th>
  					<th align = "center">상태여부</th>
  					<th align = "center">신청취소</th>
  
  
  
 				</tr>
                  </thead>
                  <tbody>
<!-- for문 boardList 반복 --> 
 <c:forEach var="row" items="${ApplyPerView}">
  
   <tr>
   
   
    <td width='120px'>${row.user_tb_user_id_pk}
    </td>
    <td width='120px'>${row.board_tb_board_no_pk}
    </td>
    <td width='120px'>${row.apply_dt}
    </td>
    <td width='120px'>
 <c:choose>
    <c:when test="${row.apply_st==0}">
    미확인
    </c:when>
    <c:when test="${row.apply_st==1}">
    수락
    </c:when>
    <c:when test="${row.apply_st==2}">
    취소
    </c:when>
    </c:choose>
    </td>
    <td width='120px'>
    <a href="applyDelete?board_id=${row.board_tb_board_no_pk}&user_id=${sessionScope.userLoginInfo.user_id_pk}" class="btn btn-warning fa fa-minus">
    신청취소</a>
    </td>
    
   </tr>
   
  </c:forEach>

                  </tbody>
                </table>
              </div>
              <!-- /.table-responsive -->
            </div>
            <!-- /.box-body -->
            
            <!-- /.box-footer -->
            
       <div class="text-center">
  	<ul class="pagination">
  
  <c:if test="${Applycount.prev}">
  		<li><a href="applyperview?page=${Applycount.startPage-1}">&laquo;</a></li>
  </c:if>
  
  <c:forEach begin="${Applycount.startPage}"
             end="${Applycount.endPage}" var="idx">
  		<li
  			<c:out value="${Applycount.page == idx?'class= active':''}"/>>
  			<a href="applyperview?page=${idx}">${idx}</a>
  		</li>
  </c:forEach>
  
  <c:if  test="${Applycount.next && Boardcount.endPage>0}">
  		<li><a href="applyperview?page=${Applycount.endPage+1}">&raquo;</a></li>
  </c:if>
 </ul>
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

 <%@include file="./include/footer.jsp"%>
</body>
</html>
