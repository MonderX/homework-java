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
	
	private Map<String,Double> turnoverMap; //ҵ��
	
	private Set<Employee> employeeSet; //Ա������
	
	private Map<String,Double> allWagesMap; //����֧��
	
	public Company() {
		turnoverMap = new HashMap<>();
		employeeSet = new TreeSet<>();
		allWagesMap = new HashMap<>();
	}
	
	public void startWages() {
		System.out.println("����ʼ");
		Scanner sc = new Scanner(System.in);
		while(true) {
			addEmployee();
			System.out.println("==========");
		}
	}
	
	private void addEmployee() {
		System.out.println("¼��Ա����Ϣ");
		Scanner sc = new Scanner(System.in);
		System.out.println("��������");
		String name = sc.next();
		if(name==null||name.length()<1){
			System.out.println("������ʽ����");
			return;
		}
		
		System.out.println("���빤��");
		Double slaray;
		if(sc.hasNextDouble()) {
			slaray = sc.nextDouble();
		}else {
			System.out.println("���ʸ�ʽ����");
			return;
		}
		
		System.out.println("������Ա�����գ�yyyy-MM-dd��:");
		String birstr = sc.next();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		try {
			birthday = dateformat.parse(birstr);
		} catch (ParseException e) {
			System.out.println("�ַ�����ʽ��ʧ��");
			e.printStackTrace();
			return;
		}
		addAloneEmployee(name,slaray,birthday,sc);
	}
	
	private void addAloneEmployee(String name,double wages,Date birthday,Scanner sc){
		System.out.println("������Ա�����ͣ�1����ͨԱ����2�Ǿ���3�ǹɶ�����");
		String type = sc.next();
		if("1".equals(type)){
			Employee employee = new Employee(name,wages,birthday);
			employeeSet.add(employee);
		}else if("2".equals(type)){
			Leader leader = new Leader(name,wages,birthday);
			employeeSet.add(leader);
		}else if("3".equals(type)){
			System.out.println("������ɶ���ռ�ɷݣ�0~1֮��ĸ���������");
			if(sc.hasNextDouble()){
				double shares = sc.nextDouble();
				if(shares>=0&&shares<=1){
					Shareholder shareholder = new Shareholder(name,wages,birthday,shares);
					if(shareholder.checkShares(shares,employeeSet)){
						employeeSet.add(shareholder);
					}else{
						System.out.println("�ɶ��ɷݳ���Χ");
					}
				}else{
					System.out.println("�ɶ��ɷݸ�ʽ����");
				}
			}else{
				System.out.println("�ɶ��ɷݸ�ʽ����");
			}
		}else{
			System.out.println("Ա�����͸�ʽ����");
		}
	}

	/**
	 * ��ȫ��Ա������һ���¹���
	 * @param dateStr�������ڣ�yyyy-MM��
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
				System.out.println("���շֺ죺"+(oneturnover-allWages)*shareholder.getShares());
			}
		}
	}

	/*
	 * ��ȡָ����ݵ�Ӫҵ��
	 * @param year ָ������ݣ�ʾ����2015��
	 * @return double ָ����ݵ�Ӫҵ����û�����������
	 */
	private double getTurnover(String year) {
		if(year==null||year.length()!=4){
			System.out.println("������ݴ���");
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

