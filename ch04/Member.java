package ch04;

import java.util.Scanner;

public class Member {
		// 회원용 객체로 main()메서드는 exam에서 진행함
		// 클래스의 기본속성이 3가지가 필요하다.
		// 필드, 생성자, 메서드
		
		// 필드 : 객체가 가지고 있어야 할 값 (변수)
		// 회원번호, 아이디, 성명, 암호, 이메일주소, 집주소, 전화번호
		
		public int mno;
		public String id;
		public String pw;
		
		
		// 생성자 : Exam 클래스에서 main()메서드에서 new로 호출할 때 동작 
		public Member() {
			// 기본 생성자: 클래스명과 같은 메서드
			// Member member = new Member();
		}
		
		
		// 메서드 : Member 클래스에서 행해지는 동작 CRUD
		public Member memberAdd(Scanner input) { //main에서 전달된 스캐너 객체
			Member member = new Member(); // 리턴용 객체
			
			System.out.println("회원가입용 메서드입니다.");
			System.out.println("회원번호를 입력하세요.");
			System.out.println("(숫자)>>>");
			member.mno = input.nextInt();
			
			System.out.println("회원 ID를 입력하세요.");
			System.out.println(">>>");
			member.id = input.next();
			
			System.out.println("회원 PW를 입력하세요.");
			System.out.println(">>>");
			member.pw = input.next();
			
			return member;
		} // memberAdd() 메서드 종료
		
		public void memberAllList(Member[] members) {
			System.out.println("모든 회원 보기 리스트 메서드 입니다.");
			for(int i = 0; i<members.length; i++) {
				System.out.println("회원번호 : " + members[i].mno);
				System.out.println(" : 회원id : " + members[i].id);
				System.out.println(" : 회원pw : " + members[i].pw);
		        System.out.println("----------------------------");
			}
		} // memberAllList() 메서드 종료
		
		public void memberLogin() {
			System.out.println("로그인 메서드 입니다.");
		}
		
		public void memberUpdate() {
			System.out.println("회원수정 메서드 입니다.");
		}
		
		public void memberDelete() {
			System.out.println("회원탈퇴 메서드 입니다.");
		}
		
		
		
}
