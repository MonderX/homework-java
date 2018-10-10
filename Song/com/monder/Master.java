package com.monder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Master{

	public static List<Song> listSong;  //�����б�

	/**
	  * ��ʼ��listSong
	  */
	public Master(){
		listSong = new ArrayList<>();
	}

	/**
	  * ���Ÿ����� 
	  * @return �ɹ����ŷ���true������ʧ�ܻ����б����޿ɲ��ŵĸ�����������false
	  */
	public boolean play(){
		if(listSong.size()==0){
			System.out.println("�޿ɲ��ŵĸ���");
			return false;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("����Ҫ˳�򲥷Ż�����ѡ���ţ�˳������1����ѡ����2����");
		String message = sc.next();
		if("1".equals(message)){
			playerOneSong(0);
		}else if("2".equals(message)){
			System.out.println("��ѡ��Ҫ���ŵĸ�����ţ���ѡ���1~"+listSong.size());
			if(sc.hasNextInt()){
				int number = sc.nextInt();
				if(number>=1&&number<=listSong.size()){
					playerOneSong(number-1);
				}else{
					System.out.println("���ų���Χ��");
					return false;
				}
			}else{
				System.out.println("�������");
				return false;
			}
		}else{
			System.out.println("������ѡ����");
			return false;
		}
		return true;
	}

	public void playerOneSong(int number){
		Song song = listSong.get(number);
		System.out.println("����"+song.singer+"�ӳ���"+song.songName+"����ʱ��"+song.time);
		listSong.remove(number);
	}

}