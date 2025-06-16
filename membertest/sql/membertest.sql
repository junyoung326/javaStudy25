------------------------- member 테이블 생성하기 ------------------------
create table member (
mno number(5) not null,
mname nvarchar2(10) not null,
mphone nvarchar2(20) not null,
id nvarchar2(10) primary key,
pw nvarchar2(10) not null,
mdate date default sysdate not null
)

alter table member add (nickname nvarchar2(10) null, title nvarchar2(10) null, content nvarchar2(100))

create sequence member_seq increment by 1 start with 1 nocycle nocache

drop table member

insert into member(mno, mname, mphone, id, pw)
values (member_seq.nextval, '이준영', '01012345678', 'ljy', '0402')

select * from member



