<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@include file="./include/header.jsp"%>
 
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Dashboard
        <small>Version 2.0</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
      </ol>
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
              <h3 class="box-title">SkillShare 게시판</h3>

              <div class="box-tools pull-right">
              	<a href="boardviewCri?page=1" class="btn btn-box-tool fa fa-list"></a>
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
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
					 <c:forEach var="row" items="${boardDashBoardView}">
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
					  </form>
					  </c:forEach>

                  </tbody>
                </table>
                
              </div>
              <!-- /.table-responsive -->
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix">
             
            </div>
            <!-- /.box-footer -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
      
      <!--   row -->
      <div class="row">
        <!-- Left col -->
        <div class="col-md-12">
          <!-- TABLE: LATEST ORDERS -->
          <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">문의사항</h3>

              <div class="box-tools pull-right">
              <a href="questionboard" class="btn btn-box-tool fa fa-list"></a>
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
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
                  <c:forEach var="row" items="${questionDashBoardView}">
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
            <div class="box-footer clearfix">
             
            </div>
            <!-- /.box-footer -->
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