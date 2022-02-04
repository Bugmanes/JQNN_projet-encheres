<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/AccueilServlet"	method="Post">
					<select name="categorie"
						id="categorie">
						<!-- <option value="">Toutes</option> -->
						<option value="1">Informatique</option>
						<option value="2">Ameublement</option>
						<option value="3">Vètement</option>
						<option value="4">Sport&Loisirs</option>
					</select>
					<button type="submit">
					<p>rechercher</p>
					</button>
					</form>
</body>
</html>