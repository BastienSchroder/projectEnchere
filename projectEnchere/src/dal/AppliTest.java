package dal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;


import bo.Utilisateur;

public class AppliTest {
	private static Logger loggerA = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("dal.jdbc.EnchereDAOJdbcImpl");


	public static void main(String[] args) {
		loggerA.info("testeeeeeeeeee");
	}

}
