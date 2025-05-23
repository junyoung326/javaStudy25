package ch03;

import java.util.Scanner;

public class VendingMachineExam02 {

    // 총 구매 금액 (전역 변수로 선언해야 다른 메서드에서도 접근 가능)
    static int buyTotal = 0;

    public static void main(String[] args) {
        System.out.println("음료 자판기입니다.");
        Scanner inputInt = new Scanner(System.in); // 숫자 입력용 스캐너
        Scanner inputStr = new Scanner(System.in); // 문자열 입력용 스캐너

        // 음료 이름, 재고, 가격 배열
        String[] drinkNames = {"물", "파워에이드", "포카리", "토레타"};
        int[] drinkStocks = {10, 10, 10, 10};
        int[] drinkPrices = {1000, 2000, 2000, 2000};

        boolean run = true;
        while (run) {
            System.out.println("\n[메인 메뉴]");
            System.out.println("1. 관리자 모드 | 2. 사용자 모드 | 3. 프로그램 종료");
            System.out.print(">>> ");
            int select = inputInt.nextInt();

            switch (select) {
                case 1:
                    adminMode(inputInt, inputStr, drinkStocks, drinkNames, drinkPrices);
                    break;
                case 2:
                    userMode(inputInt, inputStr, drinkStocks, drinkNames, drinkPrices);
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    run = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }

    // 관리자 모드: 메뉴 변경, 가격 변경, 리필, 통계
    private static void adminMode(Scanner inputInt, Scanner inputStr, int[] drinkStocks, String[] drinkNames, int[] drinkPrices) {
        System.out.println("\n[관리자 모드]");
        System.out.println("1. 메뉴 변경 | 2. 가격 변경 | 3. 음료 리필 | 4. 통계(이윤 계산)");
        System.out.print(">>> ");
        int choice = inputInt.nextInt();

        switch (choice) {
            case 1:
                changeMenu(inputInt, inputStr, drinkNames);
                break;
            case 2:
                changePrice(inputInt, drinkPrices);
                break;
            case 3:
                refill(inputInt, drinkStocks);
                break;
            case 4:
                profit(drinkStocks, drinkNames);
                break;
            default:
                System.out.println("올바른 메뉴를 선택해 주세요.");
        }
    }

    // 사용자 모드: 음료 주문 및 결제
    private static void userMode(Scanner inputInt, Scanner inputStr, int[] drinkStocks,
                                 String[] drinkNames, int[] drinkPrices) {
        boolean ordering = true;
        while (ordering) {
            System.out.println("\n[사용자 모드]");
            System.out.println("1. 음료 구매 | 2. 관리자 호출 | 3. 뒤로가기");
            System.out.print(">>> ");
            int userChoice = inputInt.nextInt();

            switch (userChoice) {
                case 1:
                    orderDrinks(inputInt, inputStr, drinkStocks, drinkNames, drinkPrices);
                    if (buyTotal > 0) {
                        System.out.println("결제 수단을 선택해 주세요. 1. 신용카드 | 2. 현금");
                        System.out.print(">>> ");
                        String payment = inputStr.next();
                        paying(payment, buyTotal);
                        buyTotal = 0; // 결제 후 초기화
                    }
                    ordering = false;
                    break;
                case 2:
                    System.out.println("관리자를 호출하겠습니다...");
                    break;
                case 3:
                    ordering = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    // 음료 주문 처리
    private static void orderDrinks(Scanner inputInt, Scanner inputStr, int[] stocks, String[] drinkNames, int[] prices) {
        boolean more = true;
        while (more) {
            System.out.println("\n[음료 목록]");
            for (int i = 0; i < drinkNames.length; i++) {
                System.out.printf("%d. %s (%d원) [재고: %d개]\n", i + 1, drinkNames[i], prices[i], stocks[i]);
            }

            System.out.print("원하는 음료 번호를 선택하세요: ");
            int menu = inputInt.nextInt() - 1;
            if (menu < 0 || menu >= drinkNames.length) {
                System.out.println("올바른 번호를 입력해 주세요.");
                continue;
            }

            System.out.print("구매 수량을 입력하세요: ");
            int quantity = inputInt.nextInt();
            if (quantity <= 0 || quantity > stocks[menu]) {
                System.out.println("재고가 부족하거나 잘못된 수량입니다.");
                continue;
            }

            stocks[menu] -= quantity;
            int cost = prices[menu] * quantity;
            buyTotal += cost;
            System.out.printf("%s %d개를 선택하셨습니다. (합계: %d원)\n", drinkNames[menu], quantity, buyTotal);

            System.out.print("더 주문하시겠습니까? (yes/no): ");
            String again = inputStr.next();
            more = again.equalsIgnoreCase("yes");
        }
    }

    // 결제 처리
    private static void paying(String method, int total) {
        Scanner cash = new Scanner(System.in);
        switch (method) {
            case "1":
                System.out.println("신용카드로 " + total + "원을 결제합니다.");
                break;
            case "2":
                System.out.print("현금 금액을 입력해 주세요: ");
                int myCash = cash.nextInt();
                if (myCash < total) {
                    System.out.println("현금이 부족합니다. 결제 실패.");
                } else {
                    System.out.println("거스름돈은 " + (myCash - total) + "원 입니다.");
                }
                break;
            default:
                System.out.println("잘못된 결제 수단입니다.");
                break;
        }
    }

    // 통계 출력
    private static void profit(int[] stocks, String[] drinkNames) {
        System.out.println("\n[이윤 통계]");
        System.out.println("총 판매 금액: " + buyTotal + "원");
        for (int i = 0; i < drinkNames.length; i++) {
            System.out.printf("%s 재고: %d개\n", drinkNames[i], stocks[i]);
        }
    }

    // 재고 리필
    private static void refill(Scanner inputInt, int[] drinkStocks) {
        System.out.println("\n[음료 리필]");
        for (int i = 0; i < drinkStocks.length; i++) {
            System.out.printf("%d번 음료 현재 재고: %d개, 추가할 수량: ", i + 1, drinkStocks[i]);
            int add = inputInt.nextInt();
            if (add > 0) drinkStocks[i] += add;
        }
    }

    // 가격 변경
    private static void changePrice(Scanner input, int[] prices) {
        System.out.println("\n[가격 변경]");
        System.out.print("변경할 음료 번호 (1~4): ");
        int index = input.nextInt() - 1;
        if (index >= 0 && index < prices.length) {
            System.out.print("새 가격을 입력해 주세요: ");
            int newPrice = input.nextInt();
            prices[index] = newPrice;
            System.out.println("가격이 변경되었습니다.");
        } else {
            System.out.println("잘못된 번호입니다.");
        }
    }

    // 메뉴 이름 변경
    private static void changeMenu(Scanner input, Scanner inputStr, String[] names) {
        System.out.println("\n[메뉴 변경]");
        System.out.print("변경할 음료 번호 (1~4): ");
        int index = input.nextInt() - 1;
        if (index >= 0 && index < names.length) {
            System.out.print("새 이름을 입력해 주세요: ");
            String newName = inputStr.next();
            names[index] = newName;
            System.out.println("메뉴가 변경되었습니다.");
        } else {
            System.out.println("잘못된 번호입니다.");
        }
    }
}    
