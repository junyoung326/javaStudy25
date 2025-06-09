-- 1. 학과 2. 학생, 교수 3. 담당 4. 강좌 5. 수강 순서로 생성
SELECT TABLE_NAME FROM USER_TABLES

ALTER TABLE HS_CLASS_OFFICE DROP CONSTRAINT class_off_id_pk
CONSTRAINT class_off_id_fk2 REFERENCES HS_CLASS_OFFICE (class_off_id) ON DELETE CASCADE
CONSTRAINT class_off_id_fk2 REFERENCES HS_CLASS_OFFICE (class_off_id) ON DELETE SET NULL

delete from HS_CLASS_OFFICE

DROP TABLE REGIS_COURSE -- 성공
DROP TABLE HS_LECTURE -- 성공
DROP TABLE HS_PROFESSOR
DROP TABLE HS_STUDENTS
DROP TABLE HS_CLASS_OFFICE

CREATE TABLE HS_STUDENTS(hs_stu_id varchar2(10), class_off_id varchar2(10) NOT NULL, hs_prof_id varchar2(10) NOT NULL, hs_stu_name varchar(15) NOT NULL, 
hs_stu_jumin varchar2(14) not null, hs_stu_addr varchar2(100) not null, hs_stu_phnum varchar2(15) not null,
hs_stu_email varchar2(15) not null, hs_stu_image long, hs_stu_sub varchar2(3) not null)

alter table hs_students add constraint hs_stu_id_pk primary key (hs_stu_id)

--alter table hs_stude=nts add constraint hs_stu_id_fk1 foreign key (hs_stu_id) references hs_professor (prof_id)

ALTER TABLE HS_STUDENTS ADD CONSTRAINT class_off_id_fk2 FOREIGN KEY (class_off_id) REFERENCES HS_CLASS_OFFICE (class_off_id);

--ALTER TABLE HS_STUDENTS ADD CONSTRAINT hs_prof_id_fk3 FOREIGN KEY (hs_prof_id) REFERENCES HS_PROFESSOR (prof_id);





CREATE TABLE HS_CLASS_OFFICE (
	class_off_id		varchar2(10) ,
	class_off_name		varchar2(20) NOT NULL,
	class_off_phnum		varchar2(15) NOT NULL
)

ALTER TABLE HS_CLASS_OFFICE ADD CONSTRAINT class_off_id_pk PRIMARY KEY (class_off_id)



CREATE TABLE HS_PROFESSOR (
	prof_id			varchar2(10),
	prof_name		varchar2(15) NOT NULL,
	prof_jumin		varchar2(14) NOT NULL UNIQUE,
	prof_addr		varchar2(100) NOT NULL,
	prof_phnum		varchar2(15) NOT NULL,
	prof_email		varchar2(100) NOT NULL,
	prof_image		long,
	class_off_id		varchar2(10) NOT NULL,
	hs_stu_id		varchar2(10) NOT NULL
)

ALTER TABLE HS_PROFESSOR ADD CONSTRAINT hs_prof_id_pk PRIMARY KEY (prof_id)

--ALTER TABLE HS_PROFESSOR ADD CONSTRAINT hs_prof_stu_id_fk1 FOREIGN KEY (hs_stu_id) REFERENCES hs_students (hs_stu_id)

ALTER TABLE HS_PROFESSOR ADD CONSTRAINT hs_prof_class_off_id_fk2 FOREIGN KEY (class_off_id) REFERENCES HS_CLASS_OFFICE (class_off_id)



CREATE TABLE HS_LECTURE (
	lec_id			varchar2(10),
	lec_name		varchar2(15) NOT NULL,
	lec_arch_grade	char(1) NOT NULL, 
	lec_time		number(1) NOT NULL, 
	lec_room		varchar2(10) NOT NULL,
  	prof_id			varchar2(10),

)


ALTER TABLE HS_LECTURE ADD CONSTRAINT hr_lec_id_pk PRIMARY KEY (lec_id)

ALTER TABLE HS_LECTURE ADD CONSTRAINT hs_lec_prof_id_fk FOREIGN KEY (prof_id) REFERENCES hs_professor (prof_id)




CREATE TABLE REGIS_COURSE (
	rc_atten_grade		number(2),
	rc_midterm_grade	number(2),
	rc_finalterm_grade	number(2),
	rc_else_grade		number(2),
	rc_total		    number(3),
	rc_avg_grade		char(1),
	hs_stu_id		varchar2(10),
	lec_id			varchar2(10),
	prof_id			varchar2(10)
	)

ALTER TABLE REGIS_COURSE ADD CONSTRAINT rc_stu_lec_prof_id PRIMARY KEY (hs_stu_id, lec_id, prof_id)

ALTER TABLE REGIS_COURSE ADD CONSTRAINT rc_lec_id_fk1 FOREIGN KEY (lec_id) REFERENCES HS_LECTURE (lec_id)

ALTER TABLE REGIS_COURSE ADD CONSTRAINT rc_stu_id_fk2 FOREIGN KEY (hs_stu_id) REFERENCES HS_STUDENTS (hs_stu_id)

SELECT * FROM HS_STUDENTS
SELECT * FROM HS_CLASS_OFFICE
SELECT * FROM HS_PROFESSOR
SELECT * FROM HS_LECTURE
SELECT * FROM REGIS_COURSE

INSERT INTO HS_STUDENTS VALUES ('1234', '2222', '1234', '이준영', '000402-1234567', '경기도 오산시', '010-1234-5678', 'ljy@naver.com', null, '2-1')
INSERT INTO HS_CLASS_OFFICE VALUES ('1234', '컴퓨터공학부', '031-1234-5678')
INSERT INTO HS_PROFESSOR VALUES ('2222', '김', '770225-1234567', '경기도 수원시', '010-5687-9548', 'kim@gmail.com', null, '1234', '1234')
INSERT INTO HS_LECTURE VALUES ('2222', '자바', '3', '3', '01', '3456')
INSERT INTO REGIS_COURSE VALUES ('10', '30', '30', '30', '100', '30', '1234', '2222', '3456')









SELECT * FROM HS_STUDENTS
SELECT * FROM HS_CLASS_OFFICE
SELECT * FROM HS_PROFESSOR
SELECT * FROM HS_LECTURE
SELECT * FROM REGIS_COURSE

INSERT INTO HS_STUDENTS VALUES ('1234', '2222', '1234', '이준영', '000402-1234567', '경기도 오산시', '010-1234-5678', 'ljy@naver.com', null, '2-1')
INSERT INTO HS_CLASS_OFFICE VALUES ('1234', '컴퓨터공학부', '031-1234-5678')
INSERT INTO HS_PROFESSOR VALUES ('2222', '김', '770225-1234567', '경기도 수원시', '010-5687-9548', 'kim@gmail.com', null, '1234', '1234')
INSERT INTO HS_LECTURE VALUES ('2222', '자바', '3', '3', '01', '3456')
INSERT INTO REGIS_COURSE VALUES ('10', '30', '30', '30', '100', '30', '1234', '2222', '3456')


