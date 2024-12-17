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
public class Bitacora implements Serializable  {
	private Integer id_bitacora;
	private Integer id_sesion;
	private Date fecha;
	private Boolean exitoso;

}
