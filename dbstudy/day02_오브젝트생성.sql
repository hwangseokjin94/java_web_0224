-- 삭제 (참조관계에서 외래키를 가진 테이블(자식테이블)을 기본키를 가진 테이블(부모테이블)보다 먼저 삭제해야 한다.)
DROP TABLE 제품;
DROP TABLE 주문;
DROP TABLE 배송;
DROP TABLE 게시판;
DROP TABLE 회원;
DROP TABLE 택배업체;
DROP TABLE 제조사;
DROP TABLE 창고;


-- 회원테이블 (기본키)
CREATE TABLE 회원
(
회원아이디 VARCHAR2(20) NOT NULL PRIMARY KEY,
비밀번호 VARCHAR2(16) NOT NULL,
이메일 VARCHAR2(50) NOT NULL UNIQUE,
휴대폰 CHAR(15) UNIQUE,
주소 VARCHAR2(100),
가입일 DATE
);


-- 게시판테이블 (기본키, 회원테이블을 참조하는 외래키)
CREATE TABLE 게시판
(
게시글번호 NUMBER NOT NULL PRIMARY KEY,
제목 VARCHAR2(100) NOT NULL,
내용 VARCHAR2(1000),
작성자 VARCHAR2(20) NOT NULL,
작성일자 DATE,
FOREIGN KEY (작성자) REFERENCES 회원 (회원아이디)
);


-- 제조사테이블 (기본키)
CREATE TABLE 제조사
(
제조사사업자번호 CHAR(12) NOT NULL PRIMARY KEY,
제조사명 VARCHAR2(20) NOT NULL,
제조사전화번호 CHAR(15),
대표이사 CHAR(10)
);


-- 창고테이블 (기본키)
CREATE TABLE 창고
(
창고코드 CHAR(10) NOT NULL PRIMARY KEY,
창고위치 VARCHAR2(100) NOT NULL,
사용여부 CHAR(1),
창고전화번호 CHAR(15)
);


-- 택배업체테이블 (기본키)
CREATE TABLE 택배업체
(
택배업체사업자번호 CHAR(12) NOT NULL PRIMARY KEY,
택배업체명 VARCHAR2(20) NOT NULL,
택배업체전화번호 CHAR(15),
택배업체주소 VARCHAR2(100)
);


-- 배송테이블 (기본키, 택배업체테이블을 참조하는 외래키)
CREATE TABLE 배송
(
배송번호 NUMBER NOT NULL PRIMARY KEY,
배송업체 CHAR(12),
배송금액 NUMBER,
배송일자 DATE,
FOREIGN KEY (배송업체) REFERENCES 택배업체 (택배업체사업자번호)
);


-- 주문테이블 (기본키, 회원테이블을 참조하는 외래키, 배송테이블을 참조하는 외래키)
CREATE TABLE 주문
(
주문번호 NUMBER NOT NULL PRIMARY KEY,
주문회원 VARCHAR2(20),
주문일자 DATE,
배송주소 VARCHAR2(100) NOT NULL,
결제방식 CHAR(10),
배송번호 NUMBER,
FOREIGN KEY (주문회원) REFERENCES 회원 (회원아이디),
FOREIGN KEY (배송번호) REFERENCES 배송 (배송번호)
);


-- 제품테이블 (기본키, 창고테이블을 참조하는 외래키, 주문테이블을 참조하는 외래키, 제조사테이블을 참조하는 외래키)
CREATE TABLE 제품
(
제품코드 CHAR(10) NOT NULL PRIMARY KEY,
제조사 CHAR(12),
주문번호 NUMBER,
창고코드 CHAR(10),
제품수량 NUMBER,
제품단가 NUMBER,
카테고리 CHAR(10),
적용할인율 NUMBER(2, 2),
FOREIGN KEY (제조사) REFERENCES 제조사 (제조사사업자번호),
FOREIGN KEY (주문번호) REFERENCES 주문 (주문번호),
FOREIGN KEY (창고코드) REFERENCES 창고 (창고코드)
);
