package com.monder.company;

import java.util.Date;

public class Leader extends Employee{
	
	private double bonus; //���ս���
	
	public Leader(String name,double slaray,Date birthday) {
		super(name,slaray,birthday);
		bonus = 8888;
		this.type = 2;
	}
	
	public double getWages() {
		String message = name+"����Ӧ�����ʣ�"+slaray+"��ʵ������:"+slaray+",����:"+bonus;
		System.out.println(message);
		return slaray+bonus;
	}
	
}
