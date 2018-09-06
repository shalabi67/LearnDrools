package com.learn.drool.data;

public class Product {
	private int id;
	private String name;
	private int price;

	public static Product createProduct(int id, String name, int price) {
		Product product = new Product();
		product.id = id;
		product.name = name;
		product.price = price;

		return product;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
