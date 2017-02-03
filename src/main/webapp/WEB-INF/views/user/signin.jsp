<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%--以上标签必须放在最上 否则无法在移动端正常显示--%>
	<title>SignIn</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
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
	<br>
	<div class="container col-lg-10 col-lg-offset-1">
		<form class="form-horizontal  col-md-4 col-md-offset-1 col-lg-6 col-lg-offset-0" method="post" action="signin"
		      style="margin-top: 20px;">
			<fieldset>
				<legend>Sign into your account</legend>
				<br>
				<div class="form-group">
					<label for="inputEmail" class="col-lg-2 control-label">email</label>
					<div class="col-lg-10">
						<input type="email" class="form-control" id="inputEmail" name="email" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPwd" class="col-lg-2 control-label">password</label>
					<div class="col-lg-10">
						<input type="password" class="form-control" id="inputPwd" name="password" required="required">
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-8 col-lg-offset-2">
						<button type="submit" class="btn btn-primary">Sign in<span
								class="glyphicon glyphicon-play"></span></button>
					</div>
				</div>
				<div class="text-right"><a href="<%=request.getContextPath()%>/user/forgot-password">Forgot
					password?</a></div>
			</fieldset>
			<hr>
			<div>
				Don't have an account?<br>
				<a href="<%=request .getContextPath()%>/user/signup">sign up </a>
			</div>
		</form>
		<div class="form-horizontal  col-lg-6  col-md-5 hidden-sm hidden-xs">
			<div class="jumbotron">
				<h2>登录</h2>
				<p>使用email和密码组合进行登录，忘记密码请点击Forgot password链接。<br>
					注册新账户请点击下方sign up链接</p>
			</div>
		</div>
	</div>
</div>
</body>
<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
</html>
