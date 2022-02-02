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
	private final static String SQL_INSERT = "INSERT INTO  UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	private final static String SELECT_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo = ?;";
	private final static String SELECT_BY_PSEUDO_CONNEXION = "SELECT * FROM UTILISATEUR WHERE pseudo =? AND password =?";

	@Override
	public void newUtilisateur(Utilisateur utilisateur) {

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

	@Override
	public Utilisateur selectByPseudo(String pseudo) {
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
			// TODO by @Nael
			// throw new DALException("problème de méthode selectByPseudo()",e);
		} finally {
			// cnx.close(); //TODO by @Nael
		}
		return utilisateur;
	}

	public Utilisateur selectByPseudoConnexion(Utilisateur utilisateur) throws BLLException, DALException {
		try {
			Connection cnx = ConnexionProvider.getConnection();
			PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_PSEUDO_CONNEXION);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getEmail());
			stmt.setString(3, utilisateur.getMotDePasse());
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				utilisateur.setNom(result.getString("nom"));
				utilisateur.setMotDePasse(null);
			} else {
				// levee d'une BLLException
				throw new BLLException("identification incorect");

			}
		} catch (SQLException e) {
			// lever une exception de type DALException
			throw new DALException("probleme technique", e);
			e.printStackTrace();
		}
		return utilisateur;
	}

}
