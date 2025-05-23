package ch04;

import java.util.Scanner;

public class Car {
	// 필드 (객체가 가지고 있어야 하는 값) -> 글로벌 변수 (GV)
	// 고유 데이터
	public String company; // 제작회사(현대, 기아, KGM, 쉐보레, 아우디)
	public String model; // 아반테, 그렌져, 소나타
	public String color; // 빨강, 은색, 검정색, 흰색
	public int maxSpeed = 300; // 최고속도
	public String oilType; // 경유, 휘발유
	public final int MAXSPEED = 300; 
	public final int MINSPEED = 0; 

	
	// 상태값(변동 가능)
	public int speed;
	public int rpm;
	public int oil;
	
	// 부품 -> 다른 클래스를 생성하여 연결한다.
	// public Body body;
	// public Engine engine;
	// public Tire tire;
	
	// 부품에 필드 사용법
	// Car myCar = new Car(); -> 객체 생성 (인스턴스)
	// myCar.maxSpeed = 300; -> 객체에 있는 maxSpeed에 300 정수를 넣는다.
	// -------------------------------------------------------------
	
	// 기본 생성자 : 생략 가능 (객체가 생성할 때 사용되는 메서드 : 클래스며오가 같은 이름을 사용한다.)
	public Car() {
		speed = 0;
		rpm = 50;
		oil = 100;
	
		
	} // 객체가 생성되면서 변수에 값이 저장됨.
	
	// 사용자지정 생성자 -> 개발자가 응용하는 기법
	// 사용자 지정 생성자가 만들어지면 기본생성자는 자동으로 생성되지 않는다.
	public Car(String company, String model, String color) {
		this.company = company ;
		this.model = model ;
		this.color = color ;
	} // Car myCar = new Car("벤츠", "이클래스", "빨강");
	
	
	// 메서드 (객체가 수행해야 되는 동작)
	// c(시동시작) r(차량상태, 주행상태), u(가속, 감속, 주차) d(시동종료)
	public void start() {
		System.out.println(this.model + "가(이) 주행을 시작합니다.");
		System.out.println("현재 속도 : " + this.speed);
		System.out.println("현재 rpm : " + this.rpm);
		System.out.println("현재 주유량 : " + this.oil);
	} // start 메서드 종료
	
	public void drive() {
		boolean run= true;
		while (run) {
			Scanner inputInt = new Scanner(System.in);
			System.out.println("1. 가속");
			System.out.println("2. 감속");
			System.out.println("3. 주차");
			System.out.print("(숫자)>>>");
			int select = inputInt.nextInt();
			switch (select) {
			case 1:
				if (this.speed < MAXSPEED) {
					this.speed += 50;
					this.rpm = 100;
					this.oil -= 10;
					System.out.println("현재 속도는 " + this.speed + "이고, rpm은 "+ this.rpm + "입니다.");
				} else {
					System.out.println("더 이상 가속이 불가능합니다.");
				}// case 1 if문 종료
				break;
			case 2:
				if (this.speed > MINSPEED) {
					this.speed -= 50;
					this.rpm = 50;
					this.oil -= 10;
					System.out.println("현재 속도는 " + this.speed + "이고, rpm은 "+ this.rpm + "입니다.");
				} else {
					System.out.println("더 이상 감속이 불가능합니다.");
				}// case 2 if문 종료
				break;
			case 3:       
				if (this.speed > MINSPEED) {
					this.speed = 30;
					System.out.println("주차를 시작하겠습니다. 현재 속도 : " + this.speed);
					this.speed = 0;
					this.oil -= 10;
					System.out.println("주차 완료! 현재 속도 : " + this.speed);
					run = false;
				} else {
					System.out.println("최저 속도입니다. 가속한 후 다시 시도해 주세요.");
				} // case 3 if문 종료
				break;
			default:
				System.out.println("숫자 1~3 중에 입력해 주세요.");
			} // 스위치문 종료
		} // 와일문 종료

	} // drive 메서드 종료
} // Car 클래스 종료
