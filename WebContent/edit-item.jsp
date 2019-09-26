<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Item</title>
<style>
	body {
		background-color: gainsboro;
	}
	ul {
	text-align: right;
	margin-right: 40%;
	}
	li {
	margin: 10px;
	padding: 10px;
	}

</style>
</head>
<body>
<h1 style="text-align:center;">Edit Item</h1>
<form action = "editItemServlet" method="post">
<ul style="list-style:none;">
<li>Title : <input type ="text" name = "title" value="${itemToEdit.title}"></li>
<li>Author : <input type = "text" name = "author" value= "${itemToEdit.author}"></li>
<li>ISBN : <input type ="text" name = "ISBN" value="${itemToEdit.ISBN}"></li>
<li>Sale Price : <input type = "text" name = "salePrice" value= "${itemToEdit.salePrice}"></li>
<li>Average Days to Sell (in whole days) : <input type ="text" name = "avgDaysToSell" value="${itemToEdit.avgDaysToSell}"></li>
<li><input type = "hidden" name = "id" value="${itemToEdit.id}"></li>
</ul>
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>