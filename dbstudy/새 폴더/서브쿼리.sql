-- 1. 회사의 전체 평균 연봉보다 더 많은 연봉을 받는 사원들의 employee_id, last_name, salary 를 조회한다.
-- 사용할 테이블 (employees)



-- 2. Patrick Sully 와 같은 부서에 있는 모든 사원의 first_name, last_name, hire_date 를 조회한다.
-- 사용할 테이블 (employees)
SELECT FIRST_NAME,LAST_NAME,HIRE_DATE
FROM EMPLOYEES
WHERE DEPARTMENT_ID =(SELECT DEPARTMENT_ID
                    FROM EMPLOYEES
                    WHERE FIRST_NAME = 'Patrick'
                    AND LAST_NAME = 'Sully');


-- 3. 직업(job_id)이 'SA_MAN' 인 사원이 받을 수 있는 최대연봉(max_salary)보다 큰 연봉을 받는 사원들의 employee_id, last_name, salary 를 조회한다.
-- 사용할 테이블 (employees, jobs)
SELECT  employee_id, last_name, salary 
FROM employees
WHERE salary >(SELECT MAX_SALARY FROM JOBS WHERE JOB_ID ='SA_MAN');


-- 4. 부서(department_id)가 20 인 사원들 중에서 전체 사원의 평균 급여보다 높은 급여를 받는 사원들의 employee_id, first_name, last_name, salary, job_id 정보를 조회한다.
-- 사용할 테이블 (employees)

SELECT   employee_id, first_name, last_name, salary, job_id 
FROM employees
WHERE DEPARTMENT_ID =20
AND salary >(SELECT AVG(SALARY) FROM EMPLOYEES);


-- 5. 사원번호(employee_id)가 131 인 사원의 job_id 와 salary 가 모두 일치하는 사원들의 last_name, job_id, salary 를 조회한다.
-- 사용할 테이블 (employees)
SELECT   last_name, salary, job_id 
FROM employees
AND(JOB_ID,salary) =(SELECT JOB_ID,salary FROM EMPLOYEES WHERE EMPLOYEE_ID = 131 );


-- 6. 기존의 직업(job_id)을 여전히 가지고 있는 사원들의 employee_id, job_id 를 조회한다.
-- 사용할 테이블 (employees, job_history)
SELECT employee_id, job_id
FROM employees
WHERE(employee_id, job_id) IN (SELECT employee_id, job_id FROM job_history );



-- 7. location_id 가 1000 번대(1000~1900)인 국가(country_id)의 country_id, country_name 을 조회한다.
-- 사용할 테이블 (contries, locations)

SELECT country_id, country_name 
FROM COUNTRIES 
WHERE COUNTRY_ID IN (SELECT COUNTRY_ID FROM locations WHERE LOCATION_ID BETWEEN 1000 AND 1900);

-- 8. 'Executive' 부서에 근무하는 모든 사원들의 department_id, last_name, job_id 를 조회한다.
-- 사용할 테이블 (employees, departments)



-- 9. department_id 가 30 인 부서에 근무하는 사원들 중에서 department_id 가 50 인 사원들이 받는 연봉보다 큰 연봉을 받는 사원들의 employee_id, last_name, salary 를 조회한다.
-- 사용할 테이블 (employees)



-- 10. department_id 가 50 인 부서에 근무하는 사원들의 연봉(salary) 보다 더 적은 연봉을 받는 다른 부서 사원들의 department_id, employee_id, last_name, salary 를 조회한다.
-- 사용할 테이블 (employees)



-- 11. last_name 에 u가 포함되는 사원들과 동일한 부서에 근무하는 사원들의 employee_id, last_name 을 조회한다.
-- 사용할 테이블 (employees)



-- 12. 매니저(manager_id)가 아닌 사원의 이름(first_name, last_name)을 조회한다.
-- 사용할 테이블 (employees)



-- 13. 도시 이름(city)이 'S'로 시작하는 지역에 사는 사원들의 employee_id, last_name, department_id, city 를 employee_id 순으로 정렬하여 조회한다.
-- 사용할 테이블 (employees, departments, locations)



-- 14. 자신의 소속부서(department_id)의 평균 연봉보다 낮은 연봉을 받는 사원들의 last_name, department_id, salary, 평균 연봉을 조회한다.
-- 부서(department_id)순으로 정렬하고 같은 부서내에서는 높은 연봉(salary)을 가진 사원을 먼저 조회한다.
-- 사용할 테이블 (employees)


