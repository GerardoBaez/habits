package com.habits.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.habits.model.Habit;
import com.habits.model.Priority;

public class PriorityMapper implements RowMapper<Priority>  {

	@Override
	public Priority mapRow(ResultSet rs, int rowNum) throws SQLException {
		Priority priority= new Priority();
		priority.setId_cat_priority(rs.getInt("id_cat_priority"));
		priority.setName(rs.getString("level"));
		return priority;
	}

}
