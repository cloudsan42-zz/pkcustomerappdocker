package com.prokarma.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.prokarma.util.db.MongoDBHandler;

public class AppUtil {
	
		
	public static void loadAllDBProps(){
		Properties prop = new Properties();
		InputStream input = null;

		try {

			//input = new FileInputStream("db.properties");
			input = AppUtil.class.getClassLoader().getResourceAsStream("db.properties");

			// load a properties file
			prop.load(input);

			MongoDBHandler.dbHost=prop.getProperty("db.host");
			MongoDBHandler.dbPort=prop.getProperty("db.port");
			MongoDBHandler.dbUser=prop.getProperty("db.user");
			MongoDBHandler.dbPassword=prop.getProperty("db.password");
			MongoDBHandler.dbName=prop.getProperty("db.database");
			MongoDBHandler.dbOperations=prop.getProperty("db.operations");
			
			// get the property value and print it out
			System.out.println(MongoDBHandler.dbHost);
			System.out.println(MongoDBHandler.dbPort);
			System.out.println(MongoDBHandler.dbURI);
			System.out.println(MongoDBHandler.dbUser);
			System.out.println(MongoDBHandler.dbPassword);
			System.out.println(MongoDBHandler.dbName);
			System.out.println(MongoDBHandler.dbOperations);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void loadDBProps() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			//input = new FileInputStream("db.properties");
			input = AppUtil.class.getClassLoader().getResourceAsStream("db.properties");

			// load a properties file
			prop.load(input);

			MongoDBHandler.dbUser=prop.getProperty("db.user");
			MongoDBHandler.dbPassword=prop.getProperty("db.password");
			MongoDBHandler.dbName=prop.getProperty("db.database");
			MongoDBHandler.dbOperations=prop.getProperty("db.operations");
			
			// get the property value and print it out
			System.out.println(MongoDBHandler.dbHost);
			System.out.println(MongoDBHandler.dbPort);
			System.out.println(MongoDBHandler.dbUser);
			System.out.println(MongoDBHandler.dbPassword);
			System.out.println(MongoDBHandler.dbName);
			System.out.println(MongoDBHandler.dbOperations);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
