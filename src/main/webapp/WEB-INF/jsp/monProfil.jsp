<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon profil</title>
<link rel="stylesheet" href="asset/css/style.css">
</head>
<body>
 
 
 
    <section class="modify-profile">
        <form action="">
            <h1>Modifier mon profil</h1>
            <a href="vendeurJojo44.html">jojo44</a>
            <div class="form-container">
                <div class="form-block">
                    <div class="form-item">
                        <div class="lastname">
                            <label for="lastname">Nom</label>
                            <input type="text" name="lastname" id="lastname">
                        </div>
                        <div class="firstname">
                            <label for="firstname">Prénom</label>
                            <input type="text" name="firstname" id="firstname">
                        </div>
                    </div>
                    <div class="form-item">
                        <div class="email">
                            <label for="email">Email</label>
                            <input type="email" name="email" id="email">
                        </div>
                        <div class="phone">
                            <label for="phone">Téléphone</label>
                            <input type="tel" name="phone" id="phone">
                        </div>
                    </div>
                    <div class="form-item">
                        <div class="address">
                            <label for="address">Rue :</label>
                            <input type="text" name="rue" id="rue">
                        </div>
                        <div class="form-block">
                            <div class="form-item">
                                <div class="postalcode">
                                    <label for="postalcode">Code Postal</label>
                                    <input type="text" name="code" id="postalcode">
                                </div>
                            </div>                    
                        </div>
                        <div class="town">
                            <label for="town">Ville</label>
                            <input type="text" name="ville" id="town">
                        </div>
                    </div>                   
                </div>              
              
                <input class="btn-save" type="button" value="Enregistrer mes modifications">
            </div>
        </form>
    </section>
 
</body>
</html>