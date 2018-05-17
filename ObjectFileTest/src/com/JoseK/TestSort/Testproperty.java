package com.JoseK.TestSort;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;


public class Testproperty {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Properties pro = new Properties();
		
		pro.setProperty("xiaohedan", "10-03");
		pro.setProperty("fanciwei", "09-21");
		pro.setProperty("lianai", "03-24");
		
		String str = pro.getProperty("lianai");
		System.out.println(str);
		
		pro.storeToXML(new FileOutputStream(new File("E:/java/java_test/mag.XML")), "пео╒");
		pro.load(new FileReader(new File("E:/java/java_test/mag.XML")));
		System.out.println(pro.getProperty("lianai"));
		
	}

}
