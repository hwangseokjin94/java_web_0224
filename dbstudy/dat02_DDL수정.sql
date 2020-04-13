--테이블삭제
DROP TABLE buys;
DROP TABLE users;

--users테이블
create TABLE users
(
user_id VARCHAR2(30) NOT NULL,
user_name VARCHAR2(30) NOT NULL,
user_birthday DATE NOT NULL,
user_address VARCHAR2(50) NOT NULL,
user_phone VARCHAR2(15)
);
--구조확인
DESC users;

--새로운 컬럼추가
ALTER TABLE users ADD user_reg_date DATE;
ALTER TABLE users ADD user_point NUMBER NOT NULL;

--새로운 기본키 추가
ALTER TABLE users ADD CONSTRAINT users_pk PRIMARY key(user_id);
SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = UPPER('users');

--기존 컬럼 이름 바꾸기
ALTER TABLE users RENAME COLUMN user_address TO user_addr; --RENAME COLUMN 기존이름 TO 새이름

DESC users;
--기존칼럼삭제
ALTER TABLE users DROP COLUMN user_point;

--buys테이블
CREATE TABLE buys
(
buy_no NUMBER NOT NULL,
user_id VARCHAR2(30),
product_name VARCHAR2(50),
product_price NUMBER,
buy_date DATE 
);

--기본키
ALTER TABLE buys ADD CONSTRAINT buys_pk PRIMARY KEY(buy_no);

--외래키
ALTER TABLE buys ADD CONSTRAINT users_buys_fk FOREIGN KEY  (user_id) REFERENCES users (user_id);

--구매수량 칼럼추가
ALTER TABLE buys ADD product_amount NUMBER NOT NULL;
DESC buys;
SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = UPPER('buys');

--기존 컬럼 수정 (타입 변경, product_name의 기존타입 : VARCHAR2(50)   )
ALTER TABLE buys MODIFY product_name CHAR(50); --새 타입 CHAR(50)

--기존 칼럼 수정(NOT NULL 추가 :user_id가 NULL상태인데 NOT널 추가하기)타입 유지 not null추가
ALTER TABLE buys MODIFY user_id VARCHAR2(30) NOT NULL; 
DESC buys;

--기존 칼럼 수정(NULL 변경가not null임
ALTER TABLE buys MODIFY user_id VARCHAR2(30)  NULL; 
ALTER TABLE buys MODIFY product_amount NUMBER  NULL;






