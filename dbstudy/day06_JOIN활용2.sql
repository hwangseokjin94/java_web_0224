-- 테이블 삭제
DROP TABLE buys;
DROP TABLE users;


-- 시퀀스 삭제
DROP SEQUENCE users_seq;
DROP SEQUENCE buys_seq;


-- 시퀀스 생성
CREATE SEQUENCE users_seq
INCREMENT BY 1
START WITH 1
MAXVALUE 999999
NOCYCLE
NOCACHE;

CREATE SEQUENCE buys_seq
INCREMENT BY 1
START WITH 10001
MAXVALUE 99999999
NOCYCLE
NOCACHE;


-- users 테이블 생성
CREATE TABLE users
(
u_no NUMBER NOT NULL PRIMARY KEY, -- 회원번호 (기본키)
u_id VARCHAR2(5) NOT NULL UNIQUE, -- 아이디 (PK는 아니지만 참조관계를 위해서 NOT NULL + UNIQUE 제약조건을 추가한다.)
u_name VARCHAR2(10), -- 이름
u_birthyear NUMBER(4), -- 생년
u_address VARCHAR2(10), -- 주소
u_mobile1 VARCHAR2(3), -- 010
u_mobile2 VARCHAR2(8), -- 11111111
u_regdate DATE -- 가입일
);


-- buys 테이블 삭제
CREATE TABLE buys
(
b_no NUMBER NOT NULL PRIMARY KEY, -- 구매번호
u_id VARCHAR2(5), -- 구매회원아이디
p_name VARCHAR2(10), -- 제품명
p_category VARCHAR2(10), -- 제품카테고리
p_price NUMBER, -- 제품가격
b_amount NUMBER, -- 구매갯수
FOREIGN KEY (u_id) REFERENCES users (u_id)  -- 외래키(u_id 는 users 테이블의 u_id 를 참조한다.)
);


-- users 테이블에 ROW 삽입
INSERT INTO users VALUES(users_seq.NEXTVAL, 'YJS', '유재석', 1972, '서울', '010', '11111111', '2008-08-08');
INSERT INTO users VALUES(users_seq.NEXTVAL, 'KHD', '강호동', 1970, '경북', '011', '22222222', '2007-07-07');
INSERT INTO users VALUES(users_seq.NEXTVAL, 'KKJ', '김국진', 1965, '서울', '019', '33333333', '2009-09-09');
INSERT INTO users VALUES(users_seq.NEXTVAL, 'KYM', '김용만', 1967, '서울', '010', '44444444', '2015-05-05');
INSERT INTO users VALUES(users_seq.NEXTVAL, 'KJD', '김제동', 1974, '경남', NULL, NULL, '2013-03-03');
INSERT INTO users VALUES(users_seq.NEXTVAL, 'NHS', '남희석', 1971, '충남', '016', '66666666', '2017-04-04');
INSERT INTO users VALUES(users_seq.NEXTVAL, 'SDY', '신동엽', 1971, '경기', NULL, NULL, '2008-10-10');
INSERT INTO users VALUES(users_seq.NEXTVAL, 'LHJ', '이휘재', 1972, '경기', '011', '88888888', '2006-04-04');
INSERT INTO users VALUES(users_seq.NEXTVAL, 'LKK', '이경규', 1960, '경남', '018', '99999999', '2004-12-12');
INSERT INTO users VALUES(users_seq.NEXTVAL, 'PSH', '박수홍', 1970, '서울', '010', '00000000', '2012-05-05');


-- buys 테이블에 ROW 삽입
INSERT INTO buys VALUES(buys_seq.NEXTVAL, 'KHD', '운동화', NULL, 30, 2);
INSERT INTO buys VALUES(buys_seq.NEXTVAL, 'KHD', '노트북', '전자', 1000, 1);
INSERT INTO buys VALUES(buys_seq.NEXTVAL, 'KYM', '모니터', '전자', 200, 1);
INSERT INTO buys VALUES(buys_seq.NEXTVAL, 'PSH', '모니터', '전자', 200, 5);
INSERT INTO buys VALUES(buys_seq.NEXTVAL, 'KHD', '청바지', '의류', 50, 3);
INSERT INTO buys VALUES(buys_seq.NEXTVAL, 'PSH', '메모리', '전자', 80, 10);
INSERT INTO buys VALUES(buys_seq.NEXTVAL, 'KJD', '책', '서적', 15, 5);
INSERT INTO buys VALUES(buys_seq.NEXTVAL, 'LHJ', '책', '서적', 15, 2);
INSERT INTO buys VALUES(buys_seq.NEXTVAL, 'LHJ', '청바지', '의류', 50, 1);
INSERT INTO buys VALUES(buys_seq.NEXTVAL, 'PSH', '운동화', NULL, 30, 2);
INSERT INTO buys VALUES(buys_seq.NEXTVAL, 'LHJ', '책', '서적', 15, 1);
INSERT INTO buys VALUES(buys_seq.NEXTVAL, 'PSH', '운동화', NULL, 30, 2);


-- INSERT 완료
COMMIT;

-- 삽입된 데이터 확인
SELECT * FROM users;
SELECT * FROM buys;



-- 조인의 활용

-- 1. 제품을 구매한 고객명(u_name)과 구매한 제품명(p_name)을 조회하시오.
SELECT u.u_name, b.p_name
FROM users u, buys b
WHERE u.u_id = b.u_id;

SELECT u.u_name, b.p_name
FROM users u INNER JOIN buys b
ON u.u_id = b.u_id;


-- 2. 제품을 구매한 고객명(u_name)과 총 구매횟수, 총 구매액(제품가격 * 구매갯수)를 조회하시오.

-- 1) 조인이 필요 없는 경우(buys 테이블로 모든 작업이 가능한 경우)
-- 제품을 구매한 "고객아이디(u_id)" 와 총 구매횟수, 총 구매액(제품가격 * 구매갯수)를 조회하시오.
SELECT u_id, COUNT(*) AS 총구매횟수, SUM(p_price * b_amount) AS 총구매액
FROM buys
GROUP BY u_id;

-- 2) 조인이 필요한 경우(조회하고자 하는 고객명(u_name)이 buys 테이블에 없고 users 테이블에 있기 때문에 이 두 테이블의 조인이 필요하다.)
SELECT u.u_name, COUNT(*) AS 총구매횟수, SUM(b.p_price * b.b_amount) AS 총구매액
FROM users u, buys b
WHERE u.u_id = b.u_id
GROUP BY u.u_name;


-- 3. 모든 사용자가 구매한 제품이름을 조회하시오.
-- 구매한 적이 없는 사용자도 함께 조회하시오.

-- 1) JOIN ON 문법
SELECT u.u_name, b.p_name
FROM users u LEFT OUTER JOIN buys b
ON u.u_id = b.u_id;

-- 2) 콤마(,) 구분법
SELECT u.u_name, b.p_name
FROM users u, buys b
WHERE u.u_id = b.u_id(+);


-- 4. 제품 구매 여부와 상관 없이 고객명(u_name)과 총 구매횟수를 조회하시오.
-- 구매 이력이 없는 고객은 총 구매횟수가 0 으로 조회된다.

SELECT u.u_name, COUNT(b.u_id) AS 총구매횟수
FROM users u LEFT OUTER JOIN buys b
ON u.u_id = b.u_id
GROUP BY u.u_name;


-- 5. 제품 구매 여부와 상관 없이 고객명(u_name)과 총 구매액을 조회하시오.
-- 구매 이력이 없는 고객은 총 구매액이 0 으로 조회된다.
SELECT u.u_name, NVL(SUM(b.p_price * b.b_amount), 0) AS 총구매액
FROM users u LEFT OUTER JOIN buys b
ON u.u_id = b.u_id
GROUP BY u.u_name;
