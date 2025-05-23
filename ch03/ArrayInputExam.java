package ch03;

import java.util.Scanner;

public class ArrayInputExam {

	public static void main(String[] args) {
		// 키보드로 입력 받은 값을 배열에 저장 후 CRUD 테스트
		// C 성적을 입력
		// R 성적을 보기 (전체 보기, 1개 보기)
		// U 성적을 수정하기
		// D 성적을 삭제하기
		// 개선사항 -> 성적 입력 시 NULL값을 보고 넣어보기
		
		Scanner inputInt = new Scanner(System.in);
		
		System.out.println("====== 엠비씨 성적처리 =====");
		System.out.println("학생 수를 입력해주세요!!!");
		System.out.println(">>>");
		int count = inputInt.nextInt(); // 학생 수
		System.out.println(count + "명의 학생 성적을 입력하겠습니다.");
		
		String[] names = new String[count]; // 이름 배열
		int[] kors = new int[count];        // 국어점수 배열 
		int[] mats = new int[count];        // 수학점수 배열 
		int[] engs = new int[count];        // 영어점수 배열 
		// 국어 영어 수학 점수의 배열을 학생명 수만큼 만듦.
		
		boolean run = true ; 
		
		while(run) {
			System.out.println("======= 성적처리 =======");
			System.out.println("1. 성적입력");
			System.out.println("2. 전체성적보기");
			System.out.println("3. 개인성적보기");
			System.out.println("4. 성적수정하기");
			System.out.println("5. 성적삭제하기");
			System.out.println("9. 성적프로그램 종료");
			System.out.print(">>>");
			int select = inputInt.nextInt(); // 성적처리 메뉴 선정
			
			switch(select) {
			case 1 :
				System.out.println("성적입력 화면입니다.");
				//메서드 생성할 때는 입력 값과 출력 값을 먼저 생각해야 한다.
				scoreAdd(names, kors, mats, engs);
				break;
			}

		} // 성적처리 while문 종료

		
	} // main 메서드 종료

	static void scoreAdd(String[] names, int[] kors, int[] mats, int[] engs) {
		// main에서 만든 배열 4개를 키보드로 값을 넣는다.
		Scanner inputStr = new Scanner(System.in);
		
	}

} // 클래스 종료
