package com.atguigu.team.view;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;
import com.atguigu.team.service.TeamService;
import com.atguigu.team.util.TSUtility;

public class TeamView {
	/*
	 *  listSvc和teamSvc属性：供类中的方法使用
		enterMainMenu ()方法：主界面显示及控制方法。
		以下方法仅供enterMainMenu()方法调用：
		listAllEmployees ()方法：以表格形式列出公司所有成员
		addMember ()方法：实现添加成员操作
		deleteMember ()方法：实现删除成员操作
	 * */
	/*
	 * - listSvc: NameListService = new NameListService()
	- teamSvc: TeamService = new TeamService()
	 * */
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();
	
	/*
	 *  + enterMainMenu(): void 
		- listAllEmployees(): void 
		- addMember(): void 
		- deleteMember(): void 
		+ main(args: String[]) : void 
	 * */
	public static void main(String[] args){
		//System.out.println("qqqqq");
		TeamView tv = new TeamView();
		//System.out.println("uuuuu");
		tv.enterMainMenu();
		//System.out.println("ttttttt");
	}
	
	public void enterMainMenu(){
		boolean isflag = true;
		while(isflag){
			
			/*
			 * -------------------------------------开发团队调度软件--------------------------------------

			ID     姓名      年龄    工资      职位      状态      奖金      股票    领用设备
 			1      段誉      22        3000.0
 			2      令狐冲  32        18000.0 架构师  FREE    15000.0  2000    联想T4(6000.0)
 			3      任我行  23        7000.0   程序员  FREE                               戴尔(NEC17寸)
 			4      张三丰  24        7300.0   程序员  FREE                               戴尔(三星 17寸)
 			5      周芷若  28        10000.0 设计师  FREE    5000.0                佳能 2900(激光)
 			……
			---------------------------------------------------------------------------------------------------
			1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)： 
			*/
			System.out.println("-----------------------------开发团队调度软件---------------------------------");
			listAllEmployees();
			System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
			char ch = TSUtility.readMenuSelection();
			switch(ch){
			case '1':
				listAllTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.print("请确认是否退出(Y/N):");
				char c = TSUtility.readConfirmSelection();
				if(c == 'Y'){
					isflag = false;
					System.out.println("退出成功！！");
				}
				break;
			}
		}
	}
	
	private void listAllEmployees(){
		Employee[] employees = listSvc.getAllEmployees();
		System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
		for(int i = 0;i < employees.length;i++){
			Employee em = employees[i];
			//System.out.println("wwwwwww");
			System.out.println(em.toString());
		}
		System.out.println("----------------------------------------------------");
	}
	
	private void listAllTeam(){
		/*
		 * ------------------团队成员列表---------------------
		TID/ID	姓名	年龄	工资	职位	奖金	股票
		1/12	黄蓉	27	9600.0	设计师	4800.0
		按回车键继续...
		 * */
		System.out.println("------------------团队成员列表---------------------");
		Programmer[] team = teamSvc.getTeam();
		if(team.length == 0 || team == null){
			System.out.println("该团队为空！！");
		}else{
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
			for(int i = 0;i < team.length;i++){
				Programmer pro = team[i];
				System.out.println(pro.getTeamInfo());
			}
		}
		TSUtility.readReturn();
	}
	
	private void addMember(){
		/*
		 * ---------------------添加成员---------------------
			请输入要添加的员工ID：2
			添加成功
			按回车键继续...
		 * */
		System.out.println(" ---------------------添加成员---------------------");
		System.out.print("请输入要添加的员工ID：");
		int id = TSUtility.readInt();
		Employee employee;
		try {
			employee = listSvc.getEmployee(id);
			teamSvc.addMember(employee);
			System.out.println("添加成功!");
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		TSUtility.readReturn();
	}
	
	private void deleteMember(){
		/*
		 * ---------------------删除成员---------------------
		请输入要删除员工的TID：
		确认是否删除(Y/N)：y
		没有找到该成员
		按回车键继续...
		 * */
		System.out.println(" ---------------------删除成员---------------------");
		System.out.print("请输入要删除员工的TID：");
		int tid = TSUtility.readInt();
		System.out.print("确认是否删除(Y/N)：");
		char c = TSUtility.readConfirmSelection();
		if(c == 'Y'){
			try {
				teamSvc.removeMember(tid);
				System.out.println("删除成功！！");
			} catch (TeamException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}
		
	}
}
