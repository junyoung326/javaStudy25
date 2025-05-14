package ch02;

import java.util.Scanner;

public class IfExam {

	public static void main(String[] args) {
		// if(조건문) {  실행문  }
		//    조건문에 true가 처리되면 중괄호 안쪽이 실행된다.
		//    조건문에 false가 처리되면 중괄호 안쪽이 실행되지 않는다.
		
		Scanner input = new Scanner(System.in);
		// 키보드로 입력받을 수 있는 객체를 생성하여 input 변수에 연결
		
		System.out.println("귀하의 성함을 입력하세요.");
		System.out.print(">>>");
		String name = input.next(); // 키보드로 입력 받은 이름을 name 변수에 넣음
		
		System.out.println("귀하의 국어 점수를 입력하세요.");
		System.out.print(">>>");
		int scoreKor = input.nextInt(); // 키보드로 입력 받은 국어 점수를 score에 넣음
		
		if (scoreKor > 0 && scoreKor <= 100) { //0보다 크거나 100이하이면 true
			if(scoreKor >= 90) { //score 변수에 입력된 값이 90 이상이냐?
				System.out.println(name + "님이 입력하신 점수가 90점 이상입니다.");
				System.out.println("점수 : " + scoreKor + ": 등급 (A)");				
			} else if (scoreKor >= 80) {
				System.out.println(name + "님이 입력하신 점수가 80 ~ 89점 이상입니다.");
				System.out.println("점수 : " + scoreKor + ": 등급 (B)");			
			} else if (scoreKor >= 70) {
				System.out.println(name + "님이 입력하신 점수가 70 ~ 79점 이상입니다.");
				System.out.println("점수 : " + scoreKor + ": 등급 (C)");			
			} else if (scoreKor >= 60) {
				System.out.println(name + "님이 입력하신 점수가 60 ~ 69점 이상입니다.");
				System.out.println("점수 : " + scoreKor + ": 등급 (D)");			
			} else {
				System.out.println(name + "님이 입력하신 점수가 낮아 등급 F로 결정됩니다.");
				System.out.println("점수 : " + scoreKor + ": 등급 (F)");			
			} // 정상값이 입력되었을 때 실행문
		} else {
			System.out.println(name + "님 입력값을 확인해 주세요");
			System.out.println("현재 입력값은 " + scoreKor + "입니다.");
		}
		
		System.out.println("-----------------------");
		
		System.out.println("귀하의 수학 점수를 입력하세요.");
		System.out.print(">>>");
		int scoreMat = input.nextInt(); // 키보드로 입력 받은 수학 점수를 score에 넣음
		
		if (scoreMat > 0 && scoreMat <= 100) { //0보다 크거나 100이하이면 true
			if(scoreMat >= 90) { //score 변수에 입력된 값이 90 이상이냐?
				System.out.println(name + "님이 입력하신 점수가 90점 이상입니다.");
				System.out.println("점수 : " + scoreMat + ": 등급 (A)");				
			} else if (scoreMat >= 80) {
				System.out.println(name + "님이 입력하신 점수가 80 ~ 89점 이상입니다.");
				System.out.println("점수 : " + scoreMat + ": 등급 (B)");			
			} else if (scoreMat >= 70) {
				System.out.println(name + "님이 입력하신 점수가 70 ~ 79점 이상입니다.");
				System.out.println("점수 : " + scoreMat + ": 등급 (C)");			
			} else if (scoreMat >= 60) {
				System.out.println(name + "님이 입력하신 점수가 60 ~ 69점 이상입니다.");
				System.out.println("점수 : " + scoreMat + ": 등급 (D)");			
			} else {
				System.out.println(name + "님이 입력하신 점수가 낮아 등급 F로 결정됩니다.");
				System.out.println("점수 : " + scoreMat + ": 등급 (F)");			
			} // 정상값이 입력되었을 때 실행문
		} else {
			System.out.println(name + "님 입력값을 확인해 주세요");
			System.out.println("현재 입력값은 " + scoreMat + "입니다.");
		}
		
		System.out.println("-----------------------");
		
		System.out.println("귀하의 영어 점수를 입력하세요.");
		System.out.print(">>>");
		int scoreEng = input.nextInt(); // 키보드로 입력 받은 영어 점수를 score에 넣음
		
		if (scoreEng > 0 && scoreEng <= 100) { //0보다 크거나 100이하이면 true
			if(scoreEng >= 90) { //score 변수에 입력된 값이 90 이상이냐?
				System.out.println(name + "님이 입력하신 점수가 90점 이상입니다.");
				System.out.println("점수 : " + scoreEng + ": 등급 (A)");				
			} else if (scoreEng >= 80) {
				System.out.println(name + "님이 입력하신 점수가 80 ~ 89점 이상입니다.");
				System.out.println("점수 : " + scoreEng + ": 등급 (B)");			
			} else if (scoreEng >= 70) {
				System.out.println(name + "님이 입력하신 점수가 70 ~ 79점 이상입니다.");
				System.out.println("점수 : " + scoreEng + ": 등급 (C)");			
			} else if (scoreEng >= 60) {
				System.out.println(name + "님이 입력하신 점수가 60 ~ 69점 이상입니다.");
				System.out.println("점수 : " + scoreEng + ": 등급 (D)");			
			} else {
				System.out.println(name + "님이 입력하신 점수가 낮아 등급 F로 결정됩니다.");
				System.out.println("점수 : " + scoreEng + ": 등급 (F)");			
			} // 정상값이 입력되었을 때 실행문
		} else {
			System.out.println(name + "님 입력값을 확인해 주세요");
			System.out.println("현재 입력값은 " + scoreEng + "입니다.");
		}
		
		System.out.println("-----------------------");
		System.out.println("평균을 구하시겠습니까?");
		String scoreAvg = input.next();
		double avg = ((double)scoreKor + scoreMat + scoreEng)/3 ; 
		// 총점 계산 
		// 소수점까지 정확하게 표현하려면 변수 하나라도 double로 바꿔야 함.
		// 자동 변환이 되더라도 int로 먼저 계산한 후, double타입으로 바껴서 소수점 뒤가 0으로 표현됨.
		if (scoreAvg.equalsIgnoreCase("yes")) {
			System.out.println(name + "님의 평균은 " + avg + "점입니다.");
		}else if (scoreAvg.equalsIgnoreCase("no")) {
			System.out.println("평균을 구하지 않겠습니다.");
		}

		
	} // main 메서드 종료 -> 변수 input, name, score가 사라짐

} // class 종료 -> 메서드가 사라짐 -> 프로그램 종료
 