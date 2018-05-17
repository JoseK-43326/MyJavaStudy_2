package com.JoseK.TestSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsApp {

	public static void main(String[] args) {
		
		Goods g1 = new Goods("°×²Ë",100,100);
		Goods g2 = new Goods("»Æ¹Ï",150,60);
		Goods g3 = new Goods("Î÷¹Ï",300,80);	
		List<Goods> list = new ArrayList<Goods>();
		list.add(g1);
		list.add(g2);
		list.add(g3);
		Collections.sort(list);
		System.out.println(list);
	}

}
