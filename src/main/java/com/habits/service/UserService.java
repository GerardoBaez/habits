package com.habits.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.habits.dao.UsersDao;
import com.habits.model.HabitResponse;
import com.habits.model.User;

@Service
public class UserService {
	
	@Autowired
	private UsersDao userdao;
	
	/**
	 * Metodo para obtener los usuarios existentes
	 * @return
	 */
	public List<User> getUsers(){
		 List<User> users= new ArrayList<User>();
		 users=userdao.getUsers();
		 return users;
	}
	
	/**
	 * Metodo para insertar usuario
	 * @param user
	 */
	public void createUser(User user) {	
		userdao.createUser(user);
	}
	
	
}
