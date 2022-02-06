<%@page import="fr.eni.projet.bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon profil</title>
</head>
<body>
	<div class="container">
		<%@include file="headerConnecter.jsp"%>
		<main>

			<form action="/ModifierProfil" method="post">

				<%
				Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
				%>
				<p id="Paragraphe">
					<b>Bonjour ${utilisateur.prenom}.</b>
				</p>
				<label> Pseudo : </label><input type="text" value="pseudo"
					placeholder="Saisissez votre user Pseudo :"
					autocomplete="${utilisateur.pseudo}"><br> <label>
					Saisissez votre Nom :</label><input type="text" value="nom"
					placeholder="Saisissez votre nom :"
					autocomplete="${utilisateur.nom}"><br> <label>
					Saisissez votre prenom :</label><input type="text" value="prenom"
					placeholder="Saisissez votre prenom :"
					autocomplete="${utilisateur.prenom }"><br> <label>
					Saisissez votre email:</label><input type="email" value="email"
					placeholder="Saisissez votre email:"
					autocomplete="${utilisateur.email }"><br> <label>
					Saisissez votre Telephone :</label><input type="text" value="telephone"
					placeholder="Saisissez votre telephone :"
					autocomplete="${utilisateur.telephone }"><br> <label>
					Mot de passe Actuel :</label><input type="password" value="old_mdp"
					placeholder=" password Actuel :"><br> <label>
					Saisissez nouveau password :</label><input type="password" value="new_mdp"
					placeholder="Saisissez nouveau password :"><br> <label>
					Confirmation :</label><input type="password"
					placeholder="Conform your password :"><br> <label>
					Saisissez votre Rue:</label><input type="email" value="rue"
					placeholder="Saisissez votre Rue:"
					autocomplete="${utilisateur.rue}"><br> <label>
					Saisissez votre Ville:</label><input type="email" value="ville"
					placeholder="Saisissez votre Ville :"
					autocomplete="${utilisateur.ville }"><br> <label>
					Saisissez votre Code postal:</label><input type="text" value="code_postal"
					placeholder="Saisissez votre Code Pstal:"
					autocomplete="${utilisateur.codePostal}"><br>

				<p id="credit">
					<b>Vous avez ${Utilisateur.credit} </b>
				</p>

				<div>
					<button type="submit" value="valider" name="choix">Enregistrer
						les modifications</button>
					<br>
				</div>
			</form>
			<div>
				<form action="./ModifierProfil" method="get">
					<a href="./AccueilServlet"><button type="submit"
							value="supprimer" name="choix">Supprimer mon compte</button> </a><br>

				</form>
			</div>



		</main>
		<footer></footer>
</body>
</html>