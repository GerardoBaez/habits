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
public class HabitRequest implements Serializable {
	
    private String name;
	private String description;
	private Integer id_meta;
	private Date fch_creacion;
	private Date fch_modif;	
	private Integer id_user;
	private Integer id_cat_priority;
	private Integer id_cat_category;

}
