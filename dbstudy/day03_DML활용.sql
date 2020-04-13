DROP TABLE buys;
DROP TABLE users;



--user테이블
CREATE TABLE users
(
user_id VARCHAR2(30) NOT NULL PRIMARY KEY,
name VARCHAR2(30) NOT NULL,
birth_year NUMBER NOT NULL,
address VARCHAR(100) NOT NULL,
mobile1 CHAR(3),  --010,011등
mobile2 CHAR(9),  --1234-5678등
height NUMBER,
reg_date DATE
);

CREATE TABLE buys
(
buy_no NUMBER NOT NULL PRIMARY KEY,
user_id VARCHAR2(30) NOT NULL,
prod_name VARCHAR2(30) NOT NULL,
category VARCHAR2(20),
price NUMBER NOT NULL,
amount NUMBER NOT NULL,
FOREIGN KEY (user_id) REFERENCES users( user_id)
);
DESC buys;

--INSERT INTO users(user_id,name,birth_year,address,reg_date)VALUES('aaa','kim',1995,'서울 마포',SYSDATE);
--INSERT INTO users VALUES('bbb','kim','1996','인천 부평','010','1234-5678',NULL,'20/04/07');
--'20/04/07'
--'2020/04/07' 
--'20-04-07'
--'2020-04-07'

--INSERT, UPDATE, DELETE문은 COMMIT이 필요하다 트랜잭션관리.
--COMMIT; --변경된 내용을 DB에 저장한다.
--ROLLBACK; --변경된 내용을 취소한다.

--INSERT INTO buys(buy_no,user_id,prod_name,price,amount) VALUES(1,'KKK','TV',100,1);--참조무결성위배 user_id에kkk가없다
--INSERT INTO buys(buy_no,user_id,prod_name,price,amount) VALUES(1,'KKJ','TV',100,1);



--uers 테이블 ROw삽입생삽입
INSERT INTO users VALUES('YJS', '유재석', 1972, '서울', '010', '11111111', 178, '2008-08-08');
INSERT INTO users VALUES('KHD', '강호동', 1970, '경북', '011', '22222222', 182, '2007-07-07');
INSERT INTO users VALUES('KKJ', '김국진', 1965, '서울', '019', '33333333', 171, '2009-09-09');
INSERT INTO users VALUES('KYM', '김용만', 1967, '서울', '010', '44444444', 177, '2015-05-05');
INSERT INTO users VALUES('KJD', '김제동', 1974, '경남', NULL, NULL, 173, '2013-03-03');
INSERT INTO users VALUES('NHS', '남희석', 1971, '충남', '016', '66666666', 180, '2017-04-04');
INSERT INTO users VALUES('SDY', '신동엽', 1971, '경기', NULL, NULL, 176, '2008-10-10');
INSERT INTO users VALUES('LHJ', '이휘재', 1972, '경기', '011', '88888888', 180, '2006-04-04');
INSERT INTO users VALUES('LKK', '이경규', 1960, '경남', '018', '99999999', 170, '2004-12-12');
INSERT INTO users VALUES('PSH', '박수홍', 1970, '서울', '010', '00000000', 183, '2012-05-05');


-- buys 테이블에 ROW 삽입
INSERT ALL
    INTO buys VALUES(1, 'KHD', '운동화', NULL, 30, 2)
    INTO buys VALUES(2, 'KHD', '노트북', '전자', 1000, 1)
    INTO buys VALUES(3, 'KYM', '모니터', '전자', 200, 1)
    INTO buys VALUES(4, 'PSH', '모니터', '전자', 200, 5)
    INTO buys VALUES(5, 'KHD', '청바지', '의류', 50, 3)
    INTO buys VALUES(6, 'PSH', '메모리', '전자', 80, 10)
    INTO buys VALUES(7, 'KJD', '책', '서적', 15, 5)
    INTO buys VALUES(8, 'LHJ', '책', '서적', 15, 2)
    INTO buys VALUES(9, 'LHJ', '청바지', '의류', 50, 1)
    INTO buys VALUES(10, 'PSH', '운동화', NULL, 30, 2)
    INTO buys VALUES(11, 'LHJ', '책', '서적', 15, 1)
    INTO buys VALUES(12, 'PSH', '운동화', NULL, 30, 2)
SELECT * FROM DUAL;

--INSERT된 내용을 DB에저장한다.
COMMIT;

--삽입된 데이터확인
SELECT * FROM users;
SELECT * FROM buys;

--데이터 수정
--UPDATE 테이블 SET 칼럼 = 값 [WHERE 조건식]

--1. buys테이블의 모든 ROW의 구매번호(buy_no)를 1000씩 증가시키기
UPDATE buys SET buy_no = buy_no+1000;

--2. users테이블에서 name이 '유재석'인 데이터의 전화번호(mobile2)를 '5678-1234'로 수정하기
UPDATE users SET mobile2 = '5678-1234' WHERE name = '유재석';

--3. buys 테이블에서 category 가 '전자'인 제품들의 가격들의 (price)을 10%인상시키기
UPDATE buys SET price = price*1.1 WHERE category='전자';
UPDATE buys SET price = price*(1-0.1) WHERE category='전자';--10%인하시키기

--4.users 테이블에서 name이 신동엽인 데이터의 전화번호 mobile1 , mobile2011,1234-5678로수정하기
UPDATE users SET mobile1='011' , mobile2='1234-5678' WHERE name= '신동엽';

--5 buys 테이블에서category가 없는 데이터들의 category를 '신발''로 수정
UPDATE buys SET category = '신발' WHERE category = NULL; --NULL체크는 =(등호)로 불가능
UPDATE buys SET category = '신발' WHERE category IS NULL;
UPDATE buys SET category = '신발' WHERE category IS NOT NULL;

--6.user 테이블에서 전화번호 mobile1가 010이 아닌 모든 데이터의 전화번호를(mobile1를 010으로 수정하기.
--단 전화번호가 없는 사람은 변경하지않기
UPDATE users SET mobile1 ='010' WHERE mobile1 != '010' AND mobile1 IS NOT NULL;
UPDATE users SET mobile1 ='010' WHERE mobile1 <> '010' AND mobile1 IS NOT NULL;

SELECT * FROM users;
SELECT * FROM buys;
--데이터 삭제
--DELETE FROM 테이블[WHERE 조건식]

--1. buy_no가 1012 인데이터 삭제하기
DELETE FROM buys WHERE buy_NO =1012;

--2. user 테이블에서 전화번호가 mobile1 가없는 데이터를 모두 삭제하기
DELETE FROM users WHERE mobile1 IS NULL; --돌지않는 이유'전화번호 없는김제동의 데이터가'buys테이블 존재 구매내역이 buys에있기때문에 지우지못한다.

--3. buys 테이블에서 user_id가 'KJD'인 데이터를 삭제하기
DELETE FROM buys WHERE user_id = 'KJD';

--4. buys 테이블의 모든 ROW 전체삭제
DELETE FROM buys; --DML,취소(ROLLBACK)가능 , 속도 느림
TRUNCATE TABLE buys;--DDL 취소 (ROLLBACK)불가능, 속도 빠름