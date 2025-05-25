package ch04.marioKart;

import java.util.Scanner;

import ch04.marioKart.dto.CartDTO;
import ch04.marioKart.dto.CharacterDTO;
import ch04.marioKart.dto.GliderDTO;
import ch04.marioKart.dto.MemberDTO;
import ch04.marioKart.dto.TireDTO;

public class GameService {
	// 필드

	// 생성자
	// selectTrack(); 트랙선택
	// startRace(); 게임시작(결과공개)

	// 메서드
	public static void menu(Scanner input, CharacterDTO[] characterDTOs, MemberDTO loginState, CartDTO[] cartDTOs,
			GliderDTO[] gliderDTOs, TireDTO[] tireDTOs, TrackDTO[] trackDTOs) {
		System.out.println("--------------게임 서비스 메뉴에 진입하였습니다.--------------");
		boolean run = true;
		while (run) {
			System.out.println("1. 글라이더 선택 | 2. 타이어 선택 | 3. 트랙 선택 | 4. 게임 시작");
			System.out.print(">>>");
			String select = input.next();
			switch (select) {
			case "1":
				for (int i = 0; i < gliderDTOs.length; i++) {
					if (gliderDTOs[i] != null) {
						System.out.println("글라이더 이름: " + gliderDTOs[i].name + ", 비행속도 : " + gliderDTOs[i].airSpeed
								+ ", 낙하속도 : " + gliderDTOs[i].fallSpeed + ", 핸들링(조작성) : " + gliderDTOs[i].handling);
					} // if문 종료
				} // for문 종료 (글라이더 목록 출력)
				System.out.println("장착하고 싶은 글라이더 이름을 입력해 주세요!");
				System.out.print(">>>");
				String selectGlider = input.next();
				for (int i = 0; i < gliderDTOs.length; i++) {
					if (gliderDTOs[i] != null && gliderDTOs[i].name.equals(selectGlider)) {
						loginState.gliderDTO = gliderDTOs[i];
					} // if문 종료
				} // for문 종료 (글라이더 선택)
				System.out.println(loginState.nickName + "님이 " + loginState.gliderDTO.name + "을/를 장착하였습니다.");
				break;
			case "2":
				for (int i = 0; i < tireDTOs.length; i++) {
					if (tireDTOs[i] != null) {
						System.out.println("타이어 이름: " + tireDTOs[i].name + ", 지상속도 : " + tireDTOs[i].groundSpeed
								+ ", 제어력 : " + tireDTOs[i].control + ", 미끄러짐 : " + tireDTOs[i].drift);
					} // if문 종료
				} // for문 종료 (타이어 목록 출력)
				System.out.println("장착하고 싶은 타이어 이름을 입력해 주세요!");
				System.out.print(">>>");
				String selectTire = input.next();
				for (int i = 0; i < gliderDTOs.length; i++) {
					if (tireDTOs[i] != null && tireDTOs[i].name.equals(selectTire)) {
						loginState.tireDTO = tireDTOs[i];
					} // if문 종료
				} // for문 종료 (글라이더 선택)
				System.out.println(loginState.nickName + "님이 " + loginState.tireDTO.name + "을/를 장착하였습니다.");
				break;
			case "3":
				System.out.println("1. 마리오서킷: 마리오 대표 트랙");
				System.out.println("2. 화산트랙: 용암이 무너지는 트랙");
				System.out.println("3. 도쿄블러: 도쿄 도심 배경 트랙");
				System.out.println("4. 초코마운틴: 낙석 주의, 미끄러운 지형의 트랙");
				System.out.println("원하는 트랙 번호(1~4)를 선택해 주세요!");
				System.out.print(">>>");
				String selectTrack = input.next();
				switch(selectTrack) {
				case "1": 
					loginState.trackDTO = trackDTOs[0];
					System.out.println(loginState.nickName + "님이 " + loginState.trackDTO.name + "에 입장하였습니다.");
					break;
				case "2": 
					loginState.trackDTO = trackDTOs[1];
					System.out.println(loginState.nickName + "님이 " + loginState.trackDTO.name + "에 입장하였습니다.");
					break;
				case "3": 
					loginState.trackDTO = trackDTOs[2];
					System.out.println(loginState.nickName + "님이 " + loginState.trackDTO.name + "에 입장하였습니다.");
					break;
				case "4": 
					loginState.trackDTO = trackDTOs[3];
					System.out.println(loginState.nickName + "님이 " + loginState.trackDTO.name + "에 입장하였습니다.");			
					break;
				} // 트랙 선택 스위치문 종료
				break;
			case "4":
				System.out.println("게임을 시작합니다!!!");
				System.out.println(loginState.trackDTO.item + " 아이템전입니다.");
				System.out.println(loginState.trackDTO.item + "을 지금 사용하시겠습니까?");
				System.out.print(">>>");
				String answer = input.next();
				if (answer.equalsIgnoreCase("yes")) {
					if (loginState.trackDTO.item.equals("바나나")) {
						loginState.characterDTO.handling += 1.5; // 상대가 없어서 핸들링 점수 상승..	
						System.out.println("핸들링 점수가 1.5 상승하여 " + loginState.characterDTO.handling + "점입니다.");
					} else if(loginState.trackDTO.item.equals("폭탄")) {
						loginState.characterDTO.acceleration += 1.5;
						System.out.println("가속 점수가 1.5 상승하여 " + loginState.characterDTO.acceleration + "점입니다.");
					} else if(loginState.trackDTO.item.equals("부스트")) {
						loginState.characterDTO.acceleration += 3.0;
						System.out.println("가속 점수가 3.0 상승하여 " + loginState.characterDTO.acceleration + "점입니다.");
					} else if(loginState.trackDTO.item.equals("번개")) {
						loginState.characterDTO.speed += 2.0;
						System.out.println("스피드 점수가 2.0 상승하여 " + loginState.characterDTO.speed + "점입니다.");
					}
				} else {
					System.out.println("아이템을 사용하지 않습니다.");
				} // 대답 if문 종료
				
			default:
				System.out.println("1~4 중에서 입력해 주세요!");
				continue;

			} // 스위치문 종료
		} // 와일문 종료
} // 메뉴 메서드 종료
}
