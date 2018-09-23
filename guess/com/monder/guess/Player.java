package com.monder.guess;

public class Player {
	
	public int num;	
	/**
	 * 生成随机数赋值给num
	 * @return 成功生成随机数返回true
	 */
	public boolean guess() {		
		num = (int)(Math.random()*10);
		return true;
		
	}
		

	

}
