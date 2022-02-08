<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/Test"	method="Post">
					<label for="pseudo">Pseudo :</label>
					<input type="text" id="pseudo" name="pseudo" />
					<button type="submit">
					<p>rechercher</p>
					</button>
					</form>
</body>
</html>