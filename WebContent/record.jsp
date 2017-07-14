<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="style/js/record.js"></script>
<div class="container-fluid">
	<div style="border: 1px solid #D3D6D4; border-radius: 5px; padding: 5px 10px;">
		<div class="">
			<h4>操作记录</h4><hr style="margin: 10px 0 15px;">
		</div>
		<div class="table-responsive">
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<td>类型</td>
						<td>内容</td>
						<td>时间</td>
						<td>操作</td>
					</tr>
				</thead>
				<c:if test="${requestScope.rrows == 0 }">
					<tr style="text-align: center;">
						<td colspan="4">暂无记录</td>
					</tr>
				</c:if>
				<c:forEach items="${requestScope.reclist }" var="rec">
					<tr>
						<td>${rec.type }</td>
						<td>${rec.content }</td>
						<td>${rec.time }</td>
						<td style="width: 150px;"><button onclick="delrec(${rec.id}, ${requestScope.rpageNo})" class="btn btn-danger btn-xs">删除</button></td>
					</tr>
				</c:forEach>
			</table>
			<div style="text-align: center;">
				<ul style="margin: 0;" class="pagination">
					<li class="${requestScope.rdisabled}"><a href="javascript:void(0)" onclick="rflush(1)">首页</a></li>
					<li class="${requestScope.rdisabled}"><a href="javascript:void(0)" onclick="rflush(${requestScope.rpageNo - 1})">&laquo;</a></li>
					<c:forEach var="i" begin="1" end="${requestScope.rpages}">
						<c:if test="${i <= 10 }">
							<li class="${requestScope.rdisabled} ${requestScope.rpageNo == i?'active':'' }"><a href="javascript:void(0)" onclick="rflush(${i})">${i}</a></li>
						</c:if>
						<c:if test="${i == 11 }">
							<li class="${requestScope.rdisabled} ${requestScope.rpageNo > 10?'active':'' }"><a onclick="rflush(${requestScope.rpages })">..${requestScope.rpages}</a></li>
						</c:if>
					</c:forEach>
					<li class="${requestScope.rdisabled}"><a href="javascript:void(0)" onclick="rflush(${requestScope.rpageNo + 1})">&raquo;</a></li>
					<li class="${requestScope.rdisabled}"><a href="javascript:void(0)" onclick="rflush(${requestScope.rpages})">尾页</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>