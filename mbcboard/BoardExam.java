package mbcboard;

import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.dao.MemberDAO;
import mbcboard.dto.MemberDTO;
import mbcboard.service.BoardService;
import mbcboard.service.MemberService;

public class BoardExam {
	// 필드
	public static MemberDTO session = null; // MemberDTO 클래스 객체로 MemberDTO안의 변수가 다 들어감
	public static Scanner inputStr = new Scanner(System.in);
	public static Scanner inputInt = new Scanner(System.in);
	public static Scanner inputLine = new Scanner(System.in);
	public static MemberDAO memberDAO = new MemberDAO();
	private static MemberDTO memberDTO = new MemberDTO();
	// 생성자 -> static 블럭

	// 메서드
	public static void main(String[] args) throws SQLException {
		// mbc게시판용 jdbc 테스트
		// dto : 객체를 담당한다.
		// dao : 데이터베이스에서 연동을 담당한다.
		// service : 부메뉴와 서비스를 담당한다.
		boolean run = true;
		
		while(run) {
			System.out.println("MBC 자유 게시판입니다.");
			System.out.println("1. 회원가입");
			System.out.println("2. 비회원용 게시판");
			System.out.println("3. 회원용 게시판");
			System.out.println("4. 종료");
			System.out.print(">>>");
			String select = inputStr.next();
			switch (select) {
			case "1":
				System.out.println("회원가입 서비스로 진입합니다.");
				MemberService.insert(memberDAO);
				break;
			case "2": 
				System.out.println("비회원용 게시판 서비스로 진입합니다.");
				BoardService boardService = new BoardService();
				boardService.subMenu(inputStr);
				break;
			case "3":
				System.out.println("회원용 게시판 서비스로 진입합니다.");
				System.out.println("로그인 화면입니다.");
				session = MemberService.login(session);
				break;
			case "4":
				System.out.println("자유게시판 프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("1~4까지만 입력바랍니다.");
			} // switch문 종료
		} // while문 종료
		
	} // main() 종료

} // class 종료
