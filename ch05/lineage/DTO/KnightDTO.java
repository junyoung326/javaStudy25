package ch05.lineage.DTO;

public class KnightDTO extends HumanDTO { // 객체를 상속한다.
	
	// 필드
	private String sword; // 칼
	private String armor; // 갑옷
	private String shield; // 방패
	
	// 생성자

	// 메서드
	
	
	public String getSword() {
		return sword;
	}

	public String getArmor() {
		return armor;
	}

	public String getShield() {
		return shield;
	}

	public void setSword(String sword) {
		this.sword = sword;
		
	}

	public void setArmor(String string) {
		this.armor = armor;
		
	}

	public void setShield(String string) {
		this.shield = shield;
		
	}

	public void setName(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setSex(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setLevel(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setHp(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setMp(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setMoney(int i) {
		// TODO Auto-generated method stub
		
	}

}
