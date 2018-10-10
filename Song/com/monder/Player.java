package com.monder;

import java.util.Scanner;

public class Player {
	
	/**
	 * �����û�����ĸ�����
	 * @return
	 */
	public String getUserString(Scanner sc,String message) {
		String rV;
		while(true) {
			System.out.println("�����������"+message+":");
			rV= sc.next();
			if(rV==null||rV.equals("")) {
				System.out.println(message+"����Ϊ�գ�����������");
			}else {
				break;
			}
		}
		return rV;
	}
	
	/**
	 * ���ظ���ʱ��
	 * @param sc
	 * @return
	 */
	public double getUserNumber(Scanner sc){
		double rV;
		while(true){
			System.out.println("�����������ʱ����");
			rV = sc.nextDouble();
			if(rV<=0){
				System.out.println("ʱ������С�ڵ���0������������");
			}else{
				break;
			}
		}
		return rV;
	}

	
	public boolean addSong() {
		System.out.println("��ʼ��Ӹ���");
		Scanner sc = new Scanner(System.in);
		String songName = getUserString(sc,"����" );
		String singer = getUserString(sc,"����");
		double time = getUserNumber(sc);
		
		Song song = new Song(songName,singer,time);
		Master.listSong.add(song);
		return true;
		}
	

}
