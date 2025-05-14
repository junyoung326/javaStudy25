package ch01;

public class Operations {

	public static void main(String[] args) {
		int x = -100;  //음수 100을 x에 넣는다.
		int result1 = +x ;  //음수에 +부호가 붙어서 부호가 유지된다.
		int result2 = -x ;   // 음수에 -부호가 붙어서 부호가 변경된다.
		System.out.println(result1);
		System.out.println(result2);
		
		short s = 100 ;
		// short result3 = -s ; 계산에 기본타입은 int이기 때문에 오류
		int result3 = -s ;
		System.out.println(result3);
		
		System.out.println("-----------------------");
		int x1 = 10 ;
		x1++ ; // x = x + 1 -> 11
		System.out.println("x1 = " + x1); 
		++x1 ; // x = x + 1 -> 12
		System.out.println("x1 = " + x1);   //12
		
		System.out.println("-----------------------");
		int y = 10 ;
		y-- ;  // y = y - 1 -> 9
		--y ;  // y = y - 1 -> 8
		System.out.println("y = " + y);
		
		System.out.println("-----------------------");
		int z = 10 ;
		int x2 = 10 ;
		z = x2++ ; // x값을 z에 넣고 x를 1증가 시킨다.
		System.out.println("z = " + z);
		System.out.println("x2 = " + x2);
		
		System.out.println("-----------------------");
		boolean play = true ; // 참값을 삽입
		System.out.println(play);
		
		play = !play;
		System.out.println(play);
		
		play = !play;
		System.out.println(play);
		
		System.out.println("-----------------------");
		int v1 = 5 ;
		int v2 = 2;
		int result11 = v1 + v2 ;
		System.out.println("result11 = " + result11); //int 타입의 7
		
		int result22 = v1 - v2 ;
		System.out.println("result22 = " + result22); //int 타입의 3
		
		int result33 = v1 * v2 ;
		System.out.println("result33 = " + result33); //int 타입의 10
		
		int result44 = v1 / v2 ;
		System.out.println("result44 = " + result44); //int 타입의 2
		
		int result55 = v1 % v2 ;
		System.out.println("result55 = " + result55); //int 타입의 1
		
		double result66 = (double) v1 / v2 ;
		System.out.println("result66 = " + result66); //int 타입의 2.5

	} // 메인 메서드 종료

} // 클래스 종료
