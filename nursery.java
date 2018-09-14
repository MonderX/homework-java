package com.monder.day1;

public class nursery {

	public static void main(String[] args) {
		int cnt;
		for(cnt = 99;cnt>0;cnt--) {
			if(cnt>1) {
				System.out.println(cnt + " bottles of beer on the wall," + cnt + " bottles of beer.");
				System.out.println("Take one down.");
				System.out.println("Pass it around");
				if(cnt-1==1) {
					System.out.println("1 bottle of beer on the wall");
				}else{
					System.out.println(cnt-1+" bottles of beer on the wall");
				}
			}else{
				System.out.println(cnt + " bottle of beer on the wall," + cnt + " bottle of beer.");
				System.out.println("Take one down.");
				System.out.println("Pass it around");
				System.out.println(cnt-1+" bottle of beer on the wall");
			}
		}	
	}
}
