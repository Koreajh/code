/**
 * <현재 url을 검사해 header에 현재 페이지 명에 따라 네이게이션에 active class를 추가함>
 * 		
 * @author [김윤교]
 * @version [v0.1], [2016.03.13] 			 
 */
window.onload = function(){
  var sUrl = document.location.href;
  var aUrl = sUrl.split( "/" );
  sUrl = aUrl.pop();
  aUrl = sUrl.split( "?" );
  sUrl = aUrl.reverse().pop();
  
  if ( sUrl =="usermanagerCri" || sUrl == "userdetails" ) {
    $( '#usermanager' ).addClass( 'active' );
  }
  else if ( sUrl =="boardAdd" || sUrl =="boardviewCri" || sUrl == "boardDetails" || sUrl == "boardChangeForm" ) {
    $( '#boardview' ).addClass( 'active' );
  }
  else if ( sUrl =="notice" || sUrl == "noticedetails" || sUrl == "boardChangeForm" ) {
	    $( '#notice' ).addClass( 'active' );
  }
  else if ( sUrl =="questionboard" || sUrl == "questiondetails" || sUrl == "questionForm" ) {
	    $( '#questionboard' ).addClass( 'active' );
  }
  else if ( sUrl == "applyviewCri" || sUrl == "applyPerView"  ) {
	    $( '#applyView' ).addClass( 'active' );
  }
}