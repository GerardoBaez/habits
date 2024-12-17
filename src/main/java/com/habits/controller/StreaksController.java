package com.habits.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habits.model.Streak;
import com.habits.service.StreakService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path="/streaks",produces= MediaType.APPLICATION_JSON_VALUE)
public class StreaksController {
	
	@Autowired
	private StreakService streakservice;
	
	@GetMapping(value="list")
	public List<Streak>getStreaks(){
		List<Streak> streaks = streakservice.getStreaks();
		return streaks;
	} 
	
	@PostMapping(value="create")
	public void createStreak(@RequestBody Streak streak) {
		streakservice.createStreak(streak);
	}
	
}
