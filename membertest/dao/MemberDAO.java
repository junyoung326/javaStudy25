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

	// �ʵ�
	public MemberDTO memberDTO = new MemberDTO();
	public Connection connection = null; // 1�ܰ�
	public Statement statement = null; // 3�ܰ�(����)
	public PreparedStatement preparedStatement = null; // 3�ܰ�(����)
	public ResultSet resultSet = null; // 4�ܰ� ��� �޴� ǥ ��ü
	public int result = 0; // 4�ܰ迡�� ��� �޴� ����

	// �⺻������
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1�ܰ� ojdbc6.jar ȣ��
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.175:1521:xe", "membertest",
					"membertest"); // 2�ܰ�
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �̸��̳� jdbc6.jar ������ �߸��Ǿ����ϴ�.");
			e.printStackTrace();
			System.exit(0); // ��������
		} catch (SQLException e) {
			System.out.println("url, id, pw�� �߸��Ǿ����ϴ�. MemberDAO�� �⺻�����ڸ� Ȯ���ϼ���");
			e.printStackTrace();
			System.exit(0); // ��������
		}
	} // �⺻ ������ ����

	// �޼���
	// ȸ������
	public void insertInfo(MemberDTO memberDTO) throws SQLException {
		try {
			String sql = "insert into member (mno, mname, mphone, id, pw)" + "values(member_seq.nextval, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getMname());
			preparedStatement.setString(2, memberDTO.getMphone());
			preparedStatement.setString(3, memberDTO.getId());
			preparedStatement.setString(4, memberDTO.getPw());
			result = preparedStatement.executeUpdate();
			//System.out.println("���� Ȯ�� : " + sql); // ���� �ϼ��� Ȯ�ο� (�׽�Ʈ)

			if (result > 0) {
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
				connection.commit();
			} else {
				System.out.println("ȸ������ ����!!!");
				connection.rollback(); // ���� ���
			}
		} catch (SQLException e) {
			System.out.println("���� �߻� : insert()�޼��忡 �������� Ȯ���ϼ���");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}

	}

	// �α���
	public MemberDTO login(MemberDTO session) throws SQLException {
		try {
			String sql = "select * from member where id=? and pw=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, session.getId());
			preparedStatement.setString(2, session.getPw());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) { // memberDTO�� �ֱ�
				session.setMno(resultSet.getInt("mno"));
				session.setMname(resultSet.getString("mname"));
				session.setMphone(resultSet.getString("mphone"));
				session.setMdate(resultSet.getDate("mdate"));
			}

		} catch (SQLException e) {
			System.out.println("MemberDAO�� login �޼��带 Ȯ���ϼ���.");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			resultSet.close();
		}
		if (resultSet == null) {
			System.out.println("id �Ǵ� pw�� ��ġ���� �ʽ��ϴ�.");
			session = null;
		}
		return session;
	}

	// ȸ�� Ż��
	public void deleteOne(String memberPw, MemberDTO session) throws SQLException {
		try {
			String sql = "delete from member where pw=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberPw);

			result = preparedStatement.executeUpdate();

			if (result > 0) {
				System.out.println("ȸ�� Ż��Ǿ����ϴ�.");
				session = null;
				connection.commit();
			} else {
				System.out.println("ȸ�� Ż�� ����!!!");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("���� �߻� : MemberDAO�� deleteOne()�޼���� sql���� Ȯ���ϼ���!");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}

	}

	// ȸ�� ���� ����
	public void modify(String name, Scanner inputStr) throws SQLException {
		MemberDTO memberDTO = new MemberDTO();

		System.out.println("1. �̸� | 2. ��ȭ��ȣ | 3. ���̵� | 4. ��й�ȣ ������ ������ ����˴ϴ�.");

		System.out.print("�̸� ���� : ");
		memberDTO.setMname(inputStr.next());

		System.out.print("��ȭ��ȣ ���� : ");
		memberDTO.setMphone(inputStr.next());

		System.out.print("���̵� ���� : ");
		memberDTO.setId(inputStr.next());

		System.out.print("��й�ȣ ���� : ");
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
				System.out.println(result + "���� ȸ�� ������ �����Ǿ����ϴ�.");
				connection.commit();
			} else {
				System.out.println("������ ���� �ʾҽ��ϴ�.");
				connection.rollback();
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO�� modify()�޼���� sql���� Ȯ���ϼ���!");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}

	}
	
	// ��ü����
	public void readAll() throws SQLException {
		try {
			String sql = "select * from member order by mno desc";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			System.out.println("��ȣ\t �̸�\t ��ȭ��ȣ\t ���̵�\t ��й�ȣ\t ȸ�������\t �г���\t ����\t ����\t");
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
			System.out.println("=============��===============");
		} catch (SQLException e) {
			System.out.println("MemberDAO�� readAll()�޼���� sql���� Ȯ���ϼ���!");
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
				System.out.println(result + "���� �Խù��� ��ϵǾ����ϴ�.");
				connection.commit(); // ��������
			} else {
				System.out.println("�Է� ����!!!");
				connection.rollback(); // �ѹ� (�������)
			} 
		} catch (SQLException e) {
			System.out.println("���� �߻� : board()�޼��忡 �������� Ȯ���ϼ���");
			e.printStackTrace();
		} finally {
			preparedStatement.close();
		}
	
	}
}
