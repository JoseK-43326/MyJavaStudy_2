package com.JoseK.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;


public class TestRUL {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://study.163.com");
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		BufferedWriter bw = 
				new BufferedWriter(new OutputStreamWriter(new FileOutputStream("E:\\java\\java_test\\URL.txt"), "utf-8"));
		String msg = null;
		while((msg = br.readLine()) != null){
			bw.append(msg);
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}
