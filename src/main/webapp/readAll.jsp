<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class = "container">
<table class ="table">
<thead>
 <tr>
     <th>ID</th>
     <th>NAME</th>
     <th>SALARY</th>
 </tr>
 </thead>
 <tbody>
 <c:forEach items="${empList}" var="emp">
 <tr>  
 <td>${emp.id}</td>
     <td>${emp.name}</td>
     <td>${emp.salary}</td>
 </tr>
 
 </c:forEach>
</tbody>
</table>
</div>
</body>
</html>