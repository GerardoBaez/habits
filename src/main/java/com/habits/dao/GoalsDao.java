package com.habits.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.habits.mapper.GoalsMapper;
import com.habits.model.Goal;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class GoalsDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * Metodo para obtener las metas 
	 * @return
	 */
	public List<Goal> getGoals(){
		return jdbcTemplate.query("SELECT * FROM GOALS", new GoalsMapper());
	}
	
	/**
	 * Metodo para crear las metas 
	 * @param goal
	 */
	public void createGoal(Goal goal) {
		Object [] params= {goal.getId_habit(),goal.getName(),goal.getDescription(),goal.getStart(),goal.getEnd()};
		jdbcTemplate.update("INSERT INTO  GOALS (id_habit,name,description,start,end) VALUES (?,?,?,?,?)",params);
	}
}


