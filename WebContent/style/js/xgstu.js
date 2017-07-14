$(function() {
	var dataformInit = $("#xgssform").serializeArray();  
	var jsonTextInit = JSON.stringify({ dataform: dataformInit });  // 将表单转化为json格式保存
	var tsleep;
	
	function updatess (dataform) {
		
		var stuid = $('#stuid').val();
		var sex   = $('#sex').val();
		var lou   = $('#lou').val();
		var home  = $('#home').val();
		var tel   = $('#tel').val();
		var regs  = new RegExp("^[0-9]*$");  // 纯数字验证
		var regh  = new RegExp("^[\u4e00-\u9fa5]{0,}$");  // 汉字
		var regsj = /^1[34578]\d{9}$/;  // 手机号码验证
		
		if(!regs.test(stuid) || stuid == "" || !regs.test(home) || home == "" || !regs.test(lou) || lou == ""){
			$('#xxgalert').fadeIn(200);
			$('#xsts').html("学号 宿舍楼 寝室号必须是纯数字！");
		}else if(!regsj.test(tel) || tel == ""){
			$('#xxgalert').fadeIn(200);
			$('#xsts').html("手机号码格式错误！");
		}else if(!regh.test(sex) || sex == ""){
			$('#xxgalert').fadeIn(200);
			$('#xsts').html("性别格式不正确！");
		}else {
			$.post('updatesd', dataform, function(data) {
				if(data.length > 1){
					$('#alertsuccess').fadeIn(200);
					$('#xgsuccess').html("修改成功！3秒后跳转...");
					var i = 2;
					var sw = setInterval(() => {
						$('#xgsuccess').html("修改成功！" + i + "秒后跳转...");
						i--;
						if(i == -1){
							clearInterval(sw);
						}
					}, 1000);
					tsleep = setTimeout(function() {
						flush(1);
					}, 4000);
				} else {
					$('#xxgalert').fadeIn(200);
					$('#xsts').html("修改失败 未知错误！");
				}
			});
		}
	}
	
	function stoptz() {
		clearTimeout(tsleep);
		$('#xxgalert').hide();
		$('#alertsuccess').hide();
	}
	
	$('input').blur(()=>{
		setTimeout(() => {  // 异步执行  实现实时修改
			var dataform = $("#xgssform").serializeArray();  
			var jsonText = JSON.stringify({ dataform: dataform });
			if(!$('input').is(':focus') && jsonTextInit != jsonText){
				updatess(dataform);
			}
		}, 0);
	});
	$('input').focus(()=> {
		stoptz();
	});
	
	$('#astop').click(stoptz);
	$('#xgfh').click(()=>{ stoptz(); flush(); });
});