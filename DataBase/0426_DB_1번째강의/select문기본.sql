-- dapartments ���̺��� ��� ��, ��� �÷� ��ȸ�ϱ�
select *
from departments;

-- employess ���̺��� �����, ��� �÷� ��ȸ�ϱ�
select *
from employees;

-- jobs ���̺��� �����, ��� �÷� ��ȸ�ϱ�
select *
from jobs;
-- locations ���̺��� �����, ��� �÷� ��ȸ�ϱ�
select *
from locations;

-- ���̺��� ������ �÷��� ��ȸ�ϱ�
-- employees ���̺��� ������̵�, �̸�, �޿��� ��ȸ�ϱ�
select employee_id, first_name, salary  -- select ��
from employees;                         -- from ��

-- employees ���̺��� ������̵�, �̸�, �������̵� ��ȸ�ϱ�
select employee_id, first_name, last_name, department_id
from employees;

-- departmenets ���̺��� �μ����̵�, �μ��� ��ȸ�ϱ�
select department_id, department_name
from departments;

-- jobs ���̺��� �������̵�, �ּұ޿�, �ִ�޿� ��ȸ�ϱ�
select job_id, min_salary, max_salary
from jobs;

-- locations ���̺��� ��ġ���̵�, �ּ�, ���ø� ��ȸ�ϱ�
select location_id, street_address, city
from locations;

-- employees ���̺��� �ҼӺμ����̵�, ����� ������̵�, ����� �̸� ��ȸ�ϱ�
select department_id, manager_id, first_name
from employees;

-- ��ȸ����� �ߺ��� ���� ���� �� �ߺ��� ���� �����ϰ� ��ȸ�ϱ�
-- employees�� ��ϵ� ������� �����ϴ� ������ ���̵� ��ȸ�ϱ�
select DISTINCT job_id
from employees;

-- employees�� ��ϵ� ������� �ҼӺμ� ���̵� ��ȸ�ϱ�
select distinct department_id
from employees;

-- jobs_history ���̺��� ��ȸ�ؼ� ������ ����� ���� �ִ� ����� ���̵� ��ȸ�ϱ�
select distinct employee_id
from job_history;

-- ���� �����ڸ� �̿��ؼ� �� �� �̻��� �÷����� �ٿ��� ��ȸ�ϱ�
select employee_id, first_name, last_name, first_name || ' ' || last_name
from employees;

-- ��ȸ ����� ��Ī�� �ٿ��� ��ȸ�ϱ�
select employee_id, first_name || ' ' || last_name as full_name
from employees;

select employee_id, first_name || ' ' || last_name full_name
from employees;

-- ��Ī ���� ���� ���� �����ؾ��ϴµ� ���� �������� ""���
-- Ư�����ڳ� �׷� ���� ��������� ""�� �Ⱦ��°� ����
select employee_id, first_name || ' ' || last_name "full name"
from employees;

-- ��Ī�� ���� ���� as�� �ۼ��ص� �ǰ� ���ص� ��
select employee_id as id, first_name || ' ' || last_name as name
from employees;
select employee_id id, first_name || ' ' || last_name name
from employees;

-- ��Ģ ������ ����ϱ�
-- employees ���̺��� ������̵�, �̸�, �ֱ�, ���� ��ȸ�ϱ�
select employee_id, first_name, salary, salary*4 salary_of_month
from employees;

-- jobs ���̺��� �������̵�, �ּұ޿�, �ִ�޿�, �ּұ޿��� �ִ�޿��� ���̸� ��ȸ�ϱ�
select job_id, min_salary, max_salary, max_salary - min_salary as salary_gap
from jobs;

-- where ���� �̿��ؼ� ��ȸ�Ǵ� ���� �����ϱ�
-- ������̵� 100�� ����� ���̵�, �̸�, �޿��� ��ȸ�ϱ�
select employee_id, first_name, salary
from employees
where employee_id = 100;

-- �̸��� Steven�� ����� ������̵�, �̸�, �������̵�, �޿��� ��ȸ�ϱ�
select employee_id, first_name, job_id, salary
from employees
where first_name = 'Steven'; -- �ؽ�Ʈ���� ��ҹ��ڸ� �����Ѵ�.

-- �޿��� 2500������ ����� ������̵�, �̸�, �������̵�, �޿��� ��ȸ�ϱ�
select employee_id, first_name, job_id, salary
from employees
where salary <= 2500;

-- �޿��� 15000�̻��� ����� ������̵�, �̸�, �������̵�, �޿��� ��ȸ�ϱ�
select employee_id, first_name, job_id, salary
from employees
where salary >= 15000;

-- ��ȸ����� �̸��� ���� ������������ �����ϱ�
select first_name, salary
from employees
where salary >= 10000
order by first_name asc;

-- �޿��� 10000�̻��� ����� �̸�, �޿��� ��ȸ�ϱ�
-- ��ȸ����� �޿��� ���� ������������ �����ϱ�
select first_name, salary
from employees
where salary >= 10000
order by salary desc;

-- �޿��� 10000�̻��� ����� �̸�, �޿��� ��ȸ�ϱ�
-- ��ȸ����� �޿��� ���� ������������ �����ϱ�
-- �޿��� ������ ��� �̸������� �������� �����ϱ�
select first_name, salary
from employees
where salary >= 10000
order by salary desc, first_name asc;