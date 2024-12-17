package com.habits.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.habits.mapper.SessionsMapper;
import com.habits.mapper.StreaksMapper;
import com.habits.model.Sesion;
import com.habits.model.Streak;

@Repository
public class StreakDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * Metodo para obtener los usuarios
	 * @return
	 */
	public List<Streak> getStreaks(){
		List<Streak> sesions= new ArrayList<>();
		sesions=jdbcTemplate.query("SELECT * FROM Streaks",new StreaksMapper());
		return sesions;
	}
	
	/**
	 * Metodo para crar un usuario
	 * @param habitreq
	 * @return
	 */
	public int createStreak(Streak streak) {
		Object [] params = {streak.getId_habito(),streak.getFirst_day(),streak.getLast_day(),streak.getTotal_dias()};
		int update = jdbcTemplate.update("INSERT INTO STREAKS (ID_HABIT,FIRST_DAY,LAST_DAY,TOTAL_DAYS) VALUES (?,?,?,?)",params);
		return update;
	} 
	

}
