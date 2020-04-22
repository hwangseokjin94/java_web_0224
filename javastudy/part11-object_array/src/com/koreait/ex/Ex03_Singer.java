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
		System.out.println("제목 : " + title + ", 장르 : " + genre + "(" + playTime + "분)");
	}
	
}

// 데이터클래스 Singer
class Singer {
	
	// Field
	String name;
	Song[] songList;
	int idx;
	
	// Constructor
	Singer(String name, int songCount) {
		this.name = name;
		if (songCount >= 1) {
			songList = new Song[songCount];
		}
	}
	
	// Method
	void addSong(Song song) {
		songList[idx++] = song;
	}
	void printSinger() {
		System.out.println("이름 : " + name);
		System.out.println("대표곡 목록 -----");
		for (Song song : songList) {
			song.printSong();
		}
	}
	
}

// 메인클래스
public class Ex03_Singer {

	public static void main(String[] args) {
		
		Singer singer = new Singer("유산슬", 2);
		
		singer.addSong( new Song("합정역 5번출구", "트로트", 3.5) );
		singer.addSong( new Song("사랑의 재개발", "트로트", 4.0) );
		
		singer.printSinger();		

	}

}
