<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
System.out.println("fail 왔다 감");
%>
<script>
    alert("실패");
    window.location.href = '<%= request.getContextPath() %>/visa.do';
</script>
</body>
</html>