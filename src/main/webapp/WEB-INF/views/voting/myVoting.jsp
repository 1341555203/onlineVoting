<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%--以上标签必须放在最上 否则无法在移动端正常显示--%>
	<title>My Voting</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
	<style>
		.whitebg{
			background-color:white;
		}
		.breadcrumb li{
			font-size: medium;
		}
		#userIcon img{
			width: 120px;
			height:120px;
		}
	</style>
</head>
<body>
<div class="container col-lg-8 col-lg-offset-2 ">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="<%=request.getContextPath()%>/sys/home">VOTE</a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="<%=request.getContextPath()%>/sys/help">help</a></li>
			</ul>
		</div>
	</nav>
	<br>
	<div class="container col-xs-12 whitebg">
		<legend>
			<ul class="breadcrumb">
				<li class="active">Account</li>
				<li><a href="<%=request.getContextPath()%>/user/myVotes">My Voting</a></li>
				<li><a href="<%=request.getContextPath()%>/voting/startup">Startup!</a></li>
				<li><a href="<%=request.getContextPath()%>/user/signout">signout</a></li>
			</ul>
		</legend>
		<div class="col-xs-10 col-xs-offset-1">
			<div class="list-group">
				<c:forEach var="menu" items="${menuList}">
					<div class="list-group-item" style="margin-bottom: 10px">
						<h4 class="list-group-item-heading text-center">${menu.menuTitle}</h4>
						<hr/>
						<div class="list-group-item-text">
								${menu.menuDiscription}
						</div>
						<p class="text-right">
								${menu.createDate}
						</p>
							<%--<a href="#" class="btn btn-block btn-primary">Cast This</a>--%>
					</div>
				</c:forEach>
			</div>
	</div>
</div>

</body>
<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
</html>