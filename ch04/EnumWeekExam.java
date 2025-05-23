package ch04;

public class EnumWeekExam {

	public static void main(String[] args) {
		Week today = Week.SUNDAY;
		System.out.println(today == Week.SUNDAY); // 변수값과 객체 주소가 같다.
		
		Week week1 = Week.SATURDAY;
		Week week2 = Week.SATURDAY;
		System.out.println(week1 == week2); // Week 타입에 열거상수를 대입해도 객체는 같다.
		
	}

}
