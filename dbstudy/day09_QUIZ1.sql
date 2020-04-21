/*
1. CLIENTS 테이블을 생성하시오. 가능하면 모든 제약 조건에 적절한 이름을 부여하시오.
  1) 고객번호(c_no) : NUMBER, 기본키
  2) 고객아이디(c_id) : VARCHAR2(30), 필수, 중복 불가
  3) 고객비밀번호(c_pw) : VARCHAR2(30), 필수 
  4) 고객포인트(c_point) : NUMBER, 기본값 0, 0 ~ 100000 사이만 가능
  5) 고객등급(c_grade) : VARCHAR2(5), VIP, S, A, B 중 하나만 가능
  6) 고객이메일(c_email) : VARCHAR2(100), 중복 불가
  7) 가입일(c_regdate) : DATE, 기본값 현재날짜
*/

CREATE TABLE CLIENTS
(
C_NO NUMBER CONSTRAINT CLIENTS_PK PRIMARY KEY,
C_ID VARCHAR2(30) CONSTRAINT ID_NN NOT NULL CONSTRAINT ID_UQ UNIQUE,
C_PW VARCHAR2(30) CONSTRAINT PW_NN NOT NULL,
C_POINT NUMBER DEFAULT 0 CONSTRAINT POINT_CK CHECK (C_POINT BETWEEN 0 AND 100000),
C_GRADE VARCHAR2(5) CONSTRAINT GRADE_CK CHECK (C_GRADE IN ('VIP', 'S', 'A', 'B')),
C_EMAIL VARCHAR2(100) CONSTRAINT EMAIL_UQ UNIQUE,
C_REGDATE DATE DEFAULT SYSDATE
);

DESC USER_CONSTRAINTS;

SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'CLIENTS';


-- 2. 임의의 고객 정보를 10개 이상 삽입하시오. 모든 고객이 현재 날짜로 가입되지 않도록 주의하시오. (자바 코드로 생성해도 됩니다.)
INSERT INTO CLIENTS 
VALUES (1, 'id01', '1111', 500, 'B', 'id01@gmail.com', '19/01/05');

-- 3. 고객포인트가 1000 이상인 사람들의 고객포인트를 500 만큼 증가시키시오.
UPDATE CLIENTS 
SET C_POINT = C_POINT + 500 
WHERE C_POINT >= 1000;

-- 4. 임의의 한 고객을 선정하여 비밀번호를 '1111'로 수정하시오.
UPDATE CLIENTS
SET C_PW = '1111'
WHERE C_ID = 'id01';

-- 5. 고객등급이 'VIP' 인 모든 고객의 고객포인트를 1000 증가시키시오.
UPDATE CLIENTS
SET C_POINT = C_POINT + 1000
WHERE C_GRADE = 'VIP';

-- 6. 고객등급이 'B' 인 모든 고객의 고객포인트를 1.5배로 증가시키시오.
UPDATE CLIENTS
SET C_POINT = C_POINT * 1.5
WHERE C_GRADE = 'B';

-- 7. 고객포인트가 50000 이상인 고객 중에서 고객등급이 'S' 인 고객의 고객등급을 'VIP' 로 수정하시오.
UPDATE CLIENTS
SET C_GRADE = 'VIP'
WHERE C_POINT >= 50000
AND C_GRADE = 'S';

-- 8. 고객포인트가 2000 미만인 고객 중에서 가입일 이후로 1년 이상 경과한 고객들의 고객등급을 'B' 로 수정하시오.
UPDATE CLIENTS
SET C_GRADE = 'B'
WHERE C_POINT < 2000
AND (SYSDATE - C_REGDATE) >= 365;
-- AND MONTHS_BETWEEN(SYSDATE, C_REGDATE) >= 12;

-- 9. 고객번호나 고객아이디를 조건으로 이용하여 임의의 한 고객을 삭제하시오.
DELETE FROM CLIENTS
WHERE C_NO = 1;

-- 10. CLIENTS 테이블을 삭제하시오.
DROP TABLE CLIENTS;
