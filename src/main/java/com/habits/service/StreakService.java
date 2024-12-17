package com.habits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.habits.dao.StreakDao;
import com.habits.model.Streak;

@Service
public class StreakService {
	
	@Autowired
	private StreakDao streakdao;
	
	public List<Streak>getStreaks(){
		List<Streak> streaks = streakdao.getStreaks();
		return streaks;
	}
	
	public void createStreak(Streak streak) {
		streakdao.createStreak(streak);
	}

}
