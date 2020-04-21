-- 1. 회사의 전체 평균 연봉보다 더 많은 연봉을 받는 사원들의 employee_id, last_name, salary 를 조회한다.
-- 사용할 테이블 (employees)
SELECT employee_id, last_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);


-- 2. Patrick Sully 와 같은 부서에 있는 모든 사원의 first_name, last_name, hire_date 를 조회한다.
-- 사용할 테이블 (employees)
SELECT first_name, last_name, hire_date
FROM employees
WHERE department_id = (SELECT department_id
                       FROM employees
                       WHERE first_name = 'Patrick'
                       AND last_name = 'Sully');


-- 3. 직업(job_id)이 'SA_MAN' 인 사원이 받을 수 있는 최대연봉(max_salary)보다 큰 연봉을 받는 사원들의 employee_id, last_name, salary 를 조회한다.
-- 사용할 테이블 (employees, jobs)
SELECT employee_id, last_name, salary
FROM employees
WHERE salary > (SELECT max_salary FROM jobs WHERE job_id = 'SA_MAN');


-- 4. 부서(department_id)가 20 인 사원들 중에서 전체 사원의 평균 급여보다 높은 급여를 받는 사원들의 employee_id, first_name, last_name, salary, job_id 정보를 조회한다.
-- 사용할 테이블 (employees)
SELECT employee_id, first_name, last_name, salary, job_id
FROM employees
WHERE department_id = 20
AND salary > (SELECT AVG(salary) FROM employees);


-- 5. 사원번호(employee_id)가 131 인 사원의 job_id 와 salary 가 모두 일치하는 사원들의 last_name, job_id, salary 를 조회한다.
-- 사용할 테이블 (employees)
SELECT last_name, job_id, salary
FROM employees
WHERE (job_id, salary) = (SELECT job_id, salary FROM employees WHERE employee_id = 131);



-- 6. 기존의 직업(job_id)을 여전히 가지고 있는 사원들의 employee_id, job_id 를 조회한다.
-- 사용할 테이블 (employees, job_history)
SELECT employee_id, job_id
FROM employees
WHERE (employee_id, job_id) IN (SELECT employee_id, job_id FROM job_history);


-- 7. location_id 가 1000 번대(1000~1900)인 국가(country_id)의 country_id, country_name 을 조회한다.
-- 사용할 테이블 (countries, locations)
SELECT country_id, country_name 
FROM countries
WHERE country_id IN (SELECT country_id FROM locations WHERE location_id BETWEEN 1000 AND 1900);


-- 8. 'Executive' 부서에 근무하는 모든 사원들의 department_id, last_name, job_id 를 조회한다.
-- 사용할 테이블 (employees, departments)

-- departments 테이블의 department_name 은 UNIQUE 하지 않기 때문에
-- 서브쿼리의 결과는 '다중 행'일 가능성이 있어, 등호(=) 대신 IN 을 사용한다.
SELECT department_id, last_name, job_id
FROM employees
WHERE department_id IN (SELECT department_id FROM departments WHERE department_name = 'Executive');

SELECT department_id, last_name, job_id
FROM employees
WHERE (department_id, 'Executive') IN (SELECT department_id, department_name FROM departments);


-- 9. department_id 가 30 인 부서에 근무하는 사원들 중에서 department_id 가 50 인 사원들이 받는 연봉보다 큰 연봉을 받는 사원들의 employee_id, last_name, salary 를 조회한다.
-- 사용할 테이블 (employees)

-- 'department_id 가 50 인 사원들이 받는 연봉' 의 결과는 여러 개이다. (다중 행 서브쿼리)
-- 다중 행 서브쿼리와 크기 비교(>, <)는 ANY, ALL 을 사용한다.

-- 1) ANY : 서브쿼리의 결과 중에서 하나라도 만족하면 된다.
SELECT employee_id, last_name, salary
FROM employees
WHERE salary > ANY(SELECT salary FROM employees WHERE department_id = 50)
AND department_id = 30;

SELECT employee_id, last_name, salary
FROM employees
WHERE salary > (SELECT MIN(salary) FROM employees WHERE department_id = 50)
AND department_id = 30;


-- 2) ALL : 서브쿼리의 결과를 모두 만족하면 된다.
SELECT employee_id, last_name, salary
FROM employees
WHERE salary > ALL(SELECT salary FROM employees WHERE department_id = 50)
AND department_id = 30;

SELECT employee_id, last_name, salary
FROM employees
WHERE salary > (SELECT MAX(salary) FROM employees WHERE department_id = 50)
AND department_id = 30;


-- 10. department_id 가 30 인 부서에 근무하는 사원들의 연봉(salary) 보다 더 적은 연봉을 받는 다른 부서 사원들의 department_id, employee_id, last_name, salary 를 조회한다.
-- 사용할 테이블 (employees)

SELECT department_id, employee_id, last_name, salary
FROM employees
WHERE salary < ALL(SELECT salary FROM employees WHERE department_id = 30);

SELECT department_id, employee_id, last_name, salary
FROM employees
WHERE salary < (SELECT MIN(salary) FROM employees WHERE department_id = 30);


-- 11. last_name 에 u 가 포함되는 사원들과 동일한 부서에 근무하는 사원들의 employee_id, last_name 을 조회한다.
-- 사용할 테이블 (employees)

SELECT employee_id, last_name
FROM employees
WHERE department_id IN (SELECT DISTINCT department_id FROM employees WHERE last_name LIKE '%u%');


-- 12. 매니저(manager_id)가 아닌 사원의 이름(first_name, last_name)을 조회한다.
-- 사용할 테이블 (employees)

-- 1) IN 
SELECT first_name, last_name
FROM employees
WHERE employee_id NOT IN (SELECT manager_id FROM employees WHERE manager_id IS NOT NULL);

-- 2) EXISTS
SELECT first_name, last_name
FROM employees e
WHERE NOT EXISTS (SELECT m.manager_id FROM employees m WHERE e.employee_id = m.manager_id);


-- 13. 도시 이름(city)이 'S'로 시작하는 지역에 사는 사원들의 employee_id, last_name, department_id, city 를 employee_id 순으로 정렬하여 조회한다.
-- 사용할 테이블 (employees, departments, locations)

-- 1) 조인 (INNER JOIN)
SELECT e.employee_id, e.last_name, e.department_id, l.city
FROM
     employees e,
     departments d,
     locations l
WHERE e.department_id = d.department_id  -- 조인조건1
AND d.location_id = l.location_id  -- 조인조건2
AND l.city LIKE 'S%'
ORDER BY e.employee_id;


-- 2) 인라인 서브쿼리 (FROM 절에서 사용하는 서브쿼리)
SELECT e.employee_id, e.last_name, e.department_id, l.city
FROM
     employees e,
     departments d,
     (SELECT location_id, city FROM locations WHERE city LIKE 'S%') l
WHERE e.department_id = d.department_id  -- 조인조건1
AND d.location_id = l.location_id  -- 조인조건2
ORDER BY e.employee_id;


-- 14. 자신의 소속부서(department_id)의 평균 연봉보다 낮은 연봉을 받는 사원들의 last_name, department_id, salary, 평균 연봉을 조회한다.
-- 부서(department_id)순으로 정렬하고 같은 부서내에서는 높은 연봉(salary)을 가진 사원을 먼저 조회한다.
-- 사용할 테이블 (employees)

-- 1) 조인할 테이블(부서별 평균연봉을 가진 테이블) -> 인라인 서브쿼리가 된다.
SELECT department_id, AVG(salary) AS 평균연봉 
FROM employees 
GROUP BY department_id 
ORDER BY department_id;

SELECT e.last_name, e.department_id, e.salary, TO_CHAR(g.평균연봉, '99,999')
FROM
     employees e,
     (SELECT department_id, AVG(salary) AS 평균연봉 
      FROM employees 
      GROUP BY department_id) g
WHERE e.department_id = g.department_id  -- 조인조건
AND e.salary < g.평균연봉
ORDER BY e.department_id ASC, e.salary DESC;
