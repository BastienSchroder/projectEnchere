package dal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import bo.Utilisateur;

public class AppliTest {
	private static Logger loggerA = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("dal.jdbc.EnchereDAOJdbcImpl");


	public static void main(String[] args) {
		loggerA.info("testeeeeeeeeee");
		// TODO Auto-generated method stub
		try {
			Files.write(Paths.get("./WebContent/WEB-INF/log.txt"), "oiuhzaeigfbazehgfbvazhb".getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
