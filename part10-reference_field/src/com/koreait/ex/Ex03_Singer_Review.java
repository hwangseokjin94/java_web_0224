package com.koreait.ex;

class Song1{
	String title;
	String genre;
	double playTime;
	Song1(String title,String genre,double playTime){
		this.title = title;
		this.genre = genre;
		this.playTime=playTime;
	}
	
	void printSong() {
		System.out.println("노래제목"+title+"장르"+genre+"  "+playTime);
	}
	
	
}//song
class Singer1{
	
	String name;
	String company;
	Song1 song1;
	
	Singer1(String name, String company, Song1 song1){
		this.name=name;
		this.company=company;
		this.song1=song1;
	}
	void printSinger() {
		
		System.out.println("가수이름 "+name);  
		System.out.println("소속사 "+company);
		song1.printSong();
	}
	
	
	
}//singer




public class Ex03_Singer_Review {

	public static void main(String[] args) {
		Singer1 singer1 = new Singer1("유산슬","MBC",new Song1("합정역 5번출구","트로트",3.5));
		singer1.printSinger();
	}

}
