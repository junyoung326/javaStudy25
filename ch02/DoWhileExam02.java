package ch02;

import java.util.Scanner;

public class DoWhileExam02 {

	public static void main(String[] args) {
		// 업앤다운 게임 만들기
		// 컴퓨터가 랜덤 숫자를 생성한다. (1~50)
		// 사용자가 숫자를 입력한다.
		// 컴퓨터가 랜덤숫자를 판단하여 up/down을 알려준다.
		// 사용자의 숫자와 컴퓨터의 랜덤숫자가 일치하면 프로그램 종료와 함께 당첨 사실을 알린다.
		// 3번 안에 성공 시 상품 증정용 코드 추가

		int answer = (int) (Math.random() * 50) + 1; // 컴퓨터가 랜덤 숫자를 생성한다. (1~50)
		Scanner input = new Scanner(System.in); // 키보드로 입력 받는 객체 생성
		int question = 0; // 사용자가 입력하는 숫자 보관용
		int hits = 0; // 카운트용

		System.out.println("===================");
		System.out.println("업앤다운 게임에 오신 걸 환영합니다.");
		System.out.println("3번 안에 맞추면 상품을 제공합니다.");
		System.out.println("상품 제공은 관리자에게 문의하세요.");
		System.out.println("===================");

		do {
			System.out.println("1부터 50 사이의 숫자를 입력하세요.");
			question = input.nextInt(); // 사용자가 숫자를 키보드로 입력한다.
			hits++; // 키보드로 입력한 횟수 카운트용
			if (question > answer) { // 사람이 쓴 숫자가 크니 답은 아래쪽에 있다.
				System.out.println("down");
			} else if (question < answer) { // 사람이 쓴 숫자가 작으니 답은 위쪽에 있다.
				System.out.println("up");
			} // if문 종료
		} while (question != answer); // do-while문 종료
		// 랜덤 숫자와 사용자가 입력한 숫자가 같지 않으면 do문으로 올라감.
		// 랜덤 숫자와 사용자가 입력한 숫자가 같으면 아래로 내려옴.
		System.out.println("정답입니다. " + answer);
		System.out.println("고객님이 맞춘 횟수는 : " + hits + "번 입니다.");
		if (hits <= 3) {
			System.out.println("상품 수령: 관리자가 연락을 드립니다.");
		} else {
			System.out.println("상품 수령 실패 : 다음 번 기회는 없습니다~~!");
		} // if문 종료

	} // 메인 메서드 종료

} // 클래스 종료
