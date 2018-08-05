package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;
import com.atguigu.team.domain.Status;

public class TeamService {
	/*
	 * -counter: int = 1
	   -MAX_MEMBER: final int = 5
 	   -team: Programmer[] = new Programmer[MAX_MEMBER];
	   -total: int = 0;
	 * */
	private static int counter = 1;
	private final int MAX_MEMBER = 5;
	//数组用来保存当前团队中的各成员对象 
	private Programmer[] team = new Programmer[MAX_MEMBER];
	//记录团队成员的实际人数
	private int total = 0;
	/*
	 *  + getTeam(): Programmer[]
		+ addMember(e: Employee) throws TeamException: void 
		+ removeMember(memberId: int) throws TeamException: void 
	 * */
	public Programmer[] getTeam(){
		Programmer[] p = new Programmer[total];
		for(int i = 0; i < total;i++ ){
			p[i] = team[i];
		}
		return p;
	}
	
	public void addMember(Employee e) throws TeamException{
//		成员已满，无法添加
		if(total >= team.length){
			throw new TeamException("成员已满，无法添加");
		}
		
//		该成员不是开发人员，无法添加
		if(!(e instanceof Programmer)){
			throw new TeamException("该成员不是开发人员，无法添加");
		}
//		该员已是团队成员 
		for(int i = 0;i < total;i++){
			if(e.getId() == team[i].getId()){
				throw new TeamException("该员已是团队成员");
			}
		}
//		该员正在休假，无法添加
		Programmer p = (Programmer)e;
		if(p.getStatus() == Status.VOCATION){
			throw new TeamException("该员正在休假，无法添加");
		}else if(p.getStatus() == Status.BUSY){
			throw  new TeamException("该员工正在其他团队");
		}
//		团队中只能有一名架构师
//		团队中只能有两名设计师
//		团队中只能有三名程序员
		int archSum = 0;
		int decSum = 0;
		int proSum = 0;
		for(int i = 0;i < total;i++){
			Programmer pro = team[i];
			if(pro instanceof Architect){
				archSum++;
			}else if(pro instanceof Designer){
				decSum ++;
			}else if(pro instanceof Programmer){
				proSum ++;
			}
		}
		if (e instanceof Architect) {
			if(archSum >= 1){
				throw new TeamException("团队中只能有一名架构师");
			}
		}else if(e instanceof Designer){ 
			if(decSum >= 2){
				throw new TeamException("团队中只能有两名设计师");
			}
		}else if(e instanceof Programmer){ 
			if(proSum >= 3){
				throw new TeamException("团队中只能有三名程序员");
			}
		}
		
		p.setStatus(Status.BUSY);
		team[total++] = p;
		//设置团队成员id
		p.setMemberId(counter++);

	}
	
	public void removeMember(int memberId) throws TeamException{
		int i = 0;
		for(;i < total;i++){
			if(team[i].getMemberId() == memberId){
				team[i].setStatus(Status.FREE);
			}
		}
		
		if(i >= total){
			throw new TeamException("找不到该成员！");
		}
		
		for(int j = i;j < total;j++){
			team[j] = team[j+1];
		}
		
		team[--total] = null;
	}
}
