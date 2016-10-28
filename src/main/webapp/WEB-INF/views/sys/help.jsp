<%--
  Created by IntelliJ IDEA.
  User: mtf81
  Date: 2016/10/28
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="S" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Help</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container col-lg-8 col-lg-offset-2 " >
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=request.getContextPath()%>/sys/home">VOTE</a>
			</div>

			<div class="navbar-collapse collapse" id="bs-example-navbar-collapse-2" aria-expanded="false" style="height: 1px;">
				<ul class="nav navbar-nav">
					<%--c:if 判断 若已登录则试用dropdown显示当前用户--%>
					<li><a href="<%=request.getContextPath()%>/user/signup">Sign Up<span class="sr-only">(current)</span></a></li>
					<li><a href="<%=request.getContextPath()%>/user/signin">Sign in</a></li>

					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${currentUser} <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="<%=request.getContextPath()%>/user/account">Account</a></li>
							<li><a href="<%=request.getContextPath()%>/voting/startup">Start up a Voting</a></li>
							<li><a href="<%=request.getContextPath()%>/voting/myVoting">My Vote Center</a></li>
							<li class="divider"></li>
							<li><a href="<%=request.getContextPath()%>/user/signout">Sign Out</a></li>
							<%--<li class="divider"></li>--%>
							<%--<li><a href="#">One more separated link</a></li>--%>
						</ul>
					</li>

				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Search</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<%=request.getContextPath()%>/sys/help">help</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container col col-xs-12 "style="background-color: white">
		<div class="list-group">
			<div class="list-group-item" style="margin-bottom: 10px">
				<h4 class="list-group-item-heading text-center">List group item heading</h4>
				<hr/>
				<div class="list-group-item-text">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.t eget metus. Maecenas sed diam eget risus varius blandit.</div>
				<p class="text-right">
					2016-10-28 11:16:03
				</p>
				<a href="#" class="btn btn-block btn-primary">vote this</a>
			</div>
		</div>
	</div>
	<div class="container col-xs-12">
		<div class="well well-sm">
			footer
		</div>
	</div>

	<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>