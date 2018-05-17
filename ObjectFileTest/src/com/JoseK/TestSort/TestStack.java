package com.JoseK.TestSort;

import java.util.ArrayDeque;


public class TestStack extends ArrayDeque<String>{


	public boolean add(String e) {
		offer(e);
		return true;
	}

	public String push() {
		return pollFirst();
	}


	public String pop() {
		return peekLast();
	}



}
