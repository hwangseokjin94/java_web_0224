package com.koreait.ex2;

class Song{
	String title ;
	String genre;
	double playtime;
	
	Song(String title , String genre , double playtime){
		this.title =title;
		this.genre = genre ; 
		this.playtime = playtime;
				
	}
	void printSong() {
		System.out.println("제목 : " + title + " 장르: " + genre + "  플레이타임 :"+playtime);
	}
	
	
	
}
class Singer extends Song {
	String name;
	String company;
	Singer (String name ,String company, String title , String genre , double playtime){
		super(title, genre, playtime);
		this.name = name;
		this.company =company;
	}
	
	void printStinger() {
		printSong();
		System.out.println("가수 = "+name+"소속사"+company);
	}
	
	
}




public class Ex03_Singer {

	public static void main(String[] args) {
		Singer singer = new  Singer("유재석","MBC", "합정역", "트로트", 3.5);
		singer.printStinger();

	}

}
