<%--
  Created by IntelliJ IDEA.
  User: mtf81
  Date: 2016/11/2
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>SignUp</title>
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
				<li><a href="<%=request.getContextPath()%>/user/signin">sign in</a></li>
				<li><a href="<%=request.getContextPath()%>/sys/help">help</a></li>
			</ul>
		</div>
	</nav>


	<div class="container">
		<form class="form-horizontal  col-md-4 col-md-offset-1 col-lg-4 col-lg-offset-0" method="post" action="signin" style="margin-top: 20px;">
			<fieldset>
				<legend>Sign into your account</legend>
				<br>
				<div class="form-group">
					<label for="inputUsername" class="col-lg-2 control-label">username</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="inputUsername" name="username" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail" class="col-lg-2 control-label">email</label>
					<div class="col-lg-10">
						<input type="email" class="form-control" id="inputEmail" name="loginEmail" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPwd" class="col-lg-2 control-label">password</label>
					<div class="col-lg-10">
						<input type="password" class="form-control" id="inputPwd" name="password" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPwd2" class="col-lg-2 control-label">confirm pwd</label>
					<div class="col-lg-10">
						<input type="password" class="form-control" id="inputPwd2" name="password2" required="required">
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-8 col-lg-offset-2">
						<button type="submit" class="btn btn-primary">Sign Up<span
								class="glyphicon glyphicon-play"></span></button>
					</div>
				</div>
				<hr>
			</fieldset>

		</form>
		<div class="form-horizontal  col-lg-4  col-md-5 hidden-sm hidden-xs">
			<div class="jumbotron">
				<h1>Lorem</h1>
				<p>This is a simple hero unit, a simple jumbotron-style component for calling extra attention to
					featured content or information.</p>
			</div>
		</div>
	</div>
</div>
</body>
<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
</html>
