package com.monder.traffic;

public class Car extends Traffic{

	@Override
	protected void calculation(double distance) {
		name = "������";
		startTime = 20;
		endTime= 20;
		getTicket = 5;
		securityCheck = 2;
		waiting = 10;
		speed = 70;
		price = 0.32;
		allTime = startTime+ endTime+getTicket+securityCheck+waiting+(distance/speed)*60;
		allPrice = distance*price + 4;
		
	}

}
