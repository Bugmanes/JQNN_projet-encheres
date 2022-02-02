<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
<link rel="stylesheet" href="asset/css/style.css">
</head>
<jsp:include  page ="/headerInvité"></jsp:include>
<body>
	<main>
		<div class="titreMonProfil">
			<h4>Mon Profil</h4>
		</div>
		<div class="formulaireInscription">
			<form action="<%=request.getContextPath() %>/InscriptionConnexion" method="post">
				<div>
					<label for="pseudo">Pseudo :</label> <input type="text" id="pseudo"
						name="pseudo" />
				</div>
				<div>
					<label for="prenom">prenom :</label> <input type="text" id="prenom"
						name="prenom" />
				</div>
				<div>
					<label for="telephone">telephone :</label> <input type="phone"
						id="telephone" name="telephone" />
				</div>
				<div>
					<label for="password">Mot de passe :</label> <input type="password"
						id="password" name="password" />
				</div>
				<div>
					<label for="nom">Nom :</label> <input type="text" id="nom"
						name="nom" />
				</div>
				<div>
					<label for="email">email :</label> <input type="email" id="email"
						name="email" />
				</div>
				<div>
					<label for="rue">Rue :</label> <input type="text" id="rue"
						name="rue" />
				</div>
				<div>
					<label for="ville">ville :</label> <input type="text" id="ville"
						name="ville" />
				</div>
				<div>
					<label for="password2">Confirmation :</label> <input
						type="password" id="password2" name="password2" />
				</div>
				<div class="buttonCree">
					<a href="/seConnecter"></a>
					<button type="submit">
						<p>Créer</p>
					</button>
				</div>
				<div class="buttonAnnuler">
					<a href="/acceuil.html">
						<button>
							<p>Anuller</p>
						</button>
					</a>
				</div>
			</form>
		</div>
	</main>
</body>
</html>