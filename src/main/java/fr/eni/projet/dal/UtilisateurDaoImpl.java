package fr.eni.projet.dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.util.ConnexionProvider;

public class UtilisateurDaoImpl implements UtilisateurDAO {
	
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
		return null;
	}

}
