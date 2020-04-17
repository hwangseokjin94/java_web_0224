-- 1. 부서의 위치(location_id)가 1700 인 사원들의 employee_id, last_name, department_id, salary 를 조회한다.
-- 사용할 테이블 (departments, employees)

SELECT e.employee_id, e.last_name, e.department_id, e.salary
FROM departments d, employees e
WHERE d.department_id = e.department_id  -- 조인 조건(두 테이블의 관계 조건)
AND d.location_id = 1700;  -- 일반 조건

SELECT e.employee_id, e.last_name, e.department_id, e.salary
FROM departments d INNER JOIN employees e
ON d.department_id = e.department_id  -- 조인 조건(두 테이블의 관계 조건)
AND d.location_id = 1700;  -- 일반 조건  ( WHERE d.location_id = 1700;  -- 일반 조건 )


-- 2. 부서명(department_name)이 'Executive' 인 부서에 근무하는 모든 사원들의 department_id, last_name, job_id 를 조회한다.
-- 사용할 테이블 (departments, employees)
SELECT e.department_id, e.last_name, e.job_id
FROM departments d, employees e
WHERE d.department_id = e.department_id
AND d.department_name = 'Executive';

SELECT e.department_id, e.last_name, e.job_id
FROM departments d INNER JOIN employees e
ON d.department_id = e.department_id
AND d.department_name = 'Executive';  -- 일반조건 ( WHERE d.department_name = 'Executive';  -- 일반조건 )


-- 3. 기존의 직업(job_id)을 여전히 가지고 있는 사원들의 employee_id, job_id 를 조회한다.
-- 사용할 테이블 (employees, job_history)
SELECT e.employee_id, e.job_id
FROM employees e, job_history j
WHERE e.employee_id = j.employee_id
AND e.job_id = j.job_id;

SELECT e.employee_id, e.job_id
FROM employees e INNER JOIN job_history j
ON e.employee_id = j.employee_id
AND e.job_id = j.job_id;


-- 4. 각 부서별 사원수와 평균연봉을 department_name, location_id 와 함께 조회한다.
-- 평균연봉은 소수점 2 자리까지 반올림하여 표현하고, 각 부서별 사원수의 오름차순으로 조회한다.
-- 사용할 테이블 (departments, employees)
SELECT d.department_id, d.department_name, d.location_id, COUNT(*) AS 사원수, ROUND(AVG(e.salary), 2) AS 평균연봉
FROM departments d, employees e
WHERE d.department_id(+) = e.department_id
GROUP BY d.department_id, d.department_name, d.location_id
ORDER BY 사원수;  -- ORDER BY COUNT(*);

SELECT d.department_id, d.department_name, d.location_id, COUNT(*) AS 사원수, ROUND(AVG(e.salary), 2) AS 평균연봉
FROM departments d RIGHT OUTER JOIN employees e
ON d.department_id = e.department_id
GROUP BY d.department_id, d.department_name, d.location_id
ORDER BY 사원수;  -- ORDER BY COUNT(*);


-- 5. 도시이름(city)이 T 로 시작하는 지역에 사는 사원들의 employee_id, last_name, department_id, city 를 조회한다.
-- 사용할 테이블 (employees, departments, locations)
SELECT * FROM EMPLOYEES;  -- 모든 사원은 DEPARTMENT_ID 를 가지고 있다.
SELECT * FROM DEPARTMENTS;  -- DEPARTMENT_ID 를 알면 LOCATION_ID 를 알 수 있다.
SELECT * FROM LOCATIONS;  -- LOCATION_ID 를 알면 CITY 를 알 수 있다.

SELECT e.employee_id, e.last_name, e.department_id, l.city
FROM employees e, departments d, locations l
WHERE e.department_id = d.department_id  -- 조인조건1
AND d.location_id = l.location_id  -- 조인조건2
AND l.city LIKE 'T%';  -- 일반조건

SELECT e.employee_id, e.last_name, e.department_id, l.city
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id INNER JOIN locations l -- 조인조건1
ON d.location_id = l.location_id  -- 조인조건2
AND l.city LIKE 'T%';  -- 일반조건


-- 6. 자신의 담당 매니저(manager_id)의 고용일(hire_date)보다 빨리 입사한 사원을 찾아서 last_name, hire_date, manager_id 를 조회한다. 
-- 사용할 테이블 (employees)
SELECT * FROM EMPLOYEES;
-- 내 정보 : employees me
-- 매니저 정보 : employees other
-- 내 매니저 : me 의 manager_id 와 other 의 employee_id 가 같은 사원

SELECT me.last_name AS 내이름, me.hire_date AS 내고용일, other.hire_date AS 매니저고용일, me.manager_id AS 내매니저
FROM employees me, employees other
WHERE me.manager_id = other.employee_id  -- 조인조건
AND me.hire_date < other.hire_date;  -- 일반조건

SELECT me.last_name AS 내이름, me.hire_date AS 내고용일, other.hire_date AS 매니저고용일, me.manager_id AS 내매니저
FROM employees me INNER JOIN employees other
ON me.manager_id = other.employee_id  -- 조인조건
WHERE me.hire_date < other.hire_date;  -- 일반조건


-- 7. 같은 소속부서(department_id)에서 나보다 늦게 입사(hire_date)하였으나 나보다 높은 연봉(salary)을 받는 사원이 존재하는 사원들의
-- department_id, full_name(first_name 과 last_name 사이에 공백을 포함하여 연결), salary, hire_date 를 full_name 순으로 정렬하여 조회한다.
-- 사용할 테이블 (employees)
-- 나 : employees me
-- 다른 사원 : employees other

SELECT DISTINCT me.department_id, me.first_name || ' ' || me.last_name AS full_name, me.salary, me.hire_date
FROM employees me, employees other
WHERE me.department_id = other.department_id  -- 조인조건
AND me.hire_date < other.hire_date  -- 일반조건
AND me.salary < other.salary  -- 일반조건
ORDER BY full_name;

SELECT DISTINCT me.department_id, me.first_name || ' ' || me.last_name AS full_name, me.salary, me.hire_date
FROM employees me INNER JOIN employees other
ON me.department_id = other.department_id  -- 조인조건
WHERE me.hire_date < other.hire_date  -- 일반조건
AND me.salary < other.salary  -- 일반조건
ORDER BY full_name;


-- 8. 같은 소속부서(department_id)의 다른 사원보다 늦게 입사(hire_date)하였으나 현재 더 높은 연봉(salary)을 받는 사원들의
-- department_id, full_name(first_name 과 last_name 사이에 공백을 포함하여 연결), salary, hire_date 를 full_name 순으로 정렬하여 조회한다.
-- 사용할 테이블 (employees)

SELECT DISTINCT other.department_id, other.first_name || ' ' || other.last_name AS full_name, other.salary, other.hire_date
FROM employees me, employees other
WHERE me.department_id = other.department_id  -- 조인조건
AND me.hire_date < other.hire_date  -- 일반조건
AND me.salary < other.salary  -- 일반조건
ORDER BY full_name;

SELECT DISTINCT other.department_id, other.first_name || ' ' || other.last_name AS full_name, other.salary, other.hire_date
FROM employees me INNER JOIN employees other
ON me.department_id = other.department_id  -- 조인조건
WHERE me.hire_date < other.hire_date  -- 일반조건
AND me.salary < other.salary  -- 일반조건
ORDER BY full_name;
