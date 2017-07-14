$(function() {
	var cansub = true;
	// $('#name').blur(function(event) {  学生可以重名
	// 	var name = $('#name').val();
	// 	$.get('yzstusd?sname=' + name, function(data) {
	// 		if(data.length > 0){
	// 			$('#xaddalert').fadeIn(200);
	// 			$('#xsts').html("该学生已存在！");
	// 			cansub = false;
	// 		}
	// 	});
	// });
	$('#asf').on('click', function(event) {
		event.preventDefault();

		var name  = $('#name').val();
		var sex   = $('#sex').val();
		var stuid = $('#stuid').val();
		var lou   = $('#lou').val();
		var home  = $('#home').val();
		var tel   = $('#tel').val();
		var regs  = new RegExp("^[0-9]*$");  // 纯数字验证
		var regh  = new RegExp("^[\u4e00-\u9fa5]{0,}$");  // 汉字
		//var reghb = new RegExp("[\\u4E00-\\u9FFF]+","g");  // 包涵汉字
		var regsj = /^1[34578]\d{9}$/;  // 手机号码验证
		if(name == ""){
			$('#xaddalert').fadeIn(200);
			$('#xsts').html("姓名不能为空！");
		}else if(!regh.test(sex) || sex == ""){
			$('#xaddalert').fadeIn(200);
			$('#xsts').html("性别格式不正确！");
		}else if(!regs.test(stuid) || stuid == "" || !regs.test(home) || home == "" || !regs.test(lou) || lou == ""){
			$('#xaddalert').fadeIn(200);
			$('#xsts').html("学号 宿舍楼 寝室号必须是纯数字！");
		}else if(!regsj.test(tel) || tel == ""){
			$('#xaddalert').fadeIn(200);
			$('#xsts').html("手机号码格式错误！");
		}else if(cansub == true){
			$.post('addstusd', $("#astuform").serializeArray(), function(data) {
				$('#xsgl').html(data);
			});
		}
	});
	$('input').focus(function(event) {
		$('#xaddalert').hide();
	});
});