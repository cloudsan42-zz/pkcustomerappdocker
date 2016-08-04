package com.prokarma.api;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import com.prokarma.controller.CustomerService;
import com.prokarma.util.db.MongoDBHandler;

public class CustomerStarter {

	public static void main(String[] args) {
		PropertySource<?> ps = new SimpleCommandLinePropertySource(args);
		System.out.println(System.getProperties().toString());
		MongoDBHandler.dbURI=System.getProperty("dbhosts");
		System.out.println("System Property RECEIVED :::: " +MongoDBHandler.dbURI);
		/*if (args.length>=1 && args.length < 2) {
			System.out.println(
					"Starting the CustomerStarter....Arguments :::: " + args[0] + " " + args[1]);
			MongoDBHandler.dbHost = (String) ps.getProperty("dbhost");
			MongoDBHandler.dbPort = (String) ps.getProperty("dbportno");
			System.out.println("RECEIVED 2 COMMAND LINE ARGUMENTS:::: HOST :::: " + MongoDBHandler.dbHost
					+ " PORT-NO :::: " + MongoDBHandler.dbPort);
		}*/
		SpringApplication.run(CustomerService.class, args);
	}

}
