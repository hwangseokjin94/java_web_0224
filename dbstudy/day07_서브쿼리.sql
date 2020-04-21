-- 서브쿼리
-- 쿼리 내에 또 다른 쿼리문을 삽입하는 것


-- 단일 행 서브쿼리
-- 1. 결과가 1개인 서브쿼리
-- 2. 연산자 : =, !=, >, >=, <, <=

-- 1. 평균 연봉 이상을 받는 사원을 조회하시오.
-- 평균 연봉(서브쿼리)
SELECT AVG(SALARY) FROM EMPLOYEE;
-- 연봉이 평균 연봉 이상(메인쿼리)
-- SELECT * FROM EMPLOYEE WHERE SALARY >= 평균연봉;
SELECT * FROM EMPLOYEE WHERE SALARY >= (SELECT AVG(SALARY) FROM EMPLOYEE);

-- 2. 사원번호가 1001 인 사원과 성별이 같은 사원을 조회하시오.
-- 사원번호가 1001 인 사원의 성별(서브쿼리)
SELECT GENDER FROM EMPLOYEE WHERE emp_no = 1001;
-- 성별이 사원번호가 1001 인 사원의 성별과 같은(메인쿼리)
SELECT * FROM EMPLOYEE WHERE GENDER = (SELECT GENDER FROM EMPLOYEE WHERE emp_no = 1001);




-- 다중 행 서브쿼리
-- 1. 결과가 여러 개인 서브쿼리
-- 2. 연산자 : IN, ANY, ALL, EXISTS

-- 1. depart 가 1 인 부서에 근무하는 사원들의 직급(position) 과 일치하는 직급을 가진 사원들을 조회하시오.
-- depart 가 1 인 부서에 근무하는 사원들의 직급(position) : 서브쿼리
SELECT POSITION FROM EMPLOYEE WHERE DEPART = 1;
-- depart 가 1 인 부서에 근무하는 사원들의 직급(position) 과 일치하는 직급을 가진 사원 : 메인쿼리
-- SELECT * FROM EMPLOYEE WHERE POSITION = '과장', '사원';  불가!!!!!
-- SELECT * FROM EMPLOYEE WHERE POSITION IN ('과장', '사원');
SELECT * FROM EMPLOYEE WHERE POSITION IN (SELECT POSITION FROM EMPLOYEE WHERE DEPART = 1);

-- 2. emp_no 가 1002, 1003 인 사원과 같은 부서에서 근무하는 사원들을 조회하시오.
-- emp_no 가 1002, 1003 인 사원이 근무하는 부서 : 서브쿼리
SELECT depart FROM employee WHERE emp_no IN (1002, 1003);
-- emp_no 가 1002, 1003 인 사원과 같은 부서에서 근무하는 사원 : 메인쿼리
SELECT * FROM employee WHERE depart IN (SELECT depart FROM employee WHERE emp_no IN (1002, 1003));




-- employee 테이블과 구조가 동일한 새 테이블을 생성하시오.
-- CREATE TABLE new_employee (칼럼.....);
CREATE TABLE new_employee AS (SELECT * FROM employee);  -- pk 는 제외하고 복사된다.

-- employee 테이블과 구조가 동일하고 데이터는 없는 새 테이블을 생성하시오.
CREATE TABLE new_employee2 AS (SELECT * FROM employee WHERE 1 = 2);

DROP TABLE new_employee;
DROP TABLE new_employee2;
