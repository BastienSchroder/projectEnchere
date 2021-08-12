package dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bo.Utilisateur;
import dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private static final String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,codePostal,ville,motDePasse,credit,administrateur) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_UTILISATEUR = "SELECT * FROM UTILISATEURS WHERE noUtilisateur=?";
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
	@Override
	public Utilisateur selectUtilisateur(int noUtilisateur) {
		Connection cnx = null;
		Utilisateur user = null;
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(SELECT_UTILISATEUR);
			rqt.setInt(1, noUtilisateur);
			ResultSet rs = rqt.executeQuery();
			//System.out.println(rs.wasNull());
			if (rs.next()) {
				user = new Utilisateur(noUtilisateur, rs.getString("pseudo"),rs.getString("nom"),rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),rs.getString("rue"), rs.getString("codePostal"), rs.getString("ville"), rs.getString("motDePasse"), rs.getInt("credit"), rs.getBoolean("administrateur"));
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}


}
