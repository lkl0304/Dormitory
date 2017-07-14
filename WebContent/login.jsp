<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/css/login.css">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="bootstrap/js/jquery-3.2.0.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var login = "${requestScope.login}";
	if (login == "error") {  // 用于跳转
		location.href="login";
	}
	var err = "${requestScope.err}";
	if(err.length){
		alert("登录失败！请填写正确信息！");
		location.href="login";
	}
</script>
<title>登录</title>
</head>
<body style="background: url('images/bg.jpg') no-repeat; background-size: 100%;">
	<div class="container" style="margin-top: 8%;">
		<h2 class="login" style="text-align: center;">宿舍管理系统</h2>
		<div class="panel panel-info login">
			<div class="panel-heading">
				<span>登录</span>
			</div>
			<div class="panel-body" style="margin-top: 10px;">
				<form style="margin-bottom: 5px;" action="loginad" method="post">
					<div class="form-group">
						<div class="input-group">
							<label for="user" class="input-group-addon"><span class="glyphicon glyphicon-user"></span></label>
							<input id="user" type="text" name="username" value="${requestScope.aname}" class="form-control" placeholder="用户名" required="required">
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<label for="pass" class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></label>
							<input id="pass" type="password" name="password" value="${requestScope.apass}" class="form-control" placeholder="密码" required="required">
						</div>
					</div>
					<div class="checkbox pull-right">
						<label for="bao">
							<input id="bao" type="checkbox" name="mima" value="mima" checked="checked">记住密码
						</label>
					</div>
					<input type="submit" value="登录" class="btn btn-info btn-group-justified">
				</form>
			</div>
		</div>
	</div>
</body>
</html>