package com.habits.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.habits.mapper.PriorityMapper;
import com.habits.model.Priority;

@Repository
public class PrioritiesDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Priority>getPriorities(){
		return jdbcTemplate.query("SELECT * FROM habits.cat_priority", new PriorityMapper());
	}
	
	public void createPriority(Priority priority) {
		Object [] params= {priority.getName()};
		jdbcTemplate.update("INSERT INTO CAT_PRIORITY (level)  VALUES (?)",params);
	}
}
