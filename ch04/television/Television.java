package ch04.television;

public class Television {
	static String company = "Samsung";
	static String model = "LED";
	static String info ; 
	
	static { // 정적 블록
		info = company + "-" + model;
	}
	
	int field1; // 인스턴스 필드
	void method1() { // 인스턴스 메소드
	}
	
	static int field2 ; // 정적 필드
	static void method2() { // 정적 메소드		
	}
	
	static { // 정적 블록
		//field1 = 10; // 인스턴스 필드 사용불가
		//method1(); // 인스턴스 메소드 사용불가
		field2 = 20;
		method2();
	}
	
	static void method3() { //정적 메소드
		Television tel = new Television();
		tel.field1 = 10; // 객체 생성하여 변수와 연결
		tel.method1(); // 인스턴스 멤버는 객체 필요
		//this.field1 = 10; // 컴파일 오류
		//this.method1() ; // 컴파일 오류
		field2 = 10;
		method2();
	}
	
	
	
}
