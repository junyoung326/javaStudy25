package ch05.extended.phone;

public class DmbCellPhoneExam {

	public static void main(String[] args) {
		DmbCellPhone dmbPhone = new DmbCellPhone("디엠비폰", "빨강", 10);
		// 생성자로 초기값을 전달한다. (모델명, 색상, 채널번호)
		System.out.println("모델 : " + dmbPhone.model);
		System.out.println("색상 : " + dmbPhone.color);
		// 부모로부터 받은 필드를 활용하여 출력
		System.out.println("채널번호 : " + dmbPhone.channel);
		System.out.println("----------------------------");
		// 전화에 대한 부모 메소드 활용
		dmbPhone.powerOn(); // 전원 켭니다.
		dmbPhone.bell(); // 전화벨이 울립니다.
		dmbPhone.sendVoice("여보세요");
		dmbPhone.receiveVoice("안녕하세요 김기원입니다.");
		dmbPhone.sendVoice("반갑습니다.");
		dmbPhone.receiveVoice("테스트 종료합니다. 안녕히 계세요.");
		dmbPhone.hangup(); // 전화 종료
		System.out.println("----------------------------");
		
		// dmb에 대한 방송 자식 메소드 활용
		dmbPhone.turnOnDmb(); // dmb 전원을 켭니다.
		dmbPhone.changeChannelDmb(12); // 채널 변경함
		dmbPhone.turnOffDmb(); // dmb 전원을 끕니다.
	}

}
