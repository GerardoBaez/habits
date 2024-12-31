package com.habits.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.habits.model.Categorie;
import com.habits.model.User;
import com.habits.model.UserResponse;

public class UserMapper  implements RowMapper<UserResponse> {
	
	@Override
	public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserResponse user= new UserResponse();
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setCreated_at(rs.getDate("created_at"));
		return user;
	}

}
