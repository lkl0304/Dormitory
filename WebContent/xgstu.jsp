<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="xxgalert" style="display: none;" class="alert alert-warning">
	<strong>错误信息: </strong><span id="xsts">错误</span>
</div>
<div id="alertsuccess" style="display: none;" class="alert alert-success">
	<strong>成功信息: </strong><span id="xgsuccess">成功</span>&nbsp;<a href="javascript:void(0);" id="astop">留在本页</a>
</div>
<div>
	<a id="xgfh" class="pull-right btn btn-warning btn-xs">返回</a>
	<h4>修改 <strong>${requestScope.stulist[0].name}</strong> 的信息</h4>
</div>
<hr style="margin: 10px 0;">
<div style="margin-top: 15px;" class="table-responsive">
	<form id="xgssform">
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>学号</td>
					<td>性别</td>
					<td>宿舍楼</td>
					<td>寝室号</td>
					<td>电话</td>
					<!-- td>操作</td -->
				</tr>
			</thead>
			<c:forEach items="${requestScope.stulist}" var="stu">
				<input class="sr-only" type="text" name="sid" value="${stu.id}">
				<input class="sr-only" type="text" name="stu.name" value="${stu.name}">
				<tr> <!-- 发现问题 int 存不了11为数字 -->
					<td><input id="stuid" name="stu.stuid" type="text" class="inp" maxlength="10" value="${stu.stuid }"></td>
					<td><input id="sex" name="stu.sex" type="text" class="inp" value="${stu.sex }"></td>
					<td><input id="lou" name="stu.lou" type="text" class="inp" maxlength="11" value="${stu.lou }"></td>
					<td><input id="home" name="stu.home" type="text" class="inp" maxlength="8" value="${stu.home }"></td>
					<td><input id="tel" name="stu.tel" type="text" class="inp" maxlength="11" value="${stu.tel }"></td>
					<!-- td>
						<button id="xgf" class="btn btn-success btn-sm">保存修改</button>
						<a onclick="flush(1);" class="btn btn-warning btn-sm">返回</a>
						 为什么用button会自动提交表单 一开始好像没有
					</td -->
				</tr>
			</c:forEach>
		</table>
	</form>
	<script type="text/javascript" src="style/js/xgstu.js"></script>
</div>