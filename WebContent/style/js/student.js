function flush(page) {  // 用于跳转页面
	$.get("getstussd?pageNo=" + page, function (data) {
		$('#xsgl').html(data);
	});
}
function addstu() { 
	$.get("addstu.jsp", function (data) {
		$('#stpan').html(data);
	});
}
function delstu(id, ys, name) {
	$.post("delstusd", { 
		sid : id,
		sname : name,
		pageNo : ys
	}, function(data){
		$('#xsgl').html(data);
	});
}
function search() {
	var name = $('#search').val();
	if(name.length > 0)
	{
		$.post("searchsd" ,{sname : name }, function (data, status) {
			$('#xsgl').html(data);
		});
	}
}
function xg(name){  // 修改先根据名称获得要修改的用户信息  用id才最好
	$.post("searchsd",{ 
		sname : name,
		xg : 1
	}, function (data) {
		$('#mypan').html(data);
	});
}