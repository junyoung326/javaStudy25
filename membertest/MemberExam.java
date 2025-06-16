package membertest;

import java.sql.SQLException;
import java.util.Scanner;

import membertest.dao.MemberDAO;
import membertest.dto.MemberDTO;
import membertest.service.MemberSV;

public class MemberExam {
	// 필드
	public static MemberDTO session = null;
	public static Scanner inputStr = new Scanner(System.in);
	public static Scanner inputInt = new Scanner(System.in);
	public static MemberDAO memberDAO = new MemberDAO();
	private static MemberDTO memberDTO = new MemberDTO();

	// 생성자 -> static 블럭
	
	// 메서드
	public static void main(String[] args) throws SQLException {
		boolean run = true;
		while(run) {
			System.out.println("자유 게시판입니다.");
			System.out.println("1. 회원가입");
			System.out.println("2. 회원용 게시판");
			System.out.println("3. 종료");
			System.out.print(">>>");
			String select = inputStr.next();
			switch(select) {
			case "1":
				System.out.println("회원가입 서비스로 진입합니다.");
				MemberSV.insert(memberDAO);
				break;
			case "2":
				System.out.println("회원용 게시판 서비스를 진입합니다.");
				System.out.println("로그인 화면입니다.");
				session = MemberSV.login(session);
				if (session != null) {
					System.out.println("1. 회원 관리 | 2. 게시물 작성");
					System.out.print(">>>");
					String mSelect = inputStr.next();
					switch(mSelect) {
					case "1":
						System.out.println("===========회원 관리 메뉴 진입==========");
						MemberSV.subMenu(session);
						break;
					case "2":
						System.out.println("==============자유게시판 진입==============");
						MemberSV.board(inputStr, session);
						break;
					}
				}
			case "3":
				System.out.println("자유게시판 프로그램을 종료합니다.");
				run = false;
				break;
			case "99":
				System.out.println("관리자 전용입니다.");
				System.out.println("전체 사용자를 확인하겠습니다.");
				MemberSV.readAll(memberDAO);
				break;
			}
		}
		
	}

}
