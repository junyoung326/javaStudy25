package test_exam.service;

import java.util.Scanner;

public class ManageSV {

	public static void manageSv(Scanner inputStr, Scanner inputInt, 
			String[] names, int[] studentNos, int[] engScores,
			int[] korScores, int[] totalScores, double[] avgScores) {
		boolean run = true;
		while(run) {
			for (int i = 0; i < names.length; i++) {
				int engSum = 0;
				engSum += engScores[i];
				int korSum = 0;
				korSum += korScores[i];
				double avg = 0;
				System.out.println();
			} // for문 종료
		} // while문 종료
	} // 메소드 종료

}
