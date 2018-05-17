package com.JoseK.Test;

import java.util.Arrays;



public class TestDemo01 /*implements Runnable*/{


	public static void main(String[] args) {
		
					
//测试冒泡排序法(未优化版)
		/*int[] a = new int[]{9,8,7,6,5,10};
		long start = System.currentTimeMillis();
		int length = a.length;
		int times = length -1;
		for(int j = 0; j < times; j++){
			System.out.println("第" + (j+1) + "趟");
			for(int i = 0; i < times ;i++){
				if(a[i] > a[i+1]){
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}				
			}
			System.out.println(Arrays.toString(a));
		}
		long end = System.currentTimeMillis();
		System.out.println("排序用时：" + (end - start)+"ms");*/
//多线程测试
		/*TestDemo01 test = new TestDemo01();
		Thread thread  = new Thread(test);
		thread.start();		
		for(int i = 0; i < 50; i++){
			System.out.println("我是主线程  ---->");	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/		
//测试String类型
		/*String str1 = new String ("taobao");
		String str2 = new String("taobao");
		String str3 = "tao";
		String str4 = "bao";
		System.out.println(str1 == (str3 + str4));
		System.out.println(str1.equals(str3+str4));*/	
//测试数组复制的效率
		/*char[] str1 = new char[]{'a','b','c','d','e','f'};
		char[] str2 = new char[]{'u','v','w','x','y','z'};
		long start = System.currentTimeMillis();
		System.arraycopy(str1, 0, str2, 0, 5);
		long end = System.currentTimeMillis();
		System.out.println(Arrays.toString(str2));
		System.out.println("arraycopy复制用时：" + (end-start));
		long start2 = System.currentTimeMillis();
		char[] result = Arrays.copyOf(str2, 5);
		long end2 = System.currentTimeMillis();
		System.out.println("copyOf用时："+ (end - start));
		System.out.println(result);*/
//== 和 equals 测试
		/*Integer int1 = new Integer(12);
		Integer int2 = new Integer(12);
		Long long1 = new Long(9);
		Integer int3 = 5;
		Integer int4 = 5;
		Integer int5 = 129;
		Integer int6 = 129;
		System.out.println(int5 == int6);
		System.out.println(int3 == int4);
		System.out.println(int1 == int2);
		System.out.println(int1.equals(int2));	
		Float f1 = 100.0f;
		Float f2 = 100.0f;
		System.out.println(f1 ==f2);
		Double d1 = 100.0;
		Double d2 = 100.0;
		System.out.println(d1==d2);*/
		
		
		
	}
	/*@Override
	public void run() {
		while(true){
			System.out.println("我是子线程 ---->");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}		
	}*/

}
