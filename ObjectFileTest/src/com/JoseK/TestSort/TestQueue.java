package com.JoseK.TestSort;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;


public class TestQueue {


	public static void main(String[] args) {
		/*Queue<String> que = new ArrayDeque<String>();
		
		que.offer("xiaohedan");
		que.offer("fanciwei");
		que.offer("lianai");
		//ȡͷһ��Ԫ��   ʵ�ֵ��� Queue���� FIFO
		//ʵ�ֵ���Deque���� FILO 
		String str = que.peek();
		System.out.println(str);*/
		
		
		Deque<String> dque = new ArrayDeque<String>();
		
		dque.offer("xiaohedan");
		dque.offer("fanciwei");
		dque.offer("lianai");
		
		dque.pollLast();
		
		String str = dque.peekLast();
		System.out.println(str);
		
	}

}
