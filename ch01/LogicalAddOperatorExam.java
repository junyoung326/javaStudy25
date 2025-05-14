package ch01;

public class LogicalAddOperatorExam {

	public static void main(String[] args) {
		
		int value = 8;
		if( (value%2==0) | (value%3==0) ) {
			System.out.println("2 또는 3의 배수입니다." + value );
		} // if문 종료
		if( (value%2==0) && (value%3==0) ) {
			System.out.println("2배수이고 3의 배수입니다." + value );
		}

	}

}
