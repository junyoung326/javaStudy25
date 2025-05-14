package ch02;

import java.util.Scanner;

public class IfSwitchExam {

	public static void main(String[] args) {
		Scanner id = new Scanner(System.in); // 입력 도구 준비
		Scanner pw = new Scanner(System.in);
		Scanner answer = new Scanner(System.in);
		Scanner newPw = new Scanner(System.in);

		String myId = new String("southkorea25");
		String myPw = new String("12345678");

		System.out.println("아이디를 입력해 주세요. >>> ");
		String verId = id.next();
		// String verPw = pw.next();

		switch (verId) {
		case "southkorea25":
			System.out.println("비밀번호를 입력해 주세요. >>>");
			String verPw = pw.next();
			switch (verPw) {
			case "12345678":
				System.out.println("로그인 완료!");
				System.out.println("비밀번호를 재설정하시겠습니까?");
				String myAnswer = answer.next();
				if (myAnswer.equalsIgnoreCase("yes")) {
					System.out.println("새로운 비밀번호를 설정해 주세요. >>>");
					String myNewPw = newPw.next();
					System.out.println("새로운 비밀번호는 " + myNewPw + "입니다.");
				} else {
					System.out.println("비밀번호를 변경하지 않습니다.");
				} // if문 종료
				break;
			default:
				System.out.println("로그인 실패!");
				break;
			} // 중첩 switch문 종료
		default:
			System.out.println("아이디가 맞지 않습니다.");
		}// 주 switch문 종료

	} // 메인 메서드 종료

} // 클래스 종료
