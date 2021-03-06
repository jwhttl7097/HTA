-- dapartments 테이블의 모든 행, 모든 컬럼 조회하기
select *
from departments;

-- employess 테이블의 모든행, 모든 컬럼 조회하기
select *
from employees;

-- jobs 테이블의 모든행, 모든 컬럼 조회하기
select *
from jobs;
-- locations 테이블의 모든행, 모든 컬럼 조회하기
select *
from locations;

-- 테이블에서 지정된 컬럼만 조회하기
-- employees 테이블에서 사원아이디, 이름, 급여를 조회하기
select employee_id, first_name, salary  -- select 절
from employees;                         -- from 절

-- employees 테이블에서 사원아이디, 이름, 직종아이디 조회하기
select employee_id, first_name, last_name, department_id
from employees;

-- departmenets 테이블에서 부서아이디, 부서명 조회하기
select department_id, department_name
from departments;

-- jobs 테이블에서 직종아이디, 최소급여, 최대급여 조회하기
select job_id, min_salary, max_salary
from jobs;

-- locations 테이블에서 위치아이디, 주소, 도시명 조회하기
select location_id, street_address, city
from locations;

-- employees 테이블에서 소속부서아이디, 상사의 사원아이디, 사원의 이름 조회하기
select department_id, manager_id, first_name
from employees;

-- 조회결과에 중복된 값이 있을 때 중복된 행을 제거하고 조회하기
-- employees에 등록된 사원들이 종사하는 직종의 아이디를 조회하기
select DISTINCT job_id
from employees;

-- employees에 등록된 사원들의 소속부서 아이디를 조회하기
select distinct department_id
from employees;

-- jobs_history 테이블을 조회해서 직종이 변경된 적이 있는 사원의 아이디를 조회하기
select distinct employee_id
from job_history;

-- 연결 연산자를 이용해서 두 개 이상의 컬럼값을 붙여서 조회하기
select employee_id, first_name, last_name, first_name || ' ' || last_name
from employees;

-- 조회 결과에 별칭을 붙여서 조회하기
select employee_id, first_name || ' ' || last_name as full_name
from employees;

select employee_id, first_name || ' ' || last_name full_name
from employees;

-- 별칭 적을 때는 띄어쓰기 없이해야하는데 굳이 적으려면 ""사용
-- 특수문자나 그럴 때도 사용하지만 ""는 안쓰는게 좋음
select employee_id, first_name || ' ' || last_name "full name"
from employees;

-- 별칭을 만들 때는 as를 작성해도 되고 안해도 됨
select employee_id as id, first_name || ' ' || last_name as name
from employees;
select employee_id id, first_name || ' ' || last_name name
from employees;

-- 사칙 연산자 사용하기
-- employees 테이블에서 사원아이디, 이름, 주급, 월급 조회하기
select employee_id, first_name, salary, salary*4 salary_of_month
from employees;

-- jobs 테이블에서 직종아이디, 최소급여, 최대급여, 최소급여와 최대급여의 차이를 조회하기
select job_id, min_salary, max_salary, max_salary - min_salary as salary_gap
from jobs;

-- where 절을 이용해서 조회되는 행을 제한하기
-- 사원아이디가 100인 사원의 아이디, 이름, 급여를 조회하기
select employee_id, first_name, salary
from employees
where employee_id = 100;

-- 이름이 Steven인 사원의 사원아이디, 이름, 직종아이디, 급여를 조회하기
select employee_id, first_name, job_id, salary
from employees
where first_name = 'Steven'; -- 텍스트값은 대소문자를 구분한다.

-- 급여가 2500이하인 사원의 사원아이디, 이름, 직종아이디, 급여를 조회하기
select employee_id, first_name, job_id, salary
from employees
where salary <= 2500;

-- 급여를 15000이상인 사원의 사원아이디, 이름, 직종아이디, 급여를 조회하기
select employee_id, first_name, job_id, salary
from employees
where salary >= 15000;

-- 조회결과는 이름에 대한 오름차순으로 정렬하기
select first_name, salary
from employees
where salary >= 10000
order by first_name asc;

-- 급여가 10000이상인 사원의 이름, 급여를 조회하기
-- 조회결과는 급여에 대한 내림차순으로 정렬하기
select first_name, salary
from employees
where salary >= 10000
order by salary desc;

-- 급여가 10000이상인 사원의 이름, 급여를 조회하기
-- 조회결과는 급여에 대한 내림차순으로 정렬하기
-- 급여가 동일한 경우 이름순으로 오름차순 정렬하기
select first_name, salary
from employees
where salary >= 10000
order by salary desc, first_name asc;