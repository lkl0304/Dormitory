$(function() {
	$('a[data-toggle="tab"]').on('hidden.bs.tab', function (e) {
		flush(1); // 学生管理界面
		lflush(1); // 楼层管理界面
		rflush(1);  // 记录管理界面
	});
	$('#sub').on('click', function(event) {
		var bf  = document.getElementById('gmfrom');
		var np1 = $('#npass1').val();
		var np2 = $('#npass2').val();
		
		if(np1 != "" && np2 != "")
		{
			if(np1 != np2)
			{
				alert('两次密码不相同！');
			}else{
				var que = confirm("确定修改？");
				if(que == true)
				{
					bf.submit();
				}
			}
		}else {
			alert("不能留空");
		}
	});
});