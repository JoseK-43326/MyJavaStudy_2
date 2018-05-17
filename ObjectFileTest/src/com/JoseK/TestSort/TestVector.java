package com.JoseK.TestSort;

import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

public class TestVector {


	public static void main(String[] args) {
		Vector<String> vec = new Vector<String>();
		vec.add("xiaohedan");
		vec.add("fanciwei");
		vec.add("lianai");
		Enumeration<String> e = vec.elements();
		while(e.hasMoreElements()){ //Enumeration ”Î Iterator ∫‹œ‡À∆
			String str = e.nextElement();
			System.out.println(str);
			}
		
		
		String str1 = "josek.com josek@qq.com josek.cn";
		StringTokenizer token = new StringTokenizer(str1," ");
		while(token.hasMoreTokens()){
			String str2 = token.nextToken();
			System.out.println(str2);
		}

}
}
