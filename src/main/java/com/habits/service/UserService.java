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
		ResponseEntity <ServiceResponse<List<UserResponse>>> prepareResponse= null;
		log.info("Obteniendo usuarios");
		List<UserResponse> users= new ArrayList<UserResponse>();
		try {
			users=userdao.getUsers();
			prepareResponse= this.prepareResponse(true, users, HttpStatus.OK, null);	
		}catch(DataAccessException exec) {
			log.error("Ocurrio un error");
			log.error(exec.getMessage());
			prepareResponse=this.prepareResponse(false, null, HttpStatus.BAD_REQUEST, "Error de datos");
		}
		return prepareResponse;
	}
	
	/**
	 * Metodo para obtener usuario por el  nombre
	 * @return
	 */
	public ResponseEntity <ServiceResponse<UserResponse>> getUserByName(String name){
		ResponseEntity <ServiceResponse<UserResponse>> prepareResponse= null;
		log.info("Obteniendo usuario");
		List<UserResponse> users= new ArrayList<UserResponse>();
		try {
			users=userdao.getUserByName(name);
			prepareResponse= this.prepareResponse(true, users, HttpStatus.OK, null);	
		}catch(DataAccessException exec) {
			log.error("Ocurrio un error");
			log.error(exec.getMessage());
			prepareResponse=this.prepareResponse(false, null, HttpStatus.BAD_REQUEST, "Error de datos");
		}
		if(users.isEmpty()) {
			prepareResponse=this.prepareResponse(false, null, HttpStatus.OK, "No existe el usuario");
		}
		
		return prepareResponse;
	}
	
	/**
	 * Metodo para obtener usuario por el  nombre
	 * @return
	 */
	public ResponseEntity <ServiceResponse<UserResponse>> getUserByEmail(String email){
		ResponseEntity <ServiceResponse<UserResponse>> prepareResponse= null;
		log.info("Obteniendo usuario");
		List<UserResponse> users= new ArrayList<UserResponse>();
		try {
			users=userdao.getUserByEmail(email);
			prepareResponse= this.prepareResponse(true, users, HttpStatus.OK, null);	
		}catch(DataAccessException exec) {
			log.error("Ocurrio un error");
			log.error(exec.getMessage());
			prepareResponse=this.prepareResponse(false, null, HttpStatus.BAD_REQUEST, "Error de datos");
		}
		if(users.isEmpty()) {
			prepareResponse=this.prepareResponse(false, null, HttpStatus.OK, "No existe el usuario");
		}
		
		return prepareResponse;
	}
	
	
	
	/**
	 * Metodo para insertar usuario
	 * @param user
	 * @return 
	 */
	public ResponseEntity<ServiceResponse> createUser(User user) {	
		log.info("Creando usuario..");
		ResponseEntity<ServiceResponse> response = null;
		UserResponse createdUser = null;
		ServiceResponse isvalid = this.isvalid(user);
		if(isvalid.isExitoso()) {
			try {
				 createdUser = userdao.createUser(user);
			}
			catch(DataAccessException | NullPointerException exce) {
				log.error("Ocurrio un error");
				log.error(exce.getMessage());
				response=this.prepareResponse(false, null, HttpStatus.BAD_REQUEST, "Error de base datos");
			}
			if(createdUser!=null) {
				response=this.prepareResponse(true, createdUser, HttpStatus.OK, null);
			}
		}
		else {	
			response=this.prepareResponse(false,null,HttpStatus.BAD_REQUEST,isvalid.getServiceErrors().getErrors().get(0).getMessage());
		}
		return  response;
	}
	
	
	public ResponseEntity prepareResponse(Boolean exitoso,Object respuesta, HttpStatus status,String errormsg){
		ServiceResponse service = new ServiceResponse();
		List<ServiceError> list= new ArrayList<>();
		ServiceErrors errors = new ServiceErrors();
		ServiceError error = new ServiceError();
		error.setMessage(errormsg);
		list.add(error);
		errors.setErrors(list);
		service.setServiceErrors(errors);
		service.setExitoso(exitoso);
		service.setRespuesta(respuesta);
		return new ResponseEntity<>(service,status);
	}
	
	public ServiceErrors crea_error(List<ServiceError> list, String message){
		ServiceErrors errors = new ServiceErrors();
		ServiceError error = new ServiceError();
		error.setMessage(message);
		list.add(error);
		errors.setErrors(list);
		return errors;
	}
	
	
	
	public ServiceResponse isvalid(User request) {
		List<ServiceError> listerr= new ArrayList<>();
		ServiceResponse service = new ServiceResponse<UserResponse>();
		String[] userexist = userdao.userexist(request);
		if(!Boolean.parseBoolean(userexist[0])&& this.validrequest(request)) {
			service.setExitoso(true);
		}
		else {
			if(Boolean.parseBoolean(userexist[0])) {
				log.error(String.valueOf(userexist[1]));
				ServiceErrors errors = this.crea_error(listerr,userexist[1]);
				service.setExitoso(false);
				service.setServiceErrors(errors);
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
	
	public Boolean validrequest(User request) {
		boolean valid=false;
		if(request.getName()!=null && request.getEmail()!=null && request.getPass()!=null) {
			valid=true;
		}
		return valid;
	}
	
	
	
}
