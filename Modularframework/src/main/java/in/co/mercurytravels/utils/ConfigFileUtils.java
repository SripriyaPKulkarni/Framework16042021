package in.co.mercurytravels.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileUtils {

	public static Properties readProperties(String filename) throws IOException{
		filename=filename.trim();
		
		InputStream fileReader=new FileInputStream(filename);
		
		Properties prop=new Properties();
		
		prop.load(fileReader);
		
		return prop;
		
	}
}
