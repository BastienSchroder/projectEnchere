package dal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

import bo.Utilisateur;

public class AppliTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Files.write(Paths.get("./WebContent/WEB-INF/test.txt"), "on est la".getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
