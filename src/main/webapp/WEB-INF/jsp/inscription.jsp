
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
			<form action="<%=request.getContextPath()%>/InscriptionConnexion"
				method="POST">
	          <div  class="partieGauche">
					<div class="pseudo">
						<label for="pseudo">Pseudo :</label> <input type="text"
							id="pseudo" name="pseudo" />
					</div>
					<div class="prenom">
						<label for="prenom">prenom :</label> <input type="text"
							id="prenom" name="prenom" />
					</div>
					<div  class="telephone">
						<label for="telephone">telephone :</label> <input type="phone"
							id="telephone" name="telephone" />
					</div>

					<div class="codePostal">
						<label for="codePostal">Code Postal :</label> <input type="numeric"
							id="codePostal" name="codePostal" />
					</div>

					<div class="password">
						<label for="password">Mot de passe :</label> <input
							type="password" id="password" name="password" />
					</div>
				</div>
				<div class="partieDroite">
					<div class="nom">
						<label for="nom">Nom :</label> <input type="text" id="nom"
							name="nom" />
					</div>
					<div class="email">
						<label for="email">email :</label> <input type="email" id="email"
							name="email" />
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
					<a href="/seConnecter">
						<button type="submit">Créer</button>
					</a>
				</div>

				<div class="buttonAnnuler">
					<a href="/accueil">
						<button type="reset">
							<p>Anuller</p>
						</button>
					</a>
				</div>
			</form>
		</div>
	</main>
</body>
</html>