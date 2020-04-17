CREATE TABLE customer
(
cust_no NUMBER NOT NULL PRIMARY KEY,
cust_name VARCHAR2(20) NOT NULL,
cust_phone VARCHAR2(30) UNIQUE,
cust_addr VARCHAR2(50)
);

DESCRIBE customer;
DESC customer;  -- 위와 같은 쿼리문


-- DDL 활용 연습문제

-- 삭제
DROP TABLE schedule;
DROP TABLE player;
DROP TABLE event;
DROP TABLE nation;


-- nation 테이블
CREATE TABLE nation
(
n_code NUMBER(3) NOT NULL,
n_name VARCHAR2(30) NOT NULL,
n_parti_person NUMBER,
n_parti_event NUMBER,
n_curr_rank NUMBER,
n_prev_rank NUMBER,
CONSTRAINT nation_pk PRIMARY KEY (n_code)
);

-- event 테이블
CREATE TABLE event
(
e_code NUMBER NOT NULL,
e_name VARCHAR2(20),
e_first_year NUMBER(4),
e_info VARCHAR2(50),
CONSTRAINT event_pk PRIMARY KEY (e_code)
);


-- player 테이블
CREATE TABLE player
(
p_code NUMBER NOT NULL,
p_name VARCHAR2(30) NOT NULL,
n_code NUMBER(3),
e_code NUMBER,
p_rank NUMBER,
p_age NUMBER(2),
p_height NUMBER(6, 2),
CONSTRAINT player_pk PRIMARY KEY (p_code),
CONSTRAINT nation_player_fk FOREIGN KEY (n_code) REFERENCES nation (n_code),
CONSTRAINT event_player_fk FOREIGN KEY (e_code) REFERENCES event (e_code)
);


-- schedule 테이블
CREATE TABLE schedule
(
s_start_date DATE,
s_end_date DATE,
s_info VARCHAR2(50),
n_code NUMBER(3),
e_code NUMBER,
CONSTRAINT schedule_pk PRIMARY KEY (n_code, e_code),
CONSTRAINT nation_schedule_fk FOREIGN KEY (n_code) REFERENCES nation (n_code),
CONSTRAINT event_schedule_fk FOREIGN KEY (e_code) REFERENCES event (e_code)
);



-- 회원테이블 (member)
CREATE TABLE member
(
m_no NUMBER NOT NULL,
m_id VARCHAR2(30) NOT NULL UNIQUE,
m_pw VARCHAR2(30) NOT NULL,
m_age NUMBER(3) CHECK (m_age >= 0 AND m_age <= 100),
m_real_age NUMBER(3) CHECK (m_real_age BETWEEN 0 AND 100),  -- 위와 같은 CHECK
m_gender VARCHAR2(3) CHECK (m_gender = '남' OR m_gender = '여'),
m_membership VARCHAR2(10) CHECK (m_membership IN ('VIP', 'GOLD', 'SILVER', 'BRONZE')),
m_reg_date DATE DEFAULT SYSDATE,
m_point NUMBER(6) DEFAULT 1000 CHECK (m_point BETWEEN 0 AND 100000),  -- DEFAULT 먼저, CHECK 나중
CONSTRAINT member_pk PRIMARY KEY (m_no)
);

-- member 테이블의 구조 확인
DESC member;

-- 각종 제약 조건은 USER_CONSTRAINTS 테이블에 자동으로 저장된다.
DESC USER_CONSTRAINTS;
SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS;
SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'member';  -- 테이블명은 대문자로 저장된다. 소문자로 비교할 수 없다.
SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'MEMBER';
SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = UPPER('member');