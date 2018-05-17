package com.JoseK.TestSort;

public class Goods implements java.lang.Comparable<Goods>{
	
	public int compareTo(Goods o) {
		int result = 0;
		result = this.price - o.price; 
		if(result == 0){
			result = this.hits - o.hits;
			if(result == 0){
				result = this.name.compareTo(o.name);
			}
		}		
		return result;
	}

	private String name;
	private int hits;
	private int price;
	
	
	public Goods() {
		
	}
	
	
	public Goods(String name, int hits, int price) {
		this.name = name;
		this.hits = hits;
		this.price = price;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {		
		return "商品："+ this.name+ ",点击量："+this.hits+ ",价格:"+this.price +"\n";
	}
	




}
