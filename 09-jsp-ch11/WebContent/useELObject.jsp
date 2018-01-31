<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setAttribute("name", "최범균");
%>
<!DOCTYPE html>
<html>
<head>
<title>EL Object</title>
</head>

<body>
	요청 URI: ${pageContext.request.requestURI}<br>
	request의 name 속성: ${requestScope.name}<br>
	code 파라미터: ${param.code}

</body>
</html>
<!-- 표현 언어 EL(Expression Language 
		사용법 =${}
		-주석오류 EL언어에는 html주석이 안먹힘-->