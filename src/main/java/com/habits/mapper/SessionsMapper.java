package com.habits.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.habits.model.Priority;
import com.habits.model.Sesion;

public class SessionsMapper implements RowMapper<Sesion> {

	@Override
	public Sesion mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Sesion sesion = new Sesion();
		
		sesion.setId_session(rs.getInt("id_session"));
		sesion.setId_habit(rs.getInt("id_habit"));
		sesion.setComent(rs.getString("comments"));
		sesion.setHora_fin(rs.getDate("time_start"));
		sesion.setHora_ini(rs.getDate("time_end"));
		sesion.setIsSuccesful(rs.getBoolean("is_succesful"));	
		return sesion;
	
	}

}
