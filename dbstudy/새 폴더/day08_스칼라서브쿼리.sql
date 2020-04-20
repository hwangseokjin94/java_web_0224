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
SELECT DISTINCT d.department_name
FROM departments d, employees e
WHERE d.department_id = e.department_id;

-- 2) 스칼라 서브쿼리
-- 내부 조인은 스칼라 서브쿼리로 해결할 수 있으나 피곤하다.
SELECT DISTINCT (SELECT d.department_name FROM departments d WHERE d.department_id = e.department_id)
FROM employees e
WHERE (SELECT d.department_name FROM departments d WHERE d.department_id = e.department_id) IS NOT NULL;


-- 5. 전체 27개 부서이름(department_name) 중에서 사원들이 근무 중인 부서이름을 첫 3글자만 나타나도록 줄여서 조회한다.
-- 근무 중인 부서가 없는 경우 'NN'을 대신 조회한다.
SELECT DISTINCT SUBSTR(NVL((SELECT d.department_name FROM departments d WHERE d.department_id = e.department_id), 'NN'), 1, 3)
FROM employees e;


-- 6. 근무지의 도시명(city)이 'Southlake' 인 곳에서 근무하는 사원들의 employee_id, last_name, department_id 를 조회한다.
-- 1) 내부 조인
SELECT e.employee_id, e.last_name, e.department_id
FROM employees e, departments d, locations l
WHERE e.department_id = d.department_id
AND d.location_id = l.location_id
AND l.city = 'Southlake';

-- 2) 스칼라 서브쿼리
SELECT e.employee_id, e.last_name, e.department_id
FROM employees e
WHERE 
   (SELECT d.location_id FROM departments d WHERE d.department_id = e.department_id)  -- 근무 중인 사원의 location_id
   =
   (SELECT l.location_id FROM locations l WHERE l.city = 'Southlake');  -- 'Southlake' 의 location_id


-- 7. 부서명(department_name) 순으로 employee_id, last_name 를 조회한다.
SELECT e.employee_id, e.last_name
FROM employees e
ORDER BY (SELECT d.department_name FROM departments d WHERE e.department_id = d.department_id);


-- 8. 가장 많은 사원이 근무하고 있는 부서의 department_id, 근무인원수를 조회한다.
SELECT department_id, COUNT(*) AS 근무인원
FROM employees
-- WHERE COUNT(*) = 45
GROUP BY department_id
HAVING COUNT(*) = (SELECT MAX(COUNT(*)) FROM employees GROUP BY department_id);


-- 9. 각 직업(job_id)별 연봉총액과 각 부서(department_id)별 연봉총액을 함께 조회한다.
SELECT job_id,
      NVL((SELECT SUM(salary) FROM employees d WHERE d.job_id = j.job_id AND department_id = 10), 0) AS 부서10,
      NVL((SELECT SUM(salary) FROM employees d WHERE d.job_id = j.job_id AND department_id = 20), 0) AS 부서20,
      NVL((SELECT SUM(salary) FROM employees d WHERE d.job_id = j.job_id AND department_id = 30), 0) AS 부서30,
      NVL((SELECT SUM(salary) FROM employees d WHERE d.job_id = j.job_id AND department_id = 40), 0) AS 부서40,
      NVL((SELECT SUM(salary) FROM employees d WHERE d.job_id = j.job_id AND department_id = 50), 0) AS 부서50,
      NVL((SELECT SUM(salary) FROM employees d WHERE d.job_id = j.job_id AND department_id = 60), 0) AS 부서60,
      NVL((SELECT SUM(salary) FROM employees d WHERE d.job_id = j.job_id AND department_id = 70), 0) AS 부서70,
      NVL((SELECT SUM(salary) FROM employees d WHERE d.job_id = j.job_id AND department_id = 80), 0) AS 부서80,
      NVL((SELECT SUM(salary) FROM employees d WHERE d.job_id = j.job_id AND department_id = 90), 0) AS 부서90,
      NVL((SELECT SUM(salary) FROM employees d WHERE d.job_id = j.job_id AND department_id = 100), 0) AS 부서100,
      NVL((SELECT SUM(salary) FROM employees d WHERE d.job_id = j.job_id AND department_id = 110), 0) AS 부서110
FROM employees j
GROUP BY job_id;

SELECT job_id,
      NVL(SUM(DECODE(department_id, 10, salary)), 0) AS 부서10,
      NVL(SUM(DECODE(department_id, 20, salary)), 0) AS 부서20,
      NVL(SUM(DECODE(department_id, 30, salary)), 0) AS 부서30,
      NVL(SUM(DECODE(department_id, 40, salary)), 0) AS 부서40,
      NVL(SUM(DECODE(department_id, 50, salary)), 0) AS 부서50,
      NVL(SUM(DECODE(department_id, 60, salary)), 0) AS 부서60,
      NVL(SUM(DECODE(department_id, 70, salary)), 0) AS 부서70,
      NVL(SUM(DECODE(department_id, 80, salary)), 0) AS 부서80,
      NVL(SUM(DECODE(department_id, 90, salary)), 0) AS 부서90,
      NVL(SUM(DECODE(department_id, 100, salary)), 0) AS 부서100,
      NVL(SUM(DECODE(department_id, 110, salary)), 0) AS 부서110
FROM employees j
GROUP BY job_id;


-- DECODE(표현식, 값1, 반환값1, 값2, 반환값2, 반환값3)
SELECT 
      employee_id, 
      last_name, 
      salary, 
      DECODE(TRUNC(salary / 10000), 2, '초고액연봉', 1, '고액연봉', '보통연봉') AS 연봉수준
FROM employees;
