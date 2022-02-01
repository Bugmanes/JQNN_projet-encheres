package fr.eni.projet.dal;

<<<<<<< HEAD

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
>>>>>>> branch 'main' of https://github.com/Jeremie-VELU/JQNN_projet-encheres.git

import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.util.ConnexionProvider;

public class UtilisateurDaoImpl implements UtilisateurDAO {
<<<<<<< HEAD
	
	private final static String SELECT_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo = 1;";
	
	@Override
	public void newUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override //a faire  Par nael
	public Utilisateur selectByPseudo(Utilisateur utilisateur) {
		Connection cnx = ConnexionProvider.getConnection();
		PreparedStatement pstmt =cnx.prepareStatement(SELECT_BY_PSEUDO)
		ResultSet rs = pstmt.executeQuery();
=======
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
>>>>>>> branch 'main' of https://github.com/Jeremie-VELU/JQNN_projet-encheres.git
		return null;
	}

}
