<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%--以上标签必须放在最上 否则无法在移动端正常显示--%>
	<title>管理</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container col-lg-8 col-lg-offset-2 " >
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="<%=request.getContextPath()%>/sys/home">VOTE</a>
			</div>

			<ul class="nav navbar-nav navbar-right">
			<li><a href="<%=request.getContextPath()%>/user/signout">sign out</a></li>
			</ul>
		</div>
	</nav>

	<div class="container col-lg-10 col-lg-offset-1">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#user" data-toggle="tab" aria-expanded="true">Users</a></li>
			<li class=""><a href="#menu" data-toggle="tab" aria-expanded="false">Menus</a></li>

		</ul>
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade active in" id="user">
				<table class="table table-striped table-hover ">
					<thead>
					<tr>
						<th>用户id</th>
						<th>用户名</th>
						<th>用户邮箱</th>
						<th>用户性别</th>
						<th>#</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td>${user.id}</td>
							<td>${user.username}</td>
							<td>${user.email}</td>
							<td>${user.gender}</td>
							<td><a href="<%=request.getContextPath()%>/admin/del/${user.id}">删除用户</a> </td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="tab-pane fade" id="menu">
				<table class="table table-striped table-hover ">
					<thead>
					<tr>
						<th>选单id</th>
						<th>选单标题</th>
						<th>选单描述</th>
						<th>选单状态</th>
						<th>#</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${menuList}" var="menu">
						<tr>
							<td>${menu.id}</td>
							<td>${menu.menuTitle}</td>
							<td>${menu.menuDiscription}</td>
							<td>${menu.menuStatus}</td>
							<td><a href="<%=request.getContextPath()%>/admin/del2/${menu.id}">删除选单</a> </td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>






	</div>

</div>
</body>
<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
</html>
