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
	<div class="container">
	<%@include file="headerInvite.jsp"%>
	<main>
		<div class="connexion">
			<div class="formuulaireConnexion">

				<form action="<%=request.getContextPath() + "/Connexion"%>"
					method="post">
					<div>
						<label for="identifiant">votre identifiant : </label>
						<input type="text" id="identifiant" name="identifiant" />
					</div>
					<div>
						<label for="password">Mot de passe : </label>
						<input type="password" id="password" name="password" />
					</div>

					<div class="checkbox">
						<input type="checkbox" id="souvenir" name="souvenir"
							value="souvenir" />
						<label for="souvenir">Se souvennir de moi</label>
					</div>
					<div class="buttonSeconnecter">
						<button type="submit">connexion</button>
					</div>
				</form>
				<div class="oublier">
					<a href="#">Mot de passe oublié</a>
				</div>
			</div>
			<%
			if(request.getAttribute("connexion")!=null){
				boolean ok =(boolean) request.getAttribute("connexion");
				if (!ok){		
			%>
			<div class = "messageErreur">
				<a>identifiant ou mot de passe incorrect</a>
			</div>
			<%
				}
			}	
			%>
			<div class="buttonCreeCompte">
				<a
					href="http://localhost:8080/JQNN_projet-encheres/InscriptionConnexion">
					<button>Crée un compte</button>
				</a>
			</div>
		</div>
	</main>
	<footer></footer>
	</div>
</body>
</html>