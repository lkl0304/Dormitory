function lflush(page) {  // 用于跳转页面
	$.get("getlousld?pageNo=" + page, function (data) {
		$('#sslgl').html(data);
	});
}
function addlou(){
	$.get("addlou.jsp", function (data) {
		$('#lpan').html(data);
	});
}
function dellou(id, ys, name) {
	var href = "dellould?lid=" + id + "&pageNo=" + ys + "&lname=" + name;
	$.get(href, function(data){
		$('#sslgl').html(data);
	});
}
function xglou(name) {
	$.get("searchld?lname=" + name + "&xg=1", function (data) {
		$('#lpan').html(data);
	});
}
function lsearch() {
	var lsr = $('#lsearch').val();
	if(lsr.length > 0){
		$.post('searchld', {lname : lsr}, function(data) {
			$('#sslgl').html(data);
		});
	}
}