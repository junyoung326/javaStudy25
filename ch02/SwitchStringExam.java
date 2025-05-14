package ch02;

public class SwitchStringExam {

	public static void main(String[] args) {
		String position = "과장";
		
		switch (position) {
		case "부장" :
			System.out.println(position + " 성과급은 1000만원");
			break;
		case "과장" :
			System.out.println(position + " 성과급은 1500만원");
			break;
		case "대리" :
			System.out.println(position + " 성과급은 2000만원");
			break;
		default:
			System.out.println("성과급 없음.");
			break;
		} // switch문 종료

	}

}
