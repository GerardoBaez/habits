package com.habits.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.habits.mapper.UserMapper;
import com.habits.model.HabitRequest;
import com.habits.model.User;
import com.habits.model.UserResponse;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UsersDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public UserResponse getUser(User user) {
		//Sigue permitiendo darse de alta con solo cambiar el nombre
		 // de usuario hacer dos consultas una para checar el nombre
		 // de usuario y otra para checar el email
		Object [] params = {"%"+user.getName()+"%","%"+user.getEmail()+"%"};
		 return jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE NAME LIKE ? AND EMAIL LIKE ?", params,new UserMapper() );
	}
	
	/**
	 * Metodo para obtener los usuarios
	 * @return
	 */
	public List<UserResponse> getUsers(){
		List<UserResponse> users= new ArrayList<>();
		users=jdbcTemplate.query("SELECT * FROM USERS",new UserMapper());
		return users;
	}
	
	/**
	 * Metodo para crar un usuario
	 * @param habitreq
	 * @return
	 */
	public UserResponse createUser(User user) {
		UserResponse response= new UserResponse();
		log.info("Creando usuario:{}",user.getName());
		Object [] params = {user.getName(),user.getEmail(),user.getPass()};
		int update = jdbcTemplate.update("INSERT INTO USERS (NAME,EMAIL,CREATED_AT,PASS) VALUES (?,?,SYSDATE(),?)",params);
		if(update==1) {
			log.info("Creacion exitosa..");
			response.setName(user.getName());
			response.setEmail(user.getEmail());
			response.setCreated_at(new Date());
		}
		return response;
	} 

}
