package com.JoseK.TestSort;

public class GoodsCompPrice implements java.util.Comparator<Goods02>{
	
	public int compare(Goods02 o1, Goods02 o2) {
		
		return -(o1.getPrice() - o2.getPrice());
	}
}


