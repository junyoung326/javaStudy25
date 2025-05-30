package ch05.getter_setter;

public class CarExam {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		//잘못된 속도를 제공
		myCar.setSpeed(-50);
		System.out.println("현재 속도 : " + myCar.getSpeed());
		// 값을 제공할 때는 setter
		//값을 받을 때는 getters
		
		myCar.setSpeed(60); // 정상속도 확인
		System.out.println("현재 속도 : " + myCar.getSpeed());
		
		//멈춤테스트
		if(!myCar.isStop()) { //myCar가 달리는 중이면(true) 안에 있는 코드 실행 : 자동차가 아직 달리는 중일 경우 멈추기
			myCar.setStop(true);		
		}
		System.out.println("현재 중지 상태 : " + myCar.getSpeed());
	}

}
