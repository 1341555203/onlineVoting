<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%--以上标签必须放在最上 否则无法在移动端正常显示--%>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
	<title>startUp</title>
</head>
<body>
<div class="container col-lg-8 col-lg-offset-2 ">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
				        data-target="#bs-example-navbar-collapse-2" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=request.getContextPath()%>/sys/home">VOTE</a>
			</div>

			<div class="navbar-collapse collapse" id="bs-example-navbar-collapse-2" aria-expanded="false"
			     style="height: 1px;">
				<ul class="nav navbar-nav">

					<c:if test="${currentUser!=null}">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
							   aria-expanded="false">${currentUser.username} <span class="caret"></span></a>
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
					</c:if>
				</ul>
				<%--<form class="navbar-form navbar-left" role="search">--%>
					<%--<div class="form-group">--%>
						<%--<input type="text" class="form-control" placeholder="Search">--%>
					<%--</div>--%>
					<%--<button type="submit" class="btn btn-default">Search</button>--%>
				<%--</form>--%>
				<ul class="nav navbar-nav navbar-right">
					<%--c:if 判断 若已登录则试用dropdown显示当前用户--%>
					<%--<li><a href="<%=request.getContextPath()%>/user/signup">Sign Up<span class="sr-only">(current)</span></a></li>--%>
					<c:if test="${currentUser==null}">
						<li><a href="<%=request.getContextPath()%>/user/signin">Sign in</a></li>
					</c:if>
					<li><a href="<%=request.getContextPath()%>/sys/help">help</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container col col-xs-12 " style="background-color: white">
		<div class="list-group">
			<div class="list-group-item" style="margin-bottom: 10px">
				<h4 class="list-group-item-heading text-center">创建新选单</h4>
				<hr/>
				<div class="list-group-item-text">


					<div class="form-group">
						<label class="control-label" for="inputDefault">请填写一个主题</label>
						<input type="text" class="form-control" id="inputDefault">
					</div>
					<div class="form-group">
						<label class="control-label" for="inputLarge">请添加一段描述</label>
						<input class="form-control input-lg" type="text" id="inputLarge">
					</div>
					<div id="optionArea">
						<div class="alert alert-dismissible alert-danger">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>测试选项1</strong>
						</div>
						<div class="alert alert-dismissible alert-danger">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>测试选项2</strong>
						</div>
						<div class="alert alert-dismissible alert-danger">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>测试选项3</strong>
						</div>
					</div>
					<a href="#" class="btn btn-default">增加一个选项</a>

					<%--<div class="form-group">--%>
						<%--<label class="col-lg-2 control-label">选择投票类型</label>--%>
						<%--<div class="col-lg-10">--%>
							<%--<div class="radio">--%>
								<%--<label>--%>
									<%--<input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked="">--%>
									<%--单选--%>
								<%--</label>--%>
							<%--</div>--%>
							<%--<div class="radio">--%>
								<%--<label>--%>
									<%--<input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">--%>
									<%--多选--%>
								<%--</label>--%>
							<%--</div>--%>
						<%--</div>--%>
					<%--</div>--%>
				</div>
				<p class="text-right">
					 *此选单为单选模式
				</p>
				<a href="#" class="btn btn-block btn-primary">创建!</a>
			</div>
		</div>
	</div>
</div>
<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>