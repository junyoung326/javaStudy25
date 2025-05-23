package ch03;

public class ArrayCreateExam2 {

	public static void main(String[] args) {
		int sum = add(new int[] { 70, 80, 90 } );
		System.out.println("총합 : " + sum);
		
		int total1 = add(new int[] { 70, 80, 90 } );
		int total2 = add(new int[] { 60, 70, 80 } );
		int total3 = add(new int[] { 90, 80, 50 } );
		System.out.println("1반의 총합 : " + total1);
		System.out.println("2반의 총합 : " + total2);
		System.out.println("3반의 총합 : " + total3);



	} // 메인 메서드 종료

	static int add(int[] scores) {
		int sum = 0 ;
		for (int i = 0; i < 3 ; i++) {
			sum += scores[i];
		} // for문 종료
		return sum;
	} // add 메서드 종료

} // class 종료
