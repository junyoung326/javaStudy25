package ch03;

import java.util.Scanner;

public class VendingMachineExam {

	public static void main(String[] args) {
		System.out.println("음료 자판기입니다.");
		Scanner inputInt = new Scanner(System.in); // int 스캐너
		Scanner inputStr = new Scanner(System.in); // String 스캐너

		int buyTotal = 0; // 총 구매한 금액
		// int water = 10; // 물 재고
		// int powerAde = 10; // 파워에이드 재고
		// int pokari = 10; // 포카리 재고
		// int toreta = 10; // 토레타 재고
		// int stocks[] = {water, powerAde, pokari, toreta};
		String drinkNames[] = { "물", "파워에이드", "포카리", "토레타" };
		int drinkStocks[] = { 10, 10, 10, 10 };
		int drinkPrices[] = { 1000, 2000, 2000, 2000 };
		// String[] bevs= null;

		boolean run = true;
		while (run) {
			System.out.println("1. 관리자 모드 | 2. 사용자 모드 | 3. 프로그램 종료");
			System.out.println("숫자를 입력해 주세요.");
			System.out.print(">>>");
			int select = inputInt.nextInt(); // 모드 선택
			switch (select) {
			case 1: // 1. 관리자 모드 선택
				System.out.println("1. 메뉴 변경 | 2. 가격 변경 | 3. 음료 리필 | 4. 통계(이윤계산)");
				System.out.println("메뉴 숫자를 입력해 주세요.");
				System.out.print(">>>");
				int select2 = inputInt.nextInt(); // 관리자 모드 메뉴 선택
				switch (select2) {
				case 1:
					changeMenu(inputInt, inputStr);
					break;
				case 2:
					changePrice(inputInt, inputStr);
					break;
				case 3:
					refill(inputInt, inputStr);
					break;
				case 4:
					profit(buyTotal, drinkStocks, drinkNames, drinkPrices);
					break;
				default:
					System.out.println("입력하신 숫자를 확인해 주세요.");
					break;
				} // 스위치문 종료
				break;
			case 2: // 사용자 모드
				System.out.println("1. 음료 구매 | 2. 관리자 호출");
				System.out.print(">>>");
				int userS = inputInt.nextInt(); // "1. 음료 구매 | 2. 관리자 호출" 중 선택
				switch (userS) {
				case 1: // 음료 구매
					user(inputInt, inputStr, buyTotal, drinkStocks, drinkNames, drinkPrices, userS);
					addOrder(inputInt, inputStr, buyTotal, drinkStocks, drinkNames, drinkPrices, userS);
					int buyTotalFinal = user(inputInt, inputStr, buyTotal, drinkStocks, drinkNames, drinkPrices, userS);

					System.out.println("결제 수단을 선택해 주세요.");
					System.out.println("1. 신용카드 2. 현금");
					System.out.print(">>>");
					String select4 = inputStr.next(); // 결제수단 선택
					paying(select4, buyTotal);

					break;
				case 2:
					System.out.println("관리자를 호출하겠습니다.");
					System.out.println("관리자 호출 중...");
					break;
				default:
					System.out.println("입력하신 숫자를 확인해 주세요.");
					break;
				} // user 스위치문 종료
			case 3:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			} // 스위치문 종료

		} // while문 종료

	} // 메인 메서드 종료

	private static void addOrder(Scanner inputInt, Scanner inputStr, int buyTotal, int[] drinkStocks,
			String[] drinkNames, int[] drinkPrices, int userS) {
		System.out.println("더 주문하시겠습니까?");
		System.out.print(">>>");
		String answer = inputStr.next();
		if (answer.equalsIgnoreCase("yes")) {
			user(inputInt, inputStr, buyTotal, drinkStocks, drinkNames, drinkPrices, userS);
		} else if (answer.equalsIgnoreCase("no")) {
			System.out.println("총 금액은 " + buyTotal + "원 입니다");
		} else {
			System.out.println("yes, no로 입력해 주세요.");
		} // 주문 추가 여부 대답 if문 종료

		
		
	} // addOrder 메서드 종료

	private static int user(Scanner inputInt, Scanner inputStr, int buyTotal, int[] drinkStocks, String[] drinkNames,
			int[] drinkPrices, int userS) {

		boolean run = true;
		while (run) {
			System.out.println("1. 물 (1,000원), 2. 파워에이드 (2,000원), 3. 포카리스웨트 (2,000원), 4. 토레타 (2,000원)");
			System.out.println("원하시는 메뉴의 번호를 눌러주세요.");
			System.out.print(">>>");
			String select1 = inputStr.next(); // 메뉴 번호 입력
			System.out.println("구매 원하시는 수량을 입력해 주세요.");
			System.out.print(">>>");
			int count = inputInt.nextInt(); // 구매 갯수 입력
			if (select1.equals("1")) {
				select1 = drinkNames[0];
				System.out.println("선택하신 " + select1 + "입니다.");
				buyTotal += (drinkPrices[0] * count);
				drinkStocks[0] -= count;
				System.out.println("현재 총 금액은 " + buyTotal + "원 입니다.");

			} else if (select1.equals("2")) {
				select1 = drinkNames[1];
				System.out.println("선택하신 " + select1 + "입니다.");
				buyTotal += (drinkPrices[1] * count);
				drinkStocks[1] -= count;
				System.out.println("현재 총 금액은 " + buyTotal + "원 입니다.");

			} else if (select1.equals("3")) {
				select1 = drinkNames[2];
				System.out.println("선택하신 " + select1 + "입니다.");
				buyTotal += (drinkPrices[2] * count);
				drinkStocks[2] -= count;
				System.out.println("현재 총 금액은 " + buyTotal + "원 입니다.");

			} else if (select1.equals("4")) {
				select1 = drinkNames[3];
				;
				System.out.println("선택하신 " + select1 + "입니다.");
				buyTotal += (drinkPrices[3] * count);
				drinkStocks[3] -= count;
				System.out.println("현재 총 금액은 " + buyTotal + "원 입니다.");

			} else {
				System.out.println("입력하신 숫자를 확인해 주세요.");
			} // 구매 if문 종료

			run = false;
			break;
		} // while문 종료
		return buyTotal;
	} // user 메서드 종료

	private static void profit(int buyTotal, int[] stocks, String[] drinkName, int[] drinkPrices) {
		System.out.println("============ 통계 (이윤 계산) ===========");
		System.out.println("통계 : " + buyTotal);
		for (int i = 0; i < drinkName.length; i++) {
			System.out.println(drinkName[i] + " 의 재고는 " + stocks[i] + "개입니다. ");

		} // profit 메서드 for문 종료

	} // 1. 관리자 메뉴 중 "4. 통계 (이윤 계산)" 메서드 종료

	private static void refill(Scanner inputInt, Scanner inputStr) {
		System.out.println("============ 음료 리필 ===========");
		String drinks[] = { "1. 물 (1,000원), 2. 파워에이드 (2,000원), 3. 포카리스웨트 (2,000원), 4. 토레타 (2,000원)" };
		for (int i = 0; i < drinks.length; i++) {
			System.out.println(drinks[i]);
		} // for문 종료
		System.out.println("리필하실 메뉴 숫자를 입력해 주세요.");
		System.out.print(">>>");
		int select5 = inputStr.nextInt(); // 리필 메뉴 선택
		System.out.println(select5 + "번이 리필되었습니다.");
	} // 1. 관리자 메뉴 중 "3. 음료 리필" 메서드 종료

	private static void changePrice(Scanner inputInt, Scanner inputStr) {
		System.out.println("============ 가격 변경 ===========");
		String drinks[] = { "1. 물 (1,000원), 2. 파워에이드 (2,000원), 3. 포카리스웨트 (2,000원), 4. 토레타 (2,000원)" };
		for (int i = 0; i < drinks.length; i++) {
			System.out.println(drinks[i]);
		} // for문 종료
		System.out.println("변경하실 메뉴 숫자를 입력해 주세요.");
		System.out.print(">>>");
		int select4 = inputInt.nextInt(); // 가격 변경 메뉴 선택
		System.out.println("변동된 가격을 입력해 주세요.");
		System.out.print(">>>");
		String priceMod = inputStr.next(); // 가격 변경
		System.out.println(select4 + "번은 " + priceMod + "로 가격이 변경되었습니다.");
	} // 1. 관리자 메뉴 중 "2. 가격 변경" 메서드 종료

	private static void changeMenu(Scanner inputInt, Scanner inputStr) {
		System.out.println("============ 메뉴 변경 ===========");
		System.out.println("1. 물 | 2. 파워에이드 | 3. 포카리스웨트 | 4. 토레타");
		System.out.println("변경하실 메뉴 숫자를 입력해 주세요.");
		System.out.print(">>>");
		int select3 = inputInt.nextInt(); // 변경 메뉴 선택
		System.out.println("변경된 메뉴를 입력해 주세요.");
		System.out.print(">>>");
		String Mod = inputStr.next(); // 메뉴 변경
		System.out.println(select3 + "번은 " + Mod + "로 변경되었습니다.");
	} // 1. 관리자 메뉴 중 "1. 메뉴 변경" 메서드 종료

	private static void paying(String select, int buyTotal) {
		Scanner cash = new Scanner(System.in);
		switch (select) {
		case "1":
			System.out.println("신용카드로 " + buyTotal + "원을 결제합니다.");
			break;
		case "2":
			System.out.println("지불한 현금이 얼마입니까?");
			System.out.print(">>>");
			int myCash = cash.nextInt();
			if (myCash < buyTotal) {
				System.out.println("현금이 부족합니다. 현금을 더 지불해 주세요!!");
			} else {
				System.out.println("거스름돈은 " + (myCash - buyTotal) + "입니다.");
			} // if문 종료
			break;
		default:
			System.out.println("입력하신 숫자를 확인해 주세요.");
			break;
		} // user 결제수단 스위치문 종료

	} // user 결제수단 메서드 종료

} // 클래스 종료
