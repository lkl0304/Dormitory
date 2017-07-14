function rflush(page) {  // 用于跳转页面
	$.get("getrecsrd?pageNo=" + page, function (data) {
		$('#czjl').html(data);
	});
}
function delrec(id, ys) {
	var href = "delrecrd?rid=" + id + "&pageNo=" + ys;
	$.get(href, function(data){
		$('#czjl').html(data);
	});
}