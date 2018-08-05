package com.atguigu.team.domain;

public class PC implements Equipment{

	/*
	 *  -model: String
 		-display: String
	 * */
	private String model;
	private String display;
	/*
	 * + PC(model: String, display: String)
	 * */
	public PC(String model,String display){
		this.model = model;
		this.display = display;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return model + "(" + display + ")";
	}
	
}
