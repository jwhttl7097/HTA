package com.sample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.vo.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void insertUser(User user) {
		String sql = "insert into sample_users "
				   + "(user_id, user_name, user_password, user_email, user_phone)"
				   + "values"
				   + "(?,?,?,?,?)";
		jdbcTemplate.update(sql, user.getId(), 
								 user.getName(),
								 user.getPassword(),
								 user.getEmail(),
								 user.getPhone());
	}
}
