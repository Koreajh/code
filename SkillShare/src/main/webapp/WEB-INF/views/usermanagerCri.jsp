<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@include file="./include/header.jsp"%>

<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        	User Manager
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
                    <th>이름</th>
                    <th>E-MAIL</th>
                    <th>상태</th>
                  </tr>
                  </thead>
                  <tbody>
<!-- for문 boardList 반복 --> 
 <!-- for문 boardList 반복 --> 
 <c:forEach var="row" items="${UserManager}">
  <form action="userdetails" method="post">
   <tr>
   	
   
    <td width='20%'><a href="userdetails?id=${row.user_id_pk}&page1=${1}&page2=${1}">${row.user_id_pk}</a>
    <input type="hidden" id="row.user_id_pk" name="row.user_id_pk" value="${row.user_id_pk}">
    </td>
    <td width='30%'>${row.user_nm}
    <input type="hidden" id="user_nm" name="user_nm" value="${row.user_nm}">
    </td>
    <td width='30%'>${row.user_em}
    <input type="hidden" id="user_em" name="user_em" value="${row.user_em}">
    </td>
    <td width='20%'>
    <c:choose>
    <c:when test="${row.access == 1}">관리자</c:when>
    <c:when test="${row.access == 2}">Ben</c:when>
    <c:when test="${row.access == 3}">탈퇴</c:when>
    <c:otherwise></c:otherwise>
    </c:choose>
    </td>
    
   </tr>
   <input type="hidden" id="user_pw" name="user_pw" value="${row.user_pw}">
   <input type="hidden" id="create_dt" name="create_dt" value="${row.create_dt}">
   <input type="hidden" id="change_dt" name="change_dt" value="${row.change_dt}">
  </form>
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
  
    <c:if test="${Usercount.prev}">
  		<li><a href="usermanagerCri?page=${Usercount.startPage-1}">&laquo;</a></li>
  </c:if>
  
  <c:forEach begin="${Usercount.startPage}"
             end="${Usercount.endPage}" var="idx">
  		<li
  			<c:out value="${Usercount.page == idx?'class= active':''}"/>>
  			<a href="usermanagerCri?page=${idx}">${idx}</a>
  		</li>
  </c:forEach>
  
  <c:if  test="${Usercount.next && Usercount.endPage>0}">
  		<li><a href="usermanagerCri?page=${Usercount.endPage+1}">&raquo;</a></li>
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

 <%@include file="./include/footer.jsp"%>
</body>
</html>

