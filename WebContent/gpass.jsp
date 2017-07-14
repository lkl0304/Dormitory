<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="panel panel-primary">
	<div class="panel-heading">
		<span class="">修改密码</span>
	</div>
	<div class="panel-body">
		<form id="gmfrom" action="changead" method="post">
			<div class="form-group">
				<div class="input-group">
					<label class="input-group-addon">原密码</label>
					<input id="opass" type="text" name="oldpass" class="form-control" required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<label class="input-group-addon">新密码</label>
					<input id="npass1" type="password" name="newpass" class="form-control" required="required">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<label class="input-group-addon">再输入</label>
					<input id="npass2" type="password" name="tpass" class="form-control" required="required">
				</div>
			</div>
			<input id="sub" type="button" value="确定修改" class="btn btn-primary btn-group-justified">
		</form>
	</div>
</div>