package com.habits.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Habit implements Serializable {
	
	private Integer id_habit;
		
	private Integer id_user;

	private String name;
	
	private Integer id_cat_category;
	
	private String description;
	
    private Date created_at;

	private Date modified_at;
	
	private Date last_day;
		
	private Integer total_days;

	private Integer id_cat_priority;
}
