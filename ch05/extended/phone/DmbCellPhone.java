package ch05.extended.phone;

public class DmbCellPhone extends CellPhone { // 자식 라이브러리 클래스
	int channel; // 자식 필드 추가 (dmb 폰은 방송을 볼 수 있는 기능이 추가됨)
	
	// 생성자 -> 매개값을 입력받아 초기값을 진행
	public DmbCellPhone(String model, String color, int channel) {
		super(); // 부모 기본 생성자 호출
		this.model = model; // 부모필드
		this.color = color;
		this.channel = channel; // 자신필드
	}

	// 메소드 -> 자식 클래스에 추가된 기능
	void turnOnDmb() {
		System.out.println("채널" + channel + "번 DMB 방송 수신을 시작합니다.");
	} // DMB 방송시작
	void changeChannelDmb(int channel) {
		this.channel = channel; // 채널 번호를 입력 받아 채널 변경 진행
		System.out.println("채널을 " + channel + "번으로 변경합니다.");
	} //DMB 채널변경
	void turnOffDmb() {
		System.out.println("DMB 방송 수신을 중지합니다.");
	} // DMB 방송종료
}
