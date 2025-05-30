package ch05.lineage;

import java.util.Scanner;

import ch05.lineage.DTO.Account;

public class loginService { // 로그인에 관한 부메뉴용

	public static Account menu(Scanner scanner, Account[] accounts, Account loginAccount) {
		System.out.println("1. 로그인 | 2. 회원가입 | 3. 회원수정 | 4. 빠져나가기");
		System.out.print(">>>");
		int select = scanner.nextInt();
		return null;
	}

}
