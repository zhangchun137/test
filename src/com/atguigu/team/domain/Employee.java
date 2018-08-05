package com.atguigu.team.domain;



public class Employee {

	/*
	 * - id: int 
 	   -name:String
 	   -age: int
 	   -salary: double 
	 * */
	private int id;
	private String name;;
	private int age;
	private double salary;
	
	/*
	 * +Employee(id: int , name: String, 
                   age: int, salary: double) 
	 * */
	
	public Employee(int id,String name,int age,double salary){
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getInfo(){
		return id + "\t" + name + "\t"+ age + "\t" + salary + "\t";
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getInfo();
	}
	
}
