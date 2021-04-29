-- ���̺� �����ϱ�
-- ������̵�, �����, �ҼӺμ����̵�, �ҼӺμ���
-- employees���̺� -> ������̵�, �����, �ҼӺμ����̵�
-- departments ���̺� - �ҼӼ�����
select employees.employee_id, employees.first_name, employees.department_id, 
       departments.department_name
from employees, departments
where employees.department_id = departments.department_id;

select A.employee_id, A.first_name, A.department_id, B.department_name
from employees A, departments B 
where A.department_id = B.department_id;

-- ���̺������ϱ�
-- ������̵�, �̸�, �������̵�, �޿�, ��������, ���� ġ�� �޿�, ���� �ִ� �޿� ��ȸ�ϱ�
-- employees ���̺� -> ������̵�, �̸�, �������̵�, �޿�
-- jobs ���̺� -> �������̵�, ��������, ���� �����޿�, ���� �ְ�޿�
select A.employee_id, A.first_name, A.salary, A.job_id, B.min_salary, B.max_salary
FROM employees A, jobs B
where A.job_id = B.job_id;

-- ���̺������ϱ�
-- �μ����̵�, �μ���, ���������̵�, ������ �ּ�, ������ ���ø� ��ȸ�ϱ�
-- departments -> �μ����̵�, �μ���, ���������̵�
-- locations -> �������ּ�, ������ ���ø�
select A.department_id, A.department_name, A.location_id, B.street_address, B.city
from departments A, locations B 
where A.location_id = B.location_id;

-- ���̺� �����ϱ�
-- �μ������ڰ� �����Ǿ� �ִ� �μ��� �μ����̵�, �μ���, �μ������� ���̵�, �μ������� �̸� ��ȸ�ϱ�
-- departments -> �μ��ƾƵ�, �μ���, �μ������ھ��̵�,
-- employees -> �μ��������̸�(����̸�)
-- departments�� manager_id�� �μ������ڷ� ������ ����� ������̵��.
-- departments�� manager_id�� ������ ������̵� ���� ��������� ���εǾ���Ѵ�.
select A.department_id, A.department_name, A.manager_id, B.first_name
from departments A, employees B 
where A.manager_id = B.employee_id
and A.manager_id is not null;

-- 3�� �̻��� ���̺� �����ϱ�
-- ������̵�, ����̸�, �������̵�, �޿�, ���������޿�, �����ʰ�޿�, �ҼӺμ� ���̵�, �μ��� ��ȸ
-- employees -> ������̵�, ����̸�, �������̵�, �޿�, �ҼӺμ����̵�
-- jobs -> ���������޿�, �����ְ�޿�
-- departments -> �μ���
select E.employee_id, E.first_name, E.job_id,
		E.salary, J.min_salary, J.max_salary, 
		E.department_id, D.department_name
from employees E, jobs J, departments D
where E.job_id = J.job_id 
and E.department_id = D.department_id
order by E.employee_id asc; 

-- 100�� ����� �̸�, ��ȭ��ȣ, �̸���, 
-- �ҼӺμ����̵�, �ҼӺμ���, �ҼӺμ� ���ø�, �ҼӺμ� �������ּ� ��ȸ�ϱ�
select E.first_name, E.phone_number, E.email,
       D.department_id, D.department_name,
       L.city, L.street_address
from employees E, departments D, locations L 
where E.employee_id = 100 -- �˻�����
and E.department_id = D.department_id 
and D.location_id = L.location_id;

-- 50�� �μ��� �Ҽӵ� ������� ������̵�, �̸�, �������̵�, �������� ��ȸ�ϱ�
-- ������̵�, �̸�, �������̵� --> employees
-- �������� --> jobs
select E.employee_id, E.first_name, J.job_id, J.job_title
from employees E, jobs J 
where E.department_id = 50 
and E.job_id = J.job_id;

-- �޿��� 15000�̻� ���� ������� �̸�, �������̵�, �޿�, �μ����� ��ȸ�ϱ�
-- �޿��� 15000�̻�, �޿�, �̸�, �������̵� --> employees 
-- �μ��� ==> departments
select E.first_name, E.job_id, E.salary, D.department_name
from employees E, departments D 
where E.salary >= 15000
and E.department_id = D.department_id;

-- 100������ ������ �����ϴ� ������� �̸�, �������̵�, ��������, �μ����̵�, �μ��� ��ȸ�ϱ�
-- 100������, �̸�, �������̵�, �μ��ƾƵ� --> employees 
-- �������� --> jobs 
-- �μ��� -- >departments
select E.first_name, E.job_id, J.job_title, 
	D.department_id, D.department_name
from employees E, jobs J, departments D 
where E.manager_id = 100
and E.job_id = J.job_id 
and E.department_id = D.department_id;

-- 1
-- ��� ������� ������̵�, �̸�, �ҼӺμ����̵�, �ҼӺμ����� ��ȸ�ϱ�
select e.employee_id, e.first_name, e.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id;

--2
-- ��� ������� ������̵�, �̸�, �������̵�, ���������� ��ȸ�ϱ�
select e.employee_id, e.first_name, j.job_id, j.job_title
from employees e, jobs j
where e.job_id = j.job_id;

--3
-- ����� �߿��� �ҼӺμ��� �������� �ʴ� ����� ���̵�, �̸�, �޿�, ����, �����ּұ޿�, �����ִ�޿��� ��ȸ�ϱ�
select e.employee_id, e.first_name, e.salary, j.job_id, j.min_salary, j.max_salary
from employees e, jobs j
where e.department_id is null
and e.job_id = j.job_id;

--4
-- 2007�⿡ �Ի��� ������� ������̵�, �̸�, �ҼӺμ����̵�, �ҼӺμ����� ��ȸ�ϱ�
select e.employee_id, e.first_name, e.department_id, d.department_name
from employees e, departments d
where e.hire_date like '2007%'
and e.department_id = d.department_id;

--5
-- Ŀ�̼��� ���� ������� ������̵�, �̸�, ����, ��������, �ҼӺμ����̵�, �ҼӺμ����� ��ȸ�ϱ�
select e.employee_id, e.first_name, j.job_id, j.job_title, d.department_id, d.department_name
from employees e, jobs j, departments d
where e.commission_pct is not null
and e.job_id = j.job_id
and e.department_id = d.department_id;

--6
-- �����ּұ޿��� 10000�޷� �̻��� ������ �����ϰ� �ִ� ������� ���̵�, �̸�, �������̵�, �޿��� ��ȸ�ϱ�
select e.employee_id, e.first_name, e.job_id, e.salary
from employees e, jobs j
where j.min_salary >= 10000
and e.job_id = j.job_id;

--7
-- ��� ������� ������̵�, �̸�, �ҼӺμ����̵�, �ҼӺμ���, �ش�μ��� ������ ���� �� �ּҸ� ��ȸ�ϱ�
select e.employee_id, e.first_name, d.department_id, d.department_name, l.city, l.street_address
from employees e, locations l, departments d
where d.location_id = l.location_id
and e.department_id = d.department_id;

--8
-- ��� ������� ������̵�, �̸�, �������̵�, ��������, �ҼӺμ����̵�, �ҼӺμ���, �ش�μ��� ������ ���� �� �ּ�
select e.employee_id, e.first_name, 
       j.job_id, j.job_title,
       d.department_id, d.department_name,
       l.city, l.street_address
from employees e, locations l, departments d, jobs j
where d.location_id = l.location_id
and e.job_id = j.job_id
and e.department_id = d.department_id;

--9
-- �μ� ������ ������ �̱��� ��ġ�ϰ� �ִ� �μ��� �μ����̵�, �μ���, ���ø��� ��ȸ�ϱ�
select d.department_id, d.department_name, l.city, l.country_id
from departments d, locations l
where l.country_id = 'US'
and d.location_id = l.location_id;

--10
-- 'Seattle'���� �ٹ��ϰ� �ִ� ������� ������̵�, �̸�, �μ����̵�, �μ����� ��ȸ�ϱ�
select e.employee_id, e.first_name, d.department_id, d.department_name
from employees e, departments d, locations l
where l.city = 'Seattle'
and e.department_id = d.department_id
and d.location_id = l.location_id;

--11
-- 2006�⿡ job�� ����� ����� �ִ� ������� ������̵�, �̸�, �������̵� ��ȸ�ϱ�
select e.employee_id, e.first_name, h.job_id
from employees e, job_history h
where e.hire_date like '2006%'
and e.job_id != h.job_id
and e.employee_id = h.employee_id;

select e.employee_id, e.first_name, h.job_id
from employees e, job_history h
where h.start_date >= to_date('2006-01-01', 'yyyy-mm-dd') 
and h.end_date < to_date('2007-01-01', 'yyyy-mm-dd')
and e.employee_id = h.employee_id;

--12
-- ������ 50�� �μ����� �ٹ��� ���� �ִ� ������� ������̵�, �̸�, �ٹ�������, �ٹ�������, �ٹ���� �������̵� ��ȸ�ϱ�
select e.employee_id, e.first_name, h.start_date, h.end_date, h.job_id
from employees e, job_history h
where h.department_id = 50
and e.employee_id = h.employee_id;

--13
-- ����� �߿��� �ڽ��� �ٹ��ϰ� �ִ� ������ �ּұ޿��� �ִ�޿��� ��հ��� ���� �޿��� �޴� 
-- ����� ���̵�, �̸�, �������̵�, �޿�, �ּұ޿�, �ִ�޿�, �ּ�/�ִ�޿� ��հ��� ��ȸ�ϱ�
-- (��հ��� (�ּұ޿�+�ִ�޿�)/2�� ���Ѵ�)
select e.employee_id, e.first_name, e.job_id, e.salary, j.min_salary, j.max_salary, ((j.min_salary+j.max_salary)/2) as ��հ�
from employees e, jobs j
where salary < ((j.min_salary+j.max_salary)/2)
and e.job_id = j.job_id
order by e.job_id;
