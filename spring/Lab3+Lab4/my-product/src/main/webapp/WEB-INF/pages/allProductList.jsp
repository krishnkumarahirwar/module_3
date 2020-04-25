<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<% List elist=(List)session.getAttribute("findAll",product);%>
<html>
<body>
<h1>
<table>
<%=eList%>
<c:forEach items="${eList}" var="product"> 
<tr>
	<td>productId:<c:out value="${product.productId}"/></td>
	<td>productName:<c:out value="${product.productName}"/></td>
	<td>productPrice:  <c:out value="${product.productPrice}"/></td>
</tr>
</c:forEach>
</table>
</h1>
</body>
</html>
