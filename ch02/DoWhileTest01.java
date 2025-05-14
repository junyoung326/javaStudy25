package ch02;

import java.util.Scanner;

public class DoWhileTest01 {

	public static void main(String[] args) {
		int input = 0 , answer = 0 ;
		
		answer = (int)(Math.random()*31) + 1 ; // 1~31까지의 랜덤정수를 넣는다.
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("1과 31사이의 정수를 입력하세요");
			input = scanner.nextInt();
			
			if( input > answer ) {
				System.out.println("down");
			} else if (input < answer) {
				System.out.println("up");
			} // if문 종료
			
		} while (input != answer); // do-while문 종료
		System.out.println("정답입니다. " + answer);

	} // 메인 메서드 종료

} // 클래스 종료
