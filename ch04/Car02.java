package ch04;

public class Car02 { // Car 클래스를 공용으로 생성한다.
	// 필드 (객체의 데이터가 저장되는 곳)
	// ----- 고유 데이터 ----
	String company = "볼보"; // 제작회사
	String model = "xc90" ; // 모델
	String color = "핑크"; // 색상
	int maxSpeed = 300; // 최고 속도
	int productionYear = 2022; //생산년도
	int currentSpeed = 100 ; // 주행속도
	boolean engineStart = true; // 시동 상태
	// ----- 상태 -----
	int speed; // 현재 속도
	int rpm; // 현재 엔진회전수
	
	// 생성자 (객체 생성 시 초기화 역할 담당)
	Car02(){
		speed = 0;
	}

}
