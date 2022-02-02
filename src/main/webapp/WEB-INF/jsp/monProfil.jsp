<%@page import="fr.eni.projet.bll.UtilisateurManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon profil</title>
</head>
<body>

<form action="" method="POST">
      
      Pseudo : <input type="text" placeholder="Saisissez votre user Pseudo :"><br>
      Saisissez votre Nom :<input type="text" placeholder="Saisissez votre nom :"><br>
      Saisissez votre prenom :<input type="text" placeholder="Saisissez votre prenom :"><br>
      Saisissez votre email:<input type="email" placeholder="Saisissez votre email:"><br>
      Saisissez votre Telephone :<input type="text" placeholder="Saisissez votre telephone :"><br>
      Mot de passe Actuel :<input type="password" placeholder=" password Actuel :"><br>
      Saisissez nouveau password :<input type="password" placeholder="Saisissez nouveau password :"><br>
      Confirmation :<input type="password" placeholder="Conform your password :"><br>
      Saisissez votre Rue:<input type="email" placeholder="Saisissez votre Rue:"><br>
      Saisissez votre Ville:<input type="email" placeholder="Saisissez votre Ville :"><br>
      Saisissez votre Rue:<input type="email" placeholder="Saisissez votre Rue:"><br>
	  
	 <%--  Crédit : ${}	 --%>	      
      <input type="submit" value="regester now">
      <input type="submit" value="Supprimer mon compte ">
    </form>
	

</body>
</html>