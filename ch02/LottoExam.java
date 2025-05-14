package ch02;

import java.util.Scanner;

public class LottoExam {  // 객체

	public static void main(String[] args) {  //주메서드
		// 로또 당첨 프로그램
		// 랜덤값으로 1~45의 숫자를 맞추세요.
		Scanner in = new Scanner(System.in); // 키보드로 입력 받는 객체를 in 변수에 연결
		System.out.println("로또 1부터 45까지의 번호 중 6개를 입력해 주세요.");
		
		int myNum1 = in.nextInt();
		System.out.println("첫 번째 번호: " + myNum1);
		int myNum2 = in.nextInt();
		System.out.println("두 번째 번호: " + myNum2);
		int myNum3 = in.nextInt();
		System.out.println("세 번째 번호: " + myNum3);
		int myNum4 = in.nextInt();
		System.out.println("네 번째 번호: " + myNum4);
		int myNum5 = in.nextInt();
		System.out.println("다섯 번째 번호: " + myNum5);
		int myNum6 = in.nextInt();
		System.out.println("여섯 번째 번호: " + myNum6); // 키보드로 번호 6개를 입력 받아 저장

		int num1 = (int)(Math.random()*45) + 1;
		int num2 = (int)(Math.random()*45) + 1;
		int num3 = (int)(Math.random()*45) + 1;
		int num4 = (int)(Math.random()*45) + 1;
		int num5 = (int)(Math.random()*45) + 1;
		int num6 = (int)(Math.random()*45) + 1; // 6개의 로또 랜덤번호 생성 후 저장
		
		int x = 0; // 맞은 숫자
		
		if (myNum1 == num1 || myNum1 == num2 || myNum1 == num3 || myNum1 == num4 || myNum1 == num5 || myNum1 == num6) {
			++x;
		} // 첫 번째 if문 종료
		if (myNum2 == num1 || myNum2 == num2 || myNum2 == num3 || myNum2 == num4 || myNum2 == num5 || myNum2 == num6) {
			++x;
		} // 두 번째 if문 종료
		if (myNum3 == num1 || myNum3 == num2 || myNum3 == num3 || myNum3 == num4 || myNum3 == num5 || myNum3 == num6) {
			++x;
		} // 세 번째 if문 종료
		if (myNum4 == num1 || myNum4 == num2 || myNum4 == num3 || myNum4 == num4 || myNum4 == num5 || myNum4 == num6) {
			++x;
		} // 네 번째 if문 종료
		if (myNum5 == num1 || myNum5 == num2 || myNum5 == num3 || myNum5 == num4 || myNum5 == num5 || myNum5 == num6) {
			++x;
		} // 다섯 번째 if문 종료
		if (myNum6 == num1 || myNum6 == num2 || myNum6 == num3 || myNum6 == num4 || myNum6 == num5 || myNum6 == num6) {
			++x;
		} // 여섯 번째 if문 종료
		System.out.println("===============================");
		System.out.println("이번 주 로또 당첨 번호입니다.");
		System.out.println(num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + " " + num6);
		System.out.println("===============================");

		if (x==0) {
			System.out.println("번호가 하나도 맞지 않았습니다.");
		} else if (x==1) {
			System.out.println("축하합니다. 번호가 1개 맞았습니다.");
		} else if (x==2) {
			System.out.println("축하합니다. 번호가 2개 맞았습니다.");
		} else if (x==3) {
			System.out.println("축하합니다. 번호가 3개 맞았습니다.");
		} else if (x==4) {
			System.out.println("축하합니다. 번호가 4개 맞았습니다.");
		} else if (x==5) {
			System.out.println("축하합니다. 번호가 5개 맞았습니다.");
		} else if (x==6) {
			System.out.println("축하합니다. 번호가 6개 맞았습니다.");
		} else {
			System.out.println("시스템이 아파요.");
		} // if문 종료
		
	} // 메인 메서드 종료

} // 클래스 종료
