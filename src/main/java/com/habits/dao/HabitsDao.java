package com.habits.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.habits.mapper.CategoriesMapper;
import com.habits.mapper.HabitsMapper;
import com.habits.model.Categorie;
import com.habits.model.Habit;
import com.habits.model.HabitRequest;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class HabitsDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * Metodo que retorna los habitos existentes
	 * @return
	 */
	public List<Habit> getHabits(){
		List<Habit> habits = jdbcTemplate.query("SELECT * FROM HABITS", new HabitsMapper());
		return habits;
	}
	
	/**
	 * 
	 * @param habitreq
	 * @return 
	 * @return 
	 */
	public int createHabit(HabitRequest habitreq) {
		Object [] params= {habitreq.getId_user(), habitreq.getName(), habitreq.getId_cat_priority(), habitreq.getDescription(),habitreq.getId_cat_priority()};
		int update = jdbcTemplate.update("INSERT INTO HABITS (id_user,name_,id_cat_category, desciption,created_at,modified_at,last_day,total_days,id_cat_priority) VALUES (?,?,?,?,SYSDATE(),SYSDATE(),SYSDATE(),1,?)", params);
		//TODO OBTENER EL ID DEL HABITO QUE SE ACABA DE CREAR
		return update;
	}
	

}
