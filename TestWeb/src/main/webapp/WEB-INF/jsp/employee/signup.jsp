<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>${userNameString }</h1>

<form action="insertUser.do" method="post">
    <!-- CSRF ��ū�� ������ input �ʵ�, ���� ���ٸ� �̵��Ǵ� ���������� ������ ��û -->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input id="userName" type="text" name="userName" placeholder="name">
    <input id="userId" type="text" name="userId" placeholder="id">
    <input id="userPw" type="password" name="userPw" placeholder="pw">
    <input id="userPhone" type="text" name="userPhone" placeholder="phone">
    <input id="userDate" type="date" name="userDate">
    
    <input type="submit" value="����">
</form>

<a href="/">home</a><br>
<a href="/main.do">main.do</a><br>
<a href="/dbTest.do">dbTest.do</a><br>
<a href="/usernam">username</a>
</body>
</html>
 