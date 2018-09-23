package com.monder.guess;

import java.util.Scanner;

/**
 * 猜数字
 * @author Mponder
 *
 */
public class GuessGame {
	public Player player1;
	public Player player2;
	public Player player3;
	public int money;
	
	/**
	 * 初始化
	 */
	public GuessGame() {	
		player1 = new Player();
		player2 = new Player();
		player3 = new Player();
		money = 0;


	}
	
	/**
	 * 游戏主程序
	 */
	public void startGame() {
		player1.guess();
		player2.guess();
		player3.guess();
		while(true) {
			System.out.println("请输入你要猜测的数字");
			Scanner sc = new Scanner(System.in);
			int PlayerNum = sc.nextInt();
			if(PlayerNum<0||PlayerNum>9){
				System.out.println("请按输入0~9的数字！");
				continue;
			}
			/**
			 * 对比输入的数字与随机数是否相同
			 */
			if(player1.num != PlayerNum&&player1.num != PlayerNum&&player1.num != PlayerNum) {
				money = money-1;
				System.out.print("不好意思，猜错了，请继续");
			}else {
				money = money+1;
				break;
			}
		}
		if(money>0) {
			System.out.println("恭喜你获得了"+money+"元");
		}else if(money==0) {
			System.out.println("哎呀，没赢没输啊");
		}else {
			System.out.println("不好意思，你输掉了"+money+"元");
		}
		
	}

}
