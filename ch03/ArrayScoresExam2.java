package ch03;

import java.util.Scanner;

public class ArrayScoresExam2 {

	public static void main(String[] args) {
		// 주메뉴 구현용
		Scanner mainSC = new Scanner(System.in);
		int select = 0;
		System.out.println("초기작업: 학생 수를 입력하세요.");
		System.out.print(">>>>>");
		int count = mainSC.nextInt(); // 학생수 등록
		String[] name = new String[count]; // 학생수로 학생 이름 테이블 작성
		byte[] engScores = new byte[count]; // 학생수로 영어 성적 테이블 작성
		byte[] korScores = new byte[count]; // 학생수로 국어 성적 테이블 작성
		byte[] totalScores = new byte[count]; // 학생수로 총점 성적 테이블 작성
		double[] avgScores = new double[count]; // 학생수로 평균 테이블 작성
		
		boolean run = true;
		while(run) {
			System.out.println("========MBC 교육센터 성적 관리 프로그램=======");
			System.out.println("1. 학생관리 | 2. 성적관리 | 3. 통계 | 4. 종료");
		    System.out.println("=============================");
		    System.out.print(">>>>>");
		    select = mainSC.nextInt(); // 1~4까지 정수 입력 후에 분기
		    switch(select) {
		    case 1 -> student(name);
		    case 2 -> scores(engScores, korScores, name);
		    case 3 -> totalScores(totalScores, engScores, korScores, name);
		    case 4 -> {
		    	System.out.println("성적처리 고생하셨습니다.");
		    	run = false;
		    } // 케이스 4 종료
		    
		    } // select 주 메뉴 스위치문 종료
 		    
		    
		    
		} // while문 종료

	} // 메인 메서드 종료

	static Object totalScores(byte[] totalScores, byte[] engScores, byte[] korScores, String[] name) {
		Scanner studentSC = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println("===================성적관리 메뉴====================");
			System.out.println("1. 전체 성적 처리 | 2. 개인 성적 검색 | 3. 메인메뉴");
			System.out.println("=====================================");
			System.out.println(">>>");
			int select = studentSC.nextInt();
			switch(select) {
			case 1 :
				totalScores2(totalScores, engScores, korScores, name);
				break;
			case 2 : 
				searchScores2(totalScores, engScores, korScores, name);
				break;
			case 3 : 
				System.out.println("메인 메뉴로 돌아갑니다.");
				run = false;
				break;
			} // 스위치문 종료
		} // while문 종료
		
		return null;
	} // totalScores 메서드 종료

	private static void searchScores2(byte[] totalScores, byte[] engScores, byte[] korScores, String[] name) {
		// TODO Auto-generated method stub
		
	} // searchScores2 메서드 종료

	private static void totalScores2(byte[] totalScores, byte[] engScores, byte[] korScores, String[] name) {
		// TODO Auto-generated method stub
		
	} // totalScores2 메서드 종료

	static Object scores(byte[] engScores, byte[] korScores, String[] name) {
		
		return null;
	} // scores 메서드 종료

	private static Object student(String[] name) {
		
		return null;
	} // student 메서드 종료

} // 클래스 종료
