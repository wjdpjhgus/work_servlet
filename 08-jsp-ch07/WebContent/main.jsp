<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<title>main</title>
</head>
<body>

main.jsp에서 생성한 내용

<jsp:include page="sub.jsp" flush="false"/> <!-- 마지막에 처리하면 false 바로처림하면 true -->

include의 이후의 내용

</body>
</html>