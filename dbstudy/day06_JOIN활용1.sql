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
CONSTRAINT department_employee_fk FOREIGN KEY (depart) REFERENCES department (dept_no)  -- 외래키 (depart 는 department 테이블의 dept_no 를 참조하는 외래키)
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
FROM department d INNER JOIN employee e  -- INNER JOIN : 양쪽에 모두 존재하는 데이터만 검색한다.
ON d.dept_no = e.depart;



-- 외부 조인 (OUTER JOIN)

-- 1. LEFT OUTER JOIN : 왼쪽 테이블의 데이터는 모두 가져오고, 오른쪽 테이블의 데이터는 일치하는 값만 가져온다.
-- 1) JOIN ON 문법
--    SELECT TABLE1.COLUMN, TABLE2.COLUMN
--    FROM 왼쪽테이블 LEFT [OUTER] JOIN 오른쪽테이블
--    ON TABLE1.COLUMN = TABLE2.COLUMN
-- 2) 콤마(,) 구분법
--    SELECT TABLE1.COLUMN, TABLE2.COLUMN
--    FROM 왼쪽테이블, 오른쪽테이블
--    WHERE TABLE1.COLUMN = TABLE2.COLUMN(+)

-- 2. RIGHT OUTER JOIN : 오른쪽 테이블의 데이터는 모두 가져오고, 왼쪽 테이블의 데이터는 일치하는 값만 가져온다.
-- 1) JOIN ON 문법
--    SELECT TABLE1.COLUMN, TABLE2.COLUMN
--    FROM 왼쪽테이블 RIGHT [OUTER] JOIN 오른쪽테이블
--    ON TABLE1.COLUMN = TABLE2.COLUMN
-- 2) 콤마(,) 구분법
--    SELECT TABLE1.COLUMN, TABLE2.COLUMN
--    FROM 왼쪽테이블, 오른쪽테이블
--    WHERE TABLE1.COLUMN(+) = TABLE2.COLUMN


DESC USER_CONSTRAINTS;  -- 제약조건을 저장하고 있는 데이터 사전
SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS;

-- 제약조건 DEPARTMENT_EMPLOYEE_FK 의 일시중지(비활성화) (DISABLE)
ALTER TABLE employee DISABLE CONSTRAINT DEPARTMENT_EMPLOYEE_FK;

-- 외래키 제약조건이 없는 상태이기 때문에 department 테이블의 dept_no 가 가지고 있지 않은 값을 저장할 수 있다.
INSERT INTO employee VALUES (emp_seq.NEXTVAL, '김미나', 5, '사원', 'F', '18-05-01', 1800000);


-- 모든 사원(부서가 없는 사원도 포함)의 사원번호, 이름, 부서명을 조회한다.
-- employee 테이블에는 있지만, department 테이블에는 없는 데이터도 조회해야 하므로,
-- 외부 조인(OUTER JOIN)이 필요하다.

-- 1) 왼쪽 조인
SELECT e.emp_no, e.name, d.dept_name
FROM employee e LEFT OUTER JOIN department d  -- 왼쪽 테이블인 employee 테이블은 전체 조회된다.
ON e.depart = d.dept_no;

-- 2) 오른쪽 조인
SELECT e.emp_no, e.name, d.dept_name
FROM department d RIGHT OUTER JOIN employee e  -- 오른쪽 테이블인 employee 테이블은 전체 조회된다.
ON d.dept_no = e.depart;

-- 외래키 제약조건을 위배하고 있는 데이터 삭제
DELETE FROM employee WHERE depart = 5;

COMMIT;

-- 제약조건 DEPARTMENT_EMPLOYEE_FK 의 활성화 (ENABLE)
ALTER TABLE employee ENABLE CONSTRAINT DEPARTMENT_EMPLOYEE_FK;




-- day06.데이터베이스구축.sql 참고


-- 1. 학번, 이름, 주소, 교수이름, 전공 을 출력한다.
-- 학생 테이블 : 학번, 이름, 주소
-- 교수 테이블 : 교수이름, 전공
SELECT s.s_no, s.s_name, s.s_address, p.p_name, p.p_major
FROM professor p, student s  -- professor 가 PK 를 가지고 (index 를 가지고) 있으므로 driving table 이 된다.
WHERE p.p_no = s.p_no;  -- 조인 조건

SELECT s.s_no, s.s_name, s.s_address, p.p_name, p.p_major
FROM professor p INNER JOIN student s
ON p.p_no = s.p_no;  -- 조인 조건


-- 2. 학번, 이름, 과목번호, 신청일자 를 출력한다.
-- 학생 테이블 : 학번, 이름
-- 수강신청 테이블 : 과목번호, 신청일자
SELECT s.s_no, s.s_name, e.c_no, e.e_date
FROM student s, enroll e
WHERE s.s_no = e.s_no;  -- 조인 조건

SELECT s.s_no, s.s_name, e.c_no, e.e_date
FROM student s INNER JOIN enroll e
ON s.s_no = e.s_no;  -- 조인 조건
