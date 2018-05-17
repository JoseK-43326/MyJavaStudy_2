package com.JoseK.TestSort;

public class Goods03 {
	
	
	private String name;
	private int hits;
	private int price;
	
	
	public Goods03() {
	}
	public Goods03(String name, int hits, int price) {
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
		return "商品：" + this.name+"价格："+this.price+"点击量："+this.hits+ "\n";
	}
}
