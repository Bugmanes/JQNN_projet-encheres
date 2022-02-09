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

			<form action="<%= request.getContextPath()%>/modifierProfil" method="post">
				<p id="Paragraphe">
					<b>Bonjour ${sessionScope.utilisateur.prenom}</b>
				</p>
				<label> Pseudo : </label><input type="text" name="pseudo" value="${sessionScope.utilisateur.pseudo}"
					placeholder="Saisissez votre user Pseudo :"><br> <label>
					<%
							if (request.getAttribute("pseudoOK")!=null){
								boolean pseudoOK = (boolean) request.getAttribute("pseudoOK");
								if (!pseudoOK){
						%>
					<div class="messageErreur">
						<a>Le pseudo ne peut pas contenir de caractères spéciaux ou de
							lettres accentuées</a>
					</div> <%
								}
							}
						%> <%
							if (request.getAttribute("pseudoUniqueOK")!=null){
								boolean pseudoUniqueOK = (boolean) request.getAttribute("pseudoUniqueOK");
								if (!pseudoUniqueOK){
						%>
					<div class="messageErreur">
						<a>Ce pseudo n'est pas disponible</a>
					</div> <%
								}
							}
						%> Saisissez votre Nom :
				</label><input type="text" name="nom" value="${utilisateur.nom}" ><br> <label>
					<%
							if (request.getAttribute("nomOK")!=null){
								boolean nomOK = (boolean) request.getAttribute("nomOK");
								if (!nomOK){
						%>
					<div class="messageErreur">
						<a>Le nom ne peut pas comporter de chiffres et caracteres
							spéciaux</a>
					</div> <%
								}
							}
						%> Saisissez votre prenom :
				</label><input type="text" name="prenom" value="${utilisateur.prenom }"><br> <label>
					<%
							if (request.getAttribute("prenomOK")!=null){
								boolean prenomOK = (boolean) request.getAttribute("prenomOK");
								if (!prenomOK){
						%>
					<div class="messageErreur">
						<a>Le nom ne peut pas comporter de chiffres et caracteres
							speciaux</a>
					</div> <%
								}
							}
						%> Saisissez votre email:
				</label><input type="email" name="email" value="${utilisateur.email }"><br> <label>
					<%
							if (request.getAttribute("emailUniqueOK")!=null){
								boolean emailUniqueOK = (boolean) request.getAttribute("emailUniqueOK");
								if (!emailUniqueOK){
						%>
					<div class="messageErreur">
						<a>Cet email est deja utilise par un compte utilisateur</a>
					</div> <%
								}
							}
						%> Saisissez votre Telephone :
				</label><input type="text" name="tel" value="${utilisateur.telephone }"><br> <label>
					<%
							if (request.getAttribute("telOK")!=null){
								boolean telOK = (boolean) request.getAttribute("telOK");
								if (!telOK){
						%>
					<div class="messageErreur">
						<a>Le numero de telephone ne peut pas contenir de lettres</a>
					</div> <%
								}
							}
						%> Mot de passe Actuel :
				</label><input type="password" value="old_mdp"
					placeholder=" password Actuel :"><br> <label>
					Saisissez nouveau password :</label><input type="password" value="new_mdp"
					><br> <label>
					Confirmation :</label><input type="password"
					><br> <label>
					Saisissez votre Rue:</label><input type="text" name="rue" value="${utilisateur.rue}"><br> <label>
					Saisissez votre Ville:</label><input type="text" name="ville" value="${utilisateur.ville }"><br> <label>
					Saisissez votre Code postal:</label><input type="text" name="codePostal" value="${utilisateur.codePostal}"><br>

				<p id="credit">
					<b>Vous avez ${Utilisateur.credit} crédits</b>
				</p>

				<div>
					<input type="submit" value="Enregistrer" >
					<br>
				</div>
			</form>
			<div>
				<form action="<%= request.getContextPath()%>/modifierProfil" method="post">
					<button type="submit"
							value="supprimer" name="choix">Supprimer mon compte</button><br>
					
					<button type="submit"
							value="annuler" name="choix">Annuler</button><br>
				</form>
			</div>



		</main>
		<footer></footer>
</body>
</html>