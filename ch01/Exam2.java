package ch01;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = in.nextInt();
		System.out.println( (num % 2 == 0) ? "짝수" : "홀수");
	} // main 메서드 종료

}
