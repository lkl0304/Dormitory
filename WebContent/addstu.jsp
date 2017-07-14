<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="style/js/addstu.js"></script>
<div class="panel panel-primary">
	<div id="xaddalert" style="display: none;" class="alert alert-warning">
		<strong>错误信息: </strong><span id="xsts">错误</span>
	</div>
	<div class="panel-heading">
		<span>添加学生</span>
		<span onclick="flush(1);" class="pull-right glyphicon glyphicon-chevron-left" style="cursor: pointer;">返回</span>
	</div>
	<div class="panel-body">
		<form id="astuform">
			<div class="form-group">
				<div class="input-group">
					<label for="name" class="input-group-addon"><span class="glyphicon glyphicon-user"></span></label>
					<input id="name" type="text" name="stu.name" class="form-control" placeholder="姓名" >
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<label for="sex" class="input-group-addon"><span class="glyphicon glyphicon-heart-empty"></span></label>
					<input id="sex" type="text" name="stu.sex" class="form-control" placeholder="性别" >
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<label for="stuid" class="input-group-addon"><span class="glyphicon glyphicon-credit-card"></span></label>
					<input id="stuid" type="text" name="stu.stuid" class="form-control" placeholder="学号" maxlength="10">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<label for="lou" class="input-group-addon"><span class="glyphicon glyphicon-map-marker"></span></label>
					<input id="lou" type="text" name="stu.lou" class="form-control" placeholder="宿舍楼" maxlength="11">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<label for="home" class="input-group-addon"><span class="glyphicon glyphicon-home"></span></label>
					<input id="home" type="text" name="stu.home" class="form-control" placeholder="寝室号" maxlength="8">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<label for="tel" class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></label>
					<input id="tel" type="text" name="stu.tel" class="form-control" placeholder="电话" maxlength="11">
				</div>
			</div>
			<div class="btn-group-justified">
				<div class="btn-group">
					<input type="reset" class="btn btn-warning">
				</div>
				<div class="btn-group">
					<input id="asf" type="button" class="btn btn-primary" value="添加">
				</div>
			</div>
		</form>
	</div>
</div>