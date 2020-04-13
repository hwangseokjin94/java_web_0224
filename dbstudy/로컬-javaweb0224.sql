-- 주석

-- 오라클 데이터 타입
-- 1. 숫자 NUMBER
-- 2. 문자 CHAR ,VARCHAR2
--      1)CHAR : 고정형(글자수나 크기에 변동이 적은데이터,주민등록 번호,우편번호, 성명 등)
--      2)VARCHAR2: 가변형 텍스트(글자수나 크기에 변동이 큰데이터,주소 등)
-- 3.날짜 : DATE, TIMESTMAP

--실행방법
--1. F5: 스크립트 전체실행
--2. Ctrl +Enter :선택한 스크립트 실행
--부서테이블
CREATE TABLE department
(
dept_no NUMBER NOT NULL PRIMARY KEY,
dept_name CHAR(10),
dept_loc VARCHAR2(100)
);