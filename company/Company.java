package com.monder.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Company {
	
	private Map<String,Double> turnoverMap; //业绩
	
	private Set<Employee> employeeSet; //员工集合
	
	private Map<String,Double> allWagesMap; //工资支出
	
	public Company() {
		turnoverMap = new HashMap<>();
		employeeSet = new TreeSet<>();
		allWagesMap = new HashMap<>();
	}
	
	public void startWages() {
		System.out.println("程序开始");
		Scanner sc = new Scanner(System.in);
		while(true) {
			addEmployee();
			System.out.println("==========");
		}
	}
	
	private void addEmployee() {
		System.out.println("录入员工信息");
		Scanner sc = new Scanner(System.in);
		System.out.println("输入姓名");
		String name = sc.next();
		if(name==null||name.length()<1){
			System.out.println("姓名格式有误");
			return;
		}
		
		System.out.println("输入工资");
		Double slaray;
		if(sc.hasNextDouble()) {
			slaray = sc.nextDouble();
		}else {
			System.out.println("工资格式错误");
			return;
		}
		
		System.out.println("请输入员工生日（yyyy-MM-dd）:");
		String birstr = sc.next();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		try {
			birthday = dateformat.parse(birstr);
		} catch (ParseException e) {
			System.out.println("字符串格式化失败");
			e.printStackTrace();
			return;
		}
		addAloneEmployee(name,slaray,birthday,sc);
	}
	
	private void addAloneEmployee(String name,double wages,Date birthday,Scanner sc){
		System.out.println("请输入员工类型（1是普通员工，2是经理，3是股东）：");
		String type = sc.next();
		if("1".equals(type)){
			Employee employee = new Employee(name,wages,birthday);
			employeeSet.add(employee);
		}else if("2".equals(type)){
			Leader leader = new Leader(name,wages,birthday);
			employeeSet.add(leader);
		}else if("3".equals(type)){
			System.out.println("请输入股东所占股份（0~1之间的浮点数）：");
			if(sc.hasNextDouble()){
				double shares = sc.nextDouble();
				if(shares>=0&&shares<=1){
					Shareholder shareholder = new Shareholder(name,wages,birthday,shares);
					if(shareholder.checkShares(shares,employeeSet)){
						employeeSet.add(shareholder);
					}else{
						System.out.println("股东股份超范围");
					}
				}else{
					System.out.println("股东股份格式错误");
				}
			}else{
				System.out.println("股东股份格式错误");
			}
		}else{
			System.out.println("员工类型格式错误");
		}
	}

	/**
	 * 给全体员工发放一个月工资
	 * @param dateStr发放日期（yyyy-MM）
	 */
	private void payOff(String dateStr){
		for(Employee employee : employeeSet){
			double tempDou = employee.getSlaray();
			String[] array = dateStr.split("-");
			if(allWagesMap.get(array[0])==null){
				allWagesMap.put(array[0],tempDou);
			}else{
				double tempAllDou = allWagesMap.get(array[0]);
				allWagesMap.put(array[0],tempAllDou+tempDou);
			}
			
		}
		for(Employee employee : employeeSet){
			String[] array = dateStr.split("-");
			if("12".equals(array[1])
				&&employee.getType()==3){
				double oneturnover = getTurnover(array[0]);
				double allWages = allWagesMap.get(array[0]);
				Shareholder shareholder = (Shareholder)employee;
				System.out.println("年终分红："+(oneturnover-allWages)*shareholder.getShares());
			}
		}
	}

	/*
	 * 获取指定年份的营业额
	 * @param year 指定的年份（示例：2015）
	 * @return double 指定年份的营业额，如果没有则随机生成
	 */
	private double getTurnover(String year) {
		if(year==null||year.length()!=4){
			System.out.println("传入年份错误");
			return 0;
		}
		Double returnValue = turnoverMap.get(year);
		if(returnValue==null){
			Random random = new Random();
			int turnover = random.nextInt(100000000);
			turnoverMap.put(year,Double.valueOf(turnover));
			return turnover;
		}else{
			return returnValue;
		}
	}

}

