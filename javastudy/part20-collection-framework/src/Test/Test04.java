package Test;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/*
Test04.java
Set을 이용하여 5X5 Bingo 배열을 생성하시오.
  */
//25개 랜덤보관하는것이 Set
//Set의 특징 순서유지가 안된다 순서없음.
public class Test04 {
	public static void main(String[] args) {
		// bingo크기
		final int SIZE = 5;
//		Set<Integer> set = new HashSet<Integer>(); Set을 순서대로뺸게아니라 크기 순으로 뺀거다... 순서대로뺴는 Set가 따로있다.

		Set<Integer> set = new LinkedHashSet<Integer>();// add 한 순서를 유지하려면 LinkedHashSet 클래스를 사용한다.
		
		
		// 1~25 사이 랜덤 생성
		while (set.size() < Math.pow(SIZE, 2)) {
			set.add((int) (Math.random() * 25) + 1);
		}
		
		// set ->bingo 2차원배열로 이동및 출력
		Iterator<Integer> itr = set.iterator();
		

		int[][] bingo = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {// Set은 인덱스 개념이없기떄문에Iterator
				bingo[i][j] = itr.next();// Set에있는걸 하나씩 옮겨주겠다.
				System.out.print(bingo[i][j]+"\t");
			}
			System.out.println();
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
