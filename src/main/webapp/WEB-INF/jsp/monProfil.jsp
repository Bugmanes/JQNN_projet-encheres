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
					<%
							if (request.getAttribute("pseudoOK")!=null){
								boolean pseudoOK = (boolean) request.getAttribute("pseudoOK");
								if (!pseudoOK){
						%>
						<div class="messageErreur">
							<a>Le pseudo ne peut pas contenir de caractères spéciaux ou de lettres accentuées</a>
						</div>
						<%
								}
							}
						%>
						<%
							if (request.getAttribute("pseudoUniqueOK")!=null){
								boolean pseudoUniqueOK = (boolean) request.getAttribute("pseudoUniqueOK");
								if (!pseudoUniqueOK){
						%>
						<div class="messageErreur">
							<a>Ce pseudo n'est pas disponible</a>
						</div>
						<%
								}
							}
						%>
					Saisissez votre Nom :</label><input type="text" value="nom"
					placeholder="Saisissez votre nom :"
					autocomplete="${utilisateur.nom}"><br> <label>
					<%
							if (request.getAttribute("nomOK")!=null){
								boolean nomOK = (boolean) request.getAttribute("nomOK");
								if (!nomOK){
						%>
						<div class="messageErreur">
							<a>Le nom ne peut pas comporter de chiffres et caracteres spéciaux</a>
						</div>
						<%
								}
							}
						%>
					Saisissez votre prenom :</label><input type="text" value="prenom"
					placeholder="Saisissez votre prenom :"
					autocomplete="${utilisateur.prenom }"><br> <label>
					<%
							if (request.getAttribute("prenomOK")!=null){
								boolean prenomOK = (boolean) request.getAttribute("prenomOK");
								if (!prenomOK){
						%>
						<div class="messageErreur">
							<a>Le nom ne peut pas comporter de chiffres et caracteres speciaux</a>
						</div>
						<%
								}
							}
						%>
					Saisissez votre email:</label><input type="email" value="email"
					placeholder="Saisissez votre email:"
					autocomplete="${utilisateur.email }"><br> <label>
					<%
							if (request.getAttribute("emailUniqueOK")!=null){
								boolean emailUniqueOK = (boolean) request.getAttribute("emailUniqueOK");
								if (!emailUniqueOK){
						%>
						<div class="messageErreur">
							<a>Cet email est deja utilise par un compte utilisateur</a>
						</div>
						<%
								}
							}
						%>
					Saisissez votre Telephone :</label><input type="text" value="telephone"
					placeholder="Saisissez votre telephone :"
					autocomplete="${utilisateur.telephone }"><br> <label>
					<%
							if (request.getAttribute("telOK")!=null){
								boolean telOK = (boolean) request.getAttribute("telOK");
								if (!telOK){
						%>
						<div class="messageErreur">
							<a>Le numero de telephone ne peut pas contenir de lettres</a>
						</div>
						<%
								}
							}
						%>
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