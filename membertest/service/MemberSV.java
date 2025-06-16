package membertest.service;

import java.awt.datatransfer.Clipboard;
import java.sql.SQLException;
import java.util.Scanner;

import membertest.dao.MemberDAO;
import membertest.dto.MemberDTO;

public class MemberSV {
	// dao�� dto�� ����Ͽ� �θ޴��� crud�� ó���Ѵ�. 
	
	// �ʵ�
	public static MemberDAO memberDAO = new MemberDAO();
	public static Scanner inputStr = new Scanner(System.in);

	// �޼���
	
	
	
	public static void insert(MemberDAO memberDAO) throws SQLException {
		MemberDTO memberDTO = new MemberDTO(); // �� ��ü ����
		System.out.print("�̸� : ");
		memberDTO.setMname(inputStr.next());
		
		System.out.print("��ȭ��ȣ : ");
		memberDTO.setMphone(inputStr.next());

		System.out.print("���̵� : ");
		memberDTO.setId(inputStr.next());
		
		System.out.print("��й�ȣ : ");
		memberDTO.setPw(inputStr.next());
		
		memberDAO.insertInfo(memberDTO); // ������ ���� ��ü�� DAO���� ����
	}

	public static MemberDTO login(MemberDTO session) throws SQLException {
		System.out.println("���̵� �Է��ϼ���.");
		System.out.print(">>>");
		session = new MemberDTO(); // ���� ��ü ����
		session.setId(inputStr.next());
		System.out.println("��й�ȣ�� �Է��ϼ���");
		System.out.print(">>>");
		session.setPw(inputStr.next());
		session = memberDAO.login(session);		
		return session;
		
	}

	public static void subMenu(MemberDTO session) throws SQLException {
		if(session != null) {
			boolean subRun = true;
			while(subRun) {
				System.out.println("1. ȸ�� ���� ����");
				System.out.println("2. ȸ�� Ż��");
				System.out.println("9. ������");
				System.out.print(">>>");
				String subSelect = inputStr.next();
				
				switch(subSelect) {
				case "1":
					System.out.println("<ȸ�� ���� ����>");
					modify(inputStr, session);
					break;
				case "2": 
					System.out.println("<ȸ�� Ż��>");
					deleteOne(inputStr, session);
					break;
				case "9":
					System.out.println("<������>");
					subRun = false;
					break;
				} // ����ġ�� ����
			} // ���Ϲ� ����
		} // if�� ����
	} // subMenu ����

	private static void deleteOne(Scanner inputStr, MemberDTO session) throws SQLException {
		System.out.println("ȸ�� Ż�� ���� ��...");
		System.out.println("��й�ȣ Ȯ�� ������ �����ϰڽ��ϴ�.");
		System.out.print(">>>");
		String memberPw = inputStr.next();
		memberDAO.deleteOne(memberPw, session);

	}

	private static void modify(Scanner inputStr, MemberDTO session) throws SQLException { // ȸ�� ���� ����
		System.out.println("�����Ϸ��� ȸ�� �̸��� �Է��ϼ���");
		System.out.print(">>>");
		String name = inputStr.next();
		memberDAO.modify(name, inputStr);
	}

	public static void readAll(MemberDAO memberDAO) throws SQLException {
		System.out.println("=========ȸ�� ����Դϴ�.=========");
		memberDAO.readAll();
	}
	
	// �����Խ���
	public static void board(Scanner inputStr, MemberDTO session) throws SQLException {
		MemberDTO boardDTO = new MemberDTO();
		System.out.print("�г��� : ");
		boardDTO.setNickname(inputStr.next());
		
		System.out.print("���� : ");
		boardDTO.setTitle(inputStr.next());

		Scanner inputLine = new Scanner(System.in);
		System.out.print("���� : ");
		boardDTO.setContent(inputLine.nextLine());

		memberDAO.board(boardDTO, session);
		System.out.println("============board �޼��� ����===========");
	}

	
}
