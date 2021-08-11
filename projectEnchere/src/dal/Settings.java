package dal;
import java.io.IOException;
import java.util.Properties;

/**
 * Les paramètres vont être stocké dans un attribut de type Properties. Les propriétés étant commune à toute l’application, nous pouvons rendre cet attribut static. 
 * Mettre l’attribut static va nous permettre d’utiliser la classe Settings sans avoir besoin de l’instancier. 
 * Nous devons maintenant charger les paramètres depuis le fichier. Cela doit être fait une seule fois. 
 * Il est possible d’utiliser un bloc d’initialisation : c’est un bloc d’instruction commençant par une accolade et finissant par une accolade. En notant ce bloc d’instruction statique, nous garantissons que ce code sera exécuté lors du chargement en mémoire de la classe.
 * Pour charger le fichier depuis le class path, java nous fournit la méthode getResourceAsStream.

 * Il reste à créer une méthode publique et static getProperty pour récupérer les valeurs des paramètres dans l’application.

 * @author Eni Ecole
 *
 */
public class Settings {
	private static Properties properties;
	
	// bloc d’initialisation
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
