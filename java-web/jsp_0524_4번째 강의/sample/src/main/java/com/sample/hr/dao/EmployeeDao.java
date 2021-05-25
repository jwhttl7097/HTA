package com.sample.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.hr.dto.EmployeeDto;
import com.sample.hr.vo.Department;
import com.sample.hr.vo.Employee;
import com.sample.utils.ConnectionUtil;

/**
 * EMPLOYEES 테이블에 대한 CRUD를 제공하는 클래스다.
 * @author user
 *
 */
public class EmployeeDao {

	/**
	 * 부서아이디를 전달받아서 해당 부서에 소속된 사원들을 반환한다.
	 * @param deptId 부서아이디
	 * @return 사원정보 목록
	 * @throws SQLException
	 */
	public List<Employee> getEmployeesByDepartmentId(int deptId) throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();
		
		String sql = "select * "
				   + "from employees "
				   + "where department_id = ?";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, deptId);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Employee emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommissionPct(rs.getDouble("commission_pct"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDepartmentId(rs.getInt("department_id"));
			
			employees.add(emp);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return employees;
	}
	
	/**
	 * 모든 사원정보를 반환한다.
	 * @return 사원정보 목록
	 * @throws SQLException
	 */
	public List<Employee> getAllEmployees() throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();
		
		String sql = "select * "
				   + "from employees "
				   + "order by employee_id";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Employee emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommissionPct(rs.getDouble("commission_pct"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDepartmentId(rs.getInt("department_id"));
			
			employees.add(emp);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return employees;
	}
	
	/**
	 * 사원아이디를 전달받아서 해당 사원의 정보를 반환한다.
	 * @param empId
	 * @return 사원정보
	 * @throws SQLException
	 */
	public EmployeeDto getEmployeesByEmployeeDto(int empId) throws SQLException {
		EmployeeDto empDto = new EmployeeDto();
		
		String sql = "select emp.*, mng.first_name || mng.last_name manager_name, d.department_name, j.job_title "
				+ "from employees emp, employees mng, departments d, jobs j "
				+ "where emp.employee_id = ? "
				+ "and emp.manager_id = mng.employee_id(+) "
				+ "and emp.department_id = d.department_id(+) "
				+ "and emp.job_id = j.job_id";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, empId);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			empDto.setId(rs.getInt("employee_id"));
			empDto.setFirstName(rs.getString("first_name"));
			empDto.setLastName(rs.getString("last_name"));
			empDto.setEmail(rs.getString("email"));
			empDto.setPhoneNumber(rs.getString("phone_number"));
			empDto.setHireDate(rs.getDate("hire_date"));
			empDto.setJobId(rs.getString("job_id"));
			empDto.setJobTitle(rs.getString("job_title"));
			empDto.setSalary(rs.getDouble("salary"));
			empDto.setCommissionPct(rs.getDouble("commission_pct"));
			empDto.setManagerId(rs.getInt("manager_id"));
			empDto.setManagerName(rs.getString("manager_name"));
			empDto.setDepartmentId(rs.getInt("department_id"));
			empDto.setDepartmentName(rs.getString("department_name"));
		}
			
		rs.close();
		pstmt.close();
		con.close();
		
		return empDto;
	}
	
	/**
	 * 전달받은 사원정보를 테이블에 추가한다.
	 * @param employee 사원정보
	 * @throws SQLException
	 */
	public void insertEmployee(Employee employee) throws SQLException {
		
		String sql = "insert into employees "
				+ "(employee_id, first_name, last_name, email, phone_number, hire_date, "
				+ "job_id, salary, commission_pct, manager_id, department_id) "
				+ "values(employees_seq.nextval, ?, ?, ?, ? "
				+ ", sysdate, ?, ?, ?, ?, ?)";
		
		Connection con = ConnectionUtil.getConnection();		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, employee.getFirstName());		 
		pstmt.setString(2, employee.getLastName());
		pstmt.setString(3, employee.getEmail());
		pstmt.setString(4, employee.getPhoneNumber());
		pstmt.setString(5, employee.getJobId());
		pstmt.setDouble(6, employee.getSalary());
		pstmt.setDouble(7, employee.getCommissionPct());
		pstmt.setInt(8, employee.getManagerId());
		pstmt.setInt(9, employee.getDepartmentId());
		pstmt.executeUpdate();		
									
		pstmt.close();
		con.close();
	}
	
	/**
	 * employeeId에 해당하는 사원의 부하직원목록을 반환
	 * @param employeeId
	 * @return
	 */
	public List<Employee> getEmployeesByManagerId(int employeeId) throws SQLException{
		List<Employee> employees = new ArrayList<Employee>();
		
		String sql = "select mng.employee_id, mng.first_name, mng.last_name, mng.email, mng.phone_number "
				+ "from employees emp, employees mng "
				+ "where emp.employee_id = ? "
				+ "and emp.employee_id = mng.manager_id(+)";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, employeeId);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Employee employee = new Employee();
			employee.setId(rs.getInt("employee_id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			employee.setEmail(rs.getString("email"));
			employee.setPhoneNumber(rs.getString("phone_number"));
			
			employees.add(employee);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return employees;
	}
}
