package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.util.ConnexionProvider;

public class UtilisateurDaoImpl implements UtilisateurDAO {
//requete SQL Insert
private final static String SQL_INSERT = ("INSERT INTO  UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);");
	
	//implementation de la methode abstraite newUtilisateur
	@Override
	public void newUtilisateur(Utilisateur utilisateur) {
try {
	Connection cnx = ConnexionProvider.getConnection();
	PreparedStatement pstmt = cnx.prepareStatement(SQL_INSERT);
	stmt.setString(1, utilisateur)
	
	
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

		
	}

//implementation de la methode abstraite selectByPseudo
	@Override
	public Utilisateur selectByPseudo(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

}
