package test_exam;

import java.util.Scanner;

import ch04.marioKart.service.MemberService;
import test_exam.service.DeleteScoresSV;
import test_exam.service.InputScoresSV;
import test_exam.service.ManageSV;
import test_exam.service.ReadScoresSV;
import test_exam.service.UpdateScoresSV;

public class TestExam {
	
	// 필드
	static Scanner inputStr = new Scanner(System.in); // String용 스캐너
	static Scanner inputInt = new Scanner(System.in); // Int용 스캐너

	public static String[] names = new String[10]; // 학생 이름 테이블 작성
	public static int[] studentNos = new int[10]; // 학번 테이블 작성
	public static int[] engScores = new int[10]; // 영어 성적 테이블 작성
	public static int[] korScores = new int[10]; // 국어 성적 테이블 작성
	public static int[] totalScores = new int[10]; // 총점 성적 테이블 작성
	public static double[] avgScores = new double[10]; // 평균 성적 테이블 작성
	
	// 생성자
	
	// 메소드
	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("========MBC 교육센터 성적 관리 프로그램=======");
			System.out.println("1. 성적입력 | 2. 성적확인 | 3. 성적수정 | 4. 성적삭제 | 5. 종료");
		    System.out.println("=============================");
		    System.out.print(">>>>>");
		    int select = inputInt.nextInt(); // 1~4까지 정수 입력 후에 분기
		    switch(select) {
		    case 1:
		    	InputScoresSV.inputScores(inputStr, inputInt, names, studentNos, engScores, korScores, totalScores, avgScores);
		    	break;
		    case 2:
		    	ReadScoresSV.readScores(inputStr, inputInt, names, studentNos, engScores, korScores, totalScores, avgScores);
		    	break;
		    case 3:
		    	UpdateScoresSV.updateScores(inputStr, inputInt, names, studentNos, engScores, korScores, totalScores, avgScores);
		    	break;
		    case 4:
		    	DeleteScoresSV.deleteScores(inputStr, inputInt, names, studentNos, engScores, korScores, totalScores, avgScores);
		    	break;
		    case 5:
		    	System.out.println("성적관리 프로그램을 종료합니다.");
		    	System.out.println("성적처리 고생하셨습니다.");
		    	run = false;
		    	break;
		    case 99 :
		    	System.out.println("관리자 메뉴 입니다.");
		    	System.out.println("학생들의 총합 점수와 총 평균을 확인합니다.");
		    	ManageSV.manageSv(inputStr, inputInt, names, studentNos, engScores, korScores, totalScores, avgScores);
		    	
		    default:
		    	System.out.println("1~4 중에서 입력해 주세요.");
		   
		    } // select 주 메뉴 스위치문 종료
		} // while문 종료
	} // 메인 메소드 종료
} // 클래스 종료

	