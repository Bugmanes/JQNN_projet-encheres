<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Se connecter</title>
<link rel="stylesheet" href="asset/css/style.css">
</head>
<body>
	<main>
		<div class="connexion">
			<div class="formuulaireConnexion">
				<form action="/" method="post">
					<div>
						<label for="identifiant">votre identifiant :</label> <input
							type="text" id="identifiant" name="identifiant" />
					</div>
					<div>
						<label for="password">Mot de passe :</label> <input
							type="password" id="password" name="password" />
					</div>

					<div class="checkbox">
						<input type="checkbox" id="souvenir" name="souvenir"
							value="souvenir" /> <label for="souvenir">Se
							souvennir de moi</label>
					</div>
					<div class="buttonSeconnecter">
						<button type="submit">connxion</button>
					</div>
				</form>
				<div class="oublier">
					<a href="#">Mot de ppasse oublier</a>
				</div>
			</div>
			<div class="buttonCreeCompte">
				<a href="#">
					<button>Cée un compte</button>
				</a>
			</div>
		</div>
	</main>
</body>
</html>