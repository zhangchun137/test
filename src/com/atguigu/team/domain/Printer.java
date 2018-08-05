package com.atguigu.team.domain;

public class Printer implements Equipment{

	/*
	 *  -type: String
		-name: String
	 * */
	private String type;
	private String name;
	/*
	 * + Printer(type: String, name: String)
	 * */
	public Printer(String type,String name) {
		this.type = type;
		this.name = name;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return type + "(" + name + ")";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
