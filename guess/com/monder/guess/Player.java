package com.monder.guess;

public class Player {
	
	public int num;	
	/**
	 * �����������ֵ��num
	 * @return �ɹ��������������true
	 */
	public boolean guess() {		
		num = (int)(Math.random()*10);
		return true;
		
	}
		

	

}
