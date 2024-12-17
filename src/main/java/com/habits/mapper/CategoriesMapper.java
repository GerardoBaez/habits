package com.habits.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.habits.model.Categorie;

public class CategoriesMapper implements RowMapper<Categorie>{

	@Override
	public Categorie mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categorie cat= new Categorie();
		
		cat.setDescription(rs.getString("description"));
		cat.setName(rs.getString("name_"));
		
		return cat;
	}

}
