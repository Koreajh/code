<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./include/header.jsp"%>

 <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Q&A
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
                        <!-- /.box-header -->
            <div class="box-body">
              <div class="table-responsive">
                <table class="table no-margin">
                  <thead>
                  <tr>
                    <th align="center">번호</th>
                    <th align="center">작성자</th>
                    <th align="center">제목</th>
                    <th align="center">작성일</th>
                  </tr>
                  </thead>
                  <tbody>
                  <!-- for문 boardList 반복 --> 
                  <c:forEach var="row" items="${QuestionView}">
                  <tr>
                  <td width='10%'>${row.ask_no_pk}
                    <input type="hidden" id="ask_no_pk" name="ask_no_pk" value="${row.ask_no_pk}">
                  </td>
                  <td width='20%'>${row.user_tb_user_id_pk}
                    <input type="hidden" id="user_tb_user_id_pk" name="user_tb_user_id_pk" value="${row.user_tb_user_id_pk}">
                  </td>
                  <td width='40%'><a href="questiondetails?id=${row.ask_no_pk}&user=${row.user_tb_user_id_pk}">${row.ask_tit}</a>
                    <input type="hidden" id="user_em" name="user_em" value="${row.ask_tit}">
                  </td>
                  <td width='30%'>${row.ask_dt}
                    <input type="hidden" id="ask_dt" name="ask_dt" value="${row.ask_dt}"></td>
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
  
  <c:if test="${Questioncount.prev}">
  		<li><a href="questionboard?page=${Questioncount.startPage-1}">&laquo;</a></li>
  </c:if>
  
  <c:forEach begin="${Questioncount.startPage}"
             end="${Questioncount.endPage}" var="idx">
  		<li
  			<c:out value="${Questioncount.page == idx?'class= active':''}"/>>
  			<a href="questionboard?page=${idx}">${idx}</a>
  		</li>
  </c:forEach>
  
  <c:if  test="${Questioncount.next && Questioncount.endPage>0}">
  		<li><a href="questionboard?page=${Questioncount.endPage+1}">&raquo;</a></li>
  </c:if>
 </ul>
              
 </div>
 		<div class="box-footer clearfix">
              <a class="btn btn-app" href="questionForm">
                <i class="fa fa-edit"></i>문의작성
              </a>
             
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