package com.JoseK.TestSort;

public class Goods02 {

	private String name;
	private int price;
	private int hits;
	
	
	public Goods02() {
	}
	public Goods02(String name, int price, int hits) {
		this.name = name;
		this.price = price;
		this.hits = hits;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	
	@Override
	public String toString() {
		return "商品：" + this.name + "价格：" + this.price + "点击量："+this.hits +"\n";
	}
	

}
