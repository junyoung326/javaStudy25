package membertest.dto;

import java.sql.Date;

public class MemberDTO {
	// 필드
	private int mno;
	private String mname;
	private String mphone;
	private String id;
	private String pw; 
	private Date mdate;
	
	private String nickname;
	private String title;
	private String content;
	
	// 기본생성자
	
	// 메서드 -> 게터 / 세터
	
	public int getMno() {
		return mno;
	}
	public String getMname() {
		return mname;
	}
	public String getMphone() {
		return mphone;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	public String getNickname() {
		return nickname;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

	
	
	
}
