package ch01;

public class CompareOperationExam {

	public static void main(String[] args) {
		int num1 = 10 ;
		int num2 = 10 ;
		boolean result1 = (num1 == num2) ; // 같은지 검사
		boolean result2 = (num1 != num2) ; // 다른지 검사
		boolean result3 = (num1 <= num2) ; // num1이 이하인지
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
		
		char char1 = 'A' ; // int 65값
		char char2 = 'B' ; // int 66값
		boolean result4 = (char1 < char2) ; // true
		System.out.println("result4 : " + result4);
		
		System.out.println("------------------");

		int v2 = 1 ; // 정수 -> double
		double v3 = 1.0 ; // 실수
		System.out.println(v2==v3); // 1이 1.0과 같은지 비교 출력
		// 비교연산자도 연산을 수행하기 전에 타입변환을 통해 큰 타입으로 일치시킨다.
		
		double v4 = 0.1 ;
		float v5 = 0.1F ; // 지수와 가수를 사용하는 부동소수점 연산으로 근사값이 표현
		System.out.println(v5);
		System.out.println(v4 == v5); //false
		System.out.println((float)v4 == v5); 
		System.out.println((int)(v4*10) == (int)(v5*10)); 
		


	}

}
