<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit List</title>
</head>
<body>
	<form action="editExistingListServlet" method="post">
		List Name: <input type="text" name="listName" value="${listToEdit.listName}"><br /> 
		Sale date: <input type="text" name="month" placeholder="mm" size="4" value="${listToEdit.sellDate.getMonthValue()}"> 
		<input type="text" name="day" placeholder="dd" size="4" value="${listToEdit.sellDate.getDayOfMonth()}">, 
		<input type="text" name="year" placeholder="yyyy" size="4" value="${listToEdit.sellDate.getYear()}"> 
		Seller Name: <input type="text" name="sellerName" value="${listToEdit.seller.sellerName}"><br /> 
		Seller Driver License: <input type="text" name="sellerDriverLicense" value="${listToEdit.seller.sellerDriverLicense}"><br /> 
		<input type="hidden" name="id" value="${listToEdit.id}"> 
		Current Books:<br /> <select name="currentItems" multiple size="6">
			<c:forEach var="listVal" items="${listToEdit.listOfItems}">
				<option value="${listVal.id}">${listVal.title}| ${listVal.author}</option>
			</c:forEach>
		</select> <br /> Remaining Items:<br /> <select name="itemsToAdd" multiple
			size="6">
			<c:forEach items="${requestScope.allItemsToAdd}" var="currentitem">
				<option value="${currentitem.id}">${currentitem.title}| ${currentitem.author} </option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Edit List and Edit Items">
	</form>
	<a href="index.html">Go add new items instead.</a>
</body>
</html>