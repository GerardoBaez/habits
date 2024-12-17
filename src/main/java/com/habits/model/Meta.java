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
public class Meta implements Serializable {
	
	public Integer id_meta;
	public Integer id_habit;
	public String nombre;
	public String descripcion;
	public Date fch_ini;
	public Date fch_fin;

}
