package com.atguigu.team.domain;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Designer extends Programmer{
	/*
	 * -bonus : double
	 * */
	private double bonus;
	
	/*
	 * + Designer(id: int , name: String, 
                   age: int, salary: double,
                   equipment: Equipment,
                   bonus : double) 
	 * */
	public Designer(int id,String name,int age,double salary,Equipment equipment,double bonus){
		super(id, name, age, bonus, equipment);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getInfo() + "设计师\t" + this.getStatus() 
			+ "\t" + this.getBonus() + "\t\t" + this.getEquipment().getDescription();
	}
	
	public String getTeamInfo(){
		return this.getMemberId() + "/" + getInfo() + "设计师\t" + this.getBonus(); 
	}
}
