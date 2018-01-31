<!-- p135 -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//쿼리문자열을 이용하여 name과 value값을 저장 (?name = 홍길동 & value =30)
	String name = request.getParameter("name");
	String value = request.getParameter("value");

	if (name != null && value != null) {
		//application 영역 내에서  사용할 수 있는 key와 값을 저장
		session.setAttribute(name, value);
	}
%>

<!DOCTYPE html>
<html>
<head><title>속성 지정</title>
</head>
<body>
	<%
		if (name != null && value != null) {
	%>
	application 기본 색체의 속성 설정
	<%=name%>=
	<%=value%>

	<%
		} else {
	%>
	application 기본객체의 속성 설정 안함
	<%
		}
	%>
</body>
</html>