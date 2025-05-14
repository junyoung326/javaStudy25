package ch02;

import java.util.Scanner;

public class CarRunExam {

	public static void main(String[] args) {
		// 자동차 주행 프로그램 만들기!!!!
		// C -> 시동을 건다. (START)
		// R -> 계기판 정보 출력
		// U -> 주행
		// D -> 시동을 끈다. (END)
		
		Scanner input = new Scanner(System.in);
		boolean run = true ; // 시동을 켠다.
		int speed = 0 ; // 차량 속도
		final int MAXSPEED = 300 ; // 최고속도 상수 (변경 안 됨)
		final int MINSPEED = 0 ; // 최저속도 상수(변경 안 됨)
		// MAXSPEED = 400 ; 
		// The final local variable MAXSPEED cannot be assigned. It must be blank and not using a compound assignment
		
		System.out.println("람보르기니가 입고되었습니다.");
		System.out.println("시동을 켭니다.");
		System.out.println("현재 속도 : " + speed + "km/h");
		
		while(run) {
			// 무한 반복 중 메뉴가 출력
			System.out.println("=================");
			System.out.println("0. 시동 종료"); // 종료 성공
			System.out.println("1. 엑셀"); // 30키로 가속 + 300 이하 최대 성공!
			System.out.println("2. 브레이크");
			System.out.println("3. 멀티미디어");
			System.out.println("4. 주유하기");
			System.out.println("=================");
			System.out.println("(0~4 숫자입력) >>>	");
			int select = input.nextInt();
			
			switch(select) {
			case 0 :
				System.out.println("시동을 종료합니다.");
				run = false ; // while문 종료
				break;
			case 1 :
				System.out.println("가속을 진행합니다.");
				speed += 30;
				if(speed >= MAXSPEED) { // 현재속도가 최고속도보다 크거나 같으면!
					speed = MAXSPEED ;
				} //최대 속도일 경우 if문 종료, 300이상 출력 안 됨
				System.out.println("현재 속도 : " + speed + "km/h");
				break;
			case 2 : 
				System.out.println("감속을 진행합니다.");
				speed -= 10 ;
				if(speed <= MINSPEED) {
					speed = MINSPEED ;
				} // 최소 속도일 경우 if문 종료
				System.out.println("현재 속도 : " + speed + "km/h");
				break;
			case 3 :
				System.out.println("멀티미디어를 실행합니다.");
				break;
			case 4 :
				System.out.println("주유를 진행합니다.");
				break;
			} // switch문 종료
		}// while문 종료
		System.out.println("람보르기니 자동차가 사라집니다.");
	} // main 메서드 종료

} // class 종료
