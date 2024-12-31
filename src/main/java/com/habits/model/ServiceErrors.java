package com.habits.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ServiceErrors implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ServiceError> errors;
	
	/**
	 * Constructor por defecto
	 */
	public ServiceErrors() {
		this.errors=new ArrayList<>();
	}
	
	public ServiceErrors(final ServiceError error) {
		this.errors=new ArrayList<>();
		this.errors.add(error);
	}
	
	public void add(final ServiceError error) {
		this.errors.add(error);
	}
	
	public void add(final List<ServiceError> errors) {
		this.errors.addAll(errors);
	}
	
	public ServiceErrors cargaError(String codError,String mensaje) {
		ServiceError err= new ServiceError();
		err.setCode(codError);
		err.setMessage(mensaje);
		this.errors.add(err);
		return this;
	}
	
	public void cargaErrores(ServiceErrors fallas) {
		if(fallas!=null&& fallas.errors!=null && !fallas.errors.isEmpty()) {
			this.errors.addAll(fallas.errors);
			
		}
		
	}
	
	
	
	
	
}
