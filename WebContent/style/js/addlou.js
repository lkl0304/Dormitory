$(function(){
	var cansub = true;
	$('#lname').blur(function(event) {
		var lname = $('#lname').val();
		
		$.ajax({
			url: 'yzlould',
			type: 'post',
			data: {lname: lname},
			success: function(data){
				if(data.length > 0){
					$('#laddalert').fadeIn(200);
					$('#xsts').html("该楼号已被添加！");
					cansub = false;
				} else {
					cansub = true;  // 一句逻辑错误呀 6.23 解决
				}
			}
		});
	});
	$('#alou').on('click', function(event) {
		event.preventDefault();
		var lname = $('#lname').val();
		var linfo = $('#info').val();

		if(!/^[0-9]*$/.test(lname) || lname == ""){
			$('#laddalert').fadeIn(200);
			$('#xsts').html("楼号必须为纯数字！");
		} else if(linfo == ""){
			$('#laddalert').fadeIn(200);
			$('#xsts').html("信息不能为空！");
		} else if(cansub == true){
			$.ajax({
				url: 'addlould',
				type: 'post',
				data: $("#alouform").serializeArray(),
				success: function(data){
					$('#sslgl').html(data);
				}
			});
		}
	});
	$('#info').focus(function(event) {
		$('#laddalert').hide();
	});
	$('#lname').focus(function(event) {
		$('#laddalert').hide();
	});
});