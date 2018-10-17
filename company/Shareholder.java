package com.monder.company;

import java.util.Date;
import java.util.Set;

public class Shareholder extends Employee{
	
	private double shares;  //占有股份
	
	public Shareholder(String name,double slaray,Date birthday,double shares) {
		super(name,slaray,birthday);
		this.shares = shares;
		this.type  = 3;
	}
	
	public boolean checkShares(double shares,Set<Employee> employeeSet) {
		double allshares = 0;
		for(Employee employee :employeeSet) {
			if(employee.getType()==3){
				Shareholder shareholder = (Shareholder)employee;
				allshares = allshares + shareholder.getShares();
			}
		}
		if((allshares+shares)>1) {
			return false;
		}else {
			return true;
		}
	}
	
	public double getShares() {
		return shares;
	}

}
