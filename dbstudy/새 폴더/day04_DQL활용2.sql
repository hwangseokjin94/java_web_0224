-- 21. 직업(job_id)이 ST_CLERK 인 사원이 근무하지 않는 부서번호(department_id)를 조회한다.
-- 단, 부서번호가 NULL인 값은 제외하고 부서번호의 중복을 제거한다.
SELECT DISTINCT DEPARTMENT_ID FROM EMPLOYEES
--WHERE JOB_ID != 'ST_CLECK'
--WHERE JOB_ID <> 'ST_CLECK'
WHERE JOB_ID NOT IN ('ST_CLECK')
AND DEPARTMENT_ID IS NOT NULL;


-- 22. 커미션(commission_pct)을 받는 사원들의 실제 커미션(commission = salary * commission_pct)을 구하고,
-- employee_id, first_name, job_id 와 함께 조회한다.
-- SELECT EMPLOYEE_ID AS ID, FIRST_NAME AS NAME, JOB_ID AS JOB, SALARY * COMMISSION_PCT AS COMMISSION  -- 칼럼명 AS 별명  또는  계산식 AS 별명
SELECT EMPLOYEE_ID ID, FIRST_NAME NAME, JOB_ID JOB, SALARY * COMMISSION_PCT COMMISSION  -- 칼럼명 별명  또는  계산식 별명
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL;


-- 23. 연봉(salary) 총액과 연봉(salary) 평균을 조회한다.
SELECT SUM(SALARY) 총연봉, AVG(SALARY) 연봉평균
FROM EMPLOYEES;

SELECT TO_CHAR(SUM(SALARY), '999,999') 총연봉, TO_CHAR(AVG(SALARY), '9,999.99') 연봉평균
FROM EMPLOYEES;


-- 24. 최대연봉(salary)과 최소연봉의 차이를 조회한다.
SELECT MAX(SALARY) - MIN(SALARY) SALARY_GAP
FROM EMPLOYEES;


-- 25. 직업(job_id) 이 ST_CLERK 인 사원들의 전체 수를 조회한다.
SELECT COUNT(JOB_ID)
FROM EMPLOYEES
WHERE JOB_ID = 'ST_CLERK';


-- 26. 매니저(manager_id)로 근무하는 사원들의 전체 수를 조회한다.
SELECT COUNT(MANAGER_ID) AS 매니저수  -- MANAGER_ID 에서 NULL 을 제외하고 개수를 구한다.
FROM EMPLOYEES;


-- 27. 회사 내에 총 몇 개의 부서가 있는지 조회한다.
SELECT COUNT(DISTINCT DEPARTMENT_ID) AS 총부서수
FROM EMPLOYEES;



-- 정렬
-- 1. ORDER BY 절을 이용한다.
-- 2. 오름차순 정렬(가나다순, 작은 숫자 먼저, 예전 날짜 먼저) : ASC  또는  생략
-- 3. 내림차순 정렬(역순) : DESC
-- 4. 주의사항 : 마지막에 한 번만 작성한다.


-- 28. 가장 오래 전에 입사(hire_date)한 직원부터 최근에 입사한 직원 순으로 last_name, hire_date 를 조회한다.
SELECT LAST_NAME, HIRE_DATE
FROM EMPLOYEES
ORDER BY HIRE_DATE ASC;  -- ASC 는 생략이 가능하다.


-- 29. 부서번호(department_id)가 20, 50 인 부서에서 근무하는 모든 사원들의 부서번호의 오름차순으로 조회하되,
-- 같은 부서번호 내에서는 last_name 의 알파벳순으로 조회한다.
SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (20, 50)
ORDER BY DEPARTMENT_ID ASC, LAST_NAME ASC;  -- ASC 는 둘 다 생략이 가능하다.


-- 30. 커미션(commission_pct)을 받는 모든 사원들의 last_name, salary, commission_pct 을 조회한다.
-- 연봉이 높은 사원을 먼저 조회하고 같은 연봉의 사원들은 커미션이 높은 사원을 먼저 조회한다.
SELECT LAST_NAME, SALARY, COMMISSION_PCT
FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL
ORDER BY SALARY DESC, COMMISSION_PCT DESC;
