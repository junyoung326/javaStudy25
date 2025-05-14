package ch01;

import java.util.Scanner;

public class LogicalOperatorExam {

	public static void main(String[] args) {
		// 논리연산자는 곱, 합, 부정으로 이루어진다.
		// 논리 곱은 & &&으로 비교하며 boolean 타입으로 결과를 산출한다.
		
		Scanner input = new Scanner(System.in); // 키보드 입력을 받을 객체 생성
		System.out.println("정수를 입력하시면 대소문자나 숫자를 판단합니다. :");
		
		int charCode = input.nextInt(); // 키보드로 입력 받은 값을 charCode 변수에 넣음
		
		if( (charCode>=65) & (charCode<=90) ) { // charCode값이 65 이상이고 90 이하이면
			System.out.println("입력값은 대문자입니다. : " + ((char)charCode));
			// 위 조건이 참일 때 출력 값
			
		}else if( (charCode>=97) && (charCode<=122) ) { // charCode값이 97 이상이고 122 이하이면
			System.out.println("입력값은 소문자입니다. : " + ((char)charCode));
	
		}else if( !(charCode < 48) && !(charCode > 57) ) { // NAND
		//}else if( (charCode >= 48) && (charCode <= 57) ) { // NAND
			// 48보다 작지 않고 57보다 크지 않은
			System.out.println("입력값이 숫자입니다. : " + ((char)charCode) ) ;
			// 48~57값은 유니코드표에 숫자임을 판단
			
		}else {
			System.out.println("대문자나 숫자가 아닙니다.");
		} // if문 종료
		
		


	} // main 메서드 종료

} // class 종료
