package dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import bo.ArticleVendu;
import bo.Categorie;
import bo.Enchere;
import bo.Retrait;

import java.sql.Statement;

import java.util.List;

import bo.Utilisateur;
import dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
	private static final String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,codePostal,ville,motDePasse,credit,administrateur) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_VAL_UNIQUE = "SELECT * FROM UTILISATEURS WHERE pseudo = ? AND email = ?";
	private static final String SELECT_UTILISATEUR = "SELECT * FROM UTILISATEURS WHERE noUtilisateur=?";
	private static final String SELECT_CATEGORIE = "SELECT * FROM CATEGORIES ";
	private static final String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS (nomArticle,description,dateDebutEncheres,dateFinEncheres,prixInitial,etatVente,noUtilisateur,noCategorie) values(?,?,?,?,?,?,?,?)";
	private static final String INSERT_RETRAIT = "INSERT INTO RETRAITS (noArticle,rue,codePostal,ville) values(?,?,?,?)";
	private static final String INSERT_ENCHERE = "INSERT INTO ENCHERES (noUtilisateur,noArticle,dateEnchere,montantEnchere) values(?,?,?,?)";
	private static final String SELECT_ARTICLE = "SELECT TOP 1 * FROM ARTICLES_VENDUS ORDER BY noArticle DESC";
	private static final String SELECT_CONNEXION = "SELECT * FROM UTILISATEURS WHERE (email=? OR pseudo=?) AND motDePasse=?";
	private static final String DELETE_PROFIL = "DELETE FROM UTILISATEURS WHERE noUtilisateur = ?";
	private static final String SELECT_ARTICLES = "SELECT * from ARTICLES_VENDUS INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.noUtilisateur = UTILISATEURS.noUtilisateur ";
	private static final String SELECT_DETAIL_ENCHERE = "SELECT * from  ENCHERES WHERE noArticle = ?";
	private static final String SELECT_ARTICLE_NO = "SELECT * from  ARTICLES_VENDUS INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.noUtilisateur = UTILISATEURS.noUtilisateur WHERE noArticle = ?";
	private static final String SELECT_CATEGORIE_NO = "SELECT * from CATEGORIES WHERE noCategorie = ?";
	private static final String SELECT_RETRAIT_NO = "SELECT * from RETRAITS WHERE noArticle = ?";
	private static final String UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, email=?, telephone=? ,rue=?, codePostal=?, ville=?, motDePasse=?, credit=?, administrateur=? WHERE noUtilisateur=?";
    private static final String UPDATE_ENCHERE = "UPDATE ENCHERES SET montantEnchere=?, noUtilisateur=? WHERE montantEnchere < ? AND noArticle=?";
    private static final String UPDATE_UTILISATEUR_CREDIT = "UPDATE UTILISATEURS SET credit=credit-? WHERE  noUtilisateur=? AND credit-?>=0";
    private static final String SELECT_ENCHERE_REMPORTE = "SELECT * FROM ENCHERES INNER JOIN ARTICLES_VENDUS ON ARTICLES_VENDUS.noArticle = ENCHERES.noArticle  INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.noUtilisateur = UTILISATEURS.noUtilisateur WHERE ENCHERES.noUtilisateur = ? AND DATEDIFF(day,ARTICLES_VENDUS.dateFinEncheres,GETDATE()) >= 0";
    private static final String UPDATE_ARTICLE = "UPDATE ARTICLES_VENDUS SET nomArticle=?, description=?, dateFinEncheres=?, prixInitial=?, prixVente=? ,noCategorie=? WHERE noArticle=?;";
	
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
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return numUser;
	}

	public void insertArticle(ArticleVendu article) {
		Connection cnx = null;
		Timestamp datestart = Timestamp.valueOf(article.getDateDebutEncheres().atStartOfDay());
		Timestamp datefin = Timestamp.valueOf(article.getDateFinEncheres().atStartOfDay());
		try {
			cnx = JdbcTools.getConnection();
			cnx.setAutoCommit(false);
			PreparedStatement rqt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			rqt.setString(1,article.getNomArticle());
			rqt.setString(2,article.getDescription());
			rqt.setTimestamp(3,datestart);
			rqt.setTimestamp(4,datefin);
			rqt.setInt(5,article.getPrixInitiale());
			rqt.setBoolean(6,article.isEtatVente());
			rqt.setInt(7,article.getNoUtilisateur());
			rqt.setInt(8,article.getNoCategorie());
			rqt.executeUpdate();
			cnx.commit();
			
			cnx.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
    public void insertRetrait(Retrait retrait) {
        Connection cnx = null;
        PreparedStatement rqt = null;
        try {
            cnx = JdbcTools.getConnection();
            cnx.setAutoCommit(false);
            rqt = cnx.prepareStatement(SELECT_ARTICLE);
            ResultSet rs = rqt.executeQuery();
            if (rs.next()) {
                rqt = cnx.prepareStatement(INSERT_RETRAIT, PreparedStatement.RETURN_GENERATED_KEYS);
                rqt.setInt(1, rs.getInt("noArticle"));
                rqt.setString(2, retrait.getRue());
                rqt.setString(3, retrait.getCodePostal());
                rqt.setString(4, retrait.getVille());
                rqt.executeUpdate();
                cnx.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	

	
	@Override
	public void insertEnchere(Enchere enchere) {
		Connection cnx = null;
        PreparedStatement rqt = null;
        try {
            cnx = JdbcTools.getConnection();
            rqt = cnx.prepareStatement(SELECT_ARTICLE);
            ResultSet rs = rqt.executeQuery();
            if (rs.next()) {
            	Date date = java.sql.Date.valueOf(enchere.getDateEnchere());
                rqt = cnx.prepareStatement(INSERT_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
                rqt.setInt(1, rs.getInt("noUtilisateur"));
                rqt.setInt(2,rs.getInt("noArticle"));
                rqt.setDate(3, date);
                rqt.setInt(4, enchere.getMontantEnchere());
                rqt.executeUpdate();
            }
        } catch (Exception e) {
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
			if (rs.next()) {


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
				

			}
			cnx.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}
	@Override
	public ArrayList<Categorie> selectCategorie() {
		Connection cnx = null;
		Categorie categ = null;
		ArrayList<Categorie> categArray = new ArrayList<Categorie>();
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(SELECT_CATEGORIE);
			//rqt.setInt(1, );
			ResultSet rs = rqt.executeQuery();
			int d=0;
			if (rs.next()) {
				do{
					d++;
					categ = new Categorie(rs.getInt("noCategorie"), rs.getString("libelle"));
					categArray.add(categ);	
				}while(rs.next());
				
		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return categArray;
	}

	
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
			cnx.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return u1;
	}

	@Override
	public void deleteUtilisateur(int noUtilisateur) {
		// TODO Auto-generated method stub
		Connection cnx = null;
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(DELETE_PROFIL);
			rqt.setInt(1, noUtilisateur);
			rqt.executeUpdate();
			cnx.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<ArticleVendu> selectArticles() {
		// TODO Auto-generated method stub
		List<ArticleVendu> listeArticle = new ArrayList<>();
		Connection cnx = null;
		ArticleVendu article = null;
		try {
			cnx = JdbcTools.getConnection();
			Statement rqt = cnx.createStatement();
			ResultSet rs = rqt.executeQuery(SELECT_ARTICLES);

			if (rs.next()) {
				do {
					article = new ArticleVendu(
							rs.getInt("noArticle"),
							rs.getString("nomArticle"),
							rs.getString("description"),
							rs.getDate("dateDebutEncheres").toLocalDate(),
							rs.getDate("dateFinEncheres").toLocalDate(),
							rs.getInt("prixInitial"),
							rs.getInt("prixVente"),
							rs.getBoolean("etatVente"), 
							rs.getString("pseudo"));

					listeArticle.add(article);
				}while(rs.next());
			}
			
			cnx.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listeArticle;
	}

	@Override
	public Enchere selectDetailEnchere(int noArticle) {
		Connection cnx = null;
		Enchere e1 = null;
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(SELECT_DETAIL_ENCHERE);
			rqt.setInt(1, noArticle);
			ResultSet rs = rqt.executeQuery();
			if(rs.next()) {
				e1 = new Enchere(rs.getDate("dateEnchere").toLocalDate(), rs.getInt("montantEnchere"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return e1;
	}
	
	@Override
	public ArticleVendu selectArticleNo(int noArticle) {
		Connection cnx = null;
		ArticleVendu a1 = null;
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(SELECT_ARTICLE_NO);
			rqt.setInt(1, noArticle);
			ResultSet rs = rqt.executeQuery();
			if(rs.next()) {
				
				a1 = new ArticleVendu(
						rs.getInt("noArticle"),
						rs.getString("nomArticle"),
						rs.getString("description"),
						rs.getDate("dateDebutEncheres").toLocalDate(),
						rs.getDate("dateFinEncheres").toLocalDate(),
						rs.getInt("prixInitial"),
						rs.getInt("prixVente"),
						rs.getBoolean("etatVente"), 
						rs.getInt("noUtilisateur"), 
						rs.getInt("noCategorie"),
						rs.getString("pseudo"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return a1;
	}

	@Override
	public Categorie selectCategorieNo(int noCategorie) {
		Connection cnx = null;
		Categorie c1 = null;
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(SELECT_CATEGORIE_NO);
			rqt.setInt(1, noCategorie);
			ResultSet rs = rqt.executeQuery();
			if(rs.next()) {
				
				c1 = new Categorie(noCategorie, rs.getString("libelle"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c1;
	}
	
	
	
	@Override
	public Retrait selectRetraitNo(int noArticle) {
		Connection cnx = null;
		Retrait r1 = null;
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(SELECT_RETRAIT_NO);
			rqt.setInt(1, noArticle);
			ResultSet rs = rqt.executeQuery();
			if(rs.next()) {				
				r1 = new Retrait(rs.getString("rue"), rs.getString("codePostal"), rs.getString("ville"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return r1;
	}

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

	@Override
	public int updateEnchere(int noArticle,int noUtilisateur, int montantEnchere) {
		Connection cnx = null;
		int res = -1;
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement requete = cnx.prepareStatement(UPDATE_ENCHERE);
			
			requete.setInt(1, montantEnchere);
			requete.setInt(2, noUtilisateur);
			requete.setInt(3, montantEnchere);
			requete.setInt(4, noArticle);
			res = requete.executeUpdate();
			cnx.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public void updateUtilisateurCredit(int noUtilisateur, int montant) {
		Connection cnx = null;
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement requete = cnx.prepareStatement(UPDATE_UTILISATEUR_CREDIT);
			requete.setInt(1, montant);
			requete.setInt(2, noUtilisateur);
			requete.setInt(3, montant);
			requete.executeUpdate();
			cnx.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<ArticleVendu> selectEnchereRemporte(int noUtilisateur) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				ArrayList<ArticleVendu> listeEnchereRemporte = new ArrayList<>();
				Connection cnx = null;
				ArticleVendu article = null;
				try {
					cnx = JdbcTools.getConnection();
					PreparedStatement rqt = cnx.prepareStatement(SELECT_ENCHERE_REMPORTE);
					rqt.setInt(1, noUtilisateur);
					ResultSet rs = rqt.executeQuery();
					if (rs.next()) {
						do {
							article = new ArticleVendu(
									rs.getInt("noArticle"),
									rs.getString("nomArticle"),
									rs.getString("description"),
									rs.getDate("dateDebutEncheres").toLocalDate(),
									rs.getDate("dateFinEncheres").toLocalDate(),
									rs.getInt("prixInitial"),
									rs.getInt("prixVente"),
									rs.getBoolean("etatVente"), 
									rs.getString("pseudo"));
							listeEnchereRemporte.add(article);
						}while(rs.next());
					}
					
					cnx.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
				return listeEnchereRemporte;
	}
	
	
	

	

}
