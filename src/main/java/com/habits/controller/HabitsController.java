package com.habits.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habits.service.HabitsService;

import lombok.extern.slf4j.Slf4j;

import com.habits.dao.HabitsDao;
import com.habits.model.Categorie;
import com.habits.model.Habit;
import com.habits.model.HabitRequest;
import com.habits.model.HabitResponse;

@RestController
@Slf4j
@RequestMapping(path="/habits",produces= MediaType.APPLICATION_JSON_VALUE)
public class HabitsController {
	
	@Autowired
	private HabitsService habservice;
	
	@GetMapping("list")
	public ResponseEntity<List<Habit>> getHabits(){
		List<Habit> habits = habservice.getHabits();
		return new ResponseEntity<List<Habit>>(habits,HttpStatus.OK);
	}
	
	
	@PostMapping("/createhabit")
	public ResponseEntity<HabitResponse> createHabit(@RequestBody HabitRequest habit) {
		ResponseEntity<HabitResponse> createHabit = habservice.createHabit(habit);
		return createHabit;
	}
	
	
	

}
