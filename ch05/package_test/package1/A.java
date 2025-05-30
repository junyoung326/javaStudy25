package ch05.package_test.package1;

public class A {
	//필드
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	
	public int field1; //public 접근 제한
	int field2; // default 접근 제한
	private int field3; // private 접근 제한
	
	//생성자 오버로딩
	public A(boolean b) {} // public 접근 제한
	A(int b) {} //default 접근 제한
	private A(String s) {} // private 접근 제한
	//생성자
	public A() {
		field1 = 1; //public 접근 제한
		field2 = 2; // default 접근 제한
		field3 = 3; // private 접근 제한

	method1();
	method2();
	method3();
	}
	
	//메소드
	public void method1() {} // public 메소드
	void method2() {} // default 메소드
	private void method3() {} // private 메소드
		
	
} // 자신의 생성자는 자신 필드에 모두 접근을 할 수 있다.
