-- 스칼라 서브쿼리
-- 1. 하나의 값을 반환하는 서브쿼리이다.
-- 2. 값이 없는 경우에는 NULL을 반환한다.
-- 3. GROUP BY 절을 제외한 모든 절에서 사용할 수 있다.


﻿-- 1. 모든 사원의 last_name, salary, 본인이 근무하는 부서의 평균연봉(salary)을 조회한다.
SELECT last_name, salary AS 내연봉, (SELECT TRUNC(AVG(SALARY)) FROM employees me WHERE me.department_id = other.department_id) AS 내부서의평균연봉
FROM employees other;


-- 2. 부서(department_id)별로 department_id, department_name, 최저연봉(salary)을 조회한다.
-- 아무도 근무하지 않는 부서도 모두 조회한다.

-- 1) LEFT OUTER JOIN - 1
SELECT d.department_id, d.department_name, MIN(e.salary) AS 최저연봉
FROM departments d, employees e
WHERE d.department_id = e.department_id(+)  -- 조인조건
GROUP BY d.department_id, d.department_name;

-- 2) LEFT OUTER JOIN - 2
SELECT d.department_id, d.department_name, MIN(e.salary) AS 최저연봉
FROM departments d LEFT OUTER JOIN employees e
ON d.department_id = e.department_id  -- 조인조건
GROUP BY d.department_id, d.department_name;

-- 3) 스칼라 서브쿼리
SELECT d.department_id, d.department_name, (SELECT MIN(e.salary) FROM employees e WHERE e.department_id = d.department_id) AS 최저연봉
FROM departments d;


-- 3. 모든 사원들의 employee_id, last_name, department_name 을 employee_id 순으로 오름차순 정렬하여 조회한다.

-- 1) 내부 조인 (INNER JOIN) - 106명 : 부서가 없는 사원은 조회되지 않는다.
SELECT e.employee_id, e.last_name, d.department_name
FROM departments d, employees e
WHERE d.department_id = e.department_id;

-- 2) 외부 조인 (RIGHT OUTER JOIN) - 107명 : 부서가 없는 사원은 department_name 이 NULL 로 조회가 된다.
SELECT e.employee_id, e.last_name, d.department_name
FROM departments d, employees e
WHERE d.department_id(+) = e.department_id;

-- 3) 스칼라 서브쿼리
-- 외부 조인(OUTER JOIN)으로 해결이 가능한 문제는 스칼라 서브쿼리를 고려할 수 있다.
SELECT e.employee_id, e.last_name, (SELECT d.department_name FROM departments d WHERE d.department_id = e.department_id) AS 부서명
FROM employees e;


-- 4. 전체 27개 부서이름(department_name) 중에서 사원들이 근무 중인 부서이름을 조회한다.
-- 널 값은 제외하고 조회한다.

-- 1) 내부 조인
SELECT e.last_name, d.department_name
FROM departments d, employees e
WHERE d.department_id = e.department_id;



-- 5. 전체 27개 부서이름(department_name) 중에서 사원들이 근무 중인 부서이름을 첫 3글자만 나타나도록 줄여서 조회한다.
-- 근무 중인 부서가 없는 경우 'NN'을 대신 조회한다.


-- 6. 근무지의 도시명(city)이 'Southlake' 인 곳에서 근무하는 사원들의 employee_id, last_name, department_id 를 조회한다.


-- 7. 부서명(department_name) 순으로 employee_id, last_name 를 조회한다.


-- 8. 가장 많은 사원이 근무하고 있는 부서의 department_id, 근무인원수를 조회한다.


-- 9. 각 직업(job_id)별 연봉총액과 각 부서(department_id)별 연봉총액을 함께 조회한다.
