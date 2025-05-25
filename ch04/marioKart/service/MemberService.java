package ch04.marioKart.service;

import java.util.Scanner;

import ch04.marioKart.dto.MemberDTO;

public class MemberService {
	// 회원 관리용 클래스
	// 회원 관리에 해당하는 모든 서비스를 제공한다.
	// 필드
	// MemberDTO memberDTO ; // 안 씀 -> new MemberDTO();
	
	// 생성자 -> new 객체 생성 (생략 시 기본 생성자 만들어짐)
	
	// 메서드
	public MemberDTO menu(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
		// 부메뉴
		System.out.println("------------회원관리 메뉴에 진입하였습니다.------------");
		boolean run = true;
		while(run) {
			System.out.println("1. 가입 | 2. 로그인 | 3. 수정 | 4. 삭제 | 5. 종료");
			System.out.print(">>>");
			int select = input.nextInt(); // menu메서드 호출 시 scanner 객체 필수
			switch(select) {
			case 1:
				System.out.println("계정을 생성합니다.");
				create(input, memberDTOs);
				break;
			case 2:
				System.out.println("로그인을 진행합니다.");
				loginState = login(input, memberDTOs, loginState);
				break;
			case 3:
				System.out.println("계정을 수정합니다.");
				modify(input, memberDTOs, loginState);
				break;
			case 4:
				System.out.println("계정을 삭제합니다.");
				delete(input, memberDTOs, loginState);
				break;
			case 5: 
				System.out.println("메인메뉴로 진입합니다.");
				run = false;
				break;
			case 99:
				System.out.println("관리자페이지입니다.");
			default:
				System.out.println("1~5값만 입력하세요.");
			} // 스위치문 종료
		} // 와일문 종료
		return loginState; // 멤버서비스의 리턴은 로그인 상태 정보 (MemberDTO)
	} // menu 종료


	private void create(Scanner input, MemberDTO[] memberDTOs) {
		// 계정 생성
		System.out.println("사용할 id를 입력하세요");
		System.out.print(">>>");
		String id = input.next();
		System.out.println("사용할 pw를 입력하세요");
		System.out.print(">>>");
		String pw = input.next();
		System.out.println("사용할 닉네임을 입력하세요.");
		System.out.print(">>>");
		String nickName = input.next();
		System.out.println("사용할 이메일을 입력해주세요");
		System.out.print(">>>");
		String email = input.next();
		// 입력 받은 값을 객체에 삽입
		MemberDTO memberDTO = new MemberDTO(); // 빈 객체 생성
		memberDTO.id = id;
		memberDTO.pw = pw;
		memberDTO.nickName = nickName;
		memberDTO.email = email; // 키보드로 받은 값을 객체에 넣음
		// 객체 완성!!!!!
		
		// 배열에 0~null 값이면 삽입(exam)
		for (int i = 0; i < memberDTOs.length; i++) {
			if (memberDTOs[i] == null) { // null이면 값이 없음
				memberDTOs[i] = memberDTO;
				break;
			} //if문 종료
		} // for문 종료
		System.out.println(memberDTO.nickName + "님 회원가입을 축하드립니다.");
	} // create 메서드 종료

	public MemberDTO login(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
		// 로그인
		System.out.println("id를 입력하세요.");
		System.out.print(">>>");
		String id = input.next();
		System.out.println("pw를 입력하세요.");
		System.out.print(">>>");
		String pw = input.next();
		// 키보드로 입력 완료 -> 빈 객체 생성 -> 삽입
		MemberDTO loginMember = new MemberDTO();
		loginMember.id = id;
		loginMember.pw = pw;
		
		// 배열에 있는 객체와 지금 키보드로 입력한 객체 비교
		for (int i = 0; i < memberDTOs.length; i++) {
			if (memberDTOs[i] != null && memberDTOs[i].id.equals(loginMember.id) 
					&& memberDTOs[i].pw.equals(loginMember.pw)) {
				System.out.println("로그인 성공");
				loginState = memberDTOs[i]; // 배열에 있는 정보가 login상태 객체에 삽입
			} // if문 종료
		} // for문 종료
		System.out.println(loginState.nickName + "님 로그인 성공!!!");
		return loginState; // 로그인 성공객체를 리턴함.
	} // login 메서드 종료
	
	public void modify(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) { // 수정
		System.out.println("id를 입력하세요");
		System.out.print(">>>");
		String id = input.next();
		System.out.println("pw를 입력하세요");
		System.out.print(">>>");
		String pw = input.next(); // 입력 값과 새로운 객체 값을 삽입
		MemberDTO modifyMember = new MemberDTO();
		modifyMember.id = id;
		modifyMember.pw = pw; // 키보드로 입력받은 객체
		if(loginState.id.equals(modifyMember.id) // 키보드 id와 로그인 id 비교
				&& loginState.pw.equals(modifyMember.pw)) { // 키보드 pw와 로그인 pw 비교
			System.out.println("변경할 pw를 입력하세요");
			System.out.print(">>>");
			loginState.pw = input.next();
		} // if문 종료 (로그인한 사용자 정보 변경만)
	} // modify 메서드 종료
	
	public void delete(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) { // 삭제
		System.out.println("id를 입력하세요.");
		System.out.print(">>>");
		String id = input.next();
		System.out.println("pw를 입력하세요.");
		System.out.print(">>>");
		String pw = input.next();
		// 키보드로 입력 완료 -> 빈 객체 생성 -> 삽입
		MemberDTO deleteMember = new MemberDTO();
		deleteMember.id = id;
		deleteMember.pw = pw;
		for (int i = 0; i < memberDTOs.length; i++) {
			if(memberDTOs[i] != null && memberDTOs[i].id.equals(deleteMember.id) && memberDTOs[i].pw.equals(deleteMember.pw)) {
				memberDTOs[i] = null;
				System.out.println("회원 정보를 삭제하였습니다.");
			} // if문 종료 (회원 정보 삭제)
		} // for문 종료 (회원 정보 삭제)
		
	} // delete 메서드 종료
} // MemberService 클래스 종료
