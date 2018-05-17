package com.JoseK.Test;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;


public class TestJavassit {

	public static void main(String[] args) throws Exception {
		
		ClassPool pool = ClassPool.getDefault();
		CtClass classz = pool.makeClass("com.JoseK.Test");
		
		CtField f1 = CtField.make("private int id;", classz);
		CtField f2 =CtField.make("private String name;", classz);
		classz.addField(f1);
		classz.addField(f2);
		
		CtMethod m1 = CtMethod.make("public void setId(int id){this.id = id;}", classz);
		CtMethod m2 = CtMethod.make("public int getId(){return id;}", classz);
		CtMethod m3 = CtMethod.make("public void setName(String name){this.name = name;}", classz);
		CtMethod m4 = CtMethod.make("public int getName(){return name;}", classz);
		classz.addMethod(m1);
		classz.addMethod(m2);
		classz.addMethod(m3);
		classz.addMethod(m4);
		
		CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")}, classz);
		constructor.setBody("{this.id = id; this.name = name;}");
		CtConstructor constructor2 = new CtConstructor(new CtClass[]{}, classz);		
		classz.addConstructor(constructor);
		classz.addConstructor(constructor2);
		
		classz.writeFile("C:/Users/Administrator/Desktop/");
		System.out.println("执行类成功");
	}

}
