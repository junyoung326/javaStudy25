package ch04.marioKart;

public class TrackDTO {
	// 필드
	public String name; // 트랙 이름
	public String item; // 트랙별 추가되는 아이템 이름
	
	// 생성자
	public TrackDTO(String name, String item) {
		this.name = name;
		this.item = item;
	}

}
