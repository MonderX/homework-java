package com.monder;

import java.util.Scanner;

public class Drive{

	public Master master;

	public Player player;

	public Drive(){
		master = new Master();
		player = new Player();
	}

	public static void main(String[] args){
		Drive d = new Drive();
		while(true){
			System.out.println("������Ҫѡ��Ľ�ɫ��1 �����ˣ�2 �û���");
			Scanner sc = new Scanner(System.in);
			String message = sc.next();
			if("1".equals(message)){
				d.master.play();
			}else if("2".equals(message)){
				d.player.addSong();
			}else{
				System.out.println("ѡ�����");
			}
		}
	}

}
