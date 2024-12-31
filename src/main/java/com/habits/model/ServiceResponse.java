package com.habits.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServiceResponse<T> implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean exitoso;
	
	private T respuesta;
	
	private ServiceErrors serviceErrors;
	
	public ServiceResponse() {
		this.serviceErrors=new ServiceErrors();
		this.exitoso=false;
	}
	
	public void ServiceResponse(String error, String mensaje) {
		if(this.serviceErrors==null) {
			this.serviceErrors= new ServiceErrors();
		}
		this.serviceErrors.cargaError(error, mensaje);
	}
	
	public void ServiceResponse(ServiceErrors serviceErrors) {
		if(this.serviceErrors==null) {
			this.serviceErrors= new ServiceErrors();
		}
		this.serviceErrors.cargaErrores(serviceErrors);
	}
	
	public void ServiceResponse(ServiceError serviceError) {
		if(this.serviceErrors==null) {
			this.serviceErrors= new ServiceErrors();
		}
		this.serviceErrors.add(serviceError);
	}
	
	
	
}
