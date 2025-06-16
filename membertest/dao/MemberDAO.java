package membertest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import membertest.dto.MemberDTO;

public class MemberDAO {

	// 필드
	public MemberDTO memberDTO = new MemberDTO();
	public Connection connection = null; // 1단계
	public Statement statement = null; // 3단계(구형)
	public PreparedStatement preparedStatement = null; // 3단계(신형)
	public ResultSet resultSet = null; // 4단계 결과 받는 표 객체
	public int result = 0; // 4단계에서 결과 받는 정수

	// 기본생성자
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1단계 ojdbc6.jar 호출
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.175:1521:xe", "membertest",
					"membertest"); // 2단계
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 이름이나 jdbc6.jar 파일이 잘못되었습니다.");
			e.printStackTrace();
			System.exit(0); // 강제종료
		} catch (SQLException e) {
			System.out.println("url, id, pw가 잘못되었습니다. MemberDAO에 기본생성자를 확인하세요");
			e.printStackTrace();
			System.exit(0); // 강제종료
		}
	} // 기본 생성자 종료

	// 메서드
	// 회원가입
	public void insertInfo(MemberDTO memberDTO) throws SQLException {
		try {
			String sql = "insert into member (mno, mname, mphone, id, pw)" + "values(member_seq.nextval, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getMname());
			preparedStatement.setString(2, memberDTO.getMphone());
			preparedStatement.setString(3, memberDTO.getId());
			preparedStatement.setString(4, memberDTO.getPw());
			result = preparedStatement.executeUpdate();
			//System.out.println("쿼리 확인 : " + sql); // 쿼리 완성본 확인용 (테스트)

			if (result > 0) {
				System.out.println("회원가입이 완료되었습니다.");
				connection.commit();
			} else {
				System.out.println("회원가입 실패!!!");
				connection.rollback(); // 저장 취소
			}
		} catch (SQLException e) {
			System.out.println("예외 발생 : insert()메서드에 쿼리문을 확인하세요");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}

	}

	// 로그인
	public MemberDTO login(MemberDTO session) throws SQLException {
		try {
			String sql = "select * from member where id=? and pw=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, session.getId());
			preparedStatement.setString(2, session.getPw());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) { // memberDTO에 넣기
				session.setMno(resultSet.getInt("mno"));
				session.setMname(resultSet.getString("mname"));
				session.setMphone(resultSet.getString("mphone"));
				session.setMdate(resultSet.getDate("mdate"));
			}

		} catch (SQLException e) {
			System.out.println("MemberDAO의 login 메서드를 확인하세요.");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			resultSet.close();
		}
		if (resultSet == null) {
			System.out.println("id 또는 pw가 일치하지 않습니다.");
			session = null;
		}
		return session;
	}

	// 회원 탈퇴
	public void deleteOne(String memberPw, MemberDTO session) throws SQLException {
		try {
			String sql = "delete from member where pw=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberPw);

			result = preparedStatement.executeUpdate();

			if (result > 0) {
				System.out.println("회원 탈퇴되었습니다.");
				session = null;
				connection.commit();
			} else {
				System.out.println("회원 탈퇴 실패!!!");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("예외 발생 : MemberDAO의 deleteOne()메서드와 sql문을 확인하세요!");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}

	}

	// 회원 정보 수정
	public void modify(String name, Scanner inputStr) throws SQLException {
		MemberDTO memberDTO = new MemberDTO();

		System.out.println("1. 이름 | 2. 전화번호 | 3. 아이디 | 4. 비밀번호 절차로 수정이 진행됩니다.");

		System.out.print("이름 수정 : ");
		memberDTO.setMname(inputStr.next());

		System.out.print("전화번호 수정 : ");
		memberDTO.setMphone(inputStr.next());

		System.out.print("아이디 수정 : ");
		memberDTO.setId(inputStr.next());

		System.out.print("비밀번호 수정 : ");
		memberDTO.setPw(inputStr.next());

		try {
			String sql = "update member set mname=?, mphone=?, id=?, pw=? where mname=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getMname());
			preparedStatement.setString(2, memberDTO.getMphone());
			preparedStatement.setString(3, memberDTO.getId());
			preparedStatement.setString(4, memberDTO.getPw());
			preparedStatement.setString(5, name);

			result = preparedStatement.executeUpdate();

			if (result > 0) {
				System.out.println(result + "명의 회원 정보가 수정되었습니다.");
				connection.commit();
			} else {
				System.out.println("수정이 되지 않았습니다.");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO의 modify()메서드와 sql문을 확인하세요!");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}

	}
	
	// 전체보기
	public void readAll() throws SQLException {
		try {
			String sql = "select * from member order by mno desc";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			System.out.println("번호\t 이름\t 전화번호\t 아이디\t 비밀번호\t 회원등록일\t 닉네임\t 제목\t 내용\t");
			while (resultSet.next()) {
				System.out.print(resultSet.getInt("mno") + "\t");
				System.out.print(resultSet.getString("mname") + "\t");
				System.out.print(resultSet.getString("mphone") + "\t");
				System.out.print(resultSet.getString("id") + "\t");
				System.out.print(resultSet.getString("pw") + "\t");
				System.out.print(resultSet.getDate("mdate") + "\t");
				System.out.print(resultSet.getString("nickname") + "\t");
				System.out.print(resultSet.getString("title") + "\t");
				System.out.println(resultSet.getString("content") + "\t");

				
			}
			System.out.println("=============끝===============");
		} catch (SQLException e) {
			System.out.println("MemberDAO의 readAll()메서드와 sql문을 확인하세요!");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			resultSet.close();
		}

	}

	public void board(MemberDTO boardDTO, MemberDTO session) throws SQLException {
		try {
			String sql = "update member set nickname=?, title=?, content=? where mname=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardDTO.getNickname());
			preparedStatement.setString(2, boardDTO.getTitle());
			preparedStatement.setString(3, boardDTO.getContent());
			preparedStatement.setString(4, session.getMname());
			result = preparedStatement.executeUpdate();
			if (result > 0) {
				System.out.println(result + "개의 게시물이 등록되었습니다.");
				connection.commit(); // 영구저장
			} else {
				System.out.println("입력 실패!!!");
				connection.rollback(); // 롤백 (저장취소)
			} 
		} catch (SQLException e) {
			System.out.println("예외 발생 : board()메서드에 쿼리문을 확인하세요");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}
	
	}
}
