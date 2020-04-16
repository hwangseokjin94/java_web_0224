--수강신청 데이터베이스 구축
--학생테이블
--교수테이블
--강의테이블
--수강신청 테이블
--과목테이블
--자식먼저 지우고 부모나중에 삭제
DROP TABLE LECTURE;
DROP TABLE ENROLL;
DROP TABLE STUDENT;
DROP TABLE COURSE;
DROP TABLE professor;
--부모테이블생성이 먼저이다. 외래키가 없는 테이블
CREATE TABLE professor(
p_no NUMBER NOT NULL PRIMARY KEY,--교수번호
p_name VARCHAR2(30) ,--교수이름
p_major VARCHAR2(30)--전공
);

CREATE TABLE course(
c_no NUMBER NOT NULL PRIMARY KEY,--과목번호 기본키
c_name VARCHAR2(30),--과목명
c_unit NUMBER(1) --이수학점
);
--부모테이블 생성후에는 자식테이블을 생성한다
--3. 핫생 테이블생성 교수테이블의 자식테이블

CREATE TABLE student(
s_no NUMBER NOT NULL PRIMARY KEY,
s_name VARCHAR2(30),
s_address VARCHAR2(30),
s_grade_no NUMBER(1),
p_no NUMBER,
FOREIGN KEY (p_no) REFERENCES professor (p_no)--외래키p_no는 professor테이블의 p_no를 참조한다.
);

--4.수강신청과 강의 관계면 수강신청이 부모테이블이다 그러므로 수강신청을 먼저 만들어야됨
--과목테이블의 자식테이블  + 강의 테이블의 부모 테이블
CREATE TABLE enroll(
s_no NUMBER NOT NULL,
c_no NUMBER NOT NULL,
e_date DATE,
PRIMARY KEY(s_no,c_no),-- 기본키 (학번+과목번호)
FOREIGN KEY (c_no)REFERENCES course (c_no),
FOREIGN KEY (s_no)REFERENCES student (s_no)

);

--5.강의 테이블 생성
CREATE TABLE lecture(
lec_no NUMBER NOT NULL PRIMARY KEY,
p_no NUMBER ,
s_no NUMBER NOT NULL,
c_no NUMBER NOT NULL,
lec_name VARCHAR2(30),--강의이름
lec_lab VARCHAR2(30), --강의실
FOREIGN KEY (p_no) REFERENCES professor(p_no),--교수(professor)테이블의 교수번호 p_no를 참조하는 자식테이블
FOREIGN KEY (s_no) REFERENCES student(s_no),--학생(student )테이블의 학번 s_no를 참조하는 자식테이블
FOREIGN KEY (s_no,c_no) REFERENCES enroll(s_no,c_no)
--3)수강신청 테이블 (enroll)학번s_no +과목 c_no를 참조하는 자식테이블 외래키
);
--데이터 입력
INSERT INTO   professor VALUES(123,'이영곤','IT경영학과');
INSERT INTO   professor VALUES(124,'박주철','경영학과');
INSERT INTO   professor VALUES(125,'황순귀','신소재 나노');

--2.과목(COURSE) (과목번호, 과목명, 이수학점)
INSERT INTO COURSE VALUES (001,'자바',7);
INSERT INTO COURSE VALUES (002,'JSP',7);
INSERT INTO COURSE VALUES (003,'PYTHON',7);

INSERT INTO STUDENT VALUES(101,'홍철화','안양','1','123');
INSERT INTO STUDENT VALUES(102,'권혜정','부천','2','124');
INSERT INTO STUDENT VALUES(103,'신지수','시흥','3','125');


INSERT INTO ENROLL VALUES(101,001,SYSDATE);
INSERT INTO ENROLL VALUES(102,002,SYSDATE);
INSERT INTO ENROLL VALUES(103,003,SYSDATE);
INSERT INTO ENROLL VALUES(102,001,SYSDATE);
INSERT INTO ENROLL VALUES(102,003,SYSDATE);
INSERT INTO ENROLL VALUES(103,001,SYSDATE);
INSERT INTO ENROLL VALUES(103,002,SYSDATE);




INSERT INTO LECTURE VALUES(111,123,101,001,'자바','E룸');
INSERT INTO LECTURE VALUES(112,124,102,002,'JSP','D룸');
INSERT INTO LECTURE VALUES(113,125,103,003,'PYTHON','A룸');




CREATE TABLE lecture(
lec_no NUMBER NOT NULL PRIMARY KEY,
p_no NUMBER ,
s_no NUMBER NOT NULL,
c_no NUMBER NOT NULL,
lec_name VARCHAR2(30),--강의이름
lec_lab VARCHAR2(30), --강의실
FOREIGN KEY (p_no) REFERENCES professor(p_no),--교수(professor)테이블의 교수번호 p_no를 참조하는 자식테이블
FOREIGN KEY (s_no) REFERENCES student(s_no),--학생(student )테이블의 학번 s_no를 참조하는 자식테이블
FOREIGN KEY (s_no,c_no) REFERENCES enroll(s_no,c_no)
--3)수강신청 테이블 (enroll)학번s_no +과목 c_no를 참조하는 자식테이블 외래키
);


COMMIT;
SELECT*FROM ALL_USERS;

--1.학번 ,이름, 주소 , 교수이름, 전공
SELECT s.s_no, s.s_name,s.s_address,p.p_name,p.p_major
FROM professor p,student s --professor 가 PK를 가지고(index를 가지고)있으므로 driving table이된다.
WHERE  p.p_no = s.p_no ; --조인조건

SELECT s.s_no, s.s_name,s.s_address,p.p_name,p.p_major
FROM professor p INNER JOIN student s
ON p.p_no =s.p_no ; --조인조건


--2.학번 이름 과목번호 신청일자를 출력한다
--학생테이블 학번 이름
--수강신청 테이블 :과목 번호, 신청일자
SELECT s.s_no, s.s_name, e.c_no, e.e_date
FROM student s, enroll e 
WHERE s.s_no = e.s_no ;

SELECT s.s_no, s.s_name, e.c_no, e.e_date
FROM student s INNER JOIN enroll e 
on s.s_no = e.s_no ;


