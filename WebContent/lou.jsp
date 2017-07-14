<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="style/js/lou.js"></script>
<script type="text/javascript">
	var add = "${requestScope.add}";
	if(add.length > 0){
		if(add == "success")
		{
			alert("添加成功！");
		} else {
			alert("添加失败！重新尝试");
		}
	}
	var del = "${requestScope.del}";
	if(del.length > 0){
		if(del == "success"){
			alert("删除成功！");
		} else {
			alert("删除失败！");
		}
	}
	var update = "${requestScope.update}";
	if(update.length > 0){
		if(update == "success"){
			alert("修改成功！");
		} else {
			alert("修改失败！");
		}
	}
</script>
<div id="lpan" class="container-fluid">
	<div class="mypanel">
		<div>
			<h4 style="cursor: pointer;" onclick="lflush(1);">宿舍楼管理</h4><hr style="margin: 10px 0;">
			<button onclick="addlou();" class="btn btn-success btn-sm">添加</button>
			<div class="pull-right">
				<input id="lsearch" type="text" class="myin" placeholder="楼号">
				<button onclick="lsearch()" style="border-radius: 15px;" class="btn btn-default btn-sm">搜索</button>
			</div>
		</div>
		<div style="margin-top: 15px;" class="table-responsive">
			<table class="table-bordered table table-striped">
				<thead>
					<tr>
						<td>序号</td>
						<td>楼号</td>
						<td>信息</td>
						<td>操作</td>
					</tr>
				</thead>
				<c:if test="${requestScope.lrows <= 0 }">
					<tr style="text-align: center;">
						<td colspan="4">暂无数据</td>
					</tr>
				</c:if>
				<c:forEach items="${requestScope.loulist}" var="lou" varStatus="in">
					<tr>
						<td>${in.index + 1}</td>
						<td>${lou.name}</td>
						<td>${lou.info}</td>
						<td style="width: 150px;">
							<button onclick="xglou('${lou.name}')" class="btn btn-xs btn-success">修改</button>
							<button onclick="dellou(${lou.id}, ${requestScope.lpageNo}, '${lou.name}')" class="btn btn-xs btn-danger">删除</button>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div class="text-center">
				<ul style="margin: 0;" class="pagination">
					<li class="${requestScope.ldisabled}"><a href="javascript:void(0)" onclick="lflush(1)">首页</a></li>
					<li class="${requestScope.ldisabled}"><a href="javascript:void(0)" onclick="lflush(${requestScope.lpageNo - 1})">&laquo;</a></li>
					<c:forEach var="i" begin="1" end="${requestScope.lpages}">
						<c:if test="${i <= 10 }">
							<li class="${requestScope.ldisabled} ${requestScope.lpageNo == i?'active':'' }"><a href="javascript:void(0)" onclick="lflush(${i})">${i}</a></li>
						</c:if>
						<c:if test="${i == 11 }">
							<li class="${requestScope.ldisabled} ${requestScope.lpageNo > 10?'active':'' }"><a onclick="lflush(${requestScope.lpages })">..${requestScope.lpages}</a></li>
						</c:if>
					</c:forEach>
					<li class="${requestScope.ldisabled}"><a href="javascript:void(0)" onclick="lflush(${requestScope.lpageNo + 1})">&raquo;</a></li>
					<li class="${requestScope.ldisabled}"><a href="javascript:void(0)" onclick="lflush(${requestScope.lpages})">尾页</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>