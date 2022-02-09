<!-- -----------------------------------Nael---------------------------------- -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Se connecter</title>
<style type="text/css">
@import url("https://fonts.googleapis.com/css?family=Roboto:400,400i,700");

html, body {
										background: rgb(42, 33, 204);
										background: linear-gradient(90deg, rgba(42, 33, 204, 1) 0%, rgba(141, 0, 196, 1) 35%,
																				rgba(0, 212, 255, 1) 100%);
										font-family: Roboto, sans-serif;
}

.main {
										width: 100%;
										margin: 0px auto;
										display: table;
										height: 100vh;
}

.wrapper {
										display: table-cell;
										height: 100%;
										vertical-align: middle;
										padding-top: 40px;
}

.content {
										overflow: hidden;
										max-width: 355px;
										width: 100%;
										background: rgba(255, 255, 255, 0.15);
										box-shadow: 0 8px 32px 0 rgb(0 0 135/ 37%);
										/* 
  
In Firefox Backdrop-filter is disabled by default. In order to see the blur effect, you should enable going to your browser settings

  https://caniuse.com/css-backdrop-filter 
  
  */
										backdrop-filter: blur(18px);
										-webkit-backdrop-filter: blur(18px);
										border: 1px solid rgba(255, 255, 255, 0.08);
										border-radius: 15px;
										padding: 20px;
										color: whitesmoke;
										animation: zoom 0.5s ease-in;
										text-align: center;
										margin: 0px auto;
										animation: 1s fadeInDown;
}

span.psw {
										float: right;
										margin-top: 20px;
										cursor: pointer;
}

span.create {
										float: left;
										margin-top: 20px;
										cursor: pointer;
}

input[type="text"], input[type="password"] {
										width: 80%;
										padding: 12px 20px;
										margin: 8px 0;
										display: block;
										box-sizing: border-box;
										border-radius: 15px;
										margin: 10px auto;
										background: rgba(255, 255, 255, 0.15);
										color: white;
										border: none;
}

::placeholder {
										/* Chrome, Firefox, Opera, Safari 10.1+ */
										color: rgb(255, 255, 255, 0.5);
										opacity: 1; /* Firefox */
}

:-ms-input-placeholder {
										/* Internet Explorer 10-11 */
										color: rgb(255, 255, 255, 0.5);
}

::-ms-input-placeholder {
										/* Microsoft Edge */
										color: rgb(255, 255, 255, 0.5);
}

.buttons {
										padding-left: 8px;
										padding-top: 3px;
										float: left;
										line-height: 0px;
}

.close {
										background: #ff5c5c;
										font-size: 9pt;
										width: 11px;
										height: 11px;
										border: 1px solid #e33e41;
										border-radius: 50%;
										display: inline-block;
}

.close:active {
										border: 1px solid rgb(0, 0, 0, 0.5);
}

.minimize {
										background: #ffbd4c;
										font-size: 9pt;
										line-height: 11px;
										margin-left: 4px;
										width: 11px;
										height: 11px;
										border: 1px solid #e09e3e;
										border-radius: 50%;
										display: inline-block;
}

.minimize:active {
										border: 1px solid rgb(0, 0, 0, 0.5);
}

.zoom {
										background: #00ca56;
										font-size: 9pt;
										line-height: 11px;
										margin-left: 6px;
										width: 11px;
										height: 11px;
										border: 1px solid #14ae46;
										border-radius: 50%;
										display: inline-block;
}

.zoom:active {
										border: 1px solid rgb(0, 0, 0, 0.5);
}

button {
										-webkit-border-radius: 5px;
										-moz-border-radius: 5px;
										border-radius: 5px;
										text-shadow: 1px 1px 0px #211d21;
										color: #ffffff;
										font-size: 13px;
										background: rgba(255, 255, 255, 0.15);
										padding: 8px 30px;
										text-decoration: none;
										border: none;
										transition: 0.5s ease-in;
										margin: 20px;
										cursor: pointer;
										font-weight: bold;
}

button:hover {
										background: rgba(250, 250, 250, 0.3);
}

/* Change styles for span on extra small screens */
@media screen and (max-width: 300px) {
										span.psw {
																				float: none;
										}
}

@
keyframes fadeInDown { 0% {
										opacity: 0;
										-webkit-transform: translate3d(0, -100%, 0);
										transform: translate3d(0, -100%, 0);
}
100
%
{
opacity
:
1;
-webkit-transform
:
none;
transform
:
none;
}
}
</style>
</head>
<body>
	<header><%@include file="headerInvite.jsp"%></header>



	<div class="main">
		<div class="connexion">
			<div class="main">
				<div class="wrapper">
					<div class="content">
						<div class="buttons">
							<div class="close"></div>
							<div class="minimize"></div>
							<div class="zoom"></div>
						</div>
						<form action="<%=request.getContextPath() + "/Connexion"%>"
							method="post">
							<h2>Login Form</h2>   

							<label for="uname"><b>votre identifiant</b></label> <input
								type="text" placeholder="Enter Username" name="identifiant"
								required> <label for="psw"><b>Mot de passe </b></label>
							<input type="password" placeholder="Enter Password"
								name="password" required>

							<div class="checkbox">
								<input type="checkbox" id="souvenir" name="souvenir"
									value="souvenir" /> <label for="souvenir">Se souvennir
									de moi</label>
							</div>

							<button type="submit">connexion</button>
							<br>
						</form>
						<span><a href="#">Mot de passe oublié</a></span>
						<div class="buttonCreeCompte text-centre">
				<a
					href="http://localhost:8080/JQNN_projet-encheres/InscriptionConnexion">
					<button>Crée un compte</button>
				</a>
			</div>

					</div>
				</div>
			</div>

			<%
			if (request.getAttribute("connexion") != null) {
				boolean ok = (boolean) request.getAttribute("connexion");
				if (!ok) {
			%>
			<div class="messageErreur">
				<a>identifiant ou mot de passe incorrect</a>
			</div>
			<% 
			}   
			}
			%>
			
		</div>

		<footer></footer>
	</div>
</body>
</html>






<!-- ----------------------------------Orginal--------------------------- -->

<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Se connecter</title>

</head>
<body>
	<div class="container">
	<%@include file="headerInvite.jsp"%>
	<main>
		<div class="connexion">
			<div class="formuulaireConnexion">

				<form action="<%=request.getContextPath()+  "/Connexion"%>"
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
</html> --%>
<!-- ----------------------------------Orginal--------------------------- -->