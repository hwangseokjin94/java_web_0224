﻿-- 1. 다음 설명을 읽고 적절한 테이블을 생성하되, 기본키/외래키는 별도로 설정하지 않는다.

-- 1) books 테이블
--    (1) bookid : 책 아이디, 숫자 (최대 11자리), 필수
--    (2) bookname : 책 이름, 가변 길이 문자 (최대 100)
--    (3) publisher : 출판사, 가변 길이 문자 (최대 50)
--    (4) price : 가격, 숫자 (최대 6자리)


-- 2) customers 테이블
--    (1) custid : 고객 아이디, 숫자 (최대 11자리), 필수
--    (2) custname : 고객 이름, 가변 길이 문자 (최대 20)
--    (3) address : 고객 주소, 가변 길이 문자 (최대 50)
--    (4) phone : 고객 전화, 고정 길이 문자 (최대 20)


-- 3) orders 테이블
--    (1) orderid : 주문 아이디, 숫자 (최대 11자리), 필수
--    (2) custid : 고객 아이디, 숫자 (최대 11자리)
--    (3) bookid : 책 아이디, 숫자 (최대 11자리)
--    (4) saleprice : 판매 가격, 숫자 (최대 6자리)
--    (5) orderdate : 주문일, 날짜


-- 4) 아래 insert 문은 변경 없이 그대로 사용한다.
INSERT ALL
    INTO books VALUES (1, '축구의역사', '굿스포츠', 7000)
    INTO books VALUES (2, '축구아는 여자', '나무수', 13000)
    INTO books VALUES (3, '축구의 이해', '대한미디어', 22000)
    INTO books VALUES (4, '골프 바이블', '대한미디어', 35000)
    INTO books VALUES (5, '피겨 교본', '굿스포츠', 6000)
    INTO books VALUES (6, '역도 단계별 기술', '굿스포츠', 6000)
    INTO books VALUES (7, '야구의 추억', '이상미디어', 20000)
    INTO books VALUES (8, '야구를 부탁해', '이상미디어', 13000)
    INTO books VALUES (9, '올림픽 이야기', '삼성당', 7500)
    INTO books VALUES (10,'올림픽 챔피언', '피어슨', 13000)
SELECT * FROM DUAL;

INSERT ALL
    INTO customers VALUES (1, '박지성', '영국 맨체스타', '000-5000-0001')
    INTO customers VALUES (2, '김연아', '대한민국 서울', '000-6000-0001')
    INTO customers VALUES (3, '장미란', '대한민국 강원도', '000-7000-0001')
    INTO customers VALUES (4, '추신수', '미국 클리블랜드', '000-8000-0001')
    INTO customers VALUES (5, '박세리', '대한민국 대전', NULL)
SELECT * FROM DUAL;

INSERT ALL 
    INTO orders VALUES (1, 1, 1, 6000, '2014-07-01')
    INTO orders VALUES (2, 1, 3, 21000, '2014-07-03')
    INTO orders VALUES (3, 2, 5, 8000, '2014-07-03')
    INTO orders VALUES (4, 3, 6, 6000, '2014-07-04')
    INTO orders VALUES (5, 4, 7, 20000, '2014-07-05')
    INTO orders VALUES (6, 1, 2, 12000, '2014-07-07')
    INTO orders VALUES (7, 4, 8, 13000, '2014-07-07')
    INTO orders VALUES (8, 3, 10, 12000, '2014-07-08')
    INTO orders VALUES (9, 2, 10, 7000, '2014-07-09')
    INTO orders VALUES (10, 3, 8, 13000, '2014-07-10')
SELECT * FROM DUAL;


-- 2. books, customers, orders 테이블에 적절한 칼럼에 기본키를 추가하시오.
-- 적절한 제약 조건 이름도 함께 부여하시오.


-- 3. 외래키가 필요한 테이블을 선정하고 적절한 칼럼에 외래키를 추가하시오.
-- 적절한 제약 조건 이름도 함께 부여하시오.


-- 4. 2014년 7월 4일부터 7월 7일 사이에 주문 받은 도서를 제외하고 나머지 모든 주문 정보를 조회하시오.


-- 5. 박지성의 총 구매액(saleprice)을 조회하시오.


-- 6. 박지성이 구매한 도서의 수를 조회하시오.


-- 7. 박지성이 구매한 도서를 발간한 출판사 수를 조회하시오.


-- 8. 고객별로 분류하여 각 고객의 이름과 각 고객별 총 구매액을 조회하시오.


-- 9. 주문한 적이 없는 고객의 이름을 조회하시오.


-- 10. 고객별로 총 구매횟수를 조회하시오. 구매한 적이 없는 고객은 구매횟수를 0으로 표시하시오.
