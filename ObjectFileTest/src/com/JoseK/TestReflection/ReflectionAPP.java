package com.JoseK.TestReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ReflectionAPP {

	
	public static void main(String[] args) {
		
		try {
			Class classz = Class.forName("com.JoseK.TestReflection.User");
			
			User u1 = (User) classz.newInstance();
			System.out.println(u1);
			
			Constructor<User> con = classz.getDeclaredConstructor(int.class,int.class,String.class);
			User u2 = con.newInstance(1001,20,"xiaohedan");
			System.out.println(u2.getName());
			
			User u3 = (User) classz.newInstance();
			Method m = classz.getDeclaredMethod("setName", String.class);
			m.invoke(u3, "xiaohedan");
			System.out.println(u3.getName());
			
			User u4 = (User) classz.newInstance();
			Field f = classz.getDeclaredField("name");
			f.setAccessible(true);
			f.set(u4, "fanciwei");
			System.out.println(u4.getName());
			
			
			
			/*Field f = classz.getDeclaredField("id");
			System.out.println(f);			
			Field[] fields = classz.getDeclaredFields();
			for(Field temp:fields){
				System.out.println(temp);
			}*/
		/*	Method m = classz.getDeclaredMethod("getName", null);
			System.out.println(m);			
			Method[] methods = classz.getDeclaredMethods();
			for(Method temp:methods){
				System.out.println(temp);
			}*/
			
			/*Constructor<User> con = classz.getConstructor(int.class,int.class,String.class);
			System.out.println(con);
			Constructor[] con1 = classz.getDeclaredConstructors();
			for(Constructor temp:con1){
				System.out.println(temp);
			}*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
