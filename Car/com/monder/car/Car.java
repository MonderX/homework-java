package com.monder.car;

import java.util.Scanner;

public class Car {
	public String brand;
	public int tank;
	public int oilConsumption;
	
	public Car() {
		brand = "奥拓";
		tank = 10;
		oilConsumption =10;
	}
	
	public void buildCar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入你需要的车的品牌");
		brand = sc.next();
		System.out.println("输入你需要的车的油箱大小");
		tank = sc.nextInt();
		System.out.println("输入你需要的车的油耗");
		oilConsumption = sc.nextInt();
	}
	
	public boolean gas() {
		System.out.println("油已加满");
		return true;
	}
	
	public boolean run() {
		System.out.println("车已开动");
		return true;
	}
	
	public void look() {
		System.out.println("你有一辆"+brand+"牌的车");
		System.out.println("你的车的油箱为 "+tank+" L");
		System.out.println("你的车的油耗为 "+oilConsumption+" L/km");
	}
	

}
