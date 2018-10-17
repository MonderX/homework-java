package com.monder.company;

import java.util.Date;

public class Employee {
	
	public String name;
	
	public Double slaray;
	
	public Date birthday;
	
	public byte type;
	
	public Employee(String name,double slaray,Date birthday) {
		this.name = name;
		this.slaray = slaray;
		this.birthday = birthday;
		type = 1;	
	}
	
	/**
	 * �õ����ʵ����
	 * @return slaray
	 */
	public Double getSlaray() {
		String message = name+"����Ӧ������Ϊ"+slaray+",ʵ������Ϊ"+slaray;
		System.out.println(message);
		return slaray;
	}
	
	public int hashCode() {
		return name.hashCode();
	}
	
	public boolean equals(Object o) {
		Employee employee = (Employee)o;
		return name.equals(employee.getName());
	}
	
	
	public int compareTo(Object o) {
		Employee employee = (Employee)o;
		Byte byte1 = new Byte(type);
		Byte byte2 = new Byte(employee.getType());
		return  byte1.compareTo(byte2);
	}
	
	public String getName() {
		return name;
	}
	
	public byte getType() {
		return type;
	}
    

}
