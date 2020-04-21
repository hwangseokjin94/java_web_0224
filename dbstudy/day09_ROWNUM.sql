-- 시퀀스 리뷰

-- 1. 간단한 테스트 테이블을 생성한다.
CREATE TABLE product 
(
prod_no NUMBER PRIMARY KEY,
prod_name VARCHAR2(30)
);

-- 2. prod_no 에 부착할 시퀀스를 생성한다.
CREATE SEQUENCE prod_seq
INCREMENT BY 1
START WITH 1000
MAXVALUE 999999
NOCYCLE
NOCACHE;

-- 3. 현재 시퀀스의 값을 확인한다.
SELECT prod_seq.CURRVAL FROM DUAL;

-- 4. 시퀀스는 NEXTVAL 를 사용해야만 최초 번호가 부여된다.
SELECT prod_seq.NEXTVAL FROM DUAL;

-- 5. 데이터를 삽입할 때 시퀀스를 활용한다.
INSERT INTO product VALUES (prod_seq.NEXTVAL, '컴퓨터');
INSERT INTO product VALUES (prod_seq.NEXTVAL, '세탁기');
INSERT INTO product VALUES (prod_seq.NEXTVAL, '에어컨');

-- 6. 입력된 데이터를 확인한다.
SELECT * FROM product;

-- 7. INSERT ALL 문을 활용해 본다.
-- 같은 시퀀스 번호를 여러 번 삽입하려고 하기 때문에 사용이 곤란하다.
-- 시퀀스는 대부분 PK 이기 때문이다.
-- INSERT ALL 은 서브쿼리의 결과를 테이블에 삽입하는 용도로만 사용하고,
-- 신규 데이터 입력은 INSERT INTO 문을 사용하는 것이 좋다.
INSERT ALL
    INTO product VALUES (prod_seq.NEXTVAL, '냉장고')
    INTO product VALUES (prod_seq.NEXTVAL, '청소기')
SELECT * FROM DUAL;

-- 8. 시퀀스 번호를 다시 1000으로 수정하고 싶다.
-- 안 됩니다. 지우고 새로 만드세요.


-------------------------------------------------------


-- ROWNUM 칼럼

-- 1. ROWNUM 칼럼을 확인한다.
SELECT ROWNUM, prod_no, prod_name FROM product;

-- 2. ROWNUM = 1 을 확인한다. (된다. 예외적으로 인정)
SELECT ROWNUM, prod_no, prod_name FROM product WHERE ROWNUM = 1;

-- 3. ROWNUM = 2 을 확인한다. (안 된다.)
SELECT ROWNUM, prod_no, prod_name FROM product WHERE ROWNUM = 2;

-- 4. ROWNUM <= 2 을 확인한다.
SELECT ROWNUM, prod_no, prod_name FROM product WHERE ROWNUM <= 2;

-- 5. prod_name 의 가나다순으로 정렬하고 그 결과에 ROWNUM <= 2 를 적용한다.
-- 정렬 이전에 ROWNUM 이 부여되기 때문에
-- ROWNUM 이 '행 번호' 역할을 수행할 수 없다.

SELECT ROWNUM, prod_no, prod_name  -- 2번째 실행
FROM product  -- 1번째 실행
ORDER BY prod_name ASC;  -- 3번째 실행

SELECT ROWNUM, prod_no, prod_name  -- 3번째 실행
FROM product  -- 1번째 실행
WHERE ROWNUM <= 2  -- 2번째 실행
ORDER BY prod_name ASC;  -- 4번째 실행


-- 6. 정렬 후에 ROWNUM 이 부여될 수 있도록 FROM 절에서 서브쿼리를 사용한다.
-- FROM 절에서 먼저 정렬을 시키기 위함이다.
-- ROWNUM 없이 정렬 : SELECT prod_no, prod_name FROM product ORDER BY prod_name ASC;
SELECT ROWNUM, ordered_product.prod_no, ordered_product.prod_name
FROM (SELECT prod_no, prod_name FROM product ORDER BY prod_name ASC) ordered_product;


-- HR 계정으로 확인

-- 연봉 TOP 10
-- 1. 연봉의 내림차순 정렬 (높은 연봉이 위로 올라옴)
-- 2. 내림차순 정렬 결과에 행번호(ROWNUM) 부여
-- 3. ROWNUM <= 10 조건

-- 이건 안 된다.
SELECT *
FROM EMPLOYEES
WHERE ROWNUM <= 10
ORDER BY SALARY DESC;

-- 아래와 같이 작성한다.
SELECT OE.*
FROM (SELECT * FROM EMPLOYEES ORDER BY SALARY DESC) OE
WHERE ROWNUM <= 10;


---------------------------------------------------------
﻿-- 1. 게시글을 저장할 수 있는 게시판(board) 테이블을 생성한다.
--    1) b_no : 게시글 번호, NUMBER, 기본키
--    2) b_writer : 작성자, VARCHAR2(50), 필수
--    3) b_title : 제목, VARCHAR2(100), 필수
--    4) b_content : 내용, VARCHAR2(2000)
--    5) b_hit : 조회수, VARCHAR2(10)
--    6) b_date : 작성일, DATE, 현재날짜 자동삽입

CREATE TABLE board (
    b_no NUMBER NOT NULL PRIMARY KEY,
    b_writer VARCHAR2(50) NOT NULL,
    b_title VARCHAR2(100) NOT NULL,
    b_content VARCHAR2(2000),
    b_hit VARCHAR2(10), -- 나중에 NUMBER 타입으로 수정할 예정
    b_date DATE DEFAULT SYSDATE
);


-- 2. 게시글 번호를 자동으로 부여하기 위해 board_seq 시퀀스를 생성한다.
-- 1) 1~999999 까지 사용할 수 있다.
-- 2) 게시글 번호는 자동으로 1씩 증가되며 부여된다.
-- 3) 999999 까지 번호가 사용되더라도 초기화 되지 않는다.
-- 4) 캐시는 사용하지 않는다.

CREATE SEQUENCE board_seq
INCREMENT BY 1
START WITH 1
MAXVALUE 999999
NOCYCLE
NOCACHE;


-- 3. board_seq 시퀀스를 이용하여 임의의 데이터를 1개만 생성한다.
INSERT INTO board VALUES (board_seq.NEXTVAL, '박나래', '연예기사1', '2019 MBC 연예대상', '0', SYSDATE);
COMMIT;

-- 4. 조회수(b_hit)를 저장하는 데이터 타입을 VARCHAR2(10) 에서 NUMBER 타입으로 수정한다.

-- 타입의 변경 -> 칼럼의 수정
ALTER TABLE board MODIFY b_hit NUMBER;  -- 쿼리문에는 문제가 없다.

-- 기존에 입력된 데이터로 인해 타입의 변경이 안 된다.

-- 1) 새로운 칼럼을 만든다.
-- 2) b_hit 칼럼 데이터를 새로운 칼럼에 복사한다.
-- 3) b_hit 칼럼의 데이터를 모두 삭제한다. (이제 데이터가 없다.)
-- 4) b_hit 칼럼의 타입을 수정한다.
-- 5) 새로운 칼럼의 데이터를 b_hit 칼럼에 복사한다.
-- 6) 새로운 칼럼을 삭제한다.
ALTER TABLE board ADD t_hit NUMBER;
UPDATE board SET t_hit = b_hit;
UPDATE board SET b_hit = NULL;
ALTER TABLE board MODIFY b_hit NUMBER;
UPDATE board SET b_hit = t_hit;
ALTER TABLE board DROP COLUMN t_hit;


-- 5. 임의의 10개 데이터를 board 테이블에 삽입한다.
--    1) 게시글 번호(b_no) : board_seq 이용
--    2) 작성일(b_date) : 삽입하지 않는다.
INSERT INTO board (b_no, b_writer, b_title, b_content, b_hit) VALUES (board_seq.NEXTVAL, '이영자', '연예기사2', '2018 MBC 연예대상', 3);
INSERT INTO board (b_no, b_writer, b_title, b_content, b_hit) VALUES (board_seq.NEXTVAL, '전현무', '연예기사3', '2017 MBC 연예대상', 7);
INSERT INTO board (b_no, b_writer, b_title, b_content, b_hit) VALUES (board_seq.NEXTVAL, '유재석', '연예기사4', '2016 MBC 연예대상', 15);
INSERT INTO board (b_no, b_writer, b_title, b_content, b_hit) VALUES (board_seq.NEXTVAL, '김구라', '연예기사5', '2015 MBC 연예대상', 2);
INSERT INTO board (b_no, b_writer, b_title, b_content, b_hit) VALUES (board_seq.NEXTVAL, '유재석', '연예기사6', '2014 MBC 연예대상', 9);
INSERT INTO board (b_no, b_writer, b_title, b_content, b_hit) VALUES (board_seq.NEXTVAL, '아빠어디가', '연예기사7', '2013 MBC 연예대상', 8);
INSERT INTO board (b_no, b_writer, b_title, b_content, b_hit) VALUES (board_seq.NEXTVAL, '박명수', '연예기사8', '2012 MBC 연예대상', 2);
INSERT INTO board (b_no, b_writer, b_title, b_content, b_hit) VALUES (board_seq.NEXTVAL, '나는가수다', '연예기사9', '2011 MBC 연예대상', 6);
INSERT INTO board (b_no, b_writer, b_title, b_content, b_hit) VALUES (board_seq.NEXTVAL, '유재석', '연예기사10', '2010 MBC 연예대상', 5);
COMMIT;


-- 6. 조회수가 높은 5개의 게시글을 조회한다.

-- 1) FROM 절에서 먼저 조회수의 내림차순으로 정렬한다.
-- 2) ROWNUM <= 5 를 통해 조회한다.
SELECT ROWNUM, OB.*
FROM (SELECT * FROM board ORDER BY b_hit DESC) OB
WHERE ROWNUM <= 5;


-- 7. 전체 게시글에서 3 ~ 5 번째 게시글을 조회한다.

SELECT * FROM board ORDER BY b_date DESC;

SELECT ROWNUM, b.*
FROM (SELECT * FROM board ORDER BY b_date DESC) b;

SELECT a.*
FROM (SELECT ROWNUM, b.*
      FROM (SELECT * FROM board ORDER BY b_date DESC) b) a;

SELECT a.*
FROM (SELECT ROWNUM AS RN, b.*
      FROM (SELECT * FROM board ORDER BY b_date DESC) b) a
WHERE RN BETWEEN 3 AND 5;
