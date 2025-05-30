package ch05.parent;

public class ChildExam {

	public static void main(String[] args) {
		Child ch = new Child();
		Parent pr = ch ; // 자동타입 변환
		
		pr.method1();
		pr.method2();
		// pr.method3(); // 자식에 있는 method3는 호출 불가

	}

}
