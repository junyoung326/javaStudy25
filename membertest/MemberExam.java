package membertest;

import java.sql.SQLException;
import java.util.Scanner;

import membertest.dao.MemberDAO;
import membertest.dto.MemberDTO;
import membertest.service.MemberSV;

public class MemberExam {
	// �ʵ�
	public static MemberDTO session = null;
	public static Scanner inputStr = new Scanner(System.in);
	public static Scanner inputInt = new Scanner(System.in);
	public static MemberDAO memberDAO = new MemberDAO();
	private static MemberDTO memberDTO = new MemberDTO();

	// ������ -> static ��
	
	// �޼���
	public static void main(String[] args) throws SQLException {
		boolean run = true;
		while(run) {
			System.out.println("���� �Խ����Դϴ�.");
			System.out.println("1. ȸ������");
			System.out.println("2. ȸ���� �Խ���");
			System.out.println("3. ����");
			System.out.print(">>>");
			String select = inputStr.next();
			switch(select) {
			case "1":
				System.out.println("ȸ������ ���񽺷� �����մϴ�.");
				MemberSV.insert(memberDAO);
				break;
			case "2":
				System.out.println("ȸ���� �Խ��� ���񽺸� �����մϴ�.");
				System.out.println("�α��� ȭ���Դϴ�.");
				session = MemberSV.login(session);
				if (session != null) {
					System.out.println("1. ȸ�� ���� | 2. �Խù� �ۼ�");
					System.out.print(">>>");
					String mSelect = inputStr.next();
					switch(mSelect) {
					case "1":
						System.out.println("===========ȸ�� ���� �޴� ����==========");
						MemberSV.subMenu(session);
						break;
					case "2":
						System.out.println("==============�����Խ��� ����==============");
						MemberSV.board(inputStr, session);
						break;
					}
				}
			case "3":
				System.out.println("�����Խ��� ���α׷��� �����մϴ�.");
				run = false;
				break;
			case "99":
				System.out.println("������ �����Դϴ�.");
				System.out.println("��ü ����ڸ� Ȯ���ϰڽ��ϴ�.");
				MemberSV.readAll(memberDAO);
				break;
			}
		}
		
	}

}
