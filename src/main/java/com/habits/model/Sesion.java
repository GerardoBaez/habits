package com.habits.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Sesion implements Serializable {
	
	private Integer id_session;
	private Integer id_habit;
	private Date hora_ini;
	private Date hora_fin;
	private String coment;
	private Boolean isSuccesful;
}
