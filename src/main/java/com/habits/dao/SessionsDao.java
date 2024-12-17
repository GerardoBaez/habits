package com.habits.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.habits.mapper.SessionsMapper;
import com.habits.mapper.UserMapper;
import com.habits.model.Sesion;
import com.habits.model.User;

@Repository
public class SessionsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * Metodo para obtener los usuarios
	 * @return
	 */
	public List<Sesion> getSessions(){
		List<Sesion> sesions= new ArrayList<>();
		sesions=jdbcTemplate.query("SELECT * FROM Sessions",new SessionsMapper());
		return sesions;
	}
	
	/**
	 * Metodo para crar un usuario
	 * @param habitreq
	 * @return
	 */
	public int createSession(Sesion sesion) {
		Object [] params = {sesion.getId_habit(),sesion.getHora_ini(),sesion.getHora_fin(),sesion.getComent(),sesion.getIsSuccesful()};
		int update = jdbcTemplate.update("INSERT INTO SESSIONS (ID_HABIT,TIME_START,TIME_END,COMMENTS,IS_SUCCESFUL) VALUES (?,?,?,?,?)",params);
		return update;
	} 

}
