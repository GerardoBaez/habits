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
public class Goal implements Serializable {
	private Integer id_goal;
	private Integer id_habit;
	private String name;
	private String description;
	private Date start;
	private Date end;
	
	
}
