
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%--以上标签必须放在最上 否则无法在移动端正常显示--%>
	<title>${resultDto.menu.menuTitle}</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
	<style>
		#userIcon img{
			width: 180px;
			height:180px;
		}

		 #resultSpan{
			 color: #b2b2b2;
		 }
		#userIcon2 img{
			width: 40px;
			height:40px;
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
			<h2>${resultDto.menu.menuTitle}
				<c:if test="${resultDto.menu.menuStatus==1}">
							<span id="resultSpan">(已关闭的投票)<span>
				</c:if>
			</h2>
			<hr>
			<h5>${resultDto.menu.menuDiscription}</h5>
			<br>
			<ul>
			<c:forEach items="${resultDto.optionDtos}" var="optionDto">
					<li>${optionDto.option.optionTitle} &nbsp;&nbsp;&nbsp;<span class="badge">${optionDto.count}</span></li>
				<br>
			</c:forEach>
				<li><canvas id="myChart" width="400" height="200"></canvas></li>
			</ul>
		</div>

		<div class="col col-md-4 col-xs-12">
			<br>
			<br>
			<h4>开始于</h4>
			<h6>&nbsp;&nbsp;${resultDto.menu.createDate}</h6>
			<div id="userIcon">
				<img src="<%=request.getContextPath()%>/image/down/u/${resultDto.menu.createdBy}" alt="创建人头像"/>
			</div>
		</div>

		<div class="col col-xs-12 col-md-8" style="margin-top: 15px;">
			<hr/>
			<c:if test="${currentUser!=null}">
			<div class="col-xs-12">
				<form method="post" action="<%=request.getContextPath()%>/voting/addCommit">
					<input type="hidden" name="menuId" value="${resultDto.menu.id}"/>
					<input type="hidden" name="userId" value="${currentUser.id}"/>
				<div class="form-group">
					<label for="textArea" class="col-lg-2 control-label">${currentUser.username}</label>
					<div class="col-lg-10">
						<textarea class="form-control" rows="3" id="textArea" name="content"></textarea>
						<span class="help-block">在上方写入你的看法</span>
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-10 col-lg-offset-2">
						<button type="reset" class="btn btn-default">Cancel</button>
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</div>
			</form>
			</div>
			</c:if>
			<legend>comments</legend>
			<div class="col-xs-12">
				<c:forEach items="${commits}" var="commit">
				<div class="panel panel-default">
					<div class="panel-body">
						<div id="userIcon2">
							<img src="<%=request.getContextPath()%>/image/down/u/${commit.userId}" alt="创建人头像"/>
						</div>
						<h4>${commit.content}</h4>
						<h5>${commit.createDate}</h5>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>

		<%--评论部分--%>
	</div>
</div>
<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/Chart.js"></script>
<script>
//	var optionLabels =
//	console.log(optionLabels);
	<%--${optionDto.count}--%>
//TODO finish the Chart code
$(function(){
	//Get context with jQuery - using jQuery's .get() method.
	var ctx = $("#myChart").get(0).getContext("2d");
//This will get the first returned node in the jQuery collection.
	var myNewChart = new Chart(ctx);



	var datas = {
		labels:[],
		datasets : [
			{
				fillColor : "rgba(220,220,220,0.5)",
				strokeColor : "rgba(220,220,220,1)",
				data : []
			}
		]
	};

	var options = {

		//Boolean - If we show the scale above the chart data
		scaleOverlay : false,

		//Boolean - If we want to override with a hard coded scale
		scaleOverride : false,

		//** Required if scaleOverride is true **
		//Number - The number of steps in a hard coded scale
		scaleSteps : null,
		//Number - The value jump in the hard coded scale
		scaleStepWidth : null,
		//Number - The scale starting value
		scaleStartValue : null,

		//String - Colour of the scale line
		scaleLineColor : "rgba(0,0,0,.1)",

		//Number - Pixel width of the scale line
		scaleLineWidth : 1,

		//Boolean - Whether to show labels on the scale
		scaleShowLabels : false,

		//Interpolated JS string - can access value
		<%--scaleLabel : "<%=value%>",--%>

		//String - Scale label font declaration for the scale label
		scaleFontFamily : "'Arial'",

		//Number - Scale label font size in pixels
		scaleFontSize : 12,

		//String - Scale label font weight style
		scaleFontStyle : "normal",

		//String - Scale label font colour
		scaleFontColor : "#666",

		///Boolean - Whether grid lines are shown across the chart
		scaleShowGridLines : true,

		//String - Colour of the grid lines
		scaleGridLineColor : "rgba(0,0,0,.05)",

		//Number - Width of the grid lines
		scaleGridLineWidth : 1,

		//Boolean - If there is a stroke on each bar
		barShowStroke : true,

		//Number - Pixel width of the bar stroke
		barStrokeWidth : 2,

		//Number - Spacing between each of the X value sets
		barValueSpacing : 5,

		//Number - Spacing between data sets within X values
		barDatasetSpacing : 1,

		//Boolean - Whether to animate the chart
		animation : true,

		//Number - Number of animation steps
		animationSteps : 60,

		//String - Animation easing effect
		animationEasing : "easeOutQuart",

		//Function - Fires when the animation is complete
		onAnimationComplete : null

	};

	$.ajax({
		url: '<%=request.getContextPath()%>/result/get/${resultDto.menu.id}',
		type: 'GET', //GET
		async: true,    //或false,是否异步
		success: function (rep) {
			for(var i =0;i<rep.length;i++){
				datas.labels.push(rep[i].option.optionTitle);
				datas.datasets[0].data.push(rep[i].count);
			}
			new Chart(ctx).Bar(datas,options);
			console.log(data);
		},
		error: function () {
			console.log("fail");
		}
	});


});

</script>
</body>

</html>