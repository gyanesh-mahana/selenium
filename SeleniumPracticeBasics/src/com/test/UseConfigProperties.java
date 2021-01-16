package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UseConfigProperties {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Properties p = new  Properties();
		FileInputStream fStream = new FileInputStream("/home/gyanesh/eclipse-workspace_testing/SeleniumTest/config.properties");
		
		p.load(fStream);
		System.out.println(p.getProperty("browser", "chrome"));
		System.out.println(p.getProperty("user", "abc@gmail.com"));
		System.out.println(p.getProperty("url", "https://www.google.com"));

		System.out.println(p.getProperty("passwd", "237287"));
	}

}
