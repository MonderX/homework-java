package com.monder.guess;

import java.util.Scanner;

/**
 * ������
 * @author Mponder
 *
 */
public class GuessGame {
	public Player player1;
	public Player player2;
	public Player player3;
	public int money;
	
	/**
	 * ��ʼ��
	 */
	public GuessGame() {	
		player1 = new Player();
		player2 = new Player();
		player3 = new Player();
		money = 0;


	}
	
	/**
	 * ��Ϸ������
	 */
	public void startGame() {
		player1.guess();
		player2.guess();
		player3.guess();
		while(true) {
			System.out.println("��������Ҫ�²������");
			Scanner sc = new Scanner(System.in);
			int PlayerNum = sc.nextInt();
			if(PlayerNum<0||PlayerNum>9){
				System.out.println("�밴����0~9�����֣�");
				continue;
			}
			/**
			 * �Ա������������������Ƿ���ͬ
			 */
			if(player1.num != PlayerNum&&player1.num != PlayerNum&&player1.num != PlayerNum) {
				money = money-1;
				System.out.print("������˼���´��ˣ������");
			}else {
				money = money+1;
				break;
			}
		}
		if(money>0) {
			System.out.println("��ϲ������"+money+"Ԫ");
		}else if(money==0) {
			System.out.println("��ѽ��ûӮû�䰡");
		}else {
			System.out.println("������˼���������"+money+"Ԫ");
		}
		
	}

}
