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
                    <th>번호</th>
                    <th>작성자</th>
                    <th>제목</th>
                    <th>작성일</th>
                    <th>조회수</th>
                    
                    
                  </tr>
                  </thead>
                  <tbody>
<!-- for문 boardList 반복 --> 
 <c:forEach var="row" items="${BoardView}">
  <form action="boardDetails" method="post">
   <tr>
   
   <c:choose>
   <c:when test="${row.user_tb_user_id_pk=='sugartoast'}">
   	<td width='10%'>공지</td>
   </c:when>
   <c:otherwise>
    <td width='10%'>${row.board_no_pk}
    
    </td>
   </c:otherwise> 
   </c:choose> 
    <td width='20%' >${row.user_tb_user_id_pk}
    
    </td>
    
    <td width='40%' ><a href="boardDetails?id=${row.board_no_pk}&user=${row.user_tb_user_id_pk}">${row.board_tit}</a>
    	<input type="hidden" id="board_tit" name="board_tit" value="${row.board_tit}">
    </td>
   
    
    <td width='20%' >${row.board_dt}
    </td>
    
    <td width='10%' >${row.read_cnt}
    </td>
    
    
   </tr>
   
   <input type="hidden" id="board_no_pk" name="board_no_pk" value="${row.board_no_pk}">
   <input type="hidden" id="user_tb_user_id_pk" name="user_tb_user_id_pk" value="${row.user_tb_user_id_pk}">
   <input type="hidden" id="board_tit" name="board_tit" value="${row.board_tit}">
   <input type="hidden" id="board_dt" name="board_dt" value="${row.board_dt}">
   <input type="hidden" id="my_sk" name="my_sk" value="${row.my_sk}">
   <input type="hidden" id="want_sk" name="want_sk" value="${row.want_sk}">
   <input type="hidden" id="board_dur" name="board_dur" value="${row.board_dur}">
   <input type="hidden" id="read_cnt" name="read_cnt" value="${row.read_cnt}">
   
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
  
  <c:if test="${Boardcount.prev}">
  		<li><a href="boardviewCri?page=${Boardcount.page}">&laquo;</a></li>
  </c:if>
  
  <c:forEach begin="${Boardcount.startPage}"
             end="${Boardcount.endPage}" var="idx">
  		<li
  			<c:out value="${Boardcount.page == idx?'class= active':''}"/>>
  			<a href="boardviewCri?page=${idx}">${idx}</a>
  		</li>
  </c:forEach>
  
  <c:if  test="${Boardcount.next && Boardcount.endPage>0}">
  		<li><a href="boardviewCri?page=${Boardcount.endPage+1}">&raquo;</a></li>
  </c:if>
 </ul>
              
 </div>
 
  <div class="box-footer clearfix">
              <c:if test="${sessionScope.userLoginInfo.access == 1}">
              <a class="btn btn-app" href="addForm">
                <i class="fa fa-edit"></i>공지작성
              </a>
              </c:if>
              <c:if test="${sessionScope.userLoginInfo.access == 0}">
              <a class="btn btn-app" href="boardForm">
                <i class="fa fa-edit"></i>게시글작성
              </a>
              </c:if>
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