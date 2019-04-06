package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperities {

	// load the properties file from the folder
	public static Properties userData = loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properities\\userdata.properties");

	public static Properties sauceLabsData = loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properities\\sauceLabsUser.properties");

	
	private static Properties loadProperties(String path) {
		
		Properties pro = new Properties();
		// Stream for reading file
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {

			System.out.println("error occured : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("error occured : " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("error occured : " + e.getMessage());
		}
		return pro;
	}
}
