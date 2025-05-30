package test_exam.service;

import java.util.Scanner;

import test_exam.dto.TestDTO;

public class DeleteScoresSV {

	public static void deleteScores(Scanner inputStr, Scanner inputInt, String[] names, int[] studentNos,
			int[] engScores, int[] korScores, int[] totalScores, double[] avgScores) {
		boolean run = true;
		while(run) {
			for (int i = 0; i < names.length; i++) {
				System.out.println("성적 삭제를 원하는 학생의 학번을 입력해 주세요!");
				System.out.print(">>>");
				int selectStNo = inputInt.nextInt();
				if (selectStNo == studentNos[i]) {
					System.out.println("삭제할 과목을 입력해 주세요!");
					System.out.print(">>>");
					String selectSj = inputStr.next();
					switch(selectSj){
					case "영어":
						engScores[i] = 0;
						System.out.println(names[i] + "학생의 영어 성적이 초기화되었습니다.");
						run = false;
						break;
					case "국어":
						korScores[i] = 0;
						System.out.println(names[i] + "학생의 영어 성적이 초기화되었습니다.");
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
