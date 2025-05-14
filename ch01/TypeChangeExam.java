package ch01;

public class TypeChangeExam {

	public static void main(String[] args) {
		byte byteValue = 10 ;
		int intValue = byteValue ; // 자동타입변환
		System.out.println(intValue);  // 10이 출력
		// byte byteValue1 = intValue ; 큰 타입에서 작은 타입은 오류
		
		char charValue = '가' ;
		intValue = charValue ;
		System.out.println("가의 유니코드 값 : " + intValue);
		
		intValue = 500;
		long longValue = intValue ; // int(4)를 큰 타입인 long(8)로 변환
		System.out.println(longValue);
		
		intValue = 200 ;
		double doubleValue = intValue ; //int(4)를 큰 타입인 double(8)로 변환
		System.out.println(doubleValue);

	}

}
   