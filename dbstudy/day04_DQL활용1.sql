-- << employees 테이블 >>﻿ --

-- SELECT 검색할 칼럼
-- FROM 테이블
-- [WHERE 조건식]
-- [GROUP BY 그룹화할 칼럼]
-- [ORDER BY 정렬 칼럼]


-- 1. 전체 사원의 모든 칼럼을 조회한다.
SELECT *  -- * : 모든 칼럼
FROM EMPLOYEES;

SELECT EMPLOYEES.*  -- 칼럼 == 테이블.칼럼
FROM EMPLOYEES;

SELECT E.*
FROM EMPLOYEES E;  -- 테이블명 테이블별명


-- 2. 전체 사원의 first_name, last_name, job_id 를 조회한다.
SELECT FIRST_NAME, LAST_NAME, JOB_ID
FROM EMPLOYEES;

SELECT EMPLOYEES.FIRST_NAME, EMPLOYEES.LAST_NAME, EMPLOYEES.JOB_ID
FROM EMPLOYEES;

SELECT E.FIRST_NAME, E.LAST_NAME, E.JOB_ID
FROM EMPLOYEES E;  -- 테이블의 별명(E)은 쿼리 작성자가 정하면 된다.


-- 3. 연봉(salary)이 12000 이상되는 사원들의 last_name, salary 를 조회한다.
SELECT LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY >= 12000;


-- 4. 사원번호(employee_id)가 150 인 사원들의 last_name, department_id 를 조회한다.
SELECT LAST_NAME, DEPARTMENT_ID
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 150;


-- 5. 커미션(commission_pct)을 받는 모든 사원들의 last_name, salary, commission_pct 를 조회한다.
SELECT LAST_NAME, SALARY, COMMISSION_PCT
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL;

SELECT LAST_NAME, SALARY, COMMISSION_PCT
FROM EMPLOYEES
WHERE COMMISSION_PCT > 0;


-- 6. 모든 사원들의 last_name, commission_pct 를 조회하되 커미션(commission_pct)이 없는 사원은 0으로 처리하여 조회한다.
SELECT LAST_NAME, NVL(COMMISSION_PCT, 0)
FROM EMPLOYEES;


-- 7. 커미션(commission_pct)이 없는 사원들은 0으로 처리하고, 커미션이 있는 사원들은 기존 커미션보다 10% 인상된 상태로 조회한다.
SELECT NVL2(COMMISSION_PCT, COMMISSION_PCT * (1 + 0.1), 0)
FROM EMPLOYEES;


-- 8. 연봉(salary)이 5000 에서 12000 인 범위의 사원들의 first_name, last_name, salary 를 조회한다.
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY >= 5000 AND SALARY <= 12000;

SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY BETWEEN 5000 AND 12000;


-- 9. 연봉(salary)이 5000 에서 12000 사이의 범위가 아닌 사원들의 first_name, last_name, salary 를 조회한다.
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY < 5000 OR SALARY > 12000;

SELECT FIRST_NAME, LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY NOT BETWEEN 5000 AND 12000;


-- 10. 직업(job_id)이 SA_REP 이나 ST_CLERK 인 사원들의 전체 칼럼을 조회한다.
SELECT *
FROM EMPLOYEES
WHERE JOB_ID = 'SA_REP' OR JOB_ID = 'ST_CLERK';

SELECT *
FROM EMPLOYEES
WHERE JOB_ID IN ('SA_REP', 'ST_CLERK');


-- 11. 연봉(salary)이 2500, 3500, 7000 이 아니며 직업(job_id) 이 SA_REP 이나 ST_CLERK 인 사람들을 조회한다.
SELECT *
FROM EMPLOYEES
WHERE (SALARY != 2500 OR SALARY != 3500 OR SALARY <> 7000)
AND JOB_ID IN ('SA_REP', 'ST_CLERK');

SELECT *
FROM EMPLOYEES
WHERE SALARY NOT IN (2500, 3500, 7000)
AND JOB_ID IN ('SA_REP', 'ST_CLERK');


-- 12. 매니저(manager_id)가 없는 사람들의 last_name, job_id 를 조회한다.
SELECT LAST_NAME, JOB_ID
FROM EMPLOYEES
WHERE MANAGER_ID IS NULL;


-- 와일드카드 (만능문자)
-- 1. 모든 문자를 대체할 수 있는 만능문자
-- 2. 글자수에 상관 없이 사용가능한 %
-- 3. 한 글자를 대체할 수 있는 _ (밑줄)
-- 4. 와일드카드를 사용하는 경우 등호(=) 대신 LIKE 연산자를 사용

-- 마, 마차, 마라도, 마동석, 마요네즈 : 마로 시작하는 문자열 -> 마%
-- 공주, 백설공주, 평강공주, 우리나라공주 : 공주로 끝나는 문자열 -> %공주
-- 맨드라미, 아이언맨, 드라마맨또롱 : 맨을 포함하는 문자열 -> %맨%


-- 13. 성(last_name)에 u 가 포함되는 사원들의 employee_id, last_name 을 조회한다.
SELECT EMPLOYEE_ID, LAST_NAME
FROM EMPLOYEES
WHERE LAST_NAME LIKE '%U%' OR LAST_NAME LIKE '%u%';

SELECT EMPLOYEE_ID, LAST_NAME
FROM EMPLOYEES
WHERE LAST_NAME LIKE IN('%U%', '%u%');  -- 처리 불가!

SELECT EMPLOYEE_ID, LAST_NAME
FROM EMPLOYEES
WHERE REGEXP_LIKE(LAST_NAME, 'U|u');  -- 정규표현식(REGULAR EXPRESSION) 활용 (나중에 배웁니다.)  U|u : U 또는 u

SELECT EMPLOYEE_ID, LAST_NAME
FROM EMPLOYEES
WHERE UPPER(LAST_NAME) LIKE '%U%';  -- LAST_NAME 을 모두 대문자로 변환하여 비교

SELECT EMPLOYEE_ID, LAST_NAME
FROM EMPLOYEES
WHERE LOWER(LAST_NAME) LIKE '%u%';  -- LAST_NAME 을 모두 소문자로 변환하여 비교


-- 14. 전화번호(phone_number)가 650 으로 시작하는 사원들의 last_name, phone_number 를 조회한다.
SELECT LAST_NAME, PHONE_NUMBER
FROM EMPLOYEES
WHERE PHONE_NUMBER LIKE '650%';

SELECT LAST_NAME, PHONE_NUMBER
FROM EMPLOYEES
WHERE SUBSTR(PHONE_NUMBER, 1, 3) = '650';  -- SUBSTR 의 결과는 언제나 문자열이다.


-- 15. 성(last_name)의 네 번째 글자가 a 인 사원들의 last_name 을 조회한다.
SELECT LAST_NAME
FROM EMPLOYEES
WHERE LAST_NAME LIKE '___a%';  -- 밑줄(_) 3개는 3글자를 의미하므로 ___a는 4번째 글자가 a라는 의미이다.


-- 16. 성(last_name) 에 a 또는 e 가 포함된 사원들의 last_name 을 조회한다.
SELECT LAST_NAME
FROM EMPLOYEES
WHERE LAST_NAME LIKE '%a%' OR LAST_NAME LIKE '%e%';


-- 17. 성(last_name) 에 a 와 e 가 모두 포함된 사원들의 last_name 을 조회한다.
SELECT LAST_NAME
FROM EMPLOYEES
WHERE LAST_NAME LIKE '%a%e%' OR LAST_NAME LIKE '%e%a%';


-- 18. 2008/02/20 ~ 2008/05/01 사이에 고용된(hire_date) 사원들의 last_name, employeed_id, hire_date 를 조회한다.
SELECT LAST_NAME, EMPLOYEE_ID, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE >= '2008/02/20' AND HIRE_DATE <= '2008/05/01';

SELECT LAST_NAME, EMPLOYEE_ID, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE BETWEEN '2008/02/20' AND '2008/05/01';


-- 19. 2004년도에 고용된(hire_date) 모든 사원들의 last_name, employee_id, hire_date 를 조회한다.
SELECT LAST_NAME, EMPLOYEE_ID, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE BETWEEN '2004/01/01' AND '2004/12/31';

SELECT LAST_NAME, EMPLOYEE_ID, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE LIKE '04%';

SELECT LAST_NAME, EMPLOYEE_ID, HIRE_DATE
FROM EMPLOYEES
WHERE SUBSTR(HIRE_DATE, 1, 2) = '04';


-- 20. 부서(department_id)를 조회하되 중복을 제거하여 조회한다.
SELECT DISTINCT DEPARTMENT_ID  -- 중복을 제거해서 한 번만 사용 : DISTINCT 칼럼
FROM EMPLOYEES;
