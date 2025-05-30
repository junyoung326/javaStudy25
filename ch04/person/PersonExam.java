package ch04.person;

public class PersonExam {

	public static void main(String[] args) {
		Person p1 = new Person("123456-1234567", "김기원");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		//p1.nation = "USA" ; final 필드로 수정할 수 없음
		//p1.ssn = "654321-7654321"; final 초기값이 이미 선언됨
		p1.name = "엠아이티";
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
	}

}
