package com.habits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habits.dao.GoalsDao;
import com.habits.model.Goal;

@Service 
public class GoalsService {
	
	@Autowired
	private GoalsDao godao;

	public void createGoal(Goal goal) {
		godao.createGoal(goal);
	}
	
	public List<Goal> getGoals() {
		List<Goal> goals = godao.getGoals();
		return goals;
	}
	
}
