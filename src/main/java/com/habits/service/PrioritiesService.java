package com.habits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habits.dao.PrioritiesDao;
import com.habits.model.Priority;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PrioritiesService {
	@Autowired
	private PrioritiesDao pDao;
	/**
	 * Metodo para obtener las prioridades
	 * @return
	 */
	public List<Priority> getPriorities() {
		List<Priority> priorities = pDao.getPriorities();
		return priorities;
	}
	
	/**
	 * Metodo para crear una prioridad
	 */
	public void createPriority(Priority pri) {
		pDao.createPriority(pri);
	}
	
}
