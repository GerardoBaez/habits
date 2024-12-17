package com.habits.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.habits.mapper.UserMapper;
import com.habits.model.HabitRequest;
import com.habits.model.User;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UsersDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * Metodo para obtener los usuarios
	 * @return
	 */
	public List<User> getUsers(){
		List<User> users= new ArrayList<>();
		users=jdbcTemplate.query("SELECT * FROM USERS",new UserMapper());
		return users;
	}
	
	/**
	 * Metodo para crar un usuario
	 * @param habitreq
	 * @return
	 */
	public int createUser(User user) {
		Object [] params = {user.getName(),user.getEmail(),user.getPass()};
		int update = jdbcTemplate.update("INSERT INTO USERS (NAME,EMAIL,CREATED_AT,PASS) VALUES (?,?,SYSDATE(),?)",params);
		return update;
	} 

}
