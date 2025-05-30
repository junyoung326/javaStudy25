package ch04.marioKart.service;

import java.util.Scanner;

import ch04.marioKart.dto.CartDTO;
import ch04.marioKart.dto.CharacterDTO;
import ch04.marioKart.dto.MemberDTO;

public class CartService {
	// 필드
	
	
	
	// 생성자
	
	
	
	// 메서드
	public static void menu(Scanner input, CharacterDTO[] characterDTOs, MemberDTO loginState, CartDTO[] cartDTOs) {
		// 키보드 입력, 객체 캐릭터 배열, 로그인한 사용자 상태, 객체 카트 배열
		for (int i = 0 ; i< characterDTOs.length; i++) {
			if(characterDTOs[i] != null) {
				System.out.println("이름 : " + characterDTOs[i].name + "무게 : " + characterDTOs[i].weight + "\n");
			} // if문 종료
		} // for문 종료
		System.out.println("캐릭터를 선택하세요");
		System.out.print(">>>");
		String selectChar = input.next();
		
		for (int i = 0 ; i < characterDTOs.length; i++) {
			if (characterDTOs[i] != null && characterDTOs[i].name.equals(selectChar)) {
				loginState.characterDTO = characterDTOs[i];
				switch (selectChar) {
				case "마리오": 
					loginState.cartDTO = cartDTOs[i];
					break;
				case "루이지":
					loginState.cartDTO = cartDTOs[i];
					break;
				case "와리오":
					loginState.cartDTO = cartDTOs[i];
					break;
				case "피치":
					loginState.cartDTO = cartDTOs[i];					
					break;
				} // 스위치문 종료	
				// 키보드로 선택한 캐릭터 정보를 로그인한 객체에 연결!!!!
			} // if문 종료
		} // for문 종료
		System.out.println(loginState.nickName + "님은 " + loginState.characterDTO.name +
				"을 선택하셔서 " + loginState.cartDTO.cart + "가 배정되었습니다.");
	} // menu 메서드 종료

}
