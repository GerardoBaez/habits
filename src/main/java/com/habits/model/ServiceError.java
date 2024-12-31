package com.habits.model;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ServiceError implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	
	private String message;
	
	private String level ;
	
	private String description;
	
	private String moreInfo;
	
	private ServiceError(String code, String message) {
		this.code=code;
		this.message=message;
	}
	
	private ServiceError(String code, String message,String level) {
		this.code=code;
		this.message=message;
		this.level=level;
	}
	
	private ServiceError(String code, String message,String level,String description , String moreInfo) {
		this.code=code;
		this.message=message;
		this.level=level;
		this.description=description;
		this.moreInfo=moreInfo;
	}
	
}
