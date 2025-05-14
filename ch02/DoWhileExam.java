package ch02;

import java.util.Scanner;

public class DoWhileExam {

	public static void main(String[] args) {
		System.out.println("메시지를 입력하세요.");
		System.out.println("프로그램을 종료하려면 q를 입력하세요 : ");
		
		Scanner in = new Scanner(System.in);
		String inputString; // 키보드로 입력 받은 값 저장용
		
		do {
			System.out.println(">>>");
			inputString = in.nextLine(); //String 값을 입력 받는다.
			System.out.println("전송값 : " + inputString);
		} while (!inputString.equals("q"));
		System.out.println("------------");
		System.out.println("프로그램 종료");
		System.out.println("------------");

	} // 메인 메서드 종료

} // 클래스 종료
