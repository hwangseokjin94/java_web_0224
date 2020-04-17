-- << departments 테이블 >>

-- 41. 같은 지역(location_id) 끼리 모아서 조회한다.
-- 1) 지역의 중복을 제거한다.
SELECT DISTINCT LOCATION_ID
FROM DEPARTMENTS;
-- 2) 지역별로 그룹화 처리를 한다.
SELECT LOCATION_ID
FROM DEPARTMENTS
GROUP BY LOCATION_ID;


-- 42. 같은 지역(location_id) 끼리 모아서 각 지역(location_id) 마다 총 몇 개의 부서가 있는지 개수를 함께 조회한다.
SELECT LOCATION_ID, COUNT(*) AS 부서수
FROM DEPARTMENTS
GROUP BY LOCATION_ID;


-- 43. 같은 지역(location_id) 끼리 모아서 해당 지역(location_id) 에 어떤 부서(department_name) 가 있는지 조회한다.
SELECT LOCATION_ID, DEPARTMENT_NAME  -- DEPARTMENT_ID 를 조회(SELECT)하려면, 반드시 GROUP BY 절에 DEPARTMENT_ID 가 있어야 한다.
FROM DEPARTMENTS
GROUP BY LOCATION_ID;



-- << employees 테이블 >>

-- 44. 각 부서(department_id)별로 그룹화하여 부서번호(department_id) 와 부서별 사원의 수를 조회한다.
SELECT DEPARTMENT_ID, COUNT(*) AS 사원수
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID;


-- 45. 부서(department_id)별로 집계하여 부서번호(department_id)와 연봉(salary)의 평균을 조회한다.
-- 연봉(salary)의 평균은 소수 이하 반올림하여 정수로 처리하고, 부서번호(department_id) 의 오름차순으로 정렬한다.
SELECT DEPARTMENT_ID, ROUND( AVG(SALARY) )
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
ORDER BY DEPARTMENT_ID;


-- 46. 동일한 직업(job_id)을 가진 사원들의 직업(job_id) 과 직업별 인원수와 연봉 평균을 조회한다.
-- 연봉(salary)의 평균은 원 단위를 절사하여 표시하고, 연봉(salary) 평균이 낮은순으로 조회한다.
SELECT JOB_ID, COUNT(*) AS 사원수, TRUNC( AVG(SALARY) , -1 ) AS 연봉평균
FROM EMPLOYEES
GROUP BY JOB_ID
ORDER BY 연봉평균;


-- 47. 직업(job_id)이 SH_CLERK 인 직원들의 인원수와 최대 연봉(salary) 및 최소 연봉(salary)를 조회한다.

-- WHERE 절이나 HAVING 절에서 모두 사용할 수 있는 조건이라면, "WHERE 절" 에 작성하라.

-- 1) WHERE 절 조건식 작성
SELECT JOB_ID, COUNT(*), MAX(SALARY), MIN(SALARY)
FROM EMPLOYEES
WHERE JOB_ID = 'SH_CLERK'
GROUP BY JOB_ID;


-- 2) HAVING 절 조건식 작성
SELECT JOB_ID, COUNT(*), MAX(SALARY), MIN(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID
HAVING JOB_ID = 'SH_CLERK';


-- 48. 근무 중인 사원수가 5명 이상인 부서의 부서번호(department_id) 와 해당 부서의 사원수를 함께 조회한다.
-- 부서번호(department_id) 를 기준으로 오름차순 정렬하여 조회한다.
SELECT DEPARTMENT_ID, COUNT(*) AS 사원수
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING COUNT(*) >= 5  -- HAVING 사원수 >= 5  불가 (GROUP BY 절은 별명을 사용할 수 없다.)
ORDER BY DEPARTMENT_ID;


-- 49. 연봉 평균(salary) 이 10000 이상인 부서의 부서번호(department_id) 와 연봉 평균을 조회한다.
-- 연봉 평균(salary)은 소수 이하 절사처리한다.
SELECT DEPARTMENT_ID, TRUNC( AVG(SALARY) )
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING AVG(SALARY) >= 10000;


-- 50. 부서(department_id)마다 같은 직업(job_id)을 가진 사원들의 인원수를 부서번호(department_id)순으로 정렬하여 조회한다.
-- 부서번호(department_id) 가 없는 사원은 조회하지 않는다.
SELECT DEPARTMENT_ID, JOB_ID, COUNT(*)
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NOT NULL  -- GROUP BY 전에 처리가 가능한 조건이므로 WHERE 절에서 하는 것이 유리하다.
GROUP BY DEPARTMENT_ID, JOB_ID
ORDER BY DEPARTMENT_ID;
