package com.atguigu.team.domain;

public class NoteBook implements Equipment{

	/*
	 *  -model: String
 		-price: double
	 * */
	private String model;
	private double price;
	
	//+ NoteBook(model: String, price: double)
	public NoteBook(String model,double price) {
		this.model = model;
		this.price = price;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return model + "(" + price + ")";
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
}
