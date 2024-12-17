package com.habits.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.habits.model.Sesion;
import com.habits.model.Streak;

public class StreaksMapper implements RowMapper<Streak> {

	@Override
	public Streak mapRow(ResultSet rs, int rowNum) throws SQLException {
		Streak streak= new Streak();
		streak.setId_habito(rs.getInt("id_streak"));
		streak.setFirst_day(rs.getDate("first_day"));
		streak.setLast_day(rs.getDate("last_day"));
		streak.setTotal_dias(rs.getInt("total_days"));
		return streak;
	}

}
