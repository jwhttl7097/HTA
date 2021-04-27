-- �޿��� 10000�̻� 15000������ ������� ���̵�, �̸�, �޿��� ��ȸ�ϱ�
select employee_id, FIRST_NAME, salary 
from employees 
where salary >= 10000 and 15000 <= 15000
order by salary desc;
-- �ҼӺμ� ���̵� 50���̰�, �޿��� 3000�̻� �޴� ����� ���̵�, �̸� �޿��� ��ȸ�ϱ�
select employee_id, FIRST_NAME, salary, department_id
from employees
where department_id = 50 and salary >= 3000;
-- ���� ���̵� SH_CLERK�̰�, �޿��� 4000�̻� �޴� ����� ���̵�, �̸�, �޿��� ��ȸ�ϱ�
SELECT employee_id, FIRST_NAME, salary
FROM employees
where job_id = 'SH_CLERK' and salary >= 4000;

-- �ڽ��� ��簡 101���̰ų� 102���� ����� ���̵�, �̸�, �������̵�, ����� ���̵� ��ȸ�ϱ�
select employee_id, FIRST_NAME, job_id, manager_id
from employees
where manager_id in (101, 102);

-- �ҼӺμ� ���̵� 30���̰ų� 60���̸鼭 �޿��� 5000�̻� �޴� ����� ���̵�, �̸�, �޿�, �ҼӺμ����̵� ��ȸ�ϱ�
select employee_id, FIRST_NAME, salary, department_id
from employees
where department_id in (30, 60) and salary >= 5000; 

-- is null, is not null�� �̿��ؼ� �÷��� ���� null�� �Ͱ� null�� �ƴѰ��� �����ؼ� ��ȸ�ϱ�
-- departments ���̺��� ��ϵ� �μ��߿��� �μ������ڰ� �������� ���� �μ��� ���̵�,
-- �μ���, ������ ���̵� ��ȸ�ϱ�
select department_id, department_name, manager_id
from departments
where manager_id is null;

-- employees���̺� ��ϵ� ����� �߿��� Ŀ�̼��� �޴� ����� ���̵�, �̸�, �޿�, Ŀ�̼� ��ȸ�ϱ�
select employee_id, first_name, salary, commission_pct
from employees
where commission_pct is not null;

-- employees���̺� ��ϵ� ����� �߿��� Ŀ�̼��� �ް�, �޿��� 10000�̻� �޴� ����� ���̵�,
-- �̸�, �޿�, Ŀ�̼��� ��ȸ�ϱ�
select employee_id, first_name, salary, commission_pct
from employees
where commission_pct is not null
and salary >= 10000;

--employees���̺� ��ϵ� ����� �߿��� Ŀ�̼��� �ް�, �޿��� 10000�̻� �޴� ����� ���̵�,
-- �̸�, �޿�, Ŀ�̼��� ��ȸ�ϱ� (Ŀ�̼ǿ� ���� ������������ ����)
select employee_id, first_name, salary, commission_pct
from employees
where commission_pct is not null
and salary >= 10000
order by commission_pct asc;

-- employee���̺��� �����ȣ�� 110�� �̻� 120�� ������ ����� ������̵�, �̸��� ��ȸ�ϱ�
select employee_id, first_name
from employees
where employee_id >= 110 and employee_id <= 120;

select employee_id, first_name
from employees
where employee_id between 110 and 120;

--employees ���̺��� ���� ���̵� CLERK�� �����ϰ� �ִ� ����� ���̵�, �̸�, �������̵� ��ȸ�ϱ�
select employee_id, first_name, job_id
from employees
where job_id like '%CLERK';

select first_name
from employees
where first_name like '%S%';

-- employees ���̺� ��ϵ� ����� �߿��� �ҼӺμ����̵� 30, 50, 60, 80�� �ƴ� �����
-- ���̵�, �̸�, �μ����̵� ��ȸ�ϱ�
select employee_id, first_name, department_id
from employees
where department_id not in (30, 50, 60, 80)
order by department_id asc;

-- ��� �μ������� ��ȸ�ϱ�
select *
from departments;

-- ��� �μ������������� ��ȸ�ϱ�
select *
from locations;

-- ��� ���������� ��ȸ�ϱ�
select *
from jobs;

-- �������� ���̺��� �������̵�, �ּұ޿�, �ִ�޿��� ��ȸ�ϱ�
select job_id, min_salary, max_salary
from jobs;

-- �μ����� ���̺��� �μ����̵�, �μ����� ��ȸ�ϱ�
select department_id, department_name
from departments;

-- ������� ���̺��� ������̵�, �̸�, �Ի���, �������̵�, �޿��� ��ȸ�ϱ�
select employee_id, first_name, hire_date, job_id, salary
from employees;

-- ������� ���̺��� ������̵� 100���� ����� �̸�, ��ȭ��ȣ, �̸���, �Ի���, �޿��� ��ȸ�ϱ�
select first_name, phone_number, email, hire_date, salary
from employees
where employee_id = 100;

-- ������� ���̺��� 100�� ����� ���� �ΰ� �ִ� ������� �̸�, �Ի���, �������̵� ��ȸ�ϱ�
select first_name, hire_date, job_id
from employees
where manager_id in 100;

-- �������̺��� ���� �ּұ޿��� 10000 �̻��� ������ ���̵�, ����, �ּұ޿�, �ִ�޿��� ��ȸ�ϱ�
select job_id, job_title, min_salary, max_salary
from jobs
where min_salary >= 10000;

-- ������̺��� Ŀ�̼��� �޴� ��� �߿��� �޿��� 5000���� �޴� ����� ���̵�, �̸�, ����, �޿��� ��ȸ�ϱ�
select employee_id, first_name, job_id, salary
from employees
where commission_pct is not null and salary <= 5000;

-- ������̺��� ������ 'MAN'�̳� 'MGR'�� ������ ����߿��� �޿��� 10000���� �޴� ����� ���̵�, 
-- �̸�, �������̵�, �޿��� ��ȸ�ϱ�
select employee_id, first_name, job_id, salary
from employees
where (job_id like '%MAN' or job_id like '%MGR') and salary <= 10000;

-- ����������̺��� Ŀ�̼��� �޴� ����߿��� 147�� ����� ��縦 �ΰ� �����鼭, �޿��� 10000�̻� �޴�
-- ����� ���̵�, ����̸�, �޿�, Ŀ�̼��� ��ȸ�ϱ�
select employee_id, first_name, salary, commission_pct
from employees
where commission_pct is not null and manager_id in 147 and salary >= 10000;

-- ����������̺��� 101���� 102���� ���� ������ ������� ���̵�, �̸�, �����̵� ��ȸ�ϱ�
select employee_id, first_name, manager_id
from employees
where manager_id in (101, 102);

-- ����������̺��� �ҼӺμ��� �������� ���� ����� ���̵�, �̸�, �������̵� ��ȸ�ϱ�
select employee_id, first_name, job_id
from employees
where department_id is null;

-- ����������̺��� 60�� �μ��� �Ҽӵ� ������� ���̵�, �̸�, ����, ������ ��ȸ�ϱ�
-- (salary�� �����̴�. �� ���� 4�ַ� �����Ѵ�. ���ް�, ������ ��Ī�� �ο��Ѵ�.)
select employee_id, first_name, salary as ����, salary/4 as �ֱ�, salary*12 as ����
from employees
where department_id in 60;

--�����Լ� �����ϱ�
-- lower(�÷��� Ȥ�� ǥ����) - �ҹ��ڷ� ��ȯ
-- upper(�÷��� Ȥ�� ǥ����) - �빮�ڷ� ��ȯ
-- substr(�÷��� Ȥ�� ǥ����, ������ġ, ����) -������ġ���� ������ŭ �߶� ��ȯ
-- length(�÷��� Ȥ�� ǥ����) - ���ڿ��� ���� ��ȯ
-- instr(�÷��� Ȥ�� ǥ����, '����') - ������ ������ ��ġ�� ��ȯ(�ε��� 1���� ����)
-- instr(�÷��� Ȥ�� ǥ����, '����', ������ġ, n��°) - ������ ������ġ���� ���ڸ� �˻����� �� n��°�� �����ϴ� ��ġ�� ��ȯ
-- lpad(�÷��� Ȥ�� ǥ����, ����, '����') - ������ ���̺��� ª���� ������ ���̸�ŭ ������ ���ڸ� ���ʿ� ä���.
-- rpad(�÷��� Ȥ�� ǥ����, ����, '����') - ������ ���̺��� ª���� ������ ���̸�ŭ ������ ���ڸ� �����ʿ� ä���.
-- trim(�÷��� Ȥ�� ǥ����) - ���ʿ��� �¿� ������ �����Ѵ�.
-- replace(�÷�Ȥ�� ǥ����, 'ã�¹���', '��ü�� ����') - ���ڸ� ã�Ƽ� ������ ���ڷ� ��ü�Ѵ�.
select lower('Hello World'),
       upper('Hello World'),
       substr('Hello World', 3),
       substr('Hello World', 1, 1),
       substr('Hello World', 3, 4),
       length('Hello World'), -- 11����
       lengthb('Hello World'), -- 11byte ����Ʈ�� ��ȯ
       length('�ȳ��ϼ���'), -- 5����
       lengthb('�ȳ��ϼ���'), -- 15byte
       instr('010-1111-1111', '-'), -- 4��ȯ
       instr('02)1234-5678', ')'), -- 3��ȯ
       instr('700)1234-5678', ')'), -- 4��ȯ
       lpad('hi', 10, '#'),    -- ########hi
       lpad('hello', 10, '#'), -- #####hello
       rpad('hi', 10, '#'),    -- hi########
       rpad('hello', 10, '#'), -- hello#####
       replace('hello', 'l', '*') -- he**o
    
from dual;

--employees ���̺��� �̸��� 'tay'�� ���ԵǴ� ����� ��ȸ�ϱ�
select first_name
from employees
where lower(first_name) like '%tay%';

--employees ���̺��� 'MAN'�̳� 'MGR'�� ������ ������ ���� ����� �̸� �������̵� ��ȸ�ϱ�
select first_name, job_id
from employees
where job_id like '%MAN' or job_id like '%MGR';

select first_name, job_id
from employees
where substr(job_id, 4) in ('MAN', 'MGR'); -- substr('SA_MAN', 4) -> 'MAN'

-- employees ���̺��� ����� ���̵�, �̸�, ������ȭ��ȣ, ��ȭ��ȣ ��ȸ�ϱ�
-- (��ȭ��ȣ�� 2��° ������ ���� ��ȸ)
select employee_id, first_name, phone_number, substr(phone_number, instr(phone_number, '.', 1, 2) +1 ) short_phone_number
from employees;

-- employees ���̺��� ��� ���̵�, �̸�, �̸��� ��ȸ�ϱ�
-- (��, �̸����� ù2���ڴ� **�� �ٲٱ�)
select employee_id, first_name, email, lower(replace(email, substr(email, 3, 2), '**')) secret_email
from employees;

-- ���� �ܾ ����ɰ�� �ذ��
select replace('aaabbaabb', substr('aaabbaabb', 3, 2), '**'),
replace(substr('aaabbaabb', 1, 4), substr('aaabbaabb', 3, 2)) || substr('aaabbaabb', 5)
from dual;
