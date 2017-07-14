<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="style/js/addlou.js"></script>
<div class="panel panel-primary">
	<div id="laddalert" style="display: none;" class="alert alert-warning">
		<strong>错误信息: </strong><span id="xsts">错误</span>
	</div>
	<div class="panel-heading">
		<span>添加楼层</span>
		<span onclick="lflush(1);" class="pull-right glyphicon glyphicon-chevron-left" style="cursor: pointer;">返回</span>
	</div>
	<div class="panel-body">
		<form id="alouform" onsubmit="return false;">
			<div class="form-group">
				<div class="input-group">
					<label for="lname" class="input-group-addon"><span class="glyphicon glyphicon-home"></span></label>
					<input id="lname" type="text" name="lou.name" class="form-control" placeholder="楼号">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<label for="info" class="input-group-addon"><span class="glyphicon glyphicon-list-alt"></span></label>
					<textarea id="info" name="lou.info" cols="10" rows="5" class="form-control" placeholder="信息"></textarea>
				</div>
			</div>
			<div class="btn-group-justified">
				<div class="btn-group">
					<input type="reset" class="btn btn-warning">
				</div>
				<div class="btn-group">
					<input id="alou" type="button" class="btn btn-primary" value="添加">
				</div>
			</div>
		</form>
	</div>
</div>