package mbcboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import mbcboard.dto.BoardDTO;
import mbcboard.dto.MemberDTO;

public class MemberDAO {
	// 게시판의 db와 연동을 담당한다.
	// jdbc 5단계를 사용
	// 1단계 : Connect 객체를 사용하여 ojdbc6.jar를 생성
	// 2단계 : url, id, pw, sql 쿼리문을 작성한다.
	// 3단계 : 쿼리문을 실행한다.
	// 4단계 : 쿼리문의 실행결과를 받는다.
	// 5단계 : 연결 종료를 진행한다.

	// 필드
	public MemberDTO memberDTO = new MemberDTO();
	public Connection connection = null;// 1단계에서 사용하는 객체
	public Statement statement = null; // 3단계에서 사용하는 객체(구형), 변수 직접 처리 '" + name + "'
	public PreparedStatement preparedStatement = null; // 3단계에서 사용하는 객체(신형), ? (인파라미터)
	public ResultSet resultSet = null; // 4단계에서 결과 받는 표 객체 (select 결과) -> executeQuery용
	public int result = 0; // 4단계에서 결과 받는 정수 (insert, update, delete) -> executeUpdate용
	// 1개의 행이 삽입 | 수정 | 삭제되었습니다. (정상처리 -> commit)
	// 0개의 행이 삽입 | 수정 | 삭제되었습니다. (비정상처리 -> rollback)

	// 기본생성자
	public MemberDAO() {
		try {
			// 예외가 발생할 수 있는 실행문
			// 프로그램 강제 종료 처리용
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1단계 ojbc6.jar 호출
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "boardtest", "boardtest"); // 2단계
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 이름이나 jdbc6.jar 파일이 잘못되었습니다.");
			e.printStackTrace();
			System.exit(0); // 강제종료
		} catch (SQLException e) {
			System.out.println("url, id, pw가 잘못되었습니다. MemberDAO에 기본생성자를 확인하세요.");
			e.printStackTrace();
			System.exit(0); // 강제종료
		}
	} // 기본생성자 종료

//		public void mCreate(String bwriter, String id, String pw) throws SQLException {
//			// jdbc를 이용하여 회원가입 쿼리를 처리한다.
//			// PreparedStatement 문을 사용해 보자.
//			// 동적쿼리문이라고 하고, ?을 사용해서 세터로 입력한다.
//			
//			try {
//				String sql = "insert into board(mno, bwriter, id, pw, regidate)" + 
//							"values(board_seq.nextval, ?, ?, ?)";
//				preparedStatement = connection.prepareStatement(sql);
//				preparedStatement.setString(1, bwriter); // 첫 번째 ?에 dto객체에 있는 제목을 넣음
//				preparedStatement.setString(2, id); // 두 번째 ?에 dto객체에 있는 내용을 넣음
//				preparedStatement.setString(3, pw); // 세 번째 ?에 dto객체 내용 전달
//				System.out.println("쿼리 확인 : " + sql); // 쿼리 완성본 확인용 (테스트)
//				
//				result = preparedStatement.executeUpdate(); // 쿼리문 실행해서 결과를 정수로 받음
//				// result = preparedStatement.executeUpdate(sql);은 오류 발생, 인파라미터로 넘어옴
//				
//				if(result>0) {
//					System.out.println(result + "개의 게시물이 등록되어 있습니다.");
//					connection.commit(); // 영구저장
//				} else {
//					System.out.println("쿼리 실행 결과 : " + result);
//					System.out.println("입력 실패!!!");
//					connection.rollback(); // 롤백 (저장취소)
//				}
//				
//			} catch (SQLException e) {
//				System.out.println("예외 발생 : insertBoard()메서드에 쿼리문을 확인하세요");
//				e.printStackTrace();
//			} finally {
//				// 예외 발생 및 정상 실행 후 무조건 처리되는 실행문
//				preparedStatement.close();
//			}
//			
//		}

	// login method
	public MemberDTO login(MemberDTO session) throws SQLException {
		try {
			String sql = "select * from member where id=? and pw=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, session.getId());
			preparedStatement.setString(2, session.getPw());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) { // memberDTO에 넣기
				session.setMno(resultSet.getInt("mno"));
				session.setBwriter(resultSet.getString("bwriter"));
				session.setRegidate(resultSet.getDate("regidate"));
				return session;
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO의 login 메서드를 확인하세요.");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			resultSet.close();
		}
		System.out.println("id 또는 pw가 일치하지 않습니다.");
		return null;
	}

	// insert method 회원가입
	public void insert(MemberDTO memberDTO) throws SQLException {
		try {
			String sql = "insert into member (mno, bwriter, id, pw)" + "values(board_seq.nextval, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getBwriter());
			preparedStatement.setString(2, memberDTO.getId());
			preparedStatement.setString(3, memberDTO.getPw());
			result = preparedStatement.executeUpdate();
			System.out.println("쿼리 확인 : " + sql); // 쿼리 완성본 확인용 (테스트)

			if (result > 0) {
				System.out.println("회원가입이 완료되었습니다.");
				connection.commit(); // 영구저장
			} else {
				System.out.println("회원가입 실패!!!");
				connection.rollback(); // 롤백 (저장취소)
			}
		} catch (SQLException e) {
			System.out.println("예외 발생 : insert()메서드에 쿼리문을 확인하세요");
			e.printStackTrace();
		} finally {
			// 예외 발생 및 정상 실행 후 무조건 처리되는 실행문
			preparedStatement.close();
		}
	}

	public void deleteOne(int selectBno) {
		// TODO Auto-generated method stub

	}

	public void modify(String title, Scanner inputStr) {
		// TODO Auto-generated method stub

	}

	public void readOne(String title) {
		// TODO Auto-generated method stub

	}

	public void insertBoard(MemberDTO memberDTO) throws SQLException {
		// jdbc를 이용하여 insert 쿼리를 처리한다.
		// PreparedStatement 문을 사용해 보자.
		// 동적쿼리문이라고 하고, ?을 사용해서 세터로 입력한다.

		try {
			String sql = "insert into board(mno, bwriter, id, pw)"
					+ "values(board_seq.nextval, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getBwriter()); // 첫 번째 ?에 dto객체에 있는 제목을 넣음
			preparedStatement.setString(2, memberDTO.getId()); // 두 번째 ?에 dto객체에 있는 내용을 넣음
			preparedStatement.setString(3, memberDTO.getPw()); // 세 번째 ?에 dto객체 내용 전달
			System.out.println("쿼리 확인 : " + sql); // 쿼리 완성본 확인용 (테스트)

			result = preparedStatement.executeUpdate(); // 쿼리문 실행해서 결과를 정수로 받음
			// result = preparedStatement.executeUpdate(sql);은 오류 발생, 인파라미터로 넘어옴

			if (result > 0) {
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

	

	public void selectAll() throws SQLException {// throws SQLException 쿼리문 예외처리용
		// SQL을 사용하여 전체 목록 보기 결과 출력
		try {
			String sql = "select mno, bwriter, id, pw, legidate from member order by legidate desc";
			// 데이터베이스에 board 테이블 내용을 가져오는 쿼리문

			statement = connection.createStatement(); // 쿼리문을 실행할 객체 생성
			// statement만 생성한 거는 자리를 만들어 놓은 것
			// statement = connection.createStatement(); 는 그 자리에 설치한 것
			resultSet = statement.executeQuery(sql); // 쿼리문을 실행하여 결과를 표로 받는다.
			// 다 하고 결과를 확인한 것

			System.out.println("번호\t 제목\t 작성자\t 작성일\t");
			while (resultSet.next()) {
				// 결과 표에 위에서부터 아래까지 내려오면서 출력
				System.out.print(resultSet.getInt("mno") + "\t");
				System.out.print(resultSet.getString("bwriter") + "\t");
				System.out.print(resultSet.getString("id") + "\t");
				System.out.print(resultSet.getString("pw") + "\t");
				System.out.println(resultSet.getDate("bdate") + "\t");
			}
			System.out.println("==========끝==========");
		} catch (SQLException e) {
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