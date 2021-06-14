package com.sample.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sample.util.MybatisUtils;
import com.sample.vo.Department;

import jakarta.servlet.annotation.WebServlet;

public class DepartmentDao {

	private SqlSessionFactory sqlSessionFactory;
	
	private static DepartmentDao instance = new DepartmentDao();
	private DepartmentDao () {
		this.sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
	}
	public static DepartmentDao getInstance() {
		return instance;
	}
	
	public List<Department> getAllDepartments() {
		SqlSession session = sqlSessionFactory.openSession();
		List<Department> departments = session.selectList("departments.getAllDepartments");
		session.close();
		return departments;
	}
}
