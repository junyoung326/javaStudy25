package ch04.marioKart;

import java.util.Scanner;

import ch04.marioKart.dto.CartDTO;
import ch04.marioKart.dto.CharacterDTO;
import ch04.marioKart.dto.GliderDTO;
import ch04.marioKart.dto.MemberDTO;
import ch04.marioKart.dto.TireDTO;
import ch04.marioKart.service.MemberService;

	// 마리오카트 게임 프로젝트
	// MVC 패턴으로 프로젝트 구현
	// DTO : 객체처리 (Data Transfer Object, 데이터 전송 객체) -> new
	// service : 부메뉴용 (객체와 객체를 연결하여 서비스 제공)
	// start : 배열과 주메뉴용

public class MarioKartExam {
	// 필드
	public static Scanner input = new Scanner(System.in); // 키보드 입력
	public static MemberDTO[] memberDTOs = new MemberDTO[10]; // 회원 배열
	public static CharacterDTO[] characterDTOs = new CharacterDTO[15]; //캐릭터 배열
	public static CartDTO[] cartDTOs = new CartDTO[8]; // 카트 배열
	public static GliderDTO[] gliderDTOs = new GliderDTO[10]; // 글라이더 배열
	public static TireDTO[] tireDTOs = new TireDTO[10]; // 아이템 배열
	public static TrackDTO[] trackDTOs = new TrackDTO[10]; // 트랙배열
	
	public static MemberDTO LoginState; // 로그인 상태 유지 (세션)
	
	// MemberSV memberService ; // 메인메뉴 실행하면서 객체 생성
	
	// 생성자 -> static에는 필요 없음 (new MarioKartExam()으로 객체를 생성하지 않는다.)
	static {
		CharacterDTO characterDTO0 = new CharacterDTO("마리오", 3.0, 4.5, 3.7, 4.1, 3.8);
		CharacterDTO characterDTO1 = new CharacterDTO("루이지", 3.2, 4.4, 3.1, 4.4, 3.2);
		CharacterDTO characterDTO2 = new CharacterDTO("와리오", 3.4, 4.2, 3.2, 4.2, 3.4);
		CharacterDTO characterDTO3 = new CharacterDTO("피치", 3.1, 4.8, 3.4, 4.5, 3.5);
		CartDTO cartDTO0 = new CartDTO("마리오카트");
		CartDTO cartDTO1 = new CartDTO("루이지카트");
		CartDTO cartDTO2 = new CartDTO("와리오카트");
		CartDTO cartDTO3 = new CartDTO("피치카트");
		GliderDTO gliderDTO0 = new GliderDTO("기본글라이더", 5.0, 5.0, 5.0);
		GliderDTO gliderDTO1 = new GliderDTO("클라우드글라이더", 6.0, 4.0, 5.0); // 하늘에서 더 오래 떠 있음
		GliderDTO gliderDTO2 = new GliderDTO("금색글라이더", 7.0, 7.0, 3.0); // 속도 빠름, 낙하도 빠름
		GliderDTO gliderDTO3 = new GliderDTO("부엉이글라이더", 4.0, 4.0, 8.0); // 조작이 쉬움, 초보자용
		TireDTO tireDTO0 = new TireDTO("기본타이어", 5.0, 5.0, 5.0);
		TireDTO tireDTO1 = new TireDTO("오프로드타이어", 4.0, 7.0, 3.0); //울퉁불퉁한 지형에서 안정적
		TireDTO tireDTO2 = new TireDTO("슬릭타이어", 7.0, 3.0, 8.0); //속도 빠름, 미끄러움
		TireDTO tireDTO3 = new TireDTO("풍선타이어", 4.0, 6.0, 4.0); //가벼움, 점프력 상승
		TrackDTO trackDTO0 = new TrackDTO("마리오서킷", "바나나"); // 바나나는 상대를 미끄러지게 함
		TrackDTO trackDTO1 = new TrackDTO("화산트랙", "폭탄"); // 폭탄은 상대가 잠시 못 움직임
		TrackDTO trackDTO2 = new TrackDTO("도쿄블러", "부스트"); // 본인 속도가 빨라짐
		TrackDTO trackDTO3 = new TrackDTO("초코마운틴", "번개"); // 상대의 크기를 줄여 속도 낮춤
		
		// 객체 생성완료
		
		characterDTOs[0] = characterDTO0; // 캐릭터 배열
		characterDTOs[1] = characterDTO1;
		characterDTOs[2] = characterDTO2;
		characterDTOs[3] = characterDTO3;
		// CharacterDTO 배열에 삽입 완료
		cartDTOs[0] = cartDTO0; // 카트 배열
		cartDTOs[1] = cartDTO1;
		cartDTOs[2] = cartDTO2;
		cartDTOs[3] = cartDTO3;
		gliderDTOs[0] = gliderDTO0; // 글라이더 배열
		gliderDTOs[1] = gliderDTO1;
		gliderDTOs[2] = gliderDTO2;
		gliderDTOs[3] = gliderDTO3;
		tireDTOs[0] = tireDTO0; // 타이어 배열
		tireDTOs[1] = tireDTO1;
		tireDTOs[2] = tireDTO2;
		tireDTOs[3] = tireDTO3;
		trackDTOs[0] = trackDTO0; // 트랙 배열
		trackDTOs[1] = trackDTO1;
		trackDTOs[2] = trackDTO2;
		trackDTOs[3] = trackDTO3;
		

	} // 스태틱 블럭 -> 스태틱으로 만든 클래스의 초기값 배정
	
	// 메서드
	public static void main(String[] args) {
		System.out.println("=========마리오 카트 게임을 시작합니다.=========");
		boolean run = true; // 처음 구동
		while(run) {
			System.out.println("1. 회원관리 | 2. 카트관리 | 3. 게임실행 | 4. 종료");
			System.out.print(">>>");
			int select = input.nextInt(); // 숫자가 아닌 경우 오류 발생함. (사후처리)
			switch(select) {
			case 1:
				System.out.println("회원관리 클래스로 진입합니다.");
				MemberService memberService = new MemberService();
				// 회원관리용 서비스 객체 생성
				LoginState = memberService.menu(input, memberDTOs, LoginState);
				// 서비스의 메뉴 호출 (스캐너 객체 전달)
				break;
			case 2:
				System.out.println("카트관리 클래스로 진입합니다.");
				CartService cartService = new CartService(); // 카트 관리 클래스 객체 생성
				cartService.menu(input, characterDTOs, LoginState, cartDTOs); // 부메뉴 호출
				break;
			case 3:
				System.out.println("게임실행 클래스로 진입합니다.");
				GameService gameService = new GameService();
				gameService.menu(input, characterDTOs, LoginState, cartDTOs, gliderDTOs, tireDTOs, trackDTOs);
				break;
			case 4:
				System.out.println("게임을 종료합니다.");
				run = false; // while문 종료됨
				break;
			default:
				System.out.println("1~4번 숫자만 입력하세요.");
				// break;
			} // switch문 종료
		} // while문 종료
		
		

	} // 메인 메서드 종료

} // 클래스 종료
