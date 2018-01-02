package com.tellusko;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop	{
	
	@Id
	private int lid;
	private String brand;
	private int price;
	
	
	
	public int getLid() {
		return lid;
	}	

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getBrand() {
		return brand;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Laptop [id=" + lid + ", brand=" + brand + ", price=" + price + "]";
	}
	
	

}
