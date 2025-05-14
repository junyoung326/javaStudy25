package ch02;

public class ForFloatConterExam {

	public static void main(String[] args) {
		// 초기화식에서 부동 소수점인 실수 방식을 사용하면 안된다.
		
		for(float x = 0.1f ; x < 1.0f ; x += 0.1f) {
			System.out.println(x);
		}

	}

}
