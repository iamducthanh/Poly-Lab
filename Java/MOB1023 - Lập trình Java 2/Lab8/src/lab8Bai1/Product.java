package lab8Bai1;

import java.io.Serializable;

public class Product implements Serializable{
	public String name;
	public Double price;
	public Product(String name, Double price) {
	this.name = name;
	this.price = price;
	}
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	public Double getPrice() {
	return price;
	}
	public void setPrice(Double price) {
	this.price = price;
	}

}
