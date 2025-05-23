package ch02;

import java.util.Scanner;

public class WhileSwitchIfExam {

	public static void main(String[] args) {
		// 성적처리 프로그램
		// 1. 교직원관리 -> 로그인 -> 학생 성적 입력 -> 학생 성적 수정 -> 학생 성적 삭제
		// 2. 학생관리 -> 로그인 -> 학생 성적 확인
		// while문 안에 switch메뉴문, 그 안에 if문 (CarRunExam 참고)
		Scanner name = new Scanner(System.in); // 입력 도구 준비
		Scanner kor = new Scanner(System.in);
		Scanner mat = new Scanner(System.in);
		Scanner eng = new Scanner(System.in);
		Scanner answer = new Scanner(System.in);
		Scanner manage = new Scanner(System.in);
		Scanner inputLogin = new Scanner(System.in);

		String teachId = new String("teacher25"); // 교직원 아이디
		String teachPw = new String("20250515"); // 교직원 비밀번호
		String stuId = new String("student25"); // 학생 아이디
		String stuPw = new String("20250505"); // 학생 비밀번호
		int avg = 0; // 학생 평균점수

		System.out.println("1. 교직원");
		System.out.println("2. 학생");
		System.out.print("(1~2)>>>>>");
		int myManage = manage.nextInt();
		switch (myManage) {
		case 1:
			System.out.println("== 교직원 메뉴로 진입 ==");
			System.out.println("== 로그인 ==");
			System.out.print("아이디를 입력해주세요. >>>");
			String myIdT = inputLogin.next(); // 교직원 아이디 시도를 키보드로 받아 myIdT에 저장
			if (myIdT == teachId) {
				System.out.print("비밀번호를 입력해주세요. >>>");
				String myPwT = inputLogin.next(); // 교직원 비밀번호 시도를 키보드로 받아 myPwT에 저장
				if (myPwT == teachPw) {
					System.out.println("로그인 성공!!!");
					System.out.println("1. 학생 성적 입력");
					System.out.println("2. 학생 성적 수정");
					System.out.println("3. 학생 성적 삭제");
					System.out.print("(1~3)>>>>>");
					int myManage2 = manage.nextInt();
					switch (myManage2) {
					case 1:
						System.out.println("== 학생 성적 입력 메뉴 진입 ==");
						System.out.println("이름을 작성해 주세요.");
						String stuName = name.next();
						System.out.println("국어 점수를 입력해 주세요.");
						int gradeKor = kor.nextInt();
						System.out.println("수학 점수를 입력해 주세요.");
						int gradeMat = mat.nextInt();
						System.out.println("영어 점수를 입력해 주세요.");
						int gradeEng = eng.nextInt();

						System.out.println(stuName + " 학생의 평균을 구하시겠습니까?");
						String myAnswer = answer.next();
						if (myAnswer.equalsIgnoreCase("yes")) {
							avg = (gradeKor + gradeMat + gradeEng) / 3;
							System.out.println(stuName + " 학생의 평균은 " + avg + " 입니다.");
							if (avg >= 90) {
								char gradeNum = 'A';
								System.out.println(stuName + " 학생의 등급은 " + gradeNum + "입니다.");
							} else if (avg >= 80 && avg < 90) {
								char gradeNum = 'B';
								System.out.println(stuName + " 학생의 등급은 " + gradeNum + "입니다.");
							} else if (avg >= 70 && avg < 80) {
								char gradeNum = 'C';
								System.out.println(stuName + " 학생의 등급은 " + gradeNum + "입니다.");
							} else {
								char gradeNum = 'F';
								System.out.println(stuName + " 학생의 등급은 " + gradeNum + "입니다.");
							} // 등급 구하는 if문 종료
						} else {
							System.out.println("평균을 구하지 않습니다.");
						} // 학생 평균 구하는 if문 종료
					case 2:
						System.out.println("== 학생성적수정 메뉴 진입 ==");

					case 3:
						System.out.println("== 학생성적삭제 메뉴 진입 ==");

					} // (myManage2) switch문 종료 
				} // 교직원 아이디 일치 if문 종료
			} // 교직원 비밀번호 일치 if문 종료

		case 2:
			System.out.println("== 학생 메뉴로 진입 ==");
			System.out.println("== 로그인 ==");
			System.out.print("아이디를 입력해주세요. >>>");
			String myIdS = inputLogin.next(); // 학생 아이디 시도를 키보드로 받아 myIdS에 저장
			if (myIdS.equals(stuId)) {
				System.out.print("비밀번호를 입력해주세요. >>>");
				String myPwS = inputLogin.next(); // 학생 비밀번호 시도를 키보드로 받아 myPwS에 저장
				if (myPwS.equals(stuPw)) {
					System.out.println("로그인 성공!!!");
					System.out.println("성적을 확인하시겠습니까?");
					String myAnswer = answer.next();
					if (myAnswer.equalsIgnoreCase("yes")) {
						System.out.println(name + " 님의 성적은\n국어: " + kor + "점\n수학: " + mat + "점\n영어: "+ eng + "점\n평균: " + avg + "점입니다." );
					} // 성적 확인 대답 if문 종료

				} // 학생 비밀번호 일치 if문 종료
			} // 학생 아이디 일치 if문 종료
		} // (myManage) switch문 종료 

	} // 메인 메서드 종료

	static int calAvg(int kor, int mat, int eng) {
		int avg = 0;
		avg = ((kor + mat + eng )/3);
		return avg;
	} // plus M end
} // 클래스 종료
