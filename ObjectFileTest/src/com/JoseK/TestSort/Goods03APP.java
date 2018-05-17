package com.JoseK.TestSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Goods03APP {

	public static void main(String[] args) {
		
		 Goods03 g1 = new Goods03("电脑",1000,4000);
		 Goods03 g2 = new Goods03("手机",1200,3000);
		 Goods03 g3 = new Goods03("相机",800,5000);
		 List<Goods03> list = new ArrayList<Goods03>();
		 list.add(g1);
		 list.add(g2);
		 list.add(g3);
		 Collections.sort(list, new Comparator<Goods03>() {
			 public int compare(Goods03 o1, Goods03 o2) {
				return -(o1.getName().compareTo(o2.getName()));
			}
		 });
		 System.out.println(list);
	}

}
