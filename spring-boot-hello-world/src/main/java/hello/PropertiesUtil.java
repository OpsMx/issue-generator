package hello;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	private Properties properties; // Singleton instance
	ClassLoader cl = PropertiesUtil.class.getClassLoader();
	
	public synchronized  Properties getInstance(){
		if(properties == null){
			properties = new Properties();
			loadProps();
		}
		return properties;
	}

	private void loadProps() {
		try{
			InputStream inputStream =  cl.getResourceAsStream("application.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
