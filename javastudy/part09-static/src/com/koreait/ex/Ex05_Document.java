package com.koreait.ex;

// 데이터클래스 Document
class Document {
	
	// static 필드
	static int count = 0;
	
	// non-static 필드
	String docName;
	
	// Constructor
	Document() {
		docName = "새 텍스트 문서" + (++count) + ".txt";
	}
	Document(String docName) {
		this.docName = docName;
	}
	
	// Method
	void printDocument() {
		System.out.println(docName);
	}
	
}

public class Ex05_Document {

	public static void main(String[] args) {
		
		Document doc1 = new Document();  // 새 텍스트 문서1.txt
		Document doc2 = new Document();  // 새 텍스트 문서2.txt
		Document doc3 = new Document();  // 새 텍스트 문서3.txt
		Document doc4 = new Document("자바.txt");  // 자바.txt
		Document doc5 = new Document();  // 새 텍스트 문서4.txt
		
		doc1.printDocument();
		doc2.printDocument();
		doc3.printDocument();
		doc4.printDocument();
		doc5.printDocument();
		
	}

}
