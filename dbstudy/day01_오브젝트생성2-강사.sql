-- 테이블 삭제
DROP TABLE 수강신청;  -- 반드시 외래키가 있는 테이블을 먼저 삭제해야 한다.
DROP TABLE 과목;
DROP TABLE 학생;


-- 학생테이블 : student
CREATE TABLE 학생
(
학번 NUMBER NOT NULL PRIMARY KEY,
성명 CHAR(10) NOT NULL,
나이 NUMBER
);


-- 과목테이블 : subject
CREATE TABLE 과목
(
과목코드 CHAR(1) NOT NULL PRIMARY KEY,
과목명 CHAR(10) NOT NULL,
교수명 CHAR(10)
);


-- 수강신청테이블 : enroll
CREATE TABLE 수강신청
(
신청번호 NUMBER NOT NULL PRIMARY KEY,
학번 NUMBER,
과목코드 CHAR(1),
FOREIGN KEY (학번) REFERENCES 학생 (학번),
FOREIGN KEY (과목코드) REFERENCES 과목 (과목코드)
);
