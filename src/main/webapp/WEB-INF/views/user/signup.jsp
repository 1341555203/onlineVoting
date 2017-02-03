<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%--以上标签必须放在最上 否则无法在移动端正常显示--%>
	<title>SignUp</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
	<style>
		.errorMsg {
			color: red;
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
				<li><a href="<%=request.getContextPath()%>/user/signin">sign in</a></li>
				<li><a href="<%=request.getContextPath()%>/sys/help">help</a></li>
			</ul>
		</div>
	</nav>
	<br>
	<br>
	<div class="container col-lg-10 col-lg-offset-1">
		<form class="form-horizontal  col-md-4 col-md-offset-1 col-lg-6 col-lg-offset-0" method="post" action="signup"
		      style="margin-top: 20px;">
			<fieldset>
				<legend>Sign up an account</legend>
				<br>
				<div class="form-group">
					<label for="inputUsername" class="col-lg-2 control-label">username</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="inputUsername" name="username" required="required">
						<div class="errorMsg"><form:form commandName="user"><form:errors
								path="username"></form:errors></form:form></div>
					</div>

				</div>
				<div class="form-group">
					<label for="inputEmail" class="col-lg-2 control-label">email</label>
					<div class="col-lg-10">
						<input type="email" class="form-control" id="inputEmail" name="email" required="required">
						<div class="errorMsg"><form:form commandName="user"><form:errors
								path="email"></form:errors></form:form>
							${errorMessage}
						</div>
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
						<input type="password" class="form-control" id="inputPwd2" required="required">
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-8 col-lg-offset-2">

					</div>
					<div class="col-lg-8 col-lg-offset-2">
						<button type="submit" class="btn btn-primary">Sign Up<span
								class="glyphicon glyphicon-play"></span></button>
					</div>
				</div>
				<hr>
			</fieldset>

		</form>
		<div class="form-horizontal  col-lg-6  col-md-5 hidden-sm hidden-xs">
			<div class="jumbotron">
				<h1>注册</h1>
				<p>注册一个账户以发起、参与投票及在表单下留言，并查看投票结果。<br>
					使用email地址登录，用户名可在个人中心修改。</p>
			</div>
		</div>
	</div>
</div>
</body>
<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
</html>
