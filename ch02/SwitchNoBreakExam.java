package ch02;

public class SwitchNoBreakExam {

	public static void main(String[] args) {
		int time = (int)(Math.random()*6) + 6 ;
		System.out.println("[현재 시간은 : " + time + "시]");
		
		switch(time) {
		case 6 : 
			System.out.println("세수를 하고 조깅을 하고 아침을 먹습니다.");
		case 7 :
			System.out.println("출근 준비를 합니다.");
		case 8 :
			System.out.println("버스를 타고 출근을 합니다.");
		case 9 :
			System.out.println("수업 준비를 합니다.");
		case 10 : 
			System.out.println("결석자에게 전화를 합니다.");
		default :
			System.out.println("자바를 열심히 가르칩니다.");
		} // switch문 1 종료
		
		int time2 = (int)(Math.random()*10) + 8 ; // 8시 ~ 18시
		System.out.println("현재 시간 : " + time2 + "시");
		switch(time2) {
		case 9 :
			System.out.println("1교시 출석을 부르고 어제 배운 내용을 복습합니다.");
		case 10 :
			System.out.println("2교시 출석을 부르고 교사와 함께 실습을 진행합니다.");
		case 11 :
			System.out.println("3교시 출석을 부르고 교사와 함께 실습을 진행합니다.");
		case 12 :
			System.out.println("4교시 응용 실습을 진행합니다.");
		case 13 :
			System.out.println("점심 식사를 하고 오세요");
		case 14 :
			System.out.println("5교시 오후 수업을 시작합니다.");
		case 15 :
			System.out.println("6교시 오후 수업 실습을 진행합니다.");
		case 16 :
			System.out.println("7교시 오후 응욜 실습을 진행합니다.");
		case 17 :
			System.out.println("8교시 실습한 내용을 github에 백업합니다.");
			break;
		default :
			System.out.println((time) + "시 현재 일과시간이 아닙니다. 휴식하세요.");
			
		} // switch문 2 종료

	} // 메인 메서드 종료

} // 클래스 종료
