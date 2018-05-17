package com.JoseK.TestSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Goods02APP {

	public static void main(String[] args) {
		
		Goods02 g1 = new Goods02("Ð¬×Ó",500,1000);
		Goods02 g2 = new Goods02("¿ã×Ó",300,1500);
		Goods02 g3 = new Goods02("ÏîÁ´",1000,3000);
		List<Goods02> list = new ArrayList<Goods02>();
		list.add(g1);
		list.add(g2);
		list.add(g3);
		Collections.sort(list, new GoodsCompPrice());
		System.out.println(list);
		
		Collections.sort(list, new GoodsCompHits());
		System.out.println(list);
		
	}

}
