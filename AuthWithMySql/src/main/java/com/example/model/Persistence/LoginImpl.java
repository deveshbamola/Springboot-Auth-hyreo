package com.example.model.Persistence;

import com.example.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Persistence.util.UserRowMapper;

@Repository
public class LoginImpl implements LogIn {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean validate(String Username, String password) { // function to authenticate the coming request
		String query = "select * from user where email = ? && pass = ?";
		User user = null;
		try {
			user = jdbcTemplate.queryForObject(query, new UserRowMapper(), Username, password);
		} catch (EmptyResultDataAccessException E) {
			return user != null;
		}
		return user != null;
	}

}
