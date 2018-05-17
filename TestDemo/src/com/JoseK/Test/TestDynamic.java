package com.JoseK.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import sun.security.action.GetBooleanAction;



public class TestDynamic {

	public static void main(String[] args) throws IOException {
		
		
		String str = "public class Test{public static void main(String[] args){System.out.println(\"Œ“œ≤ª∂–°∫ÀµØ\");}}";
		File f = new File("C:/Users/Administrator/Desktop/Test.java");
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
		dos.write(str.getBytes());
		dos.flush();
		dos.close();
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, "C:/Users/Administrator/Desktop/Test.java");
		System.out.println(result == 0? "±‡“Î≥…π¶" : "±‡“Î ß∞‹");
		
		Runtime run = Runtime.getRuntime();
		Process process = run.exec("java -cp C:/Users/Administrator/Desktop Test");
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String str1 = br.readLine();
		System.out.println(str1);
		
		
		try {
			URL[] urls = new URL[]{new URL("file:/"+"C:/Users/Administrator/Desktop/")};
			URLClassLoader loader = new URLClassLoader(urls);
			Class classz = loader.loadClass("Test");
			Method m = classz.getDeclaredMethod("main", String[].class);
			m.invoke(null, (Object)new String[]{});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
