package ch01;

public class AccuracyExam2 {

	public static void main(String[] args) {
		int apple = 1;
		//double pieceUnit = 0.1 ;
		int totalPieces = apple * 10 ; 
		int number = 7 ;
		int temp = totalPieces - number ;
		
		// double result = apple - number*pieceUnit ;
		double result = temp / 10.0 ; // 3������ �Ҽ������� ǥ�� -> ������ 10.0
		// System.out.println(number*pieceUnit);
		
		System.out.println("��� �� ������");
		System.out.println("0.7������ ����");
		System.out.println(result + "������ ���´�.");

	}

}
