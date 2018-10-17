package com.monder.company;

import java.util.Date;

public class Leader extends Employee{
	
	private double bonus; //生日奖励
	
	public Leader(String name,double slaray,Date birthday) {
		super(name,slaray,birthday);
		bonus = 8888;
		this.type = 2;
	}
	
	public double getWages() {
		String message = name+"当月应发工资："+slaray+"，实发工资:"+slaray+",奖励:"+bonus;
		System.out.println(message);
		return slaray+bonus;
	}
	
}
