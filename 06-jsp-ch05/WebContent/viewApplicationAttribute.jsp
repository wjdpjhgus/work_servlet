<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<title>기본 객체 속성 보기</title>
</head>
<body>
	<%
		Enumeration<String> attrEnum = session.getAttributeNames();//어플리케이션 영역에서 세션으로 영역을 바꿔줌 세션은 동일브라우저에서만 어플리케이션은 다름 브라우져에서도 가능
		while (attrEnum.hasMoreElements()) {
			String name = attrEnum.nextElement();
			Object value = session.getAttribute(name);
	%>
	application 속성:
	<b><%=name%></b>=
	<%=value%>
	<br>
	<%
		}
	%>

</body>
</html>