package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetURL {
	
	public static String readToken() throws IOException {
		FileReader reader=new FileReader("./src/test/resources/EndPoint.properties");
		Properties prop = new Properties();
		prop.load(reader);
		return prop.getProperty("url");
	}

}
