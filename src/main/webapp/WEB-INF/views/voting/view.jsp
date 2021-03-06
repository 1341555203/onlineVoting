
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%--以上标签必须放在最上 否则无法在移动端正常显示--%>
	<title>${menu.menuTitle}</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
	<style>
		#userIcon img{
			width: 180px;
			height:180px;
		}
	</style>
</head>
<body>
<div class="container col col-xs-12 col-lg-8 col-lg-offset-2  ">
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

	<%--主体部分--%>
	<div class="container col col-xs-12 jumbotron " style="background-color: white">
		<%--选单信息--%>
		<%--投票选项及按钮--%>
			<div class="col col-md-8 col-xs-12">
				<h2>${menu.menuTitle}</h2>
				<hr>
				<h5>${menu.menuDiscription}</h5>
				<br>
				<form method="post" action="commitVoting">

					<input type="hidden" value="${menu.id}" name="menuId">
					<input type="hidden" value="${currentUser.id}" name="userId"/>
					<c:forEach items="${menu.options}" var="option">
						<div class="form-group">
							<div class="col-lg-10">
								<div class="radio">
									<label>
										<input type="radio" name="optionId" value="${option.id}" required="required">
											${option.optionTitle}
									</label>
								</div>
							</div>
						</div>
					</c:forEach>
					<button id="subBtn"type="submit" class="btn  btn-primary " >提交我的选择</button>
				</form>
			</div>

			<div class="col col-md-4 col-xs-12">
				<br>
				<br>
				<h4>开始于</h4>
				<h6>&nbsp;&nbsp;${menu.createDate}</h6>
				<div id="userIcon">
				<img src="<%=request.getContextPath()%>/image/down/u/${menu.createdBy}" alt="创建人头像"/>
				</div>
			</div>

			<div class="col col-xs-12 col-md-8" style="margin-top: 15px;">

			</div>

		<%--评论部分--%>
	</div>
</div>
<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
</body>
<script>
	$(function(){

	});
</script>
</html>