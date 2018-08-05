package com.atguigu.team.domain;

public class Architect extends Designer{
	/*
	 * -stock : int
	 * */
	private int stock;
	
	/*
	 * +Architect (id: int , name: String, 
                   age: int, salary: double,
                   equipment: Equipment,
                   bonus : double, stock : int)
	 * */
	public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus,int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getInfo() + "架构师\t" + this.getStatus() + "\t" + this.getBonus() 
			+ "\t" + this.getStock() + "\t" + this.getEquipment().getDescription() ;
	}

	public String getTeamInfo(){
		return this.getMemberId() + "/" + getInfo() + "架构师\t" + this.getBonus() + "\t" + this.stock;
	}
}
