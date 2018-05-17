package com.JoseK.TestAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


public class SeuStudentAPP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
		Class classz = 	Class.forName("com.JoseK.TestAnnotation.SeuStudent");
		Annotation[] annotations = classz.getAnnotations();
		for(Annotation a : annotations){
			System.out.println(a);
		}
		
		SeuTabel st = (SeuTabel) classz.getAnnotation(SeuTabel.class);
		System.out.println(st.value());
		
		Field f = classz.getDeclaredField("id");
		SeuFiled sf = f.getAnnotation(SeuFiled.class);
		System.out.println(sf.columnName() + "--" + sf.type() +"--" + sf.length());
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
