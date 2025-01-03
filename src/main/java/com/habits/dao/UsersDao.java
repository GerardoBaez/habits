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
	
	public String[] userexist(User user) { 
		String [] args= new String[2];
		boolean exist=false;
		if(!this.getUserByEmail(user.getEmail()).isEmpty()) {
			exist=true;
			args[1]="El email ya existe";
		}
		if(!this.getUserByName(user.getName()).isEmpty()) {
			exist=true;
			args[1]="El usuario ya existe";
		}
		args[0]=String.valueOf(exist);
		return args;
	}
	
	public List<UserResponse> getUserByName(String name) {
		Object [] params = {name};
		 return jdbcTemplate.query("SELECT * FROM USERS WHERE NAME = ? ", params,new UserMapper() );
	}
	
	public List<UserResponse> getUserByEmail(String email) {
		Object [] params = {email};
		 return jdbcTemplate.query("SELECT * FROM USERS WHERE EMAIL = ? ", params,new UserMapper() );
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
