package mbcboard.service;

import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.dao.BoardDAO;
import mbcboard.dto.BoardDTO;

public class BoardService {
	// dao와 dto를 사용하여 부메뉴와 CRUD를 처리한다.
	
	// 필드
	public BoardDAO boardDAO = new BoardDAO(); // 1단계, 2단계가 수행된다.
	
	// 생성자
	
	// 메서드 (부메뉴, 생성, 모두보기, 1개보기, 수정하기, 삭제하기)
	public void subMenu(Scanner inputStr) throws SQLException {
		boolean subRun = true;
		while(subRun) {
			System.out.println("MBC아카데미 비회원용 게시판 서비스입니다.");
			System.out.println("1. 모두보기");
			System.out.println("2. 게시글작성");
			System.out.println("3. 게시글자세히보기");
			System.out.println("4. 게시글수정");
			System.out.println("5. 게시글삭제");
			System.out.println("6. 나가기");
			System.out.print(">>>");
			String subSelect = inputStr.next();
			
			switch(subSelect) {
			case "1": 
				System.out.println("모든 게시글 보기");
				selectAll(boardDAO);
				break;
			case "2":
				System.out.println("게시글 작성메서드로 진입합니다.");
				insertBoard(boardDAO, inputStr);
				break;
			case "3":
				System.out.println("게시글 자세히 보기");
				readOne(inputStr);
				break;
			case "4":
				System.out.println("게시글 수정메서드로 진입합니다.");
				modify(inputStr);
				break;
			case "5":
				System.out.println("게시글 삭제메서드로 진입합니다");
				deleteOne();
				break;
			case "6":
				System.out.println("게시글 보기 종료");
				boardDAO.connection.close(); // 게시판 종료 시 connection 종료
				subRun = false;
				break;
			} // switch문 종료(부메뉴)
		} // while문 종료 (부메뉴 반복)
	} // 부메뉴 메서드 종료

	private void deleteOne() throws SQLException {
		// 게시물의 번호를 받아 삭제한다.
		System.out.println("삭제하려는 게시글의 번호를 입력하세요");
		Scanner inputInt = new Scanner(System.in);
		System.out.print(">>>");
		int selectBno = inputInt.nextInt();
		boardDAO.deleteOne(selectBno);
		
	}

	private void modify(Scanner inputStr) throws SQLException {
		// 제목을 찾아서 내용을 수정한다.
		System.out.println("수정하려는 게시글의 제목을 입력하세요");
		System.out.print(">>>");
		String title = inputStr.next();
		
		boardDAO.modify(title, inputStr);
		System.out.println("======끝======");

	}

	private void readOne(Scanner inputStr) throws SQLException {
		// 제목을 입력하면 내용이 보이도록 select 처리
		System.out.println("보고 싶은 게시글의 제목을 입력하세요!");
		System.out.print(">>>");
		String title = inputStr.next();
		
		boardDAO.readOne(title);
		System.out.println("======끝======");
		
	} // readOne 메서드 종료

	private void insertBoard(BoardDAO boardDAO, Scanner inputStr) throws SQLException {
		// 키보드로 입력한 데이터를 DTO를 사용하여 데이터베이스에 insert하자.
		BoardDTO boardDTO = new BoardDTO(); // 빈 객체 생성
		System.out.println("작성자 : ");
		boardDTO.setBwriter(inputStr.next());
		
		System.out.println("제목 : ");
		boardDTO.setBtitle(inputStr.next());
		
		Scanner inputLine = new Scanner(System.in);
		System.out.println("내용 : ");
		boardDTO.setBcontent(inputLine.nextLine()); // 띄어 쓰기가 있는 문장일 때 nextLine!!!
		
		boardDAO.insertBoard(boardDTO); // 위에서 만든 객체를 DAO에게 전달
		System.out.println("=========insertBoard 메서드 종료=============");
	} // insertBoard() 메서드 종료

	private void selectAll(BoardDAO boardDAO) throws SQLException {
		// dao에게 전체보기하는 서비스를 제공한다.
		System.out.println("=================");
		System.out.println("======MBC게시판 목록입니다.======");
		boardDAO.selectAll();
		System.out.println("=================");
		
	} // 전체보기 메서드 종료

}
