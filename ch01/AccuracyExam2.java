package ch01;

public class AccuracyExam2 {

	public static void main(String[] args) {
		int apple = 1;
		//double pieceUnit = 0.1 ;
		int totalPieces = apple * 10 ; 
		int number = 7 ;
		int temp = totalPieces - number ;
		
		// double result = apple - number*pieceUnit ;
		double result = temp / 10.0 ; // 3조각을 소수점으로 표현 -> 나누기 10.0
		// System.out.println(number*pieceUnit);
		
		System.out.println("사과 한 개에서");
		System.out.println("0.7조각을 빼면");
		System.out.println(result + "조각이 남는다.");

	}

}
