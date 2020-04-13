-- 테이블 삭제
DROP TABLE buys;
DROP TABLE users;


-- users 테이블
CREATE TABLE users
(
user_id VARCHAR2(30) NOT NULL,
user_name VARCHAR2(30) NOT NULL,
user_birthday DATE NOT NULL,
user_address VARCHAR2(50) NOT NULL,
user_phone VARCHAR2(15)
);

-- users 테이블 구조 확인
DESC users;


-- 새로운 칼럼 추가
ALTER TABLE users ADD user_reg_date DATE;
ALTER TABLE users ADD user_point NUMBER NOT NULL;

-- 새로운 기본키 추가
ALTER TABLE users ADD CONSTRAINT users_pk PRIMARY KEY (user_id);

-- 기존 칼럼 이름 바꾸기
ALTER TABLE users RENAME COLUMN user_address TO user_addr;  -- RENAME COLUMN 기존이름 TO 새이름

-- 기존 칼럼 삭제
ALTER TABLE users DROP COLUMN user_point;  -- DROP COLUMN 삭제할칼럼



-- buys 테이블
CREATE TABLE buys
(
buy_no NUMBER NOT NULL,
user_id VARCHAR2(30),
product_name VARCHAR2(50),
product_price NUMBER,
buy_date DATE
);

-- buys 테이블 구조 확인
DESC buys;

-- 기본키 추가
ALTER TABLE buys ADD CONSTRAINT buys_pk PRIMARY KEY (buy_no);

-- 외래키 추가
ALTER TABLE buys ADD CONSTRAINT users_buys_fk FOREIGN KEY (user_id) REFERENCES users (user_id);

-- 구매수량 칼럼 추가
ALTER TABLE buys ADD product_amount NUMBER NOT NULL;

-- 기존 칼럼 수정 (타입 변경, product_name 의 기존 타입 : VARCHAR2(50))
ALTER TABLE buys MODIFY product_name CHAR(50);  -- 새 타입 CHAR(50)

-- 기존 칼럼 수정 (NOT NULL 로 변경 : user_id 가 NULL 임)
ALTER TABLE buys MODIFY user_id VARCHAR2(30) NOT NULL;  -- 기존 칼럼의 이름 + 타입 유지, NOT NULL 만 추가

-- 기존 칼럼 수정 (NULL 로 변경 : user_id 가 NOT NULL 임)
ALTER TABLE buys MODIFY user_id VARCHAR2(30) NULL;

