package com.habits.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.habits.model.Categorie;
import com.habits.model.Habit;

public class HabitsMapper implements RowMapper<Habit> {

	@Override
	public Habit mapRow(ResultSet rs, int rowNum) throws SQLException {
		Habit habit = new Habit();
		habit.setName(rs.getString("name_"));
		habit.setId_habit(rs.getInt("id_habit"));
		habit.setId_cat_category(rs.getInt("id_cat_category"));
		habit.setId_user(rs.getInt("id_user"));
		
		return habit;
	}

}
