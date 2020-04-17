-- 수강신청 데이터베이스 구축

-- 학생(student) 테이블
-- 교수(professor) 테이블
-- 강의(lecture) 테이블
-- 수강신청(enroll) 테이블
-- 과목(enroll) 테이블


-- 테이블 삭제 (자식을 먼저 삭제하고 부모를 나중에 삭제한다.)
DROP TABLE lecture;
DROP TABLE enroll;
DROP TABLE student;
DROP TABLE course;
DROP TABLE professor;


-- 부모(parent) 테이블 생성이 먼저이다. (외래키가 없는 테이블)

-- 1. 교수(professor) 테이블 생성
CREATE TABLE professor
(
p_no NUMBER NOT NULL PRIMARY KEY,  -- 교수번호(기본키)
p_name VARCHAR2(30),  -- 교수이름
p_major VARCHAR2(30)  -- 전공
);


-- 2. 과목(course) 테이블 생성
CREATE TABLE course
(
c_no NUMBER NOT NULL PRIMARY KEY,  -- 과목번호(기본키)
c_name VARCHAR2(30),  -- 과목명
c_unit NUMBER(1)  -- 이수학점
);


-- 부모 테이블 생성 후에는 자식 테이블을 생성한다.

-- 3. 학생(student) 테이블 생성 - 교수(professor) 테이블의 자식 테이블
CREATE TABLE student
(
s_no NUMBER NOT NULL PRIMARY KEY,  -- 학번(기본키)
s_name VARCHAR2(30),  -- 학생이름
s_address VARCHAR2(30),  -- 학생주소
s_grade_no NUMBER(1),  -- 학년
p_no NUMBER,  -- 담당교수번호
FOREIGN KEY (p_no) REFERENCES professor (p_no)  -- 외래키 (p_no 는 professor 테이블의 p_no 를 참조한다.)
);


-- 4. 수강신청(enroll) 테이블 생성 - 과목(course) 테이블의 자식 테이블 + 강의(lecture) 테이블의 부모 테이블
CREATE TABLE enroll
(
s_no NUMBER NOT NULL,  -- 학번
c_no NUMBER NOT NULL,  -- 과목번호
e_date DATE,  -- 신청일자
PRIMARY KEY (s_no, c_no),  -- 기본키(학번 + 과목번호)
FOREIGN KEY (c_no) REFERENCES course (c_no),  -- 외래키 (c_no 는 course 테이블의 c_no 를 참조한다.)
FOREIGN KEY (s_no) REFERENCES student (s_no)  -- 외래키 (s_no 는 student 테이블의 s_no 를 참조한다.)
);


-- 5. 강의(lecture) 테이블 생성
-- 1) 교수(professor) 테이블의 교수번호(p_no)를 참조하는 자식 테이블
-- 2) 학생(student) 테이블의 학번(s_no)을 참조하는 자식 테이블
-- 3) 수강신청(enroll) 테이블의 학번(s_no)+과목번호(c_no)를 참조하는 자식 테이블
CREATE TABLE lecture
(
lec_no NUMBER NOT NULL PRIMARY KEY,  -- 강의번호 (기본키)
p_no NUMBER,  -- 교수번호
s_no NUMBER,  -- 학번
c_no NUMBER,  -- 과목번호
lec_name VARCHAR2(30),  -- 강의이름
lec_lab VARCHAR2(30),  -- 강의실
FOREIGN KEY (p_no) REFERENCES professor (p_no),  -- 교수(professor) 테이블의 교수번호(p_no)를 참조하는 외래키
FOREIGN KEY (s_no) REFERENCES student (s_no),  -- 학생(student) 테이블의 학번(s_no)을 참조하는 외래키
FOREIGN KEY (s_no, c_no) REFERENCES enroll (s_no, c_no)  -- 수강신청(enroll) 테이블의 학번(s_no)+과목번호(c_no)를 참조하는 외래키
);



-- 데이터 입력 : INSERT

-- 1. 교수(professor) 테이블 (교수번호, 교수이름, 전공)
INSERT INTO professor VALUES (1, 'p_kim', 'kor');
INSERT INTO professor VALUES (2, 'p_lee', 'eng');
INSERT INTO professor VALUES (3, 'p_choi', 'mat');

-- 2. 과목(course) 테이블 (과목번호, 과목명, 이수학점)
INSERT INTO course VALUES (10, '고전문학', 2);
INSERT INTO course VALUES (20, '생활영어', 3);
INSERT INTO course VALUES (30, '공학수학', 3);

-- 3. 학생(student) 테이블 (학번, 이름, 주소, 학년, 담당교수번호)
INSERT INTO student VALUES (10000, 's_kim', 'seoul', 1, 1);
INSERT INTO student VALUES (20000, 's_lee', 'incheon', 1, 2);
INSERT INTO student VALUES (30000, 's_choi', 'jeju', 1, 3);

-- 4. 수강신청(enroll) 테이블 (학번, 과목번호, 신청일자)
INSERT INTO enroll VALUES (10000, 10, SYSDATE);
INSERT INTO enroll VALUES (10000, 20, SYSDATE);
INSERT INTO enroll VALUES (10000, 30, SYSDATE);
INSERT INTO enroll VALUES (20000, 10, SYSDATE);
INSERT INTO enroll VALUES (20000, 20, SYSDATE);
INSERT INTO enroll VALUES (20000, 30, SYSDATE);
INSERT INTO enroll VALUES (30000, 10, SYSDATE);
INSERT INTO enroll VALUES (30000, 20, SYSDATE);
INSERT INTO enroll VALUES (30000, 30, SYSDATE);

-- 5. 강의(lecture) 테이블 (강의번호, 교수번호, 학번, 과목번호, 강의이름, 강의실)
INSERT INTO lecture VALUES (1000, 1, 10000, 10, '강의_고전문학의이해', '101호');
INSERT INTO lecture VALUES (2000, 2, 20000, 20, '강의_생활영어', '201호');
INSERT INTO lecture VALUES (3000, 3, 30000, 30, '강의_공학수학', '301호');


COMMIT;


SELECT * FROM professor;
SELECT * FROM course;
SELECT * FROM student;
SELECT * FROM enroll;
SELECT * FROM lecture;
