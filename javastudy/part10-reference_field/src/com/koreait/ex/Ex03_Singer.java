package com.koreait.ex;

// 데이터클래스 Song
class Song {
	
	// Field
	String title;
	String genre;
	double playTime;
	
	// Constructor
	Song(String title, String genre, double playTime) {
		this.title = title;
		this.genre = genre;
		this.playTime = playTime;
	}
	
	// Method
	void printSong() {
		System.out.println("노래제목 : " + title + ", 장르 : " + genre + "(" + playTime + "분)");
	}
	
}

// 데이터클래스 Singer
class Singer {
	
	// Field
	String name;
	String company;
	Song song;
	
	// Constructor
	Singer(String name, String company, Song song) {
		this.name = name;
		this.company = company;
		this.song = song;
	}
	
	// Method
	void printSinger() {
		System.out.println("가수이름 : " + name);
		System.out.println("소속사 : " + company);
		song.printSong();
	}
	
}


public class Ex03_Singer {

	public static void main(String[] args) {
		
		Singer singer = new Singer("유산슬", "MBC", new Song("합정역 5번출구", "트로트", 3.5));
		singer.printSinger();

	}

}
