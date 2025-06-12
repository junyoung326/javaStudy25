package mbcboard.dto;

import java.sql.Date;

public class MemberDTO {
	// 게시판의 객체를 담당하고, 게터/세터
	// 필드
	private int mno;
	private String bwriter;
	private String id;
	private String pw;
	private Date regidate; // import java.sql.Date;

	// 기본생성자
	
	// 메서드 -> 게터/세터
	public int getMno() {
		return mno;
	}
	public String getBwriter() {
		return bwriter;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

}
