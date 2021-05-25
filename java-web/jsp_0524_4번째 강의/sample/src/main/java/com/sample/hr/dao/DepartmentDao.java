package com.sample.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.hr.dto.DepartmentDto;
import com.sample.hr.vo.Department;
import com.sample.utils.ConnectionUtil;

/**
 * DEPARTMENTS 테이블에 대한 CRUD 기능을 제공하는 클래스다.
 * @author user
 *
 */
public class DepartmentDao {
	
	/**
	 * 수정된 부서정보를 전달받아서 부서정보를 변경한다.
	 * @param dept 수정된 부서정보
	 * @throws SQLException
	 */
	public void updateDepartment(Department dept) throws SQLException {
		String sql = "update departments "
				+	"set "
				+	"department_name = ?, "
				+	"manager_id = ?, "
				+	"location_id = ? "
				+	"where department_id = ?";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dept.getName());
		pstmt.setInt(2, dept.getManagerId());
		pstmt.setInt(3, dept.getLocationId());
		pstmt.setInt(4, dept.getId());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	/**
	 * 부서아이디를 전달받아서 해당 부서의 정보를 테이블에서 삭제한다.
	 * @param departmentId
	 * @throws SQLException
	 */
	public void deleteDepartment(int departmentId) throws SQLException {
		String sql = "delete from departments "
				+	"where department_id = ?";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, departmentId);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}

	/**
	 * 전달받은 부서정보를 테이블에 추가한다.
	 * @param department 부서정보
	 * @throws SQLException
	 */
	public void inserDepartment(Department department) throws SQLException {
		// INSERT, UPDATE, DELETE 구문은 반환 받을 데이터가 없기 떄문에 반환값은 void로 설정
		
		// 1. sql쿼리문 작성
		String sql = "insert into departments "
				   + "(department_id, department_name, location_id) "
				   + "values "
				   + "(departments_seq.nextval, ?, ?)";
		
		Connection con = ConnectionUtil.getConnection();		// 2.DBMS와 연결을 담당하는 Connection 객체 획득
		PreparedStatement pstmt = con.prepareStatement(sql);	// 3.지정된 SQL을 DBMS로 전송하는 PreparedStatement 객체 획득
		pstmt.setString(1, department.getName());				// 4. sql문에서 필요한 데이터를 pstmt.set해당데이터타입()를 이용하여 
		pstmt.setInt(2, department.getLocationId());			//    ? 순서대로 데이터를 추가한다.
		pstmt.executeUpdate();		// 5. executeUpdate()를 이용하여 sql문을 실행시켜 데이터를 변경한다.
									// INSERT, UPDATE, DELETE 구문을 실행한다.
		// 자원반환
		pstmt.close();
		con.close();
	}
	
	/**
	 * 모든 부서정보를 반환한다.
	 * @return 부서정보 목록
	 * @throws SQLException
	 */
	public List<Department> getAllDepartments() throws SQLException {
		// 1. 담을 리스트 생성
		List<Department> departments = new ArrayList<Department>();
		// 2. sql문 작성
		String sql = "select department_id, department_name, manager_id, location_id "
					+ "from departments "
					+ "order by department_id asc ";
		
		Connection con = ConnectionUtil.getConnection();		// DBMS와 연결을 담당하는 Connection 객체 획득
		PreparedStatement pstmt = con.prepareStatement(sql);	// 지정된 SQL을 DBMS로 전송하는 PreparedStatement 객체 획득
		ResultSet rs = pstmt.executeQuery();					// SQL을 DBMS로 executeQuery()를 이용하여 전송하고,
																// 실행결과가 포함된 ResultSet 객체 획득
		
		// 획득한 ResulSet객체로 한 행씩 반복문을 사용하여 각 데이터타입에 맞는 rs.get메소드를 이용해 데이터 획득 후 먼저 만들어둔 리스트에 추가
		while (rs.next()) {
			Department department = new Department();
			department.setId(rs.getInt("department_id"));
			department.setName(rs.getString("department_name"));
			department.setManagerId(rs.getInt("manager_id"));
			department.setLocationId(rs.getInt("location_id"));
			
			departments.add(department);
		}
		
		// 자원반환
		rs.close();
		pstmt.close();
		con.close();
		
		return departments;
	}
	
	/**
	 * 부서아이디를 전달받아서 부서기본 정보를 반환한다.
	 * @param deptId 조회할 부서아이디
	 * @return 부서정보가 포함된 DepartmentDto
	 * @throws SQLException
	 */
	public DepartmentDto getDepartmentDto(int deptId) throws SQLException{
		String sql = "select d.department_id, d.department_name, d.manager_id, "
				   +	 "m.first_name as manager_name, "
				   + 	 "l.location_id, l.city, "
				   +	 "(select count(*) from employees e where e.department_id = ?) emp_cnt "
				   +	 "from departments d, employees m, locations l "
				   + 	 "where d.department_id = ? "
				   + 	 "and d.manager_id = m.employee_id(+) "
				   + 	 "and d.location_id = l.location_id";
		DepartmentDto dto = null;
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, deptId);
		pstmt.setInt(2, deptId);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			dto = new DepartmentDto();
			dto.setId(rs.getInt("department_id"));
			dto.setName(rs.getString("department_name"));
			dto.setManagerId(rs.getInt("manager_id"));
			dto.setManagerName(rs.getString("manager_name"));
			dto.setLocationId(rs.getInt("location_id"));
			dto.setCity(rs.getString("city"));
			dto.setEmpCount(rs.getInt("emp_cnt"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return dto;
	}
	
	public Department getDepartmentById(int deptId) throws SQLException {
		Department department = null;
		String sql = "select * "
				+	"from departments "
				+	"where department_id = ?";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, deptId);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			department = new Department();
			department.setId(rs.getInt("department_id"));
			department.setName(rs.getString("department_name"));
			department.setManagerId(rs.getInt("manager_id"));
			department.setLocationId(rs.getInt("location_id"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return department;
		
	}
}
