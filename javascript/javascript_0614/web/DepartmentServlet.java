package com.sample.web;

import java.util.List;

import com.sample.dao.DepartmentDao;
import com.sample.vo.Department;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/dept")
public class DepartmentServlet extends HttpServlet{

	private DepartmentDao departmentDao = DepartmentDao.getInstance();
	
	protected void service(jakarta.servlet.http.HttpServletRequest req, jakarta.servlet.http.HttpServletResponse res) throws jakarta.servlet.ServletException ,java.io.IOException {
		// 모든 부서정보 조회
		List<Department> departments = departmentDao.getAllDepartments();
		// 조회된 부서정보를 요청객체에 속성으로 저장
		req.setAttribute("departments", departments);
		
		req.getRequestDispatcher("script-18-ajax.jsp").forward(req, res);
	}
}
