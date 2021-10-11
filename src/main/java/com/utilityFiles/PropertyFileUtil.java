package com.utilityFiles;

import static com.utilityFiles.FilePath.APPLICATION_PROPERTIES;
import static com.utilityFiles.FilePath.USER_DIR;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//This class will read the property File and return the value based on the key
public class PropertyFileUtil {

	public String getValue(String key) throws IOException {
		Properties prop = new Properties();
		prop= new Properties();
		String filepath=USER_DIR+File.separator+APPLICATION_PROPERTIES;		
		FileInputStream file=null;
		try {
			 file= new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop.load(file);
	  return prop.getProperty(key);
		
	}
	
}
