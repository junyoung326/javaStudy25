package test_exam.dto;

public class TestDTO {
	// 필드
	private String name ; // 학생 이름 작성
	private int studentNo ; // 학번 작성
	private int engScore ; // 영어 성적 작성
	private int korScore ; // 국어 성적 작성
	private int totalScore ; // 총점 성적 작성
	private double avgScore ; // 평균 성적 작성
	
	// 생성자
	public TestDTO(String name, int studentNo, int engScore, int korScore, int totalScore, double avgScore) {
		this.name = name;
		this.studentNo = studentNo;
		this.engScore = engScore;
		this.korScore = korScore;
		this.totalScore = totalScore;
		this.avgScore = avgScore;
	}
	// 메서드
	public String getName() {
		return name;
	}
	public int getStudentNo() {
		return studentNo;
	}
	public int getEngScore() {
		return engScore;
	}
	public int getKorScore() {
		return korScore;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public double getAvgScore() {
		return avgScore;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public void setEngScore(int engScores) {
		this.engScore = engScores;
	}
	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = engScore + korScore;
	}
	public void setAvgScore(double avgScore) {
		this.avgScore = (engScore + korScore)/2;;
	}
	
}
