package dal;
import java.io.IOException;
import java.util.Properties;

/**
 * Les param�tres vont �tre stock� dans un attribut de type Properties. Les propri�t�s �tant commune � toute l�application, nous pouvons rendre cet attribut static. 
 * Mettre l�attribut static va nous permettre d�utiliser la classe Settings sans avoir besoin de l�instancier. 
 * Nous devons maintenant charger les param�tres depuis le fichier. Cela doit �tre fait une seule fois. 
 * Il est possible d�utiliser un bloc d�initialisation : c�est un bloc d�instruction commen�ant par une accolade et finissant par une accolade. En notant ce bloc d�instruction statique, nous garantissons que ce code sera ex�cut� lors du chargement en m�moire de la classe.
 * Pour charger le fichier depuis le class path, java nous fournit la m�thode getResourceAsStream.

 * Il reste � cr�er une m�thode publique et static getProperty pour r�cup�rer les valeurs des param�tres dans l�application.

 * @author Eni Ecole
 *
 */
public class Settings {
	private static Properties properties;
	
	// bloc d�initialisation
	static {
		properties = new Properties();
		try {
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static String getProperty(String key) {
		String valeur = properties.getProperty(key);
		return valeur;
	}

}
