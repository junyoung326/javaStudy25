package ch03;

public class ForEachExam {

	public static void main(String[] args) {
		int[] scores = {95, 71, 84, 93, 87}; // 1차원 배열 생성 후 값 입력
		
		int sum = 0; 
		for (int i : scores) { // 향상된 for문 i는 증가가 되는 변수 : scores는 최소값/최대값/증감대용
			sum += i ; // sum = sum + i
			
		}
		System.out.println("점수의 총합: " + sum);
		
		String[] name = new String[] {"엠비씨", "아카데미", "컴퓨터", "교육센터"};
		for (String i : name) {
			System.out.println(i);
		}
	} 

}
