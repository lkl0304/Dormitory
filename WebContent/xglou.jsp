<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="style/js/xglou.js"></script>
<div class="mypanel">
	<div id="lxgalert" style="display: none;" class="alert alert-warning">
		<strong>错误信息：</strong><span> 内容没有被修改！</span>
	</div>
	<span style="display: none;" id="llid">${requestScope.loulist[0].id}</span>
	<div>
		<h4>修改 <strong id="lnm">${requestScope.loulist[0].name}</strong> 楼信息</h4><hr style="margin: 10px 0;">
	</div>
	<div>
		<div class="form-group">
			<div class="input-group">
				<label for="xinfo" class="input-group-addon"><span class="glyphicon glyphicon-list-alt"></span></label>
				<textarea onfocus="$('#lxgalert').hide();" id="xinfo" cols="10" rows="5" class="form-control" placeholder="信息">${requestScope.loulist[0].info}</textarea>
			</div>
		</div>
		<div class="btn-group-justified">
			<div class="btn-group">
				<button onclick="lflush(1);" class="btn btn-warning">返回</button>
			</div>
			<div class="btn-group">
				<button id="xgl" class="btn btn-success">保存修改</button>
			</div>
		</div>
	</div>
</div>