package ch01;

public class CastingExam {

	public static void main(String[] args) {
		int intValue = 100 ;
		byte byteValue = (byte) intValue ; // int(4) -> byte(1) 강제타입변환
		System.out.println(intValue);
		System.out.println(byteValue);
		
		intValue = 44032 ;
		char charValue = (char)	intValue; // int(4) -> char(2) 강제타입변환
		System.out.println(charValue);
		
		double doubleValue = 3.14 ;
		intValue = (int)doubleValue; //double(8) -> int(4) 강제타입변환
		System.out.println(intValue);
		
		int i = 128 ;
		byte b = (byte) i ; // int를 byte로 강제타입변환
		System.out.println(b);
		
		System.out.println("======================");
		int num1 = 123456780 ;
		int num2 = 123456780 ;
		
		double num3 = num2 ;
		num2 = (int) num3 ;
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		
		int result = num1 - num2 ;
		System.out.println(result);

	}

}
