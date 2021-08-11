package dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bo.Utilisateur;
import dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private static final String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,codePostal,ville,motDePasse,credit,administrateur) values(?,?,?,?,?,?,?,?,?,?,?)";
	@Override
	public void insertUtilisateur(Utilisateur utilisateur) {
		Connection cnx = null;
		try {
			cnx = JdbcTools.getConnection();
			cnx.setAutoCommit(false);
			PreparedStatement rqt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
			rqt.setString(1,utilisateur.getPseudo());
			rqt.setString(2,utilisateur.getNom());
			rqt.setString(3,utilisateur.getPrenom());
			rqt.setString(4,utilisateur.getEmail());
			rqt.setString(5,utilisateur.getTelephone());
			rqt.setString(6,utilisateur.getRue());
			rqt.setString(7,utilisateur.getCodePostal());
			rqt.setString(8,utilisateur.getVille());
			rqt.setString(9,utilisateur.getMotDePasse());
			rqt.setInt(10,utilisateur.getCredit());
			rqt.setBoolean(11, utilisateur.isAdministrateur());
			rqt.executeUpdate();
			cnx.commit();
			cnx.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


}
