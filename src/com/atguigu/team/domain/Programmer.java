package com.atguigu.team.domain;


public class Programmer extends Employee{
	/*
	 *  - memberId : int
 		-status: Status
 		-equipment: Equipment
	 * */
	private int memberId;
	private Status status = Status.FREE;
	private Equipment equipment;
	
	/*
	 * +Programmer(id: int , name: String, 
                       age: int, salary: double,
                       equipment: Equipment)
	 * */
	public Programmer(int id,String name,int age,double salary,Equipment equipment){
		super(id, name, age, salary);
		this.equipment = equipment;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getInfo() + "程序员\t" + this.getStatus() + "\t\t\t" + this.getEquipment().getDescription();
	}
	
	public String getTeamInfo(){
		return this.getMemberId() + "/" + getInfo() + "程序员\t";
	}
}
