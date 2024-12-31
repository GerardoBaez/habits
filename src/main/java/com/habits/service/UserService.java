package com.habits.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.habits.dao.UsersDao;
import com.habits.model.HabitResponse;
import com.habits.model.ServiceError;
import com.habits.model.ServiceErrors;
import com.habits.model.ServiceResponse;
import com.habits.model.User;
import com.habits.model.UserResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UsersDao userdao;
	
	/**
	 * Metodo para obtener los usuarios existentes
	 * @return
	 */
	public ResponseEntity <ServiceResponse<List<UserResponse>>> getUsers(){
		List<ServiceError> listerr= new ArrayList<>();
		ServiceResponse service = new ServiceResponse<List<UserResponse>>();
		log.info("Obteniendo usuarios");
		List<UserResponse> users= new ArrayList<UserResponse>();
		try {
			users=userdao.getUsers();
			service.setExitoso(true);
			service.setRespuesta(users);	
			return new ResponseEntity< ServiceResponse<List<UserResponse>>>(service,HttpStatus.OK);
			
		}catch(DataAccessException exec) {
			log.error("Ocurrio un error");
			log.error(exec.getMessage());
			ServiceErrors errorlist = this.crea_error(listerr, "Error de datos");
			service.setExitoso(false);
			service.setServiceErrors(errorlist);
			return new ResponseEntity< ServiceResponse<List<UserResponse>>>(service,HttpStatus.BAD_REQUEST);
		
		}
		
		
	}
	
	
	public ServiceErrors crea_error(List<ServiceError> list, String message){
		ServiceErrors errors = new ServiceErrors();
		ServiceError error = new ServiceError();
		error.setMessage(message);
		list.add(error);
		errors.setErrors(list);
		return errors;
	}
	
	/**
	 * Metodo para insertar usuario
	 * @param user
	 * @return 
	 */
	public ResponseEntity<ServiceResponse> createUser(User user) {	
		log.info("Creando usuario..");
		List<ServiceError> listerr= new ArrayList<>();
		ServiceResponse service = new ServiceResponse<UserResponse>();
		UserResponse createdUser = null;
		ServiceResponse isvalid = this.isvalid(user);
		if(isvalid.isExitoso()) {
			try {
				 createdUser = userdao.createUser(user);
			}
			catch(DataAccessException | NullPointerException exce) {
				log.error("Ocurrio un error");
				log.error(exce.getMessage());
				ServiceErrors list_err = this.crea_error(listerr, "Error de base datos");
				service.setExitoso(false);
				service.setServiceErrors(list_err);
				//return new ResponseEntity<ServiceResponse>(service,HttpStatus.BAD_REQUEST);
			}
			if(createdUser!=null) {
				service.setExitoso(true);
				service.setRespuesta(createdUser);
				
			}
			
		}
		else {	
			return new ResponseEntity<ServiceResponse>(isvalid,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ServiceResponse>(service,HttpStatus.OK);
	}
	
	public ServiceResponse isvalid(User request) {
		List<ServiceError> listerr= new ArrayList<>();
		ServiceResponse service = new ServiceResponse<UserResponse>();
		try {
			UserResponse userfound = userdao.getUser(request);
			if(userfound!=null) {
				log.error("Usuario ya existente");
				ServiceErrors errors = this.crea_error(listerr, "Usuario ya existente");
				service.setExitoso(false);
				service.setServiceErrors(errors);
			}
		}catch(DataAccessException | NullPointerException exce) {
			if(request.getName()!=null && request.getEmail()!=null && request.getPass()!=null) {
				service.setExitoso(true);
			}
			else {
				log.error("No estan informados los campos necesarios");
				ServiceErrors errors = this.crea_error(listerr, "No estan informados los campos necesarios");
				service.setExitoso(false);
				service.setServiceErrors(errors);
			}
		}
		
		return service;
	}
	
	
}
