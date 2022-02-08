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

				<form action="<%=request.getContextPath() + "/Connexion"%>" method="post">
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


<%-- 


											for nael

<!DOCTYPE html>
<html lang="en">

	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="seconnecterStyle.css">
	<title>Document</title>
</head>
<body>

	<form action="<%=request.getContextPath() + "/Connexion"%>" method="post">
	<div class="main">
		<div class="wrapper">
		  <div class="content">
			<div class="buttons">
			  <div class="close">
			  </div>
			  <div class="minimize">
			  </div>
			  <div class="zoom">
			  </div>
			</div>
	  
			<h2>Login Form</h2>
	  
			<label for="uname"><b>votre identifiant</b></label>
			<input type="text" placeholder="Enter Username" name="uname" required>
	  
			<label for="psw"><b>Password</b></label>
			<input type="password" placeholder="Enter Password" name="psw" required>
	  
			<button type="submit">Login</button>
			<br>
	  
			<span class="psw">Forgot password</span>
	  
		  </div>
		</div>
	  </div>
	
</body>
</html> --%>