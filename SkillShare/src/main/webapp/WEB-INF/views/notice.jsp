<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@include file="./include/header.jsp"%>
  
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Notice Manager
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
                    <th align="center">작성자</th>
                    <th align="center">제목</th>
                    <th align="center">작성일</th>
                    <th align="center">조회수</th>
                    <th align="center">상세보기</th>
                  </tr>
                  </thead>
                  <tbody>
<!-- for문 boardList 반복 --> 
 <c:forEach var="row" items="${Notice}">
  <form action="noticedetails" method="post">
   <tr>
    <td width='10%' >${row.user_tb_user_id_pk}
    <input type="hidden" id="user_tb_user_id_pk" name="user_tb_user_id_pk" value="${row.user_tb_user_id_pk}">
    </td>
    <td width='40%' >${row.board_tit}
    <input type="hidden" id="board_tit" name="board_tit" value="${row.board_tit}">
    </td>
    <td width='15%' >${row.board_dt}
    <input type="hidden" id="board_dt" name="board_dt" value="${row.board_dt}">
    </td>
    <td width='15%' >${row.read_cnt}
    <input type="hidden" id="read_cnt" name="read_cnt" value="${row.read_cnt}">
    </td>
    <td width='20%' ><input type="submit" class="btn btn-primary" value="상세보기"></td>
   </tr>
   <input type="hidden" id="board_no_pk" name="board_no_pk" value="${row.board_no_pk}">
   <input type="hidden" id="board_con" name="board_con" value="${row.board_con}">
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
  
  <c:if test="${Noticecount.prev}">
  		<li><a href="notice?page=${Usercount.startPage-1}">&laquo;</a></li>
  </c:if>
  
  <c:forEach begin="${Noticecount.startPage}"
             end="${Noticecount.endPage}" var="idx">
  		<li
  			<c:out value="${Noticecount.page == idx?'class= active':''}"/>>
  			<a href="notice?page=${idx}">${idx}</a>
  		</li>
  </c:forEach>
  
  <c:if  test="${Noticecount.next && Noticecount.endPage>0}">
  		<li><a href="notice?page=${Noticecount.endPage+1}">&raquo;</a></li>
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