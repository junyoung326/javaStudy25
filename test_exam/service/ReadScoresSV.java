package test_exam.service;

import java.util.Scanner;

import test_exam.dto.TestDTO;

public class ReadScoresSV {

	public static void readScores(Scanner inputStr, Scanner inputInt, String[] names, 
			int[] studentNos, int[] engScores, int[] korScores, int[] totalScores, double[] avgScores) {
		TestDTO test = new TestDTO(null, 0, 0, 0, 0, 0);
		for (int i = 0; i < names.length; i++) {
			System.out.println("성적 확인을 원하시는 학생의 학번을 입력해 주세요!!");
			System.out.print(">>>");
			int selectStNo = inputInt.nextInt();
			if (selectStNo == studentNos[i]) {
				System.out.println(studentNos[i] + " 학번인 " + names[i] + " 학생의 영어 점수는 " + engScores[i] + "점이며, 국어 점수는 "
						+ korScores[i] + "점, 총점 " + totalScores[i] + "점, 평균 " + avgScores[i] + "점 입니다!!" );
			break;
			} // if문 종료
		} // for문 종료
		
	} // 메소드 종료

}
