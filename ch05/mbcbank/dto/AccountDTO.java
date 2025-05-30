package ch05.mbcbank.dto;

public class AccountDTO { //한 계좌를 담을 수 있는 필드
	private String ano; // 계좌번호
	private String owner; // 계좌주
	private int balance; // 잔고
	private String bankName ; // 은행명
	
	// 생성자
	public AccountDTO(String ano, String owner, int balance, String bankName) {
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
		this.bankName = bankName;
	}
	public AccountDTO() {
		// AccountDTO accountDTO = new AccountDTO();
	}
	
	// 메서드 (게터와 세터를 이용하여 필드를 활용한다.)
	public String getAno() {
		// 계좌번호 출력 시 변조를 담당
		return ano;
	}
	public String getOwner() {
		return owner;
	}
	public int getBalance() {
		return balance;
	}
	public String getBankName() {
		return bankName;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Override
	public String toString() {
		return "AccountDTO [ano=" + ano + ", owner=" + owner + ", balance=" + balance + ", bankName=" + bankName + "]";
	}
	
	
}
