package ch01;

import java.util.Scanner;

public class StringEqualsExam {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String strval1 = "김기원"; // 김기원이라는 string 객체 생성
		String strval2 = "김기원"; // 같은 객체가 있어서 생성은 하지 않음
		String strval3 = new String("김기원"); // 새로운 객체를 생성
		
		System.out.println(strval1 == strval2);
		System.out.println(strval1 == strval3); // 같은 번지인지 물어본다.
		System.out.println("------------------------");
		System.out.println(strval1.equals(strval2)); // 값이 같은지 물어본다.
		System.out.println(strval2.equals(strval3)); // 값이 같은지 물어본다.

		
		System.out.println("------------------------");
		System.out.println("이름을 입력하세요: ");
		String name = in.nextLine();
		System.out.println("나이를 입력하세요: ");
		String age = in.nextLine();
		System.out.println("이메일을 입력하세요: ");
		String email = in.nextLine();
		
		System.out.println(name + "님의 나이는 " + age + "이며, e-mail은 " + email + "입니다.");
		

	}

}
