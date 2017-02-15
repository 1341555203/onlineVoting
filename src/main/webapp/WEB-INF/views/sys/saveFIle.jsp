<%--
  Created by IntelliJ IDEA.
  User: mtf81
  Date: 2017/2/15
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<form method="post" action="/image/upload/u/1234567" enctype="multipart/form-data">
	<input type="file" name="upImage"/>
	<button type="submit">submit</button>
</form>
<img src="<%=request.getContextPath()%>/temp/getTestImage" style="width: 50px;height: 50px;"/>
</body>
</html>
