package mbcboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import mbcboard.dto.BoardDTO;

public class BoardDAO {
	// 게시판의 db와 연동을 담당한다.
	// jdbc 5단계를 사용
	// 1단계 : Connect 객체를 사용하여 ojdbc6.jar를 생성
	// 2단계 : url, id, pw, sql 쿼리문을 작성한다.
	// 3단계 : 쿼리문을 실행한다.
	// 4단계 : 쿼리문의 실행결과를 받는다.
	// 5단계 : 연결 종료를 진행한다.
	
	// 필드
	public BoardDTO boardDTO = new BoardDTO(); 
	public Connection connection = null;// 1단계에서 사용하는 객체
	public Statement statement = null ; // 3단계에서 사용하는 객체(구형), 변수 직접 처리 '" + name + "'
	public PreparedStatement preparedStatement = null; // 3단계에서 사용하는 객체(신형), ? (인파라미터)
	public ResultSet resultSet = null; // 4단계에서 결과 받는 표 객체 (select 결과) -> executeQuery용
	public int result = 0; // 4단계에서 결과 받는 정수 (insert, update, delete) -> executeUpdate용
	// 1개의 행이 삽입 | 수정 | 삭제되었습니다. (정상처리 -> commit)
	// 0개의 행이 삽입 | 수정 | 삭제되었습니다. (비정상처리 -> rollback)
	
	// 기본생성자
	public BoardDAO() {
		try {
			// 예외가 발생할 수 있는 실행문
			// 프로그램 강제 종료 처리용
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1단계 ojbc6.jar 호출
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "boardtest", "boardtest"); // 2단계
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 이름이나 jdbc6.jar 파일이 잘못되었습니다.");
			e.printStackTrace();
			System.exit(0); // 강제종료
		} catch(SQLException e) {
			System.out.println("url, id, pw가 잘못되었습니다. BoardDAO에 기본생성자를 확인하세요.");
			e.printStackTrace();
			System.exit(0); // 강제종료
		}
	} // 기본생성자 종료

	
	// 메서드

	public void deleteOne(int selectBno) throws SQLException {
		// 서비스에서 받은 게시물의 번호를 이용하여 데이터를 삭제한다.
		try {
			String sql = "delete from board where bno =?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, selectBno);
			
			result = preparedStatement.executeUpdate(); // 쿼리문 실행 후 결과를 정수로 리턴
			
			if(result > 0) {
				System.out.println(result + "게시물이 삭제되었습니다.");
				connection.commit();
			} else {
				System.out.println("게시물이 삭제되지 않았습니다.");
				connection.rollback();
			}
			System.out.println("==============================");
			selectAll(); // 삭제 후 전체 리스트 보기
		} catch(SQLException e) {
			System.out.println("예외발생 : deleteOne()메서드와 sql문을 확인하세요!!");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}
		
	}

	public void modify(String title, Scanner inputStr) throws SQLException {
		// 제목을 찾아서 내용을 수정한다.
		
		BoardDTO boardDTO = new BoardDTO();
		
		System.out.println("[수정할 내용을 입력하세요]");
		System.out.print("제목 : ");
		boardDTO.setBtitle(inputStr.next());
		
		Scanner inputLine = new Scanner(System.in);
		System.out.print("내용 : ");
		boardDTO.setBcontent(inputLine.nextLine());
		
		try {
			String sql = "update board set btitle=? , bcontent=?, bdate = sysdate where btitle =?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardDTO.getBtitle());
			preparedStatement.setString(2, boardDTO.getBcontent());
			preparedStatement.setString(3, title);
			
			result = preparedStatement.executeUpdate(); // 쿼리문 실행 후 결과를 정수로 보냄
			
			if(result>0) {
				System.out.println(result + "개의 데이터가 수정되었습니다.");
				connection.commit();
			}else {
				System.out.println("수정이 되지 않았습니다.");
				connection.rollback();
			}
		
		} catch(SQLException e){
			System.out.println("예외발생 : modify()메서드와 sql문을 확인하세요!!");
			e.printStackTrace(); 
		} finally {
			preparedStatement.close();
		}
	}

	public void readOne(String title) throws SQLException {
		// 제목 문자열이 넘어온 것을 select 처리하여 출력함
		
		try {
			String sql = "select bno, btitle, bcontent, bwriter, bdate from board where btitle=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, title); // service에서 넘어온 찾고 싶은 제목이 ?로 넘어간다.
			resultSet = preparedStatement.executeQuery(); // 쿼리문 실행 후 결과를 표로 받는다.
			
			if(resultSet.next()) {
				// 검색 결과가 있으면!!
				BoardDTO boardDTO = new BoardDTO(); // 빈 객체 생성
				
				boardDTO.setBno(resultSet.getInt("bno"));
				boardDTO.setBtitle(resultSet.getString("btitle"));
				boardDTO.setBcontent(resultSet.getString("bcontent"));
				boardDTO.setBwriter(resultSet.getString("bwriter"));
				boardDTO.setBdate(resultSet.getDate("bdate"));
				// 데이터 베이스에 있는 행을 객체에 넣기 완료
				
				System.out.println("============================");
				System.out.println("번호 : " + boardDTO.getBno());
				System.out.println("제목 : " + boardDTO.getBtitle());
				System.out.println("내용 : " + boardDTO.getBcontent());
				System.out.println("작성자 : " + boardDTO.getBwriter());
				System.out.println("작성일 : " + boardDTO.getBdate());
			} else {
				// 검사 결과가 없으면!!!
				System.out.println("해당하는 게시물이 존재하지 않습니다.");
			} // if문 종료
		} catch(SQLException e) {
			System.out.println("예외 발생 : readOne()메서드를 확인하세요");
			e.printStackTrace();
		} finally {
			// 항상 실행문
			resultSet.close();
			preparedStatement.close();
		}
		
	}

	public void insertBoard(BoardDTO boardDTO) throws SQLException {
		// jdbc를 이용하여 insert 쿼리를 처리한다.
		// PreparedStatement 문을 사용해 보자.
		// 동적쿼리문이라고 하고, ?을 사용해서 세터로 입력한다.
		
		try {
			String sql = "insert into board(bno, btitle, bcontent, bwriter, bdate)" + 
						"values(board_seq.nextval, ?, ?, ?, sysdate)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardDTO.getBtitle()); // 첫 번째 ?에 dto객체에 있는 제목을 넣음
			preparedStatement.setString(2, boardDTO.getBcontent()); // 두 번째 ?에 dto객체에 있는 내용을 넣음
			preparedStatement.setString(3, boardDTO.getBwriter()); // 세 번째 ?에 dto객체 내용 전달
			System.out.println("쿼리 확인 : " + sql); // 쿼리 완성본 확인용 (테스트)
			
			result = preparedStatement.executeUpdate(); // 쿼리문 실행해서 결과를 정수로 받음
			// result = preparedStatement.executeUpdate(sql);은 오류 발생, 인파라미터로 넘어옴
			
			if(result>0) {
				System.out.println(result + "개의 게시물이 등록되어 있습니다.");
				connection.commit(); // 영구저장
			} else {
				System.out.println("쿼리 실행 결과 : " + result);
				System.out.println("입력 실패!!!");
				connection.rollback(); // 롤백 (저장취소)
			}
			
		} catch (SQLException e) {
			System.out.println("예외 발생 : insertBoard()메서드에 쿼리문을 확인하세요");
			e.printStackTrace();
		} finally {
			// 예외 발생 및 정상 실행 후 무조건 처리되는 실행문
			preparedStatement.close();
		}
		
	}

	public void selectAll() throws SQLException { // throws SQLException 쿼리문 예외처리용
		// SQL을 사용하여 전체 목록 보기 결과 출력
		try {
			String sql = "select bno, btitle, bwriter, bdate from board order by bdate desc";
			// 데이터베이스에 board 테이블 내용을 가져오는 쿼리문
			
			statement = connection.createStatement(); // 쿼리문을 실행할 객체 생성
			// statement만 생성한 거는 자리를 만들어 놓은 것
			// statement = connection.createStatement(); 는 그 자리에 설치한 것
			resultSet = statement.executeQuery(sql); // 쿼리문을 실행하여 결과를 표로 받는다.
			// 다 하고 결과를 확인한 것
			
			System.out.println("번호\t 제목\t 작성자\t 작성일\t");
			while(resultSet.next()) {
				// 결과 표에 위에서부터 아래까지 내려오면서 출력
				System.out.print(resultSet.getInt("bno") + "\t");
				System.out.print(resultSet.getString("btitle") + "\t");
				System.out.print(resultSet.getString("bwriter") + "\t");
				System.out.println(resultSet.getDate("bdate") + "\t");
			}
			System.out.println("==========끝==========");
		} catch(SQLException e) {
			// 오류 발생 시 예외처리문
			System.out.println("selectAll()메서드에 쿼리문이 잘못되었습니다.");
			e.printStackTrace();
		} finally {
			// 항상 실행문
			resultSet.close();
			statement.close();
			// 열린 객체를 닫아야 다른 메서드도 정상 작동한다.
		} // try-catch종료
		
	} // selectAll 메서드 종료
	
	
	
}

	