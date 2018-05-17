package com.JoseK.TestSort;


public class TestStackApp {


	public static void main(String[] args) {
		
		TestStack list = new TestStack();
		list.add("xiaohedan");
		list.add("fanciwei");
		list.add("lianai");
		
		String str = list.pop();
		System.out.println(str);

	}

}
