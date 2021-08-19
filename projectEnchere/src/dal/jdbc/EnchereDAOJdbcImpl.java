package dal.jdbc;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.slf4j.LoggerFactory;
import java.sql.Timestamp;
import ch.qos.logback.classic.Logger;
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
	private static Logger loggerA = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("dal.jdbc.EnchereDAOJdbcImpl");
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
	private static final String DELETE_ENCHERE = "DELETE FROM ARTICLES_VENDUS WHERE noArticle = ?";
	private static final String SELECT_ARTICLES = "SELECT * from ARTICLES_VENDUS INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.noUtilisateur = UTILISATEURS.noUtilisateur WHERE etatVente=1";
	private static final String SELECT_DETAIL_ENCHERE = "SELECT * from  ENCHERES WHERE noArticle = ?";
	private static final String SELECT_ARTICLE_NO = "SELECT * from  ARTICLES_VENDUS INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.noUtilisateur = UTILISATEURS.noUtilisateur WHERE noArticle = ?";
	private static final String SELECT_CATEGORIE_NO = "SELECT * from CATEGORIES WHERE noCategorie = ?";
	private static final String SELECT_RETRAIT_NO = "SELECT * from RETRAITS WHERE noArticle = ?";
	private static final String UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, email=?, telephone=? ,rue=?, codePostal=?, ville=?, motDePasse=?, credit=?, administrateur=? WHERE noUtilisateur=?";
    private static final String UPDATE_ENCHERE = "UPDATE ENCHERES SET montantEnchere=?, noUtilisateur=? WHERE montantEnchere < ? AND noArticle=?";
    private static final String UPDATE_UTILISATEUR_CREDIT = "UPDATE UTILISATEURS SET credit=credit-? WHERE  noUtilisateur=? AND credit-?>=0";
    private static final String SELECT_ALL_USER = "SELECT * FROM UTILISATEURS";
	private static final String DELETE_ARTICLE = "DELETE FROM ARTICLES_VENDUS WHERE noArticle = ?";
	private static final String DELETE_CATEGORIE = "DELETE FROM CATEGORIES WHERE noCategorie = ?";
	private static final String INSERT_CATEGORIE = "INSERT INTO CATEGORIES (libelle) values(?)";
    private static final String SELECT_ENCHERE_REMPORTE = "SELECT * FROM ENCHERES INNER JOIN ARTICLES_VENDUS ON ARTICLES_VENDUS.noArticle = ENCHERES.noArticle  INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.noUtilisateur = UTILISATEURS.noUtilisateur WHERE ENCHERES.noUtilisateur = ? AND DATEDIFF(day,ARTICLES_VENDUS.dateFinEncheres,GETDATE()) >= 0";
    private static final String SELECT_ENCHERE_EN_COURS = "SELECT * FROM ENCHERES INNER JOIN ARTICLES_VENDUS ON ARTICLES_VENDUS.noArticle = ENCHERES.noArticle INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.noUtilisateur = UTILISATEURS.noUtilisateur WHERE ENCHERES.noUtilisateur = ? AND DATEDIFF(day,ARTICLES_VENDUS.dateDebutEncheres,GETDATE()) >= 0";
    private static final String UPDATE_ARTICLE = "UPDATE ARTICLES_VENDUS SET nomArticle=?, description=?, dateFinEncheres=?, prixInitial=?, prixVente=? ,noCategorie=? WHERE noArticle=?;";
    private static final String UPDATE_RETRAIT = "UPDATE RETRAITS SET rue=?, codePostal=?, ville=? WHERE noArticle=?;";
    private static final String UPDATE_ETAT_VENTE = "UPDATE ARTICLES_VENDUS SET etatVEnte=0 WHERE noArticle=?;";
    private static final String RECHERCHE_NOM_ARTICLE= "SELECT * FROM ARTICLES_VENDUS WHERE UPPER(nomArticle) = UPPER(?)";
    private static final String SELECT_ARTICLES_NO_CAT = "SELECT * FROM ARTICLES_VENDUS INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.noUtilisateur = UTILISATEURS.noUtilisateur WHERE noCategorie = ?";
	
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
				 loggerA.debug("--------------------------------------------------------------------");
	             loggerA.debug("Utilisateur ajouté : Pseudo="+ utilisateur.getPseudo()+", Nom="+utilisateur.getNom()+", Prenom="+utilisateur.getPrenom()+", email="+utilisateur.getEmail()+", Tel="+utilisateur.getTelephone());
	             loggerA.debug("Yo la sang, Bienvenue parmis nous !");
	             
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
			 loggerA.debug("--------------------------------------------------------------------");
             loggerA.debug(article.getNomArticle()+" a été mis aux enchère par "+article.getNoUtilisateur()+", elle débute le "+datestart+" et fini le "+datefin+ " au prix initial de "+article.getPrixInitiale()+", il appartient à la catégorie "+article.getNoCategorie());
             loggerA.debug("Bon bah on va encore brasser de l'argent !");
             
			
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
                loggerA.debug("--------------------------------------------------------------------");
                loggerA.debug("Un point de retrait a été ajouté pour l'article : "+ rs.getInt("noArticle") + " a l'adresse " + retrait.getRue()+ " " +retrait.getVille()+" "+retrait.getCodePostal());
                loggerA.debug("L'endroit ou se trouve le bidule qui lui a couté si cher alors qu'il l'aurait eu a 2 euro sur ali express !");
                
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
                loggerA.debug("--------------------------------------------------------------------");
                loggerA.debug("Une enchère sur l'article : "+ rs.getInt("noArticle") + " a été crée par "+ rs.getInt("noUtilisateur")+" avec un montant de " + enchere.getMontantEnchere());
                loggerA.debug("Aller encore plus haut, toujours plus de moulaga !");
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	@Override
	public void insertCategorie(Categorie categ) {
		Connection cnx = null;
        PreparedStatement rqt = null;
        try {
        	System.out.println("categ" +categ);
        		cnx = JdbcTools.getConnection();
                rqt = cnx.prepareStatement(INSERT_CATEGORIE, PreparedStatement.RETURN_GENERATED_KEYS);
                rqt.setString(1, categ.getLibelle());
                rqt.executeUpdate();
             
                loggerA.debug("--------------------------------------------------------------------");
                loggerA.debug("insertion de "+categ.getLibelle()+" dans la table Catégorie, le gars est pas trop relou à rajouter des catégories tout le temps");
                loggerA.debug("Toujour plus..");
                
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
			 loggerA.debug("--------------------------------------------------------------------");
             loggerA.debug("L'utilisateur " + noUtilisateur+" a été supprimé");
             loggerA.debug("Welcome to goulag");
           
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void deleteCategorie(int noCategorie) {
		// TODO Auto-generated method stub
		Connection cnx = null;
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(DELETE_CATEGORIE);
			rqt.setInt(1, noCategorie);
			rqt.executeUpdate();
			cnx.close();
			 loggerA.debug("--------------------------------------------------------------------");
             loggerA.debug("La catégorie " + noCategorie+" a été supprimé");
             loggerA.debug("C'est radicale..");
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
							rs.getInt("noUtilisateur"),
							rs.getInt("noCategorie"),
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
				e1 = new Enchere(rs.getDate("dateEnchere").toLocalDate(), rs.getInt("montantEnchere"),rs.getInt("noUtilisateur"));
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
			 loggerA.debug("--------------------------------------------------------------------");
             loggerA.debug("Utilisateur Mis à jours : Pseudo="+ utilisateur.getPseudo()+", Nom="+utilisateur.getNom()+", Prenom="+utilisateur.getPrenom()+", email="+utilisateur.getEmail()+", Tel="+utilisateur.getTelephone());
             loggerA.debug("Va falloir faire des effort la !");
             
		
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
			 loggerA.debug("--------------------------------------------------------------------");
             loggerA.debug("Une enchère sur l'article : "+noArticle + " a été Mise à jours par "+ noUtilisateur+" avec un montant de " + montantEnchere);
             loggerA.debug("J'en connais un qui va se rincer pouloulou");

			
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
	public ArrayList<Utilisateur> selectAllUtilisateur() {
		Connection cnx = null;
		Utilisateur user = null;
		ArrayList<Utilisateur> UtilisateurArray = new ArrayList<Utilisateur>();
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(SELECT_ALL_USER);
			//rqt.setInt(1, );
			ResultSet rs = rqt.executeQuery();
			int d=0;
			if (rs.next()) {
				do{
					d++;
					user = new Utilisateur(rs.getInt("noUtilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"));
					UtilisateurArray.add(user);	
				}while(rs.next());
				
		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return UtilisateurArray;
	}


	@Override
	public ArrayList<ArticleVendu> selectEnchereRemporte(int noUtilisateur) {
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

	@Override
	public void modifEnchereArticle(ArticleVendu article) {
		Connection cnx = null;
		try {
			Timestamp datefin = Timestamp.valueOf(article.getDateFinEncheres().atStartOfDay());
			cnx = JdbcTools.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(UPDATE_ARTICLE);
			rqt.setString(1, article.getNomArticle());
			rqt.setString(2, article.getDescription());
			rqt.setTimestamp(3, datefin);
			rqt.setInt(4, article.getPrixInitiale());
			rqt.setInt(5, article.getPrixVente());
			rqt.setInt(6, article.getNoCategorie());
			rqt.setInt(7, article.getNoArticle());

			rqt.executeUpdate();
			cnx.close();
			 loggerA.debug("--------------------------------------------------------------------");
             loggerA.debug("L'article : "+article.getNomArticle()+ " vien d'etre modifié ");
             loggerA.debug("Rien a ajouter.. ah si, réfléchit la prochaine fois, ça évitera de charger les requête sql !!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifEnchereRetrait(Retrait retrait) {
		Connection cnx = null;
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(UPDATE_RETRAIT);
			rqt.setString(1, retrait.getRue());
			rqt.setString(2, retrait.getCodePostal());
			rqt.setString(3, retrait.getVille());
			rqt.setInt(4, retrait.getNoArticle());
			rqt.executeUpdate();
			cnx.close();
			 loggerA.debug("--------------------------------------------------------------------");
             loggerA.debug("L'article : "+retrait.getNoArticle()+ " Possède un nouveau point de retrait ");
             loggerA.debug("Ah bah bravo ça déménage pendant l'enchère, tu nous facilite pas la vie Maurice");
	
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteEnchere(int noArticle) {
		Connection cnx = null;
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(DELETE_ENCHERE);
			rqt.setInt(1, noArticle);
			rqt.executeUpdate();
			cnx.close();
			 loggerA.debug("--------------------------------------------------------------------");
             loggerA.debug("L'article : "+noArticle+ " a été supprimé ");
             loggerA.debug("ça c'est fait");
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void updateEtatVente(int noArticle) {
		Connection cnx = null;
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement requete = cnx.prepareStatement(UPDATE_ETAT_VENTE);
			requete.setInt(1, noArticle);
			requete.executeUpdate();
			cnx.close();
			 loggerA.debug("--------------------------------------------------------------------");
             loggerA.debug("L'état de la vente : "+noArticle+ " a été mis à jours ");
             loggerA.debug("Ca avance ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public ArrayList<ArticleVendu> selectEnchereUtilisateur(int noUtilisateur) {
		Connection cnx = null;
		ArticleVendu article = null;
		ArrayList<ArticleVendu> listeEnchere = new ArrayList<>();
		try {
			cnx = JdbcTools.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(SELECT_ENCHERE_EN_COURS);
			rqt.setInt(1, noUtilisateur);
			ResultSet rs = rqt.executeQuery();
			if(rs.next()) {
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
								rs.getInt("noUtilisateur"), 
								rs.getInt("noCategorie"),
								rs.getString("pseudo"));
						listeEnchere.add(article);
					}while(rs.next());
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return listeEnchere;
	}
	

	
	
	@Override
	public List<ArticleVendu> rechercheNomArticle(String nomArticle) {
		
		Connection cnx = null;
		ArticleVendu a1 = null;
		List<ArticleVendu> listeArticle = new ArrayList<>();
		
		try {
			cnx = JdbcTools.getConnection();
			cnx.setAutoCommit(false);
			
			PreparedStatement requete = cnx.prepareStatement(RECHERCHE_NOM_ARTICLE);
			requete.setString(1, nomArticle);
			
			ResultSet rs = requete.executeQuery();
			
			if (rs.next()) {
				do {
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
							rs.getInt("noCategorie"));
					
					listeArticle.add(a1);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeArticle;
	}
	
	public List<ArticleVendu> selectArticleParNoCat (int noCat) {
		
		Connection cnx = null;
		ArticleVendu a1 = null;
		List<ArticleVendu> listeArticle = new ArrayList<>();
		
		try {
			cnx = JdbcTools.getConnection();
			cnx.setAutoCommit(false);
			PreparedStatement rqt = cnx.prepareStatement(SELECT_ARTICLES_NO_CAT);
			rqt.setInt(1, noCat);
			ResultSet rs = rqt.executeQuery();
			
			if (rs.next()) {
				do {
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
							listeArticle.add(a1);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeArticle;
	}

}
