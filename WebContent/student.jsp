<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="style/js/student.js"></script>
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
<div id="stpan" class="container-fluid">
	<div id="mypan" class="mypanel">
		<header>
			<h4 style="cursor: pointer;" onclick="flush(1)">学生管理</h4><hr style="margin: 10px 0;">
			<button onclick="addstu();" class="btn btn-success btn-sm">添加</button>
			<div class="pull-right">
				<input id="search" type="text" class="myin" placeholder="姓名">
				<button onclick="search()" style="border-radius: 15px;" class="btn btn-default btn-sm">搜索</button>
			</div>
		</header>
		<div style="margin-top: 15px;" class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<td>学号</td>
						<td>姓名</td>
						<td>性别</td>
						<td>宿舍楼</td>
						<td>寝室号</td>
						<td>电话</td>
						<td>操作</td>
					</tr>
				</thead>
				<c:if test="${requestScope.rows <= 0 }">
					<tr style="text-align: center;">
						<td colspan="8">暂无数据</td>
					</tr>
				</c:if>
				<c:forEach items="${requestScope.stulist}" var="stu" varStatus="in">
				<tr>
					<td>${stu.stuid }</td>
					<td>${stu.name }</td>
					<td>${stu.sex }</td>
					<td>${stu.lou }</td>
					<td>${stu.home }</td>
					<td>${stu.tel }</td>
					<td style="width: 150px;">
						<button onclick="xg('${stu.name}')" class="btn btn-primary btn-xs">修改</button>
						<button onclick="delstu(${stu.id}, ${requestScope.pageNo}, '${stu.name}');" class="btn btn-danger btn-xs">删除</button>
					</td>
				</tr>
				</c:forEach>
			</table>
			<footer class="footer">
				<span>平台共 ${requestScope.rows} 条数据</span>
				<ul id="pag" style="margin: 0;" class="pagination ufy">
					<li class="${requestScope.disabled}"><a href="javascript:void(0)" onclick="flush(1)">首页</a></li>
					<li class="${requestScope.disabled}"><a href="javascript:void(0)" onclick="flush(${requestScope.pageNo - 1})">&laquo;</a></li>
					<c:forEach var="i" begin="1" end="${requestScope.pages}">
						<c:if test="${i <= 10 }">
							<li class="${requestScope.disabled} ${requestScope.pageNo == i?'active':'' }"><a href="javascript:void(0)" onclick="flush(${i})">${i}</a></li>
						</c:if>
						<c:if test="${i == 11 }">
							<li class="${requestScope.disabled} ${requestScope.pageNo > 10?'active':'' }"><a onclick="flush(${requestScope.pages })">..${requestScope.rpages}</a></li>
						</c:if>
					</c:forEach>
					<li class="${requestScope.disabled}"><a href="javascript:void(0)" onclick="flush(${requestScope.pageNo + 1})">&raquo;</a></li>
					<li class="${requestScope.disabled}"><a href="javascript:void(0)" onclick="flush(${requestScope.pages})">尾页</a></li>
				</ul>
			</footer>
		</div>
	</div>
</div>