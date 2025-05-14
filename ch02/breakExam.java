package ch02;

public class breakExam {

	public static void main(String[] args) {
		int i = 0 ;
		while (true) {
			int num = (int)(Math.random()*45) + 1 ;
			System.out.println("오늘의 로또 번호 : " + num);
			i++; // 횟수
			if( i == 6 ) {
				System.out.println("프로그램 종료");
				break;
			} // if문 종료
		} // while문 종료

	} // 메인 메서드 종료

} // 클래스 종료
