package mbcjdbc.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDAO {
	// JDBC를 담당하는 클래스
	// 오라클과 쿼리를 작성하여 crud를 제공하자.
	// JDBC는 이미 만들어진 외부 라이브러리로 5단계로 설정이 필수다.
	// 1단계 : 연결하는 객체 Connection
	// 2단계 : 쿼리문을 생성하는 객체 Statement(구형, 정적쿼리) / PreparedStatement(신형, 동적쿼리)
	// 3단계 : 쿼리문을 실행하고
	// 4단계 : 쿼리문 실행결과를 받음 select(resultset) / 나머지는 int
	// 5단계 : 연결을 종료

	// 필드

	// 기본생성자 (생략시 기본으로 만듦)

	// 메서드

	public void insertEMP(String name, String dept, double score) throws SQLException {
		// 3개의 값을 매개값을 전달 받아 emp테이블로 전달해야 함.

		Connection conn = null; // db에 연결하는 객체
		Statement stmt = null; // 쿼리문 저장 객체 (구형)
		PreparedStatement pstmt = null; // 쿼리문 저장 객체 (신형)
		ResultSet resultSet = null; // 쿼리 실행 결과를 표로 출력 select용
		int result = 0; // 쿼리 실행 결과를 정수로 출력 c,u,d는 결과 값이 1(성공), 0(실패)
		// 성공 시 -> 1개의 행이 삽입 | 수정 | 삭제되었습니다.
		// 실패 시 -> 0개의 행이 삽입 | 수정 | 삭제되었습니다.

		try { // 예외가 발생 가능성이 있는 실행문에서 활용한다.
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1단계용 ojdbc6.jar 호출
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");

			stmt = conn.createStatement(); // 쿼리 처리용 객체 생성
			// insert into emp(num, name, dept, score) values (emp_seq.nextval, 'name',
			// 'dept', 'score');
			String sql = "insert into emp(num, name, dept, score)" + " values(emp_seq.nextval, '" + name + "','" + dept
					+ "','" + score + "')"; // 쿼리문 완성
			result = stmt.executeUpdate(sql); // int 타입으로 결과를 받을 명령어

			if (result > 0) {
				System.out.println(result + "행의 데이터를 추가했습니다.\n");
				conn.commit();
			} else {
				System.out.println("결과: " + result + "입니다.");
				System.out.println("입력 실패 롤백됩니다.");
				conn.rollback();
			}
		} catch (ClassNotFoundException e) { // ojdbc6.jar를 찾을 수 없거나 forName 이름이 잘못됨
			System.out.println("ojdbc6.jar가 없거나 forName의 문자열이 잘못되었습니다.");
			e.printStackTrace(); // 자바에서 제공하는 오류 메시지 출력 (빨간 글자들)
		} catch (SQLException e) { // url이나 id,pw에 대한 예외처리용
			System.out.println("URL이나 ID, PW, 쿼리문을 확인해 주세요");
			e.printStackTrace(); // 자바에서 제공하는 오류 메시지 출력 (빨간 글자들)
		} finally {
			// 성공이든 실패든 무조건 마지막에 실행되는 문
			// 열림과 반대로 닫아줌
			stmt.close();
			System.out.println("스테이트문 종료");
			conn.close();
			System.out.println("conn문 종료");
		}
	} // insertEMP메서드 종료

	public void selectEMPALL() throws SQLException {
		// emp 테이블에 모든 정보를 번호기준으로 내림차순 출력
		Connection conn = null ; // db에 연결하는 객체
		Statement stmt = null ; // 쿼리문을 처리하는 객체 (구형)
		PreparedStatement pstmt = null; // 쿼리문을 처리하는 객체 (신형)
		ResultSet resultSet = null; // select의 결과를 표형식으로 생성객체
		int result = 0; // update, delete, creater 결과가 정수로 나옴 (1행 처리 완료)
		
		try { // 오류가 발생 가능성 있는 실행문
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1단계용 ojdbc6.jar 호출
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbctest", "jdbctest");
			
			stmt = conn.createStatement(); // 쿼리 처리용 객체 생성
			String sql = "SELECT * FROM EMP ORDER BY NUM ASC"; // num 오름차순
			resultSet = stmt.executeQuery(sql); // 결과를 표로 받음
			
			System.out.println("-------------------------------------------");
			System.out.println("사원번호\t이름\t부서\t입사점수");
			System.out.println("-------------------------------------------");
			
			while(resultSet.next()) { // 결과로 받은 표 내용을 출력한다. (다음 행(row)이 존재하는지 확인하고, 있으면 커서를 다음 행으로 이동시켜서 true를 반환)
				// resultSet.next()표에 행이 있으면 true, 없으면 false
				System.out.println(resultSet.getInt(1) + "\t"); // 필드명이 num , 왼쪽부터 오른쪽으로 1씩 추가되는 테이블의 인덱스 사용
				System.out.println(resultSet.getString(2) + "\t");
				System.out.println(resultSet.getDouble(3) + "\t");
				System.out.println(resultSet.getInt(4) + "\t");
				System.out.println(resultSet.getInt("num") + "\t"); // 필드명이 num , 왼쪽부터 오른쪽으로 1씩 추가되는 테이블의 인덱스 사용
				System.out.println(resultSet.getString("name") + "\t");
				System.out.println(resultSet.getDouble("dept") + "\t");
				System.out.println(resultSet.getInt("score") + "\t");
				
			}
	
		} catch(ClassNotFoundException e) { // ojdbc6.jar를 찾을 수 없거나 forName 이름이 잘못됨
			System.out.println("ojdbc6.jar가 없거나 forName의 문자열이 잘못되었습니다.");
			e.printStackTrace(); // 자바에서 제공하는 오류 메시지 출력 (빨간 글자들)
		} catch (SQLException e) { // url이나 id,pw에 대한 예외처리용
			System.out.println("URL이나 ID, PW, 쿼리문을 확인해 주세요");
			e.printStackTrace(); // 자바에서 제공하는 오류 메시지 출력 (빨간 글자들)
		} finally {
			// 성공이든 실패든 무조건 마지막에 실행되는 문
			// 열림과 반대로 닫아줌
			resultSet.close();
			System.out.println("resultSet 종료");
			stmt.close();
			System.out.println("스테이트문 종료");
			conn.close();
			System.out.println("conn문 종료");
		}
		
	} // selectEMPALL() 메서드 종료

	public void searchEMP(String searchName) throws SQLException {
		// 키보드에서 입력 받은 객체를 db에서 찾아 출력한다.

	}

}
