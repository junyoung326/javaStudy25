package ch01;

import java.util.Scanner; // 외부 라이브러리 -> 사용자의 입력을 받음

public class LogicalExam {

	public static void main(String[] args) {
		// 논리적인 연산자는 크게 5가지 유형이 있다.
		// & : 논리곱 -> ~이고 (2가지 변수가 모두 참일 경우 참)
		// | : 논리합 -> ~이거나 (2가지 중 한 개라도 참이면 참)
		// ! : 논리 부정 -> 참과 거짓을 반전한다.
		// ^ : 배타적 논리합 -> 논리합의 마지막인 1+1 0으로 결론이 난다.
		
		String loginid = "ljy";
		String loginpw = "1234";
		
		Scanner input = new Scanner(System.in); // 입력 도구 준비
		// 콘솔에 키보드로 값을 밀어 넣을 객체 생성함
		
		System.out.println("로그인할 id를 입력하세요 : ");
		String id = input.nextLine(); // 스캐너의 메서드, 동작
		System.out.println("입력하신 id는 : " + id + " 입니다.");

	} // main 메서드 종료

} // class 종료
