-- DUAL 테이블이란?
-- DUMMY 칼럼만을 가지는 테이블
-- 테이블이 필요한 경우에 가져다 사용하는 내용이 없는 테이블
-- SELECT 문을 이용한 검색은 반드시 테이블이 필요하다.
-- 오라클 함수 확인하려면 SELECT 문을 사용하는데 불필요한 테이블 대신 DUAL 테이블을 사용한다.
DESC DUAL;
SELECT DUMMY FROM DUAL;


-- 1. NULL 처리 함수
-- NVL(값, 값이 NULL 일 때 대신 사용할 값)
SELECT NVL(NULL, 'APPLE') FROM DUAL;  -- APPLE
SELECT NVL('ABC', 'APPLE') FROM DUAL;  -- ABC
SELECT NVL('1000', 'APPLE') FROM DUAL;  -- 1000
-- NVL2(값, 값이 NULL 이 아닐 때 사용할 값, 값이 NULL 일 때 사용할 값)
SELECT NVL2(NULL, 'APPLE', 'BANANA') FROM DUAL;  -- BANANA
SELECT NVL2('ABC', 'APPLE', 'BANANA') FROM DUAL;  -- APPLE


-- 2. 대소문자 처리 함수
-- 1) UPPER : 대문자로 변환
-- 2) LOWER : 소문자로 변환
-- 3) INITCAP : 첫 글자만 대문자로, 나머지는 소문자로 변환
SELECT UPPER('apple') FROM DUAL;
SELECT LOWER('APPLE') FROM DUAL;
SELECT INITCAP('appLE') FROM DUAL;


-- 3. 길이
-- 1) LENGTH : 글자 수
-- 2) LENGTHB : 바이트 수
SELECT LENGTH('APPLE') FROM DUAL;  -- 5
SELECT LENGTH('사과') FROM DUAL;  -- 2
SELECT LENGTHB('APPLE') FROM DUAL;  -- 5
SELECT LENGTHB('사과') FROM DUAL;  -- 6  (UTF-8 인코딩은 한글이 3바이트, MS949 인코딩은 한글이 2바이트)


-- 4. 연결하기
-- 1) CONCAT(값1, 값2) : 값1 과 값2 를 연결
-- 2) 값1 || 값2 : 값1 과 값2 를 연결
SELECT CONCAT('APPLE', 'JUICE') FROM DUAL;
SELECT 'APPLE' || 'JUICE' FROM DUAL;

SELECT CONCAT('APPLE', 'JUI', 'CE') FROM DUAL;  -- CONCAT 의 인수는 2개만 가능하다.
SELECT CONCAT('APPLE', CONCAT('JUI', 'CE')) FROM DUAL;
SELECT 'APPLE' || 'JUI' || 'CE' FROM DUAL;


-- 5. 일부 추출하기
-- 1) SUBSTR(시작위치) : 시작위치부터 끝까지 추출
-- 2) SUBSTR(시작위치, 글자수) : 시작위치부터 지정한 글자수만큼 추출
SELECT SUBSTR('APPLE', 1, 3) FROM DUAL;  -- APP (첫 번째 글자부터 3글자)
SELECT SUBSTR('BANANA', 3) FROM DUAL;  -- NANA (3 번째 글자부터 끝까지)

SELECT SUBSTR('999999-8888888', -7) FROM DUAL;  -- 8888888 (뒤의 8글자)


-- 6. 특정 문자 위치 반환
-- 1) INSTR(검색대상, 찾을문자)
-- 2) INSTR(검색대상, 찾을문자, 시작위치, N번째)
SELECT INSTR('SQLSESSION', 'S') FROM DUAL;  -- 1 (S의 위치, 첫 번째 S)
SELECT INSTR('SQLSESSION', 'L') FROM DUAL;  -- 3 (L의 위치)
SELECT INSTR('SQLSESSION', 'S', 1, 1) FROM DUAL;  -- 1 (1번째 글자부터 1번째 S 찾기)
SELECT INSTR('SQLSESSION', 'S', 1, 2) FROM DUAL;  -- 4 (1번째 글자부터 2번째 S 찾기)
SELECT INSTR('SQLSESSION', 'S', 1, 3) FROM DUAL;  -- 6 (1번째 글자부터 3번째 S 찾기)
SELECT INSTR('SQLSESSION', 'S', 1, 4) FROM DUAL;  -- 7 (1번째 글자부터 4번째 S 찾기)


-- 7. 채우기
-- 1) LPAD(값, 필드폭, 채울문자) : 왼쪽에 문자를 채운다. 채운 결과는 필드폭과 같다.
-- 2) RPAD(값, 필드폭, 채울문자) : 오른쪽에 문자를 채운다. 채운 결과는 필드폭과 같다.
SELECT LPAD('APPLE', 10, '*') FROM DUAL;  -- *****APPLE (APPLE 을 10자리로 만들되, 부족한 곳은 * 를 채운다.)
SELECT RPAD('APPLE', 10, '*') FROM DUAL;  -- APPLE*****


-- 8. 정수로 올림
SELECT CEIL(123.111) FROM DUAL;  -- 124


-- 9. 정수로 내림
SELECT FLOOR(123.999) FROM DUAL;  -- 123


-- 10. 자릿수를 지정해서 내림
SELECT TRUNC(123.999) FROM DUAL;  -- 123
SELECT TRUNC(123.999, 2) FROM DUAL;  -- 123.99
SELECT TRUNC(123.999, 1) FROM DUAL;  -- 123.9
SELECT TRUNC(123.999, -1) FROM DUAL;  -- 120 (일의 자리 부터 다 버림)
SELECT TRUNC(123.999, -2) FROM DUAL;  -- 100 (십의 자리 부터 다 버림)


-- 11. 자릿수를 지정해서 반올림
SELECT ROUND(123.888) FROM DUAL;  -- 124
SELECT ROUND(123.888, 2) FROM DUAL;  -- 123.89
SELECT ROUND(123.888, 1) FROM DUAL;  -- 123.9
SELECT ROUND(123.888, -1) FROM DUAL;  -- 120
SELECT ROUND(123.888, -2) FROM DUAL;  -- 100


-- 12. 자릿수를 지정해서 올림
-- 올림 처리하는 함수가 없다.
-- ROUND 함수를 활용해서 올림 값을 만든다.
-- 값 + 0.5 -> ROUND(값 + 0.5) -> 올림 처리된 값이 나타난다.
-- 1.0 + 0.5 -> ROUND(1.5) -> 2
-- 1.1 + 0.5 -> ROUND(1.6) -> 2
-- 1.2 + 0.5 -> ROUND(1.7) -> 2
-- 1.3 + 0.5 -> ROUND(1.8) -> 2
-- 1.4 + 0.5 -> ROUND(1.9) -> 2
-- 1.5 + 0.5 -> ROUND(2.0) -> 2
-- 1.6 + 0.5 -> ROUND(2.1) -> 2
-- ...
-- 1.9 + 0.5 -> ROUND(2.4) -> 2


-- 13. 집계함수
-- 1) AVG(칼럼) : 칼럼의 평균  (주의. AVG(칼럼1, 칼럼2) 는 불가능하다.)
-- 2) MAX : 최대
-- 3) MIN : 최소
-- 4) SUM : 합계
-- 5) COUNT : 개수
SELECT AVG(SALARY) FROM EMPLOYEES;
SELECT MAX(SALARY) FROM EMPLOYEES;
SELECT MIN(SALARY) FROM EMPLOYEES;
SELECT SUM(SALARY) FROM EMPLOYEES;
SELECT COUNT(SALARY) FROM EMPLOYEES;

SELECT ROUND(AVG(SALARY)) FROM EMPLOYEES;
SELECT TRUNC(AVG(SALARY)) FROM EMPLOYEES;


-- 14. 날짜 관련 파라미터 정리
-- 1) 년도 : YYYY, YYY, YY, Y
-- 2) 월 : MM (01 - 12)
-- 3) 일
--    (1) D : 몇 번째 요일인지가 출력 (1:일 - 7:토)
--    (2) DD : 01 - 31
--    (3) DY : 일 - 토
-- 4) 시
--    (1) HH : 01 - 12 (HH12)
--    (2) HH24 : 00 - 23
-- 5) 분 : MI (00 - 59)
-- 6) 초 : SS (00 - 59)


-- 15. 현재 날짜와 시간
SELECT SYSDATE FROM DUAL;


-- 16. 날짜 만들기 (문자열->날짜)
-- 1) TO_DATE('문자열 형식의 날짜')
-- 2) TO_DATE('문자열 형식의 날짜', '변환할 파라미터')
-- 3) 기본 체크 (날짜 표기)
--    (1) '20/04/09'
--    (2) '2020/04/09'
--    (3) '20-04-09'
--    (4) '2020-04-09'
SELECT TO_DATE('2020-04-09') FROM DUAL;
SELECT TO_DATE('20-04-09', 'YY/MM/DD') FROM DUAL;  -- 체크!!

-- 날짜 차이 등의 연산(함수) 처리는 날짜 타입으로 가능하다.
SELECT SYSDATE - TO_DATE('20/04/01') FROM DUAL;  -- 8.4709953703  (소수점의 의미는 시간을 의미, 1일 == 숫자1)
SELECT TRUNC(SYSDATE - TO_DATE('20/04/01')) FROM DUAL;  -- 8 (며칠이 지났는지 일수를 계산)


-- 17. 개월수 관련 함수
-- 1) ADD_MONTHS(날짜, N) : N 개월 후 날짜
-- 2) MONTHS_BETWEEN(날짜1, 날짜2) : 날짜1 - 날짜2 방식으로 계산하여 개월수 차이를 구함
SELECT ADD_MONTHS(SYSDATE, 4) FROM DUAL;  -- 4개월 후 날짜
SELECT ADD_MONTHS(SYSDATE, -4) FROM DUAL;  -- 4개월 전 날짜
SELECT MONTHS_BETWEEN(SYSDATE, TO_DATE('20/01/01')) FROM DUAL;  -- 3.27  (3.27개월 지났다.) 


-- 18. 문자열 만들기
-- 1) 숫자 -> 문자열
-- 2) 날짜 -> 문자열
SELECT TO_CHAR(1234, '999999') FROM DUAL;  -- 1234 (앞 2자리는 공백 처리된 1234, 9 하나당 숫자 1자리)
SELECT TO_CHAR(123, '999999') FROM DUAL;  -- 123 (앞 3자리는 공백 처리된 123)
SELECT TO_CHAR(1234, '999') FROM DUAL;  -- #### (값보다 9가 부족하면 안 된다.)

SELECT TO_CHAR(1234, '000000') FROM DUAL;  -- 001234 (앞 2자리는 0으로 채운 1234, 0 하나당 숫자 1자리)
SELECT TO_CHAR(123, '000000') FROM DUAL;  -- 000123 (6자리 숫자로 출력하되, 부족한 자리는 0을 채운다.)

SELECT TO_CHAR(12.31, '99.9') FROM DUAL;  -- 12.3 (반올림 처리로 소수 이하 1자리만 남겨라.)
SELECT TO_CHAR(12.39, '99.9') FROM DUAL;  -- 12.4 (반올림 처리로 소수 이하 1자리만 남겨라.)

SELECT TO_CHAR(123456, '999,999') FROM DUAL;  -- 123,456 (천 단위 구분 기호)
SELECT TO_CHAR(123456, '$999,999') FROM DUAL;  -- $123,456

SELECT TO_CHAR(SYSDATE, 'YY/MM/DD DY') FROM DUAL;  -- 20/04/09 목


-- 19. 숫자 만들기
SELECT TO_NUMBER('1234.56', '9999.99') FROM DUAL;


-- 문제1. 이메일에서 도메인 분리하기
-- USERID@GMAIL.COM : GMAIL.COM
-- INSTR, SUBSTR 함수 이용
-- INSTR : '@' 문자의 위치를 구한다.  INSTR('USERID@GMAIL.COM', '@')
-- SUBSTR : '@' 의 다음 위치부터 끝까지 추출한다.  SUBSTR('USERID@GMAIL.COM', INSTR('USERID@GMAIL.COM', '@') + 1)
SELECT SUBSTR('USERID@GMAIL.COM', INSTR('USERID@GMAIL.COM', '@') + 1) FROM DUAL;


-- 문제2. 아이디 보안 처리하기
-- USERID : U*****
-- ADMIN : A****
-- SUBSTR, LENGTH, RPAD 함수 이용
-- SUBSTR : 아이디의 첫 번째 글자만 추출  SUBSTR('USERID', 1, 1)
-- LENGTH : 아이디의 길이  LENGTH('USERID')
-- RPAD : 아이디의 첫 번째 글자 오른쪽에 '*' 채워주기  RPAD(SUBSTR('USERID', 1, 1), LENGTH('USERID'), '*')
SELECT RPAD(SUBSTR('USERID', 1, 1), LENGTH('USERID'), '*') FROM DUAL;  -- U*****
SELECT RPAD(SUBSTR('USERID', 1, 2), LENGTH('USERID'), '*') FROM DUAL;  -- US****


-- 문제3. 일련번호 8자리로 맞추기
-- 1 ... 5000 까지 일련번호 -> 00000001 - 00005000 텍스트 형식으로 변경
-- LPAD 함수 이용
SELECT LPAD(1, 8, 0) FROM DUAL;
SELECT LPAD(NVL(1, 0), 8, 0) FROM DUAL;
SELECT LPAD(NVL(NULL, 0), 8, 0) FROM DUAL;

SELECT LPAD(NVL(MANAGER_ID, 0), 4, 0) FROM EMPLOYEES;
-- UPDATE EMPLOYEES SET MANAGER_ID = LPAD(NVL(MANAGER_ID, 0), 4, 0);


