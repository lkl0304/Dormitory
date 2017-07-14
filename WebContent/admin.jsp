 <!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/css/all.css">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="bootstrap/js/jquery-3.2.0.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="style/js/admin.js"></script>
<!-- <script type="text/javascript">
	var user  = "${sessionScope.aName}";
	var login = "${requestScope.login}";
	var chang = "${requestScope.change}";
	if(chang.length > 0){
		if(chang == "success"){
			alert("修改成功！返回重新登录");
			location.href="login";
		}else {
			alert("修改失败！");
			location.href="admin";
		}
	}
	if(user.length > 1)
	{
		if(login.length > 0){
			if (login == "success") {
				var url = 'http://chaxun.1616.net/s.php?type=ip&output=json&callback=?&_='+Math.random();  
				$.getJSON(url, function(data){
					$.post('jliprd', {ip: data.Ip});
				});
				alert("登录成功！ 欢迎" + user);
				location.href="admin";
			}
		}
	} else {
		location.href="login";
	}
</script> -->
<title>管理中心</title>
</head>
<body>
	<div class="container-fluid">
		<nav class="mynav navbar-fixed-top">
			<span style="font-size: 30px;cursor: pointer;">&nbsp;宿舍管理系统</span>
			<span style="margin-top: 30px;" class="pull-right">用户 ${sessionScope.aName} </span>
		</nav>
		<div style="margin-top: 120px;">
			<div class="row">
				<div class="col-lg-2 col-sm-2 col-md-2">
					<ul class="nav nav-pills nav-stacked mytab">
						<li class="active"><a data-toggle="tab" href="#sy">首页 <span class="glyphicon glyphicon-chevron-right pull-right"></span></a></li>
						<li><a data-toggle="tab" href="#xsgl">学生管理 <span class="glyphicon glyphicon-chevron-right pull-right"></span></a></li>
						<li><a data-toggle="tab" href="#sslgl">宿舍楼管理 <span class="glyphicon glyphicon-chevron-right pull-right"></span></a></li>
						<li><a data-toggle="tab" href="#czjl">操作记录 <span class="glyphicon glyphicon-chevron-right pull-right"></span></a></li>
						<li><a data-toggle="tab" href="#gmm">修改密码 <span class="glyphicon glyphicon-chevron-right pull-right"></span></a></li>
						<li><a href="logoutad">安全退出 <span class="glyphicon glyphicon-chevron-right pull-right"></span></a></li>
					</ul>
				</div>
				<div class="col-lg-10 col-sm-10 col-md-10">
					<div class="tab-content">
						<div id="sy" class="tab-pane fade in active">
							<!-- 首页内容 -->
							<h2 class="page-header text-center">欢迎使用宿舍管理系统</h2>
							<div class="shuyet"></div>
						</div>
						<div id="xsgl" class="tab-pane fade">
							<!-- 学生管理页面 -->
							<jsp:include page="student.jsp"></jsp:include>
						</div>
						<div id="sslgl" class="tab-pane fade">
							<!-- 宿舍楼管理页面 -->
							<jsp:include page="lou.jsp"></jsp:include>
						</div>
						<div id="czjl" class="tab-pane fade">
							<!-- 操作记录 -->
							<jsp:include page="record.jsp"></jsp:include>
						</div>
						<div id="gmm" class="tab-pane fade">
							<!-- 修改密码 -->
							<jsp:include page="gpass.jsp"></jsp:include>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>