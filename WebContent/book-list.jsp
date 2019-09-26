<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Books</title>
<style>
	body {
		background-color: gainsboro;
	}
	td {
	margin-right: 10px;
	margin-left: 10px;
	padding: 5px;
	}
	tr:nth-child(even) {
		background-color: gray;
	}
	tr:nth-child(odd) {
		background-color: silver;
	}

</style>
</head>
<body>
<h1 style="text-align:center;">Current Inventory</h1>
<form method = "post" action = "navigationServlet">
<table>
<tr>
<td></td>
<td>Title</td>
<td>Author</td>
<td>ISBN</td>
<td>Price</td>
<td>Days to Sell</td>
<td>Percent Paid</td>
</tr>
<c:forEach items="${requestScope.allItems}" var="currentitem">

<tr>
 <td><input type="radio" name="id" value="${currentitem.id}"></td>
 <td>${currentitem.title}</td>
 <td>${currentitem.author}</td>
 <td>${currentitem.ISBN}</td>
 <td>${currentitem.salePrice}</td>
 <td style="text-align:center;">${currentitem.avgDaysToSell}</td>
 <td>${currentitem.percentPaid}</td>
 </tr>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
</body>
</html>