package com.habits.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habits.model.Goal;
import com.habits.service.GoalsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path="/goals",produces= MediaType.APPLICATION_JSON_VALUE)
public class GoalsController {
	
	@Autowired
	private GoalsService goservice;
	
	@GetMapping("list")
	private List<Goal> getGoals() {
		List<Goal> goals = goservice.getGoals();
		return goals;
	}
	
	@PostMapping(value="create")
	private void createGoal(@RequestBody Goal goal) {
		goservice.createGoal(goal);
	}
}
