package ch05.package_test.package1;

public class B {
	// 필드
	A a1 = new A(true); // public 접근 제한
	A a2 = new A(1); // default 접근 제한
	//A a3 = new A("문자열"); // private 접근 제한
	// private는 개인적으로 사용하는 것이라 같은 패키지도 불가
	
	public B(){ // 생성자 호출
		A a = new A(); // A클래스에 객체 생성
		a.field1 = 1; // public 접근 제한
		a.field2 = 2; // default 접근 제한
		// a.field3 = 3; // 컴파일 에러 (private)
		a.method1(); // public 접근 제한
		a.method2(); // default 접근 제한
		a.method2(); // 컴파일 에러 (private)
	} // 같은 패키지에서는 private을 제외한 모든 접근 제한 허용
}
