package ch02;

public class ForSumExam {

	public static void main(String[] args) {
		// 1부터 100까지의 합을 구해본다. 1+2+3+...100 = sum / 5050
		int sum = 0 ; // 누적합계를 구하는 변수를 선언
		
		for (int i = 1 ; i <= 100; i++) { // 1~100까지의 증가값
			sum += i ;
			// sum = sum + i ;
		} // for문 종료
		System.out.println("1~100까지의 합 : " + sum);
		
		System.out.println("===================");
		
		int sum2 = 0 ; // 누적합계를 구하는 변수를 선언
		int i2 = 1;
		for ( ; i2 <= 500; i2++) { // 1~100까지의 증가값
			sum2 += i2 ;
			// sum2 = sum2 + i2 ;
		} // for문 종료
		
		System.out.println("1~" + (i2-1) + " 까지의 합 : " + sum2);
	} // 메인 메서드 종료

} // 클래스 종료
