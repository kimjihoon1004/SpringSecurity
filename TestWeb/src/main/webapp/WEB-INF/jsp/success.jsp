<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
System.out.println("success �Դ� ��");
%>
<script>
	alert("����");
	window.location.href = '<%= request.getContextPath() %>/visa.do';
</script>
</body>
</html>