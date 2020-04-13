-- 31. 이름(first_name) 이 'Curtis' 인 사원의 first_name, last_name, email, phone_number, job_id 를 조회한다.
-- 단, 직업(job_id) 의 결과는 소문자로 조회되도록 한다.(lower 함수)
SELECT FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, LOWER(JOB_ID)
FROM EMPLOYEES
WHERE FIRST_NAME = 'Curtis';


-- 32. 부서번호(department_id)가 60, 70, 80, 90 인 사원들의 employee_id, first_name, last_name, hire_date, job_id 를 조회한다.
-- 단, 직업(job_id) 이 IT_PROG 인 사원의 경우 '프로그래머'로 변경하여 조회한다.(replace 함수)
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HIRE_DATE, REPLACE(JOB_ID, 'IT_PROG', '프로그래머')
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (60, 70, 80, 90);


-- 33. 직업(job_id) 이 AD_PRES, PU_CLERK 인 사원들의 employee_id, 사원명(full_name), employee_id, department_id, job_id 를 조회한다.
-- 단, 사원명(full_name)은 first_name 과 last_name 의 사이에 공백을 포함하도록 연결하여 조회한다.(concat 함수)

-- 1) CONCAT 함수
SELECT EMPLOYEE_ID, CONCAT(FIRST_NAME, CONCAT(' ', LAST_NAME)) AS FULL_NAME, EMPLOYEE_ID, DEPARTMENT_ID, JOB_ID
FROM EMPLOYEES
WHERE JOB_ID IN ('AD_PRES', 'PU_CLERK');

-- 2) || 연산자
SELECT EMPLOYEE_ID, FIRST_NAME || ' ' || LAST_NAME  AS FULL_NAME, EMPLOYEE_ID, DEPARTMENT_ID, JOB_ID
FROM EMPLOYEES
WHERE JOB_ID IN ('AD_PRES', 'PU_CLERK');


-- 34. 성(last_name) 에 u 가 포함되는 사원들의 employee_id, last_name 을 조회한다.(instr 함수)
SELECT EMPLOYEE_ID, LAST_NAME
FROM EMPLOYEES
WHERE INSTR(LAST_NAME, 'u') > 0;


-- 35. 전화번호(phone_number)가 650 으로 시작하는 사원들의 last_name, phone_number 를 조회한다.(substr 함수)
SELECT LAST_NAME, PHONE_NUMBER
FROM EMPLOYEES
WHERE SUBSTR(PHONE_NUMBER, 1, 3) = '650';


-- 36. 성(last_name) 의 네 번째 글자가 a 인 사원들의 last_name 을 조회한다.(substr 함수 또는 instr 함수)

-- 1) INSTR 함수
SELECT LAST_NAME
FROM EMPLOYEES
WHERE INSTR(LAST_NAME, 'a') = 4;

-- 2) SUBSTR 함수
SELECT LAST_NAME
FROM EMPLOYEES
WHERE SUBSTR(LAST_NAME, 4, 1) = 'a';

-- 37. 회사의 연봉(salary) 평균을 소수 2자리까지 반올림하여 조회한다.(round, avg 함수)
SELECT ROUND(AVG(SALARY), 2)
FROM EMPLOYEES;


-- 38. 회사의 연봉(salary) 총액을 $500,000 과 같은 형식으로 조회한다.(to_char, sum 함수)
SELECT TO_CHAR(SUM(SALARY), '$999,999') -- 999999 : 6자리 이하 숫자는 가능
FROM EMPLOYEES;


-- 39. 성(last_name) 이 'McCain' 인 사원이 지금까지 근무한 근속일(service_days)을 '4500일' 과 같은 형식으로 조회한다.(trunc, sysdate 함수)
SELECT TRUNC(SYSDATE - HIRE_DATE) || '일' AS SERVICE_DAYS
FROM EMPLOYEES
WHERE LAST_NAME = 'McCain';


-- 40. 성(last_name) 이 'McCain' 인 사원이 지금까지 근무한 근속일(service_days)을 '120개월' 과 같은 형식으로 조회한다.(trunc, sysdate, months_between 함수)
SELECT TRUNC(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) || '개월' AS SERVICE_DAYS
FROM EMPLOYEES
WHERE LAST_NAME = 'McCain';
