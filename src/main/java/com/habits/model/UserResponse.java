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
public class UserResponse implements Serializable  {
	public String name;
	public String email;
	public Date created_at;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
