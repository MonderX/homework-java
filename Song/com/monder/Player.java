package com.monder;

import java.util.Scanner;

public class Player {
	
	/**
	 * 返回用户输入的歌曲名
	 * @return
	 */
	public String getUserString(Scanner sc,String message) {
		String rV;
		while(true) {
			System.out.println("请输入歌曲的"+message+":");
			rV= sc.next();
			if(rV==null||rV.equals("")) {
				System.out.println(message+"不能为空，请重新输入");
			}else {
				break;
			}
		}
		return rV;
	}
	
	/**
	 * 返回歌曲时长
	 * @param sc
	 * @return
	 */
	public double getUserNumber(Scanner sc){
		double rV;
		while(true){
			System.out.println("请输入歌曲的时长：");
			rV = sc.nextDouble();
			if(rV<=0){
				System.out.println("时长不能小于等于0，请重新输入");
			}else{
				break;
			}
		}
		return rV;
	}

	
	public boolean addSong() {
		System.out.println("开始添加歌曲");
		Scanner sc = new Scanner(System.in);
		String songName = getUserString(sc,"歌曲" );
		String singer = getUserString(sc,"歌手");
		double time = getUserNumber(sc);
		
		Song song = new Song(songName,singer,time);
		Master.listSong.add(song);
		return true;
		}
	

}
