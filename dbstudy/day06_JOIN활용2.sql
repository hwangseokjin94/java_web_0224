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
MAXVALUE 100
NOCYCLE
NOCACHE;


CREATE SEQUENCE buys_seq
INCREMENT BY 1
START WITH 1
MAXVALUE 100
NOCYCLE
NOCACHE;



-- users 테이블 생성
CREATE TABLE users
(
u_no NUMBER NOT NULL PRIMARY KEY,  -- 회원번호
u_id  VARCHAR2(5) NOT NULL UNIQUE,-- 아이디
u_name  VARCHAR2(10),-- 이름
u_birthyear NUMBER(4), -- 생년
u_address  VARCHAR2(10),-- 주소
u_mobile1  VARCHAR2(3),-- 010
u_mobile2  VARCHAR2(8),-- 11111111
u_regdate  DATE-- 가입일

);


-- buys 테이블 삭제
CREATE TABLE buys
(
b_no  NUMBER NOT NULL PRIMARY KEY,-- 구매번호
u_id  VARCHAR2(5) NOT NULL ,-- 구매회원아이디
p_name VARCHAR2(10), -- 제품명
p_category  VARCHAR2(20),-- 제품카테고리
p_price  NUMBER,-- 제품가격
b_amount  NUMBER,-- 구매갯수
FOREIGN KEY (u_id) REFERENCES users (u_id)
);--PK가아닌 것을 외래키로 지정하려면 ID를 유니크를 먹인다


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

SELECT *FROM USERS, BUYS;

-- 조인활용
-- 1.제품을구매한 고객명 U_NAME과 구매한 제품명 p_NAME조회
SELECT U.U_NAME , b.p_name 
FROM USERS U ,  BUYS B
WHERE U.U_ID = B.U_ID;

SELECT U.U_NAME , b.p_name 
FROM USERS U INNER JOIN BUYS B
ON U.U_ID = B.U_ID;
--2.제품을 구매한U_NAME과 구매횟수ㅡ총(구매액 제품가격* 구매갯수) 조회

--1)조인이 필요없는 경우 BUYS테이블로 모든 작업이 가능한경우
--제품을 구매한U_NAME과 구매횟수ㅡ총(구매액 제품가격* 구매갯수) 조회
SELECT *FROM USERS, BUYS;


SELECT u_id,COUNT(*) AS 총구매회수,SUM(P_PRICE *B_AMOUNT) AS 총구매액
FROM buys
GROUP BY u_id;
--2)조인이 필요한 경우 (조회하고자 하는 고객명 u_name이 buys테이블에없고 users테이블에있기 때문에 이 두테이블의 조인이 필요하다.
SELECT U.U_NAME ,B.P_PRICE ,B.B_AMOUNT ,(B.P_PRICE *B.B_AMOUNT )AS 총구매액 
FROM USERS U INNER JOIN BUYS B
ON U.U_ID = B.U_ID;

SELECT U.U_NAME ,COUNT(*) AS 총구매회수, SUM(P_PRICE *B_AMOUNT) AS 총구매액
FROM USERS U , BUYS B
WHERE U.U_ID = B.U_ID
GROUP BY u.u_name;

--3)제품 구매여부와 상관없이 구매한 고객명(u_name)과 구매횟수ㅡ총매횟수 조회
--구매이력이 없는 고객은 총구 구매횟수가 0으로 조회된다.
SELECT *FROM USERS, BUYS;


SELECT U.U_NAME , u.u_birthyear , b.p_name , b.p_category ,b.p_price
FROM USERS U INNER JOIN  BUYS B
ON U.U_ID = B.U_ID;

SELECT U.U_NAME , u.u_birthyear , b.p_name , b.p_category ,b.p_price
FROM USERS U LEFT JOIN  BUYS B
ON U.U_ID = B.U_ID;

SELECT U.U_NAME , u.u_birthyear , b.p_name , b.p_category ,b.p_price
FROM USERS U RIGHT JOIN  BUYS B
ON U.U_ID = B.U_ID;


