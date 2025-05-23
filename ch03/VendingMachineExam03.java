package ch03;

import java.util.Scanner;

public class VendingMachineExam03 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("=======음료등록 프로그램=======");
		System.out.println("등록할 음료가 몇 종류인지 입력해 주세요.");
		System.out.print(">>> ");
		int count = input.nextInt();
		System.out.println(count + "가지 종류의 음료를 등록하겠습니다.");
		System.out.println();

		String[] names = new String[count];
		int[][] drinks = new int[count][2]; // "열"은 음료의 가격[1]과 수량[0] // 사람들이 사가고 남은 음료
		int[] drinksSave = new int[count]; // 음료의 초기수량 저장용 배열 // 초기 재고
        int sumStock = 0;
        int sumSold = 0;

		Add(names, drinks, count, drinksSave);

		boolean run = true;
		boolean runBuy = true;
		boolean runBuy1 = true;
		boolean runAdm = true;

		System.out.println();
		System.out.println("=========== 자판기 프로그램 시작 ============");

		while (run) {
			System.out.println("1.음료별 재고 확인하기\n2.음료 구매하기\n3.관리자 호출하기\n9.자판기 종료하기");
			System.out.print(">>> ");
			int answerBuy = input.nextInt();
			switch (answerBuy) {
			case 1:
				System.out.println();
				System.out.println("음료별 재고 확인 메뉴입니다.");
				System.out.println();
				System.out.println("각 음료별 재고를 알려드리겠습니다.");
				for (int i = 0; i < count; i++) {
					System.out.println(names[i] + " : " + drinks[i][0] + "개");
				} // for문 종료
				System.out.println("입니다.");
				System.out.println("자판기 초기화면으로 돌아갑니다.");
				System.out.println();
				break;
			case 2:
				buyDrinks(count, names, drinks, runBuy, runBuy1);
				break;
			case 3:
				System.out.println("관리자 호출 메뉴를 선택하셨습니다.");
				System.out.println("관리자의 전화번호는 010-xxxx-xxxx 입니다.");
				System.out.println("위의 번호로 전화해주시기 바랍니다.");
				run = false;
				break;
			case 9:
				System.out.println("자판기 프로그램을 종료합니다.");
				System.out.println("다음에 다시 이용해주세요!!");
				run = false;
				break;
			case 1111:
				System.out.println("관리자 메뉴입니다.");
				System.out.println("관리자 메뉴에 진입하려면 비밀번호를 입력해주세요!!!");
				System.out.print(">>> ");
				int pw = input.nextInt();
				if (pw == 9999) {
					System.out.println("비밀번호가 일치합니다.");
					System.out.println("====== 관리자 메뉴에 진입합니다.");
					while(runAdm) {
		                  System.out.println("1.메뉴변경\n2.가격변경\n3.재고보충\n4.통계\n5.총 매출액 보기\n6.구매자 메뉴로 돌아가기\n9.자판기 종료하기");
		                  System.out.print(">>> ");
		                  int answerAdm = input.nextInt();
		                  switch (answerAdm) {
		                  case 1 :
		                	  changeMenu(count, names, drinks);
		                	  break;
		                  case 2:
		                	  changePrice(count, names, drinks);
		                	  break;
		                  case 3:
		                	  addMenu(count, names, drinks);
		                  case 4:
		                	  System.out.println("통계 메뉴입니다.");
		                      System.out.println("현재 '남아 있는' 모든 음료의 수량과, 가격의 총합을 알려드리겠습니다.");
		                      for(int i = 0 ; i<count ; i++) {
		                    	  sumStock += (drinks[i][0] * drinks[i][1]);
		                    	  System.out.println(names[i] + "의 남은 수량 : " + drinks[i][0] + "개");
		                      } // 관리자메뉴 case4 for문 종료
		                      System.out.println("모든 음료가격의 총합 : " + sumStock);
		                      System.out.println("관리자 메뉴로 돌아갑니다.");
		                      break;
		                  case 5 :
		                	  System.out.println("총 매출액을 확인합니다.");
		                      System.out.println("현재까지 팔린 음료의 총액을 보여드리겠습니다.");
		                      for (int i = 0; i<count ; i++) {
		                    	  sumSold += drinksSave[i]-(drinks[i][0]*drinks[i][1]);
		                      } // 관리자메뉴 case5 for문 종료
		                      System.out.println("현재까지 판매된 음료의 총액 : " + sumSold);
		                  } // 관리자메뉴 switch문 종료
					} // 관리자메뉴 while문 종료
				} // 관리자메뉴 if문 종료
			} // 메인 메서드 switch문 종료
		} // 메인 메서드 while문 종료

	} // 메인 메서드 종료

	private static void addMenu(int count, String[] names, int[][] drinks) {
		// TODO Auto-generated method stub
		
	}

	private static void changePrice(int count, String[] names, int[][] drinks) {
		// TODO Auto-generated method stub
		
	}

	private static void changeMenu(int count, String[] names, int[][] drinks) {
		// TODO Auto-generated method stub
		
	}

	private static void buyDrinks(int count, String[] names, int[][] drinks, boolean runBuy, boolean runBuy1) {
		// TODO Auto-generated method stub

	}

	private static void Add(String[] names, int[][] drinks, int count, int[] drinksSave) {
		// TODO Auto-generated method stub

	}
} // 클래스 종료
