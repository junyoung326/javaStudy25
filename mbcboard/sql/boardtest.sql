
--------------------------------member 테이블 부모로 생성하기------------------------------
create table member(
mno number(5) not null,
bwriter nvarchar2(10) not null,
id nvarchar2(10) primary key, -- board 테이블의 bwriter와 fk로 관계 설정하려고 함!! (타입일치!! -> type과 글자수까지 맞춰야 함)
pw nvarchar2(10) not null,
regidate date default sysdate not null
)

-- 시퀀스 객체는 이미 1개가 있으니 board_seq를 같이 사용하겠다.
drop table member -- member 테이블 삭제용 (나중에 잘못 만들었을 때 쓰기)

-- 부모 더미데이터 입력
insert into member(mno, bwriter, id, pw)
values (board_seq.nextval, '김기원', 'kkw', '1234')
insert into member(mno, bwriter, id, pw)
values (board_seq.nextval, '김수아', 'ksa', '1234')
insert into member(mno, bwriter, id, pw)
values (board_seq.nextval, '권정인', 'kji', '1234')
insert into member(mno, bwriter, id, pw)
values (board_seq.nextval, '이채윤', 'lcy', '1234')
insert into member(mno, bwriter, id, pw)
values (board_seq.nextval, '김민석', 'kms', '1234')
insert into member(mno, bwriter, id, pw)
values (board_seq.nextval, '이준영', 'ljy', '1234')

select * from member

-------------------------------member의 자식 board 외래키 생성 필수-------------------------
drop table board -- 기존에 board 테이블 삭제
drop sequence board_seq -- 자동번호 생성 제거

create table board(
bno number(5) primary key,
btitle nvarchar2(30) not null,
bcontent nvarchar2(1000) not null,
bwriter nvarchar2(10) not null,
bdate date not null
)

create sequence board_seq increment by 1 start with 1 nocycle nocache

insert into BOARD(bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '덥네용~', '무더운데 등교하시냐고 고생하셨습니다.', 'kkw', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '안녕하세요~', '무더운데 등교하시냐고 고생하셨습니다.', 'ksa', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '감사합니다~', '무더운데 등교하시냐고 고생하셨습니다.', 'kji', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '수고하셨네요~', '무더운데 등교하시냐고 고생하셨습니다.', 'lcy', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '화이팅하세요~', '무더운데 등교하시냐고 고생하셨습니다.', 'kms', sysdate)
insert into BOARD (bno, btitle, bcontent, bwriter, bdate)
values (board_seq.nextval, '반갑습니다~', '무더운데 등교하시냐고 고생하셨습니다.', 'ljy', sysdate)

select * from board;
--------------------------------------------------------------------------------------

-- 조인 : 2개의 테이블을 연결하여 값을 가져온다.
select b.*, m.bwriter from member m inner join board b on m.id = b.bwriter where id = 'kkw'


---------------------------------------------------------------------------------------
-- 회원처리용 CRUD 진행하기
 -- c 회원가입
 -- r 로그인
 -- u 정보수정 (암호 및 이메일 변경 등)
 -- d 회원탈퇴 (fk가 있으니 delete 잘 안먹힘) -> 비활성화 회원테이블의 active boolean으로 해서 active인 사람만 로그인되도록 