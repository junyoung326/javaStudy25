package ch01;


public class LocalVariableExam {

	public static void main(String[] args) {
		// 변수의 사용범위는 괄호(블럭) 안에서 효과를 발휘함
		
		int v1 = 5 ;
		int v2 = 0 ; // 변수 선언은 위에서 다 할 것!!
		if(v1>10) { // if는 비교문으로 ()값이 참치면 블럭을 실행함.
			//int v2 = v1 + 10;
			v2 = v1 +10 ;
			
		}
		int v3 = v1 + v2 + 5 ;
		
		System.out.println("v1의 값 : " + v1);
		System.out.println("v2의 값 : " + v2);
		System.out.println("v3의 값 : " + v3);

	}

}
