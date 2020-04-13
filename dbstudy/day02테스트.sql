DROP TABLE mymember;
CREATE TABLE mymember(
m_no NUMBER ,
m_id VARCHAR2(30) NOT NULL UNIQUE,
m_pw VARCHAR2(30) NOT NULL,
m_point NUMBER DEFAULT 1000 NOT NULL,
m_kind VARCHAR2(10) CHECK (m_kind IN ('VIP', 'GOLD', 'SILVER', 'BRONZE')),
m_email VARCHAR2(50) NOT NULL UNIQUE
);
DESC mymember;
--1. 회원번호 칼럼에 필수 제약 조건(NOT NULL)을 추가하시오.
ALTER TABLE mymember MODIFY m_no NUMBER NOT NULL;
--2. 회원이메일 칼럼의 필수 제약 조건(NOT NULL)을 제거하시오.
ALTER TABLE mymember MODIFY m_email  VARCHAR2(50) NULL ;
--3. 다음과 같은 회원가입을 칼럼을 새로 추가하시오.회원가입일 : DATE, 기본값 [현재 날짜]
ALTER TABLE mymember ADD  m_reg_date DATE DEFAULT SYSDATE;
--4. 회원종류 칼럼의 타입을 VARCHAR2(6) 으로 수정하시오.
ALTER TABLE mymember MODIFY m_kind  VARCHAR2(6);
--5. 회원종류 칼럼의 이름을 회원등급으로 수정하시오.
ALTER TABLE mymember rename COLUMN m_kind  To m_grade;




