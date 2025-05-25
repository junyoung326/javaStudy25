package ch04.marioKart.dto;

public class GliderDTO {
	// 필드
	public String name; // 글라이더명
	public double airSpeed; // 비행속도
	public double fallSpeed; // 낙하속도
	public double handling; // 핸들링(조작성)

	// 생성자
	public GliderDTO(String name, double airSpeed, double fallSpeed, double handling) {
		this.name = name;
		this.airSpeed = airSpeed;
		this.fallSpeed = fallSpeed;
		this.handling = handling;
	}
}
