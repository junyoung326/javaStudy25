package test_exam.service;

import java.util.Scanner;

import test_exam.dto.TestDTO;

public class InputScoresSV {


	public static void inputScores(Scanner inputStr, Scanner inputInt, String[] names, int[] studentNos,
			int[] engScores, int[] korScores, int[] totalScores, double[] avgScores) {
		
		for(int i = 0 ; i < names.length ; i++) {
			TestDTO test = new TestDTO(null, 0, 0, 0, 0, 0);
			System.out.println((i+1) + "번째 학생의 이름를 입력하세요");
			System.out.print(">>>");
			test.setName(inputStr.next());
			names[i] = test.getName();
			
			System.out.println((i+1) + "번째 학생의 학번을 입력하세요");
			System.out.print(">>>");
			test.setStudentNo(inputInt.nextInt());
			studentNos[i] = test.getStudentNo();
			
			System.out.println((i+1) + "번째 학생의 영어 점수를 입력하세요");
			System.out.print(">>>");
			test.setEngScore(inputInt.nextInt());
			engScores[i] = test.getEngScore();
			
			System.out.println((i+1) + "번째 학생의 국어 점수를 입력하세요");
			System.out.print(">>>");
			test.setKorScore(inputInt.nextInt());
			korScores[i] = test.getKorScore();
			
			test.setTotalScore(0);
			test.setAvgScore(0);
			int total = test.getTotalScore();
			double avg = test.getAvgScore();
			
			System.out.println((i+1) + "번째 학생의 이름 : " + names[i] + ", 학번 : " +engScores[i] + " , 영어 점수 : " + engScores[i] + 
					" , 국어점수 : " + korScores[i] + " , 총 점수 : " + total + ", 평균 점수 : " + avg);

			
		} // for문 종료 // 학생 수만큼 배열에 점수를 입력한다.(C)
		
	
	} // 메소드 종료
		
} // 클래스 종료
