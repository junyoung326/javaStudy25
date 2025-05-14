package ch02;

import java.util.Scanner;

public class WhileSwitchIfExam {

	public static void main(String[] args) {
		// 성적처리 프로그램
		Scanner name = new Scanner(System.in) ; // 입력 도구 준비
		Scanner kor = new Scanner(System.in) ; 
		Scanner mat = new Scanner(System.in) ;
		Scanner eng = new Scanner(System.in) ;
		Scanner answer = new Scanner(System.in) ;

		int i = 0 ; // 반 인원수
		while (i<3) {
			i++; // 반 인원수 증가
			switch (i) {
			case 3 :	
				break;
			} // switch문 종료
			
			System.out.println(i);	
			System.out.println("이름을 작성해 주세요.");
			String stuName = name.next();
			System.out.println("국어 점수를 입력해 주세요.");
			int gradeKor = kor.nextInt();
			System.out.println("수학 점수를 입력해 주세요.");
			int gradeMat = mat.nextInt();
			System.out.println("영어 점수를 입력해 주세요.");
			int gradeEng = eng.nextInt();
			
			System.out.println(stuName + " 학생의 평균을 구하시겠습니까?");
			String myAnswer = eng.next();
			if (myAnswer.equalsIgnoreCase("yes")) {
				int avg = (gradeKor + gradeMat + gradeEng) / 3 ;
				System.out.println(stuName + " 학생의 평균은 " + avg + " 입니다.");
				if (avg >= 90) {
					char gradeNum = 'A' ;
					System.out.println(stuName + " 학생의 등급은 " + gradeNum + "입니다.");
				} else if (avg >= 80 && avg < 90) {
					char gradeNum = 'B' ;
					System.out.println(stuName + " 학생의 등급은 " + gradeNum + "입니다.");
				} else if (avg >= 70 && avg < 80) {
					char gradeNum = 'C' ;
					System.out.println(stuName + " 학생의 등급은 " + gradeNum + "입니다.");
				} else {
					char gradeNum = 'F' ;
					System.out.println(stuName + " 학생의 등급은 " + gradeNum + "입니다.");
				} // 등급 구하는 if문 종료
			} else {
				System.out.println("평균을 구하지 않습니다.");
			} // 학생 평균 구하는 if문 종료
			
			


		} // while문 종료


	} // 메인 메서드 종료

} // 클래스 종료
