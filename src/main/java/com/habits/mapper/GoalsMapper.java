package com.habits.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.habits.model.Categorie;
import com.habits.model.Goal;

public class GoalsMapper implements RowMapper<Goal> {

	@Override
	public Goal mapRow(ResultSet rs, int rowNum) throws SQLException {
		 Goal goal = new Goal();
		 goal.setId_goal(rs.getInt("id_goal"));
		 goal.setName(rs.getString("name"));
		 goal.setDescription(rs.getString("description"));
		 goal.setId_habit(rs.getInt("id_habit"));
		 goal.setStart(rs.getDate("start"));
		 goal.setEnd(rs.getDate("end"));
	
		return goal;
	}

}
