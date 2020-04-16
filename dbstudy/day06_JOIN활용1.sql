-- 고급SQL활용 6.


-- 테이블 삭제
DROP TABLE employee;
DROP TABLE department;


-- department 테이블 생성 (부모)
CREATE TABLE department
(
dept_no NUMBER NOT NULL PRIMARY KEY,  -- 부서번호 (기본키)
dept_name VARCHAR2(10),  -- 부서명
dept_location VARCHAR2(10)  -- 부서위치
);


-- employee 테이블 생성 (자식)
CREATE TABLE employee
(
emp_no NUMBER NOT NULL PRIMARY KEY,  -- 사원번호 (기본키)
name VARCHAR2(30),  -- 사원명
depart NUMBER,  -- 부서번호
position VARCHAR2(10),  -- 직급
gender VARCHAR2(1),  -- 성별
hire_date DATE,  -- 입사일
salary NUMBER(10),  -- 기본급
FOREIGN KEY (depart) REFERENCES department (dept_no)  -- 외래키 (depart 는 department 테이블의 dept_no 를 참조하는 외래키)
);


-- 시퀀스 삭제
DROP SEQUENCE dept_seq;
DROP SEQUENCE emp_seq;


-- department 테이블에 부착할 시퀀스
CREATE SEQUENCE dept_seq
INCREMENT BY 1  -- 1씩 증가한다.
START WITH 1  -- 1부터 증가한다.
MAXVALUE 100  -- 최대 100까지 증가한다.
NOCYCLE  -- 순환하지 않는다. (100 다음으로 1 이 되지 않는다.)
NOCACHE;  -- 캐시 사용하지 않는다.


-- employee 테이블에 부착할 시퀀스
CREATE SEQUENCE emp_seq
INCREMENT BY 1
START WITH 1001
MAXVALUE 999999
NOCYCLE
NOCACHE;


-- department 데이터 삽입
INSERT INTO department VALUES (dept_seq.NEXTVAL, '영업부', '대구');
INSERT INTO department VALUES (dept_seq.NEXTVAL, '인사부', '서울');
INSERT INTO department VALUES (dept_seq.NEXTVAL, '총무부', '대구');
INSERT INTO department VALUES (dept_seq.NEXTVAL, '기획부', '서울');


-- employee 데이터 삽입
INSERT INTO employee VALUES (emp_seq.NEXTVAL, '구창민', 1, '과장', 'M', '95-05-01', 5000000);
INSERT INTO employee VALUES (emp_seq.NEXTVAL, '김민서', 1, '사원', 'M', '17-09-01', 2500000);
INSERT INTO employee VALUES (emp_seq.NEXTVAL, '이은영', 2, '부장', 'F', '90-09-01', 5500000);
INSERT INTO employee VALUES (emp_seq.NEXTVAL, '한성일', 2, '과장', 'M', '93-04-01', 5000000);


COMMIT;


SELECT * FROM department;
SELECT * FROM employee;


-- 조인의 활용
/*
    1) 콤마(,) 구분법
    SELECT TABLE1.COLUMN, TABLE2.COLUMN
    FROM TABLE1, TABLE2
    WHERE TABLE1.COLUMN = TABLE2.COLUMN
    
    2) JOIN ON 문법
    SELECT TABLE1.COLUMN, TABLE2.COLUMN
    FROM TABLE1 [INNER/LEFT/RIGHT/CROSS] JOIN TABLE2
    ON TABLE1.COLUMN = TABLE2.COLUMN
    
    3) TIP (DRIVING TABLE 을 우선 배치하는 것이 좋다. 일반적으로 PK를 가진 테이블이다.)
    SELECT TABLE1.COLUMN, TABLE2.COLUMN
    FROM DRIVING TABLE, DRIVEN TABLE
    WHERE DRIVING.COLUMN = DRIVEN.COLUMN
*/

-- 1. 콤마(,) 구분법
SELECT e.emp_no, e.name, d.dept_name
FROM department d, employee e
WHERE d.dept_no = e.depart;

-- 2. JOIN ON 문법
SELECT e.emp_no, e.name, d.dept_name
FROM department d INNER JOIN employee e --INNER JOIN 양쪽에 모두 존재하는데이터마 ㄴ검색한다.
ON d.dept_no = e.depart;








