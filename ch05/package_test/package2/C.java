package ch05.package_test.package2;

import ch05.package_test.package1.A;

public class C {
	// 필드
	A a1 = new A(true); // public으로 접근 가능
	//A a2 = new A(1); // default로 다른 패키지 접근 불가
	//A a3 = new A("문자열"); // private 생성자로 접근 불가
	// private는 개인적으로 사용하는 것이라 접근 불가
	
	public C(){ // C 생성자 생성
		A a = new A(); // A 객체 생성
		a.field1 = 1; // public 접근 제한
		// a.field2 = 2; // default 접근 제한
		// a.field3 = 3; // private 접근 제한
		a.method1(); // public 접근 제한
		//a.method2(); // default 접근 제한
		//a.method2(); // private 접근 제한
	} // public을 제외한 모든 접근제한은 불가 (다른 패키지임)
}