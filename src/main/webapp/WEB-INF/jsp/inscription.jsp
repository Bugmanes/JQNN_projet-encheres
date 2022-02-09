
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
<link rel="stylesheet" href="asset/css/style.css">
</head>
<%@include file="headerInvite.jsp"%>
<body>
	<main>
		<div class="titreMonProfil">
			<h4>Mon Profil</h4>
		</div>
		<div class="formulaireInscription">
			<form action="<%=request.getContextPath()%>/connexion"
				method="post">
	          <div  class="partieGauche">
					<div class="pseudo">
						<label for="pseudo">Pseudo :</label>
						<input type="text" id="pseudo" name="pseudo" />
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
					</div>
					<div class="prenom">
						<label for="prenom">prenom :</label> <input type="text"
							id="prenom" name="prenom" />
						<%
							if (request.getAttribute("prenomOK")!=null){
								boolean prenomOK = (boolean) request.getAttribute("prenomOK");
								if (!prenomOK){
						%>
						<div class="messageErreur">
							<a>Le prénom ne peut pas comporter de chiffres et caracteres speciaux</a>
						</div>
						<%
								}
							}
						%>
					</div>
					<div  class="telephone">
						<label for="telephone">telephone :</label> <input type="phone"
							id="telephone" name="telephone" />
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
					</div>

					<div class="codePostal">
						<label for="codePostal">Code Postal :</label> <input type="numeric"
							id="codePostal" name="codePostal" />
					</div>

					<div class="motDePasse">
						<label for="motDePasse">Mot de passe :</label> <input
							type="password" id="motDePasse" name="motDePasse" />
					</div>
				</div>
				<div class="partieDroite">
					<div class="nom">
						<label for="nom">Nom :</label> <input type="text" id="nom"
							name="nom" />
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
					</div>
					<div class="email">
						<label for="email">email :</label> <input type="email" id="email"
							name="email" />
						<%
							if (request.getAttribute("emailUniqueOK")!=null){
								boolean emailUniqueOK = (boolean) request.getAttribute("emailUniqueOK");
								if (!emailUniqueOK){
						%>
						<div class="messageErreur">
							<a>Cet email est deja utilisé par un compte utilisateur</a>
						</div>
						<%
								}
							}
						%>
					</div>
					<div class="rue">
						<label for="rue">Rue :</label> <input type="text" id="rue"
							name="rue" />
					</div>
					<div class="ville">
						<label for="ville">ville :</label> <input type="text" id="ville"
							name="ville" />
					</div>
					<div class="password2">
						<label for="password2">Confirmation :</label> <input
							type="password" id="password2" name="password2" />
					</div>
				</div>
				<div class="buttonCree">
						<input type="submit" value="Créer">
				</div>

				<div class="buttonAnnuler">
					<a href="<%=request.getContextPath()%>/accueil.html">
						<button type="button">Annuler</button>
					</a>
				</div>
			</form>
		</div>
	</main>
</body>
</html>