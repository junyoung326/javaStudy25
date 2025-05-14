package ch02;

public class BreakOutterExam {

	public static void main(String[] args) {
		// break문에 라벨을 붙이면 반복코드 종료시점을 정할 수 있다.
		for (char upper = 'A' ; upper <= 'Z' ; upper++) { //A~Z까지 반복용 코드
			Outter : for(char lower = 'a' ; lower <= 'z' ; lower++) { // a~z까지 반복용 코드
				
				System.out.println(upper + "-" + lower ); // 출력
				if(lower == 'c') { // c가 나오면 break문 실행
					break Outter; // Outter는 라벨문으로 break의 범위를 결정
				}
			} // 소문자 반복문 종료
		} // 대문자 반복문 종료

	} // 메인 메서드 종료

} // 클래스 종료
