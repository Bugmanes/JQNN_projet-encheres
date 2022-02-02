<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
<link rel="stylesheet" href="asset/css/style.css">
</head>
<body>
	<main>
		<div class="titreMonProfil">
			<h4>Mon Profil</h4>
		</div>
		<div class="formulaireInscription">
			<form action="<%=request.getContextPath() %>/InscriptionConnexion" method="post">
				<div>
					<label for="Pseudo">Pseudo :</label> <input type="text" id="Pseudo"
						name="Pseudo" />
				</div>
				<div>
					<label for="Prenom">prenom :</label> <input type="text" id="Prenom"
						name="Prenom" />
				</div>
				<div>
					<label for="Telephone">telephone :</label> <input type="phone"
						id="Telephone" name="Telephone" />
				</div>
				<div>
					<label for="Password">Mot de passe :</label> <input type="password"
						id="Password" name="Password" />
				</div>
				<div>
					<label for="Nom">Nom :</label> <input type="text" id="Nom"
						name="Nom" />
				</div>
				<div>
					<label for="Email">email :</label> <input type="email" id="Email"
						name="Email" />
				</div>
				<div>
					<label for="Rue">Rue :</label> <input type="text" id="Rue"
						name="Rue" />
				</div>
				<div>
					<label for="Ville">ville :</label> <input type="text" id="Ville"
						name="Ville" />
				</div>
				<div>
					<label for="Password2">Confirmation :</label> <input
						type="password" id="Password2" name="Password2" />
				</div>
				<div class="buttonCree">
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