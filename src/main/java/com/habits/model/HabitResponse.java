package com.habits.model;

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
public class HabitResponse {
	private String name;
	private String message;
	private Date fch_creacion;
}
