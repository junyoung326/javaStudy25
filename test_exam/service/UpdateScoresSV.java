package test_exam.service;

import java.util.Scanner;

import test_exam.dto.TestDTO;

public class UpdateScoresSV {

	public static void updateScores(Scanner inputStr, Scanner inputInt, String[] names, int[] studentNos,
			int[] engScores, int[] korScores, int[] totalScores, double[] avgScores) {
		TestDTO test = new TestDTO(null, 0, 0, 0, 0, 0);
		boolean run = true;
		while(run) {
			for (int i = 0; i < names.length; i++) {
				System.out.println("성적 수정을 원하는 학생의 학번을 입력해 주세요!");
				System.out.print(">>>");
				int selectStNo = inputInt.nextInt();
				if (selectStNo == studentNos[i]) {
					System.out.println("수정할 과목을 입력해 주세요!");
					System.out.print(">>>");
					String selectSj = inputStr.next();
					switch(selectSj){
					case "영어":
						System.out.println("점수를 수정해 주세요!");
						System.out.print(">>>");
						engScores[i] = inputInt.nextInt();
						System.out.println("영어 성적은 " + engScores[i] + "점으로 수정되었습니다.");
						run = false;
						break;
					case "국어":
						System.out.println("점수를 수정해 주세요!");
						System.out.print(">>>");
						korScores[i] = inputInt.nextInt();
						System.out.println("국어 성적은 " + korScores[i] + "점으로 수정되었습니다.");
						run = false;
						break;
					default:
						System.out.println("국어와 영어 중 선택하여 입력해 주세요.");
					} // switch문 종료
				} // if문 종료
			} // for문 종료
		} // while문 종료
		
	} // 메소드 종료

} // 클래스 종료
