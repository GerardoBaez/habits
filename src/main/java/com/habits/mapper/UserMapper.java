package com.habits.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.habits.model.Categorie;
import com.habits.model.User;

public class UserMapper  implements RowMapper<User> {
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user= new User();
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setId_user(rs.getInt("id_user"));
		return user;
	}

}
