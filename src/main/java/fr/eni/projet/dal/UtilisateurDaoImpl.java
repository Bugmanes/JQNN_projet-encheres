package fr.eni.projet.dal;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.projet.bo.Password;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.util.ConnexionProvider;

public class UtilisateurDaoImpl implements UtilisateurDAO {

	// requete SQL Insert
	private final static String SQL_INSERT = "INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	private final static String SELECT_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo = ?;";
	private final static String SELECT_CONNEXION = "SELECT * FROM UTILISATEURS WHERE (pseudo =? OR email =?)";
	private final static String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?;";
	private final static String UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo = ?, nom =?, prenom =?, email = ?, telephone = ?, rue = ?,code_postal =?,ville = ? WHERE no_utilisateur =?;";
	private final static String SELECT_BY_MAIL = "SELECT * FROM UTILISATEURS WHERE email=?;";
	private final static String ANONYMISER_UTILISATEUR = "UPDATE UTILISATEURS SET nom = ?, prenom =?, email = ?, telephone = ?, rue = ?,code_postal =?,ville = ?, pseudo =?, credit=? WHERE no_utilisateur=?;";

	@Override
	public void newUtilisateur(Utilisateur utilisateur) throws DALException {

		try {
			Connection cnx = ConnexionProvider.getConnection();
			ResultSet rs = null;
			// creation du PrepareStatement la definition des points d'interogation dans la
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
			
			// fermeture de connection...
			rs.close();
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			throw new DALException("probl�me avec la m�thode newUtilisateur", e);
		}
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

			// recupere les valeurs de bdd
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// creation d'un nouvel utilisateur
				utilisateur = new Utilisateur(pseudo, rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"));
			}
			
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			throw new DALException("probleme de methode selectByPseudo()", e);
		} 
		
		return utilisateur;
	}

	@Override
	public Utilisateur selectById(int id) throws DALException {
		// creation de mes varibales
		Utilisateur utilisateur = null;
		Connection cnx;
		ResultSet rs;
	
		try {
			// recuperation de la connexion
			cnx = ConnexionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			// creation du nouveau utilisateur
			if (rs.next()) {
				utilisateur = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"));
				utilisateur.setNoUtilisateur(id);
			}
			
			rs.close();
			pstmt.close();
			cnx.close();

		} catch (SQLException e) {
			throw new DALException("probleme avec la methode selectById", e);
		}

		return utilisateur;
	}

	public void updateUtilisateur(Utilisateur utilisateur) throws DALException {
		try {
			Connection cnx = ConnexionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UTILISATEUR);
			// insertion des parametres dans la base de donnees
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setInt(9, utilisateur.getNoUtilisateur());
			pstmt.executeUpdate();

			pstmt.close();
			cnx.close();

		} catch (SQLException e) {
			throw new DALException("probleme avec la methode updateUtilisateur", e);
		}
	}

	@Override
	public Utilisateur selectConnexion(String identifiant, String password) throws Exception {

		// declaration de mes variables
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Utilisateur user = null;
		boolean admin;

		try {
			cnx = ConnexionProvider.getConnection();
			stmt = cnx.prepareStatement(SELECT_CONNEXION);
			stmt.setString(1, identifiant);
			stmt.setString(2, identifiant);
			rs = stmt.executeQuery();

			if (rs.next()) {
				if (Password.check(password, rs.getString("mot_de_passe"))) {
					if (rs.getInt("administrateur") == 1) {
						admin = true;
					} else {
						admin = false;
					}
					user = new Utilisateur(rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"),
							rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
							rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
							rs.getInt("credit"), admin);
					user.setNoUtilisateur(rs.getInt("no_utilisateur"));
				}
			}
			
			rs.close();
			stmt.close();
			cnx.close();

		} catch (SQLException e) {
			throw new DALException("probleme avec la methode selectConnexion", e);
		}

		return user;
	}

	@Override
	public boolean selectUniquePseudo(String pseudo) throws DALException {

		Connection cnx;
		PreparedStatement stmt;
		ResultSet rs;
		boolean ok = true;

		try {
			cnx = ConnexionProvider.getConnection();
			stmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
			stmt.setString(1, pseudo);
			rs = stmt.executeQuery();

			if (rs.next()) {
				ok = false;
			}
			rs.close();
			stmt.close();
			cnx.close();

		} catch (SQLException e) {
			throw new DALException("probleme avec la methode selectUniquePseudo", e);
		}

		return ok;
	}

	@Override
	public boolean selectUniqueMail(String mail) throws DALException {

		Connection cnx;
		PreparedStatement stmt;
		ResultSet rs;
		boolean ok = true;

		try {
			cnx = ConnexionProvider.getConnection();
			stmt = cnx.prepareStatement(SELECT_BY_MAIL);
			stmt.setString(1, mail);
			rs = stmt.executeQuery();

			if (rs.next()) {
				ok = false;
			}
			rs.close();
			stmt.close();
			cnx.close();

		} catch (SQLException e) {
			throw new DALException("probleme avec la methode selectUniquePseudo", e);
		}

		return ok;
	}

	public void deleteUtilisateur(Utilisateur utilisateur) throws DALException {
		Connection cnx = null;
		PreparedStatement pstmt = null;
		String anonyme = "anonyme";
		try {
			cnx = ConnexionProvider.getConnection();
			pstmt = cnx.prepareStatement(ANONYMISER_UTILISATEUR);
			pstmt.setString(1, anonyme);
			pstmt.setString(2, anonyme);
			pstmt.setString(3, anonyme);
			pstmt.setString(4, anonyme);
			pstmt.setString(5, anonyme);
			pstmt.setString(6, anonyme);
			pstmt.setString(7, anonyme);
			pstmt.setString(8, anonyme);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, utilisateur.getNoUtilisateur());
			pstmt.executeUpdate();
			pstmt.close();
			cnx.close();
 
		} catch (SQLException e) {
			throw new DALException("probleme de methode deleteUtilisateur", e);
		}
	}

}
