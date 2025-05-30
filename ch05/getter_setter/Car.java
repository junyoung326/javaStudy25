package ch05.getter_setter;

public class Car {
	private int speed; // 개인적인 필드 선언
	
	void setSpeed (int speed) {
		if (speed<0) {
			this.speed = 0 ;
			return;
		}else {
			this.speed = speed;
		} // if문 종료
	} // setSpeed 종료, speed 입력값이 음수이면 0으로 입력
	
	double getSpeed() {// 게터 설정
		double km = speed*1.6;
		return km;
	} // 마일을 km로 환산하는 결과
	
	//-------------------------------------------------------
	private boolean stop;
	
	
	public boolean isStop() {
		return stop;
	}
	
	//Setter
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	} // stop값이 true이면 스톱을 진행하고 스피드 0으로 조절
	
}
