package dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bo.Utilisateur;
import dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private static final String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,codePostal,ville,motDePasse,credit,administrateur) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_VAL_UNIQUE = "SELECT * FROM UTILISATEURS WHERE pseudo = ? AND email = ?";
	private static final String SELECT_UTILISATEUR = "SELECT * FROM UTILISATEURS WHERE noUtilisateur=?";
<<<<<<< Updated upstream
	private static final String SELECT_CONNEXION = "SELECT * FROM UTILISATEURS WHERE (email=? OR pseudo=?) AND motDePasse=?";
=======
	private static final String UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, email=?, telephone=? ,rue=?, codePostal=?, ville=?, motDePasse=?, credit=?, administrateur=? WHERE noUtilisateur=?";
	
>>>>>>> Stashed changes
	
	@Override
	public int insertUtilisateur(Utilisateur utilisateur) {
		Connection cnx = null;
		PreparedStatement rqt = null;
		int numUser = -1;
		try {
			cnx = JdbcTools.getConnection();
			cnx.setAutoCommit(false);
			
			PreparedStatement requete = cnx.prepareStatement(SELECT_VAL_UNIQUE);
			requete.setString(1, utilisateur.getPseudo());
			requete.setString(2, utilisateur.getEmail());
			ResultSet rs = requete.executeQuery();
			
			if (!rs.next()) {
				//System.out.println(utilisateur.getPseudo().equals(rs.getString("pseudo")) || utilisateur.getEmail().equals(rs.getString("email")));
			
				rqt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
				numUser = rqt.RETURN_GENERATED_KEYS;
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
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return numUser;
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
<<<<<<< Updated upstream
				user = new Utilisateur(noUtilisateur, rs.getString("pseudo"),rs.getString("nom"),rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),rs.getString("rue"), rs.getString("codePostal"), rs.getString("ville"), rs.getString("motDePasse"), rs.getInt("credit"), rs.getBoolean("administrateur"));
=======
				user = new Utilisateur(noUtilisateur,
						rs.getString("pseudo"),
						rs.getString("nom"),
						rs.getString("prenom"), 
						rs.getString("email"), 
						rs.getString("telephone"),
						rs.getString("rue"), 
						rs.getString("codePostal"), 
						rs.getString("ville"), 
						rs.getString("motDePasse"), 
						rs.getInt("credit"), 
						rs.getBoolean("administrateur"));
				
>>>>>>> Stashed changes
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}
<<<<<<< Updated upstream
	
	@Override
	public Utilisateur selectConnexion(String identifiant, String mdp) {
		// TODO Auto-generated method stub
		Connection cnx = null;
		Utilisateur u1 = null;
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(SELECT_CONNEXION);
			rqt.setString(1, identifiant);
			rqt.setString(2, identifiant);
			rqt.setString(3, mdp);
			ResultSet rs = rqt.executeQuery();
			if(rs.next()) {
				u1 = this.selectUtilisateur(rs.getInt("noUtilisateur"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return u1;
	}
	
	
=======
	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		Connection cnx = null;
		
		try {
			cnx = JdbcTools.getConnection();
			cnx.setAutoCommit(false);
			
			PreparedStatement requete = cnx.prepareStatement(UPDATE_UTILISATEUR);
			
			
			requete.setString(1, utilisateur.getPseudo());
			requete.setString(2, utilisateur.getNom());
			requete.setString(3, utilisateur.getPrenom());
			requete.setString(4, utilisateur.getEmail());
			requete.setString(5, utilisateur.getTelephone());
			requete.setString(6, utilisateur.getRue());
			requete.setString(7, utilisateur.getCodePostal());
			requete.setString(8, utilisateur.getVille());
			requete.setString(9, utilisateur.getMotDePasse());
			requete.setInt(10, utilisateur.getCredit());
			requete.setBoolean(11, utilisateur.isAdministrateur());
			requete.setInt(12, utilisateur.getNoUtilisateur());
			requete.executeUpdate();
			cnx.commit();
			cnx.close();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
>>>>>>> Stashed changes


}
