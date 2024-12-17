package com.habits.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habits.model.Priority;
import com.habits.service.PrioritiesService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping(path="/priorites",produces= MediaType.APPLICATION_JSON_VALUE)
@RestController
@Slf4j
public class PrioritiesController {
	
	@Autowired
	private PrioritiesService prio;
	
	
	@GetMapping(value="list")
	public List<Priority> getPriorities() {
		List<Priority> priorities = prio.getPriorities();
		return priorities;
	}
	
	/**
	 * Metodo para crear una prioridad
	 */
	@PostMapping(value="/create")
	public void createPriority(@RequestBody Priority pri ) {
		prio.createPriority(pri);
	}
}
