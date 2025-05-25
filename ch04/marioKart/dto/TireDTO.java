package ch04.marioKart.dto;

public class TireDTO {
	// 필드
	public String name; // 타이어명
	public double groundSpeed; // 지상속도
	public double control; // 제어력
	public double drift; // 미끄러짐

	// 생성자
	public TireDTO(String name, double groundSpeed, double control, double drift) {
		this.name = name;
		this.groundSpeed = groundSpeed;
		this.control = control;
		this.drift = drift;
			
	}
	

}
