<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int var1 = 100;
%>

<%= var1 %>
${var1} <!-- 지역변수는 안된다 => 보완 : JSTL-->
<hr>
<c:set var="var2" value="200"/>
${var2}
</body>
</html>