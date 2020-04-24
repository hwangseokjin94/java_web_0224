package com.koreait.ex;

class Song {

	String title;
	String genre;
	double playtime;

	Song(String title, String genre, double playtime) {
		this.title = title;
		this.genre = genre;
		this.playtime = playtime;
	}

	void printSong() {
		System.out.println("제목 : " + title + " 장르: " + genre + "  플레이타임 :"+playtime);
	}
}


class Singer {
	String name;
	Song[] songList;
	int idx;

	Singer(String name, int songCount) {
		this.name = name;
		if (songCount >= 1) {
			songList = new Song[songCount];
		}
	}

	void addSong(Song song) {
		songList[idx++] = song;

	}

	void printSinger() {
		System.out.println("이름 :" + name);
		System.out.println("대표곡 목록 ===================");
		for (Song song : songList) {
			song.printSong();
		}
	}

}// singer



public class Ex03_Singer {
	public static void main(String[] args) {
		Singer singer = new Singer("유산슬",2);
		singer.addSong (new Song("합정역 5번출구","트로트",3.5));
		singer.addSong (new Song("사랑의 재게발","트로트",4.5));
		
		singer.printSinger();
	}
}
