package com.atguigu.team.service;

import javax.print.DocFlavor.STRING;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Equipment;
import com.atguigu.team.domain.NoteBook;
import com.atguigu.team.domain.PC;
import com.atguigu.team.domain.Printer;
import com.atguigu.team.domain.Programmer;

public class NameListService {
	//- employees: Employee[]
	private Employee[] employees;
	
	/*
	 * + NameListService()
	+ getAllEmployees(): Employee[]
	+ getEmployee(int id) throws TeamException: Employee 
	 * */
	/*
	 * NameListService()构造器：
	根据项目提供的Data类构建相应大小的employees数组
	再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Eqipment子类的对象
	将对象存于数组中
	Data类位于com.atguigu.team.service包中
	 * */
	public NameListService(){
		employees = new Employee[Data.EMPLOYEES.length];
		double bonus = 0;
		for(int i = 0;i < Data.EMPLOYEES.length;i++){
			int typein = Integer.parseInt(Data.EMPLOYEES[i][0]);
			int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
			String name = Data.EMPLOYEES[i][2];
			int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
			double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
			
			switch(typein){
			case Data.ARCHITECT:
				// id, name, age, salary, bonus, stock
				bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				int stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, createEquipment(i), bonus, stock);
				break;
			case Data.DESIGNER:
				//id, name, age, salary, bonus
				bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, createEquipment(i), bonus);
				break;
			case Data.PROGRAMMER:
				// id, name, age, salary
				employees[i] = new Programmer(id, name, age, salary, createEquipment(i));
				break;
			case Data.EMPLOYEE:
				// id, name, age, salary
				employees[i] = new Employee(id, name, age, salary);
				break;
			}
		}
		
	}
	
	private Equipment createEquipment(int i) {
		// TODO Auto-generated method stub
		int typein = Integer.parseInt(Data.EQIPMENTS[i][0]);
		String model = Data.EQIPMENTS[i][1];
		switch(typein){
		 //PC      :21, model, display
	    //NoteBook:22, model, price
	    //Printer :23, type, name
		case Data.NOTEBOOK:
			double price = Double.parseDouble(Data.EQIPMENTS[i][2]);
			return new NoteBook(model, price);
			//break;
		case Data.PC:
			String display = Data.EQIPMENTS[i][2];
			return new PC(model, display);
			//break;
		case Data.PRINTER:
			String type = Data.EQIPMENTS[i][1];
			String name = Data.EQIPMENTS[i][2];
			return new Printer(type, name); 
			//break;
		}
		return null;
	}

	public Employee[] getAllEmployees(){
		return employees;
	}
	
	public Employee getEmployee(int id) throws TeamException{
		for(int i = 0;i < employees.length;i++){
			if(id == employees[i].getId()){
				return employees[i];
			}
		}
		throw new TeamException("找不到指定的员工!");
	}
}
