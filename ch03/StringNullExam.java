package ch03;

public class StringNullExam {

	public static void main(String[] args) {
		
		String name = null ;
		// 참조타입 변수는 힙 영역의 객체를 참조하지 않았다는 뜻으로 null(공백) 값을 가질 수 있다.
		// null 값도 초기값으로 사용할 수 있기 때문에 null로 초기화된 참조 변수는 스택 영역에 생성된다.
		String hobby = "볼링";
		
		name = "엠비씨" ; 
		System.out.println("name 총 문자수 : " + name.length());
		System.out.println("hobby 총 문자수 : " + hobby.length());
		
		String StrVal1 = "김기원";
		String StrVal2 = "김기원";
		String StrVal3 = "김기원";
		String StrVal4 = new String("김기원");
		
		if(StrVal1 == StrVal2) {
			System.out.println("StrVal1과 StrVal2는 참조가 같습니다.");
		}else {
			System.out.println("StrVal1과 StrVal2는 참조가 다릅니다.");
		}
		if(StrVal2 == StrVal4) {
			System.out.println("StrVal2과 StrVal4는 참조가 같습니다.");
		}else {
			System.out.println("StrVal2과 StrVal4는 참조가 다릅니다.");
		}
		if(StrVal1.equals(StrVal2)) {
			System.out.println("StrVal1과 StrVal2는 문자열이 같습니다.");
		} else {
			System.out.println("StrVal1과 StrVal2는 문자열이 다릅니다.");
		}
		if(StrVal1.equals(StrVal3)) {
			System.out.println("StrVal1과 StrVal3는 문자열이 같습니다.");
		} else {
			System.out.println("StrVal1과 StrVal3는 문자열이 다릅니다.");
		}
		if(StrVal3.equals(StrVal4)) {
			System.out.println("StrVal3과 StrVal4는 문자열이 같습니다.");
		} else {
			System.out.println("StrVal3과 StrVal4는 문자열이 다릅니다.");
		}
	}

}
