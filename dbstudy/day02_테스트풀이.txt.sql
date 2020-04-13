-- 테이블 삭제
DROP TABLE mymember;


/*
MYMEMBER 테이블을 생성하시오.
1) 회원번호 : NUMBER, 기본키
2) 회원아이디 : VARCHAR2(30), 필수, 중복 불가
3) 회원비밀번호 : VARCHAR2(30), 필수 
4) 회원포인트 : NUMBER, 기본값 [1000], 필수
5) 회원종류 : VARCHAR2(10), VIP, GOLD, SILVER, BRONZE 중 하나
6) 회원이메일 : VARCHAR2(50), 필수, 중복 불가
*/

CREATE TABLE mymember
(
m_no NUMBER PRIMARY KEY,
m_id VARCHAR2(30) NOT NULL UNIQUE,
m_pw VARCHAR2(30) NOT NULL,
m_point NUMBER DEFAULT 1000 NOT NULL,
m_kind VARCHAR2(10) CHECK (m_kind IN ('VIP', 'GOLD', 'SILVER', 'BRONZE')),
m_email VARCHAR2(50) NOT NULL UNIQUE
);

-- mymember 테이블 구조 확인
DESC mymember;

-- 1. 회원번호 칼럼에 필수 제약 조건(NOT NULL)을 추가하시오.
ALTER TABLE mymember MODIFY m_no NUMBER NOT NULL;

-- 2. 회원이메일 칼럼의 필수 제약 조건(NOT NULL)을 제거하시오.
ALTER TABLE mymember MODIFY m_email VARCHAR2(50) NULL;

-- 3. 다음과 같은 회원가입을 칼럼을 새로 추가하시오.
--    회원가입일 : DATE, 기본값 [현재 날짜]
ALTER TABLE mymember ADD m_reg_date DATE DEFAULT SYSDATE;

-- 4. 회원종류 칼럼의 타입을 VARCHAR2(6) 으로 수정하시오.
ALTER TABLE mymember MODIFY m_kind VARCHAR2(6);

-- 5. 회원종류 칼럼의 이름을 회원등급으로 수정하시오.
ALTER TABLE mymember RENAME COLUMN m_kind TO m_grade;
