<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
              <h3 class="box-title">Latest Orders</h3>

              <div class="box-tools pull-right">
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
  					<th>ID</th>
  					<th>게시글번호</th>
  					<th>신청날짜</th>
  					<th>상태여부</th>
 					<th>수락</th>
  					<th>취소</th>
  					<th>거절</th>
                  </tr>
                  </thead>
                  <tbody>
                  <!-- for문 boardList 반복 --> 
 <c:forEach var="row" items="${ApplyView}">
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
    <td width='80px'><a href="applyAgree?apply_id=${row.apply_no_pk}"><input type="button" class="btn btn-primary" value="수락"></a>
    </td>
    <td width='80px'><a href="applyDisAgree?apply_id=${row.apply_no_pk}"><input type="button" class="btn btn-warning" value="취소"></a>
    </td>
    <td width='80px'><a href="applyAgreeDelete?apply_id=${row.apply_no_pk}"><input type="button" class="btn btn-danger" value="거절"></a>
    </td>
   </tr>
  </c:forEach>
                  </tbody>
                </table>
              </div>
              <!-- /.table-responsive -->
            </div>
            <!-- /.box-body -->
            <div class="box-footer clearfix">
              <a href="javascript::;" class="btn btn-sm btn-info btn-flat pull-left">Place New Order</a>
              <a href="javascript::;" class="btn btn-sm btn-default btn-flat pull-right">View All Orders</a>
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