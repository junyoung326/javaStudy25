package membertest.service;

import java.awt.datatransfer.Clipboard;
import java.sql.SQLException;
import java.util.Scanner;

import membertest.dao.MemberDAO;
import membertest.dto.MemberDTO;

public class MemberSV {
	// dao와 dto를 사용하여 부메뉴와 crud를 처리한다. 
	
	// 필드
	public static MemberDAO memberDAO = new MemberDAO();
	public static Scanner inputStr = new Scanner(System.in);

	// 메서드
	
	
	
	public static void insert(MemberDAO memberDAO) throws SQLException {
		MemberDTO memberDTO = new MemberDTO(); // 빈 객체 생성
		System.out.print("이름 : ");
		memberDTO.setMname(inputStr.next());
		
		System.out.print("전화번호 : ");
		memberDTO.setMphone(inputStr.next());

		System.out.print("아이디 : ");
		memberDTO.setId(inputStr.next());
		
		System.out.print("비밀번호 : ");
		memberDTO.setPw(inputStr.next());
		
		memberDAO.insertInfo(memberDTO); // 위에서 만든 객체를 DAO에게 전달
	}

	public static MemberDTO login(MemberDTO session) throws SQLException {
		System.out.println("아이디를 입력하세요.");
		System.out.print(">>>");
		session = new MemberDTO(); // 실제 객체 생성
		session.setId(inputStr.next());
		System.out.println("비밀번호를 입력하세요");
		System.out.print(">>>");
		session.setPw(inputStr.next());
		session = memberDAO.login(session);		
		return session;
		
	}

	public static void subMenu(MemberDTO session) throws SQLException {
		if(session != null) {
			boolean subRun = true;
			while(subRun) {
				System.out.println("1. 회원 정보 수정");
				System.out.println("2. 회원 탈퇴");
				System.out.println("9. 나가기");
				System.out.print(">>>");
				String subSelect = inputStr.next();
				
				switch(subSelect) {
				case "1":
					System.out.println("<회원 정보 수정>");
					modify(inputStr, session);
					break;
				case "2": 
					System.out.println("<회원 탈퇴>");
					deleteOne(inputStr, session);
					break;
				case "9":
					System.out.println("<나가기>");
					subRun = false;
					break;
				} // 스위치문 종료
			} // 와일문 종료
		} // if문 종료
	} // subMenu 종료

	private static void deleteOne(Scanner inputStr, MemberDTO session) throws SQLException {
		System.out.println("회원 탈퇴 진행 중...");
		System.out.println("비밀번호 확인 절차를 진행하겠습니다.");
		System.out.print(">>>");
		String memberPw = inputStr.next();
		memberDAO.deleteOne(memberPw, session);

	}

	private static void modify(Scanner inputStr, MemberDTO session) throws SQLException { // 회원 정보 수정
		System.out.println("수정하려는 회원 이름을 입력하세요");
		System.out.print(">>>");
		String name = inputStr.next();
		memberDAO.modify(name, inputStr);
	}

	public static void readAll(MemberDAO memberDAO) throws SQLException {
		System.out.println("=========회원 목록입니다.=========");
		memberDAO.readAll();
	}
	
	// 자유게시판
	public static void board(Scanner inputStr, MemberDTO session) throws SQLException {
		MemberDTO boardDTO = new MemberDTO();
		System.out.print("닉네임 : ");
		boardDTO.setNickname(inputStr.next());
		
		System.out.print("제목 : ");
		boardDTO.setTitle(inputStr.next());

		Scanner inputLine = new Scanner(System.in);
		System.out.print("내용 : ");
		boardDTO.setContent(inputLine.nextLine());

		memberDAO.board(boardDTO, session);
		System.out.println("============board 메서드 종료===========");
	}

	
}
