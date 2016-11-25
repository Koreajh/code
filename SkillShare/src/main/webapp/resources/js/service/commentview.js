/**
 * <aJax기반으로 댓글달기 버튼이 눌릴 시 댓글 등록 후 표시해줌>
 * 		
 * @author [김윤교]
 * @version [v0.1], [2016.03.16] 			 
 */
 
 $(function(){
$('#comment').click(function(){
	 alert("gogogo");
  var user_tb_user_id_pk = $("#user_tb_user_id_pk").val();
  var ask_tb_ask_no_pk = $("#ask_tb_ask_no_pk").val();
  var comment_con = $("#comment_con").val();
 
  $.ajax({
    type : 'post',
    url : '/commentAdd',
    headers : {
      "Content-Type" : "application/json",
      "X-HTTP-Method-Override" : "POST"
	},
    dataType : 'text',
    data : JSON.stringify({
      user_tb_user_id_pk : user_tb_user_id_pk,
      ask_tb_ask_no_pk : ask_tb_ask_no_pk,
      comment_con : comment_con
    }),
    success : function(result) {
      if (result == 'SUCCESS') {
    	alert("등록 되었습니다.");	
        getAllList();
      }
    }
  });
});
 
function getAllList(){
	alert("getAl123l");
	var question_id = 1;
	$.getJSON("/commentShow/" + question_id, function(data) {
	alert("getAll");
	  $(data).each(
	    function(){
	      str += "<li data-comment_id_pk='"+ this.comment_id_pk +"' class='commentLi'>"
	          + this.comment_id_pk + ":" + this.comment_con + "</li>";
	    });
	  $("#comment_data").html(str);
	});
	}
});