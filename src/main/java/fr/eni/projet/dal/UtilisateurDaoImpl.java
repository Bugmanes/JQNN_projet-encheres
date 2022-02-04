package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.util.ConnexionProvider;

public class UtilisateurDaoImpl implements UtilisateurDAO {

	// requete SQL Insert
	private final static String SQL_INSERT = "INSERT INTO  UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	private final static String SELECT_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo = ?;";
	private final static String SELECT_CONNEXION = "SELECT * FROM UTILISATEURS WHERE (pseudo =? OR email =?)";
	private final static String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE id = ?;";
	private final static String UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET nom = ?, prenom =?, email = ?, telephone = ?, rue = ?,code_postal =?,ville = ? WHERE pseudo =?;";

	@Override
	public void newUtilisateur(Utilisateur utilisateur) throws DALException {

		try {
			Connection cnx = ConnexionProvider.getConnection();
			ResultSet rs = null;
			// création du PrepareStatement la definition des point d'interogation dans la
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
			pstmt.setBoolean(11, utilisateur.isAdministrateur());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
			rs.close();
			pstmt.close();
			cnx.close();
		} catch (SQLException e) {
			throw new DALException("problème avec la méthode newUtilisateur", e);
		}

		// TODO Auto-generated method stub

	}

	@Override
	public Utilisateur selectByPseudo(String pseudo) throws DALException {
		// declaration
		Utilisateur utilisateur = null;
		Connection cnx;
		ResultSet rs;
		try {
			// connection
			cnx = ConnexionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
			pstmt.setString(1, pseudo);
			// récupere les valeurs de bdd
			rs = pstmt.executeQuery();

			if (rs.next()) {// creation d'un nouveau utilisateur
				utilisateur = new Utilisateur(pseudo, rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"));
			}

		} catch (SQLException e) {
			throw new DALException("problème de méthode selectByPseudo()", e);
		} finally {
			// cnx.close(); //TODO by @Nael
		}
		return utilisateur;
	}

	@Override
	public Utilisateur selectById(int id) throws DALException {
		// création de mes varibales
		Utilisateur utilisateur = null;
		Connection cnx;
		ResultSet rs;
		PreparedStatement pstmt = null;
		try {
			// récupération de la connexion
			cnx = ConnexionProvider.getConnection();
			PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			// création du nouveau utilisateur
			if (rs.next()) {
				utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"));
				utilisateur.setNoUtilisateur(id);
			}

		} catch (SQLException e) {
			throw new DALException("problème avec la méthode selectById", e);
		}

		return utilisateur;
	}

	public void updateUtilisateur(Utilisateur utilisateur) throws DALException {
		try {
			Connection cnx = ConnexionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UTILISATEUR);

			pstmt.setString(1, utilisateur.getNom());
			pstmt.setString(2, utilisateur.getPrenom());
			pstmt.setString(3, utilisateur.getEmail());
			pstmt.setString(4, utilisateur.getTelephone());
			pstmt.setString(5, utilisateur.getRue());
			pstmt.setString(6, utilisateur.getCodePostal());
			pstmt.setString(7, utilisateur.getVille());
			pstmt.setString(8, utilisateur.getPseudo());

			pstmt.executeUpdate();
			
			pstmt.close();
			cnx.close();

		} catch (SQLException e) {
			throw new DALException("problème avec la méthode updateUtilisateur", e);
		}
	}

	@Override
	public Utilisateur selectConnexion(String identifiant, String password) {
		
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Utilisateur user = null;
		
		
		
		return user;
	}
}
