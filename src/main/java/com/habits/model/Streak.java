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
public class Streak implements Serializable {
	
	public Integer total_dias;
	public Date first_day; 
	public Date last_day;
	public Integer id_habito;
	
	
	
}
