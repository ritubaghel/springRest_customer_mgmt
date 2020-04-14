<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<body>
<h2>

<c:forEach items="${employees}" var="employee">

Id is  <c:out value="${employee.id}"/>
Name is <c:out value="${employee.name}"/>
<br>
</c:forEach>

</h2>
</body>
</html>