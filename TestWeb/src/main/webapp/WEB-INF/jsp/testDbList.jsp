<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.eugeneprogram.testweb.service.TestService" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<table>
  <tr>
    <th>col1</th>
    <th>col2</th>
  </tr>

<c:forEach var="testMap" items="${testDbList}" varStatus="status">
  <tr>
      <td><p>${testMap.user_id }</p></td>
      <td><p>${testMap.user_pw }</p></td>
  </tr>
</c:forEach>
<br><br><br>

<c:forEach var="tempDb" items="${tempDbList}" varStatus="status">
  <tr>
      <td><p>${tempDb.user_id }</p></td>
      <td><p>${tempDb.user_pw }</p></td>
  </tr>
</c:forEach>



</table>
<br><br>
<h1>===================================</h1>
<c:forEach var="tempDb1" items="${allList}" varStatus="status">
  <tr>
      <td><p>${tempDb1.id }</p></td>
      <td><p>${tempDb1.user_date }</p></td>
  </tr>
</c:forEach>
</body>

</html>