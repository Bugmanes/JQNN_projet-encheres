package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.util.ConnexionProvider;

public class UtilisateurDaoImpl implements UtilisateurDAO {

	// requete SQL Insert
	private final static String SQL_INSERT = ("INSERT INTO  UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?);");
	private final static String SELECT_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo = 1;";

	@Override //a faire  Par nael
	public Utilisateur selectByPseudo(Utilisateur utilisateur) {
		Connection cnx = ConnexionProvider.getConnection();
		PreparedStatement pstmt =cnx.prepareStatement(SELECT_BY_PSEUDO)
		ResultSet rs = pstmt.executeQuery();
	}

	@Override
	public void newUtilisateur(Utilisateur utilisateur) {

		try {
			Connection cnx = ConnexionProvider.getConnection();
			java.sql.ResultSet rs = null;
			// créeation du PrepareStatement la definition des point d'interogation dans la
			// requete SQL
			PreparedStatement pstmt = cnx.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getCredit());
			pstmt.setBoolean(11, false);
			pstmt.executeUpdate();
			// création du ResultSet qui génere une clée
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int noUtilisateur = rs.getInt(1);
				rs.close();
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

}
