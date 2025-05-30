package ch04;

public class CarExam03 {

	int speed; // 필드 생성
	void run() {
		System.out.println(speed + "으로 달립니다.");
	}; // 메소드 생성
	
	public static void main(String[] args) {
		CarExam03 myCar = new CarExam03();
		myCar.speed = 60;
		myCar.run();

	}

}
