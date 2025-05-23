package ch02;

import java.util.Scanner;

public class CalculatorExam {
	// 간단한 계산기 프로그램 만들기
	// 입력받기 : 숫자 > 연산자 > 숫자
	// 연산자별로 메서드에 숫자를 넣기 (입력 받는 순서에 맞춰서 조금 귀찮지만 메서드에서 잘 해결하기)
	// 결과값 main메서드에서 출력해주기 (return을 받아서)
	// 완료 반복재생 가능하게 while문 사용하기 (다시 하시겠습니까? or 이어서 계산하시겠습니까?)
	
	static int plus(int x1, int x3) {
		int x4 = 0;
		x4 = x1 + x3;
		return x4;
	} // plus M end
	
	static int minus(int x1, int x3) {
		int x4 = 0 ;
		x4 = x1 - x3 ;
		return x4;
	} // minus M end
	
	static int times(int x1, int x3) {
		int x4 = 0 ;
		x4 = x1 * x3 ;
		return x4;
	} // times M end
	
	static int divide(int x1, int x3){
		int x4 = 0 ;
		x4 = x1 / x3 ;
		return x4;
	} // divide M end
	
	
	public static void main(String[] args) {
		
		int x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0 ; // 일단 변수 5개 만들자
		boolean run = true, run2 = true; // while문 boolean
		String y1 = "연산기호"; // 정답 표시용
		Scanner scInt = new Scanner(System.in); // 스캐너
		
		while (run) {
			if (x1 == 0) {
				System.out.println("**정수계산기**\n숫자를 입력해 주세요(int 범위 내에서만)\n>>");
				x1 = scInt.nextInt();
			}
			System.out.println("부호를 선택해 주세요\n1.+(더하기)\t2.-(빼기)\n3.(곱하기)\t4.(나누기)\n>>");
			x2 = scInt.nextInt();
			
			System.out.println("숫자를 입력해 주세요(int 범위 내에서만)\n>>");
			x3 = scInt.nextInt();
			run2 = true;
			
			switch(x2) {
			case 1 :
				x4 = plus(x1, x3); y1 = "+" ;
				break;
			case 2 :
				x4 = minus(x1, x3); y1 = "-";
				break;
			case 3 :
				x4 = times(x1, x3); y1 = "x";
				break;
			case 4 :
				x4 = times(x1, x3); y1 = "÷";
				break;
			// default는 생략하자
			} // switch(x2) end
			
			System.out.println("계산결과: " + x1 + " " + y1 + " " + x3 + " = " + x4);
			while (run2) { // while(run2)
				if (x4 != 0) {
					System.out.println("1. 종료하기\n2. 다시하기\n3. 이어서 계산하기\n>>>");
				} else {
					System.out.println("1. 종료하기\n2. 다시하기\n>>>");
				}
				x5 = scInt.nextInt();
				switch (x5) {
				case 2: 
					x1 = 0;
					x2 = 0;
					x3 = 0;
					run2 = false;
					break;
				case 3:
					x1 = x4;
					x2 = 0;
					x3 = 0;
					run2 = false;
					break;
				case 1:
					run = false; run2 = false; 
					break;
				default:
					System.out.println("숫자를 잘못 선택하셨습니다.\n다시 입력해주세요\n");
					
				} // 스위치문 종료
			} // while(run2)문 종료	
		} // while(run1)문 종료
	} // 메인 메서드 종료
} // 클래스 종료
