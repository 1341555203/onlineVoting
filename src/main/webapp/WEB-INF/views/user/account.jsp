<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%--以上标签必须放在最上 否则无法在移动端正常显示--%>
	<title>Account</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
	<style>
		.whitebg{
			background-color:white;
		}
		.breadcrumb li{
			font-size: medium;
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
			<li><a href="<%=request.getContextPath()%>/user/myVotes">Voting Center</a></li>
			<li><a href="<%=request.getContextPath()%>/voting/startup">Startup!</a></li>
			<li><a href="<%=request.getContextPath()%>/user/signout">signout</a></li>
		    </ul>
		</legend>
		<div class="col-xs-10 col-xs-offset-1">
			<h1>${currentUser.username}</h1>
			<h3>${currentUser.email}</h3>
			<h3 class="userGender">${currentUser.gender}</h3>
			<h3 class="userType">${currentUser.userType}</h3>
			<hr>
			<a class="btn btn-primary" href="<%=request.getContextPath()%>/user/account/update">修改账户信息</a>
		</div>
	</div>
</div>
</body>
<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
<script>
	$(function(){
		var userGender=$('.userGender').text();
		if(userGender!=null){
			if(userGender=='0'){
				$('.userGender').text('女');
			}
			if(userGender=='1'){
				$('.userGender').text('男');
			}
		}
		var userType=$('.userType').text();
		if(userType!=null){
			if(userType=='0'){
				$('.userType').text('普通用户');
			}
			if(userType=='1'){
				$('.userType').text('管理员');
			}
		}
	});
</script>
</html>