package ch02;

import java.util.Scanner;

public class SsnExam {

	public static void main(String[] args) {
		System.out.println("당신의 주민번호를 입력하시오(010101-1234567)>");
		Scanner in = new Scanner(System.in) ;
		String regNo = in.nextLine();
		char gender = regNo.charAt(7); // 8번째 글자를 추출
			// char은 숫자로 입력하면 안에 유니코드 매칭된 문자가 저장되고
			// 문자로 입력하면 안에 유니코드 매칭된 숫자가 저장이 됨.
			// charAt은 처음에 무조건 char 타입으로만 저장됨.
		    // System.out.println(gender);
		int genderReal = Character.getNumericValue(gender);
		
		switch(genderReal) {
		case 1 : case 3 : case 5 : case 7 :
			System.out.println("당신은 남자입니다.");
			break;
		case 2 : case 4 : case 6 : case 8:
			System.out.println("당신은 여자입니다.");
			break;
		default :
			System.out.println("당신은 외계인입니다!!!");
		} // switch문 종료
	} // main 메서드 종료

} // 클래스 종료
