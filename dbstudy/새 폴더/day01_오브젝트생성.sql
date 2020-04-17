-- 주석

-- 오라클 데이터 타입
-- 1. 숫자 : NUMBER
-- 2. 문자 : CHAR, VARCHAR2
--    1) CHAR : 고정형(글자수나 크기에 변동이 적은 데이터, 주민등록번호, 우편번호, 성명 등)
--    2) VARCHAR2 : 가변형(글자수나 크기에 변동이 큰 데이터, 주소 등)
-- 3. 날짜 : DATE, TIMESTMAP


-- 실행방법
-- 1. F5 : 스크립트 전체 실행
-- 2. Ctrl + Enter : 선택한 스크립트 실행


-- 기존에 존재하는 동일한 이름의 테이블이 있으면 삭제하고 진행할 수 있도록 삭제코드를 초반에 삽입한다.
DROP TABLE project;
DROP TABLE employee;
DROP TABLE department;


-- 부서테이블
CREATE TABLE department
(
dept_no NUMBER NOT NULL PRIMARY KEY,
dept_name CHAR(10),
dept_loc VARCHAR2(100)
);


-- 사원테이블
CREATE TABLE employee
(
emp_id VARCHAR2(50) NOT NULL,
dept_no NUMBER,
emp_position CHAR(10),
emp_gender CHAR(10),
emp_hire_date DATE,
emp_salary NUMBER(6),
PRIMARY KEY (emp_id),
FOREIGN KEY (dept_no) REFERENCES department (dept_no)
);
-- employee 테이블의 dept_no 칼럼은 department 테이블의 dept_no 칼럼을 참조한다.
-- 부모테이블 : department (PK를 보유한 테이블)
-- 자식테이블 : employee (FK를 보유한 테이블)
-- FK 참조무결성
-- 부모테이블이 가진 데이터만을 자식테이블이 가질 수 있다.
-- 부모테이블은 자식테이블보다 먼저 삭제할 수 없다. (FK를 가진 테이블을 먼저 삭제해야 한다.)

-- 프로젝트테이블
CREATE TABLE project
(
pjt_name VARCHAR2(100) NOT NULL UNIQUE,
pjt_no NUMBER NOT NULL PRIMARY KEY,
pjt_member VARCHAR2(50),
pjt_start_date DATE,
pjt_end_date DATE,
FOREIGN KEY (pjt_member) REFERENCES employee (emp_id)
);