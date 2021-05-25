<%@page import="com.sample.hr.vo.Employee"%>
<%@page import="com.sample.hr.dao.EmployeeDao"%>
<%@page import="com.sample.hr.dao.DepartmentDao"%>
<%@page import="com.sample.hr.vo.Department"%>
<%@page import="com.sample.hr.vo.Job"%>
<%@page import="java.util.List"%>
<%@page import="com.sample.hr.dao.JobDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>인사관리 :: 사원관리</title>
</head>
<body>
<!-- 
	신규 사원정보를 등록하는 폼
	1. 사원아이디, 입사일, 매니저 아이디는 입력폼에서 별로도 입력하지 않는다.
		신규사원은 전부 Human resources 부서의  203번 직원이 관리한다.
		매니저 아이디는 히든 필드로  표시했다.
	2. 
 -->
	<h1>새 사원 등록페이지</h1>
	<p>새 사원 정보를 입력하고 사원을 등록하세요</p>
	
	<%
		JobDao jobDao = new JobDao();
		List<Job> jobs = jobDao.getAllJob();
		
		DepartmentDao departmentDao = new DepartmentDao();
		List<Department> departments = departmentDao.getAllDepartments();
		
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> emps = employeeDao.getAllEmployees();
	%>
	
	<!-- =============== 플랫폼 ===============  -->
	
		<div class="container">
		<div class="row">
			<div class="col-12">
				<h1>사원 등록폼</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-12 border p-3 bg-light">
				<form method="post" action="add.jsp">
					<input type="hidden" name="managerId" value="203"/>
					<div class="form-row">
    					<div class="form-group col-md-6">
      						<label>First Name</label>
      						<input type="text" class="form-control" name="firstName">
    					</div>
    					<div class="form-group col-md-6">
      						<label>Last Name</label>
      						<input type="text" class="form-control" name="lastName">
    					</div>
  					</div>
					<div class="form-row">
    					<div class="form-group col-md-6">
      						<label>Email</label>
      						<input type="text" class="form-control" name="email">
    					</div>
    					<div class="form-group col-md-6">
      						<label>Phone Number</label>
      						<input type="text" class="form-control" name="phoneNumber">
    					</div>
  					</div>
					<div class="form-row">
    					<div class="form-group col-md-6">
      						<label>Job</label>
      						<select class="form-control" name="jobId">
      							<option value=""> 직종을 선택하세요</option>
      							<%
									for (Job job : jobs) {
								%>
									<option value="<%=job.getId()%>"><%=job.getJobTitle() %> (<%=job.getId() %>)</option>
								<%
									}
								%>     							
      						</select>
    					</div>
    					<div class="form-group col-md-6">
      						<label>Department</label>
      						<select class="form-control" name="departmentId">
      							<option value=""> 소속부서를 선택하세요</option>
								<%
									for (Department dept : departments) {
								%>
									<option value="<%=dept.getId()%>"><%=dept.getName() %> (<%=dept.getManagerId() %>)</option>
								<%
									}
								%>  							
      						</select>
    					</div>
  					</div>
  					<div class="form-row">
    					<div class="form-group col-md-6">
      						<label>Salary</label>
      						<select class="form-control" name="salary">
      							<option value="2000"> 2000</option>
      							<option value="3000"> 3000</option>
      							<option value="4000"> 4000</option>
      							<option value="5000"> 5000</option>
      							<option value="6000"> 6000</option>
      							<option value="7000"> 7000</option>
      						</select>
    					</div>
    					<div class="form-group col-md-6">
      						<label>Commission_pct</label>
      						<select class="form-control" name="commission_pct">
      							<option value="0"> 0</option>
      							<option value="0.1"> 0.1</option>
      							<option value="0.15"> 0.15</option>
      							<option value="0.2"> 0.2</option>
      							<option value="0.25"> 0.25</option>
      							<option value="0.3"> 0.3</option>
      							<option value="0.35"> 0.35</option>
      							<option value="0.4"> 0.4</option>
      						</select>
    					</div>
  					</div>
  					<div class="form-group col-12 text-right">
  						<a href="main.jsp" class="btn btn-secondary">취소</a>
  						<button type="submit" class="btn btn-primary">등록</button>
  					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>