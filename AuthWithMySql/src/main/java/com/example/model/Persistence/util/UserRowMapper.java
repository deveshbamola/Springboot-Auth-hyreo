package com.example.model.Persistence.util;

import java.sql.ResultSet;
import com.example.bean.User;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new User(rs.getString("email"), rs.getString("pass"));
	}

}
