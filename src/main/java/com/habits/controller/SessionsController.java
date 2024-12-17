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
import com.habits.model.Sesion;
import com.habits.service.SessionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path="/sessions",produces= MediaType.APPLICATION_JSON_VALUE)
public class SessionsController {
	
	@Autowired
	private SessionService session;
	
	/**
	 * Metodo para crear sesiones
	 * @param sesion
	 */
	@PostMapping(value="create")
	public void createSession(@RequestBody Sesion sesion) {
		session.createSession(sesion);
	}
	
	/**
	 * Metodo para obtener las prioridades
	 * @return
	 */
	@GetMapping(value="list")
	public List<Sesion> getSessions() {
		List<Sesion> sessions = session.getSessions();
		return sessions;
	}
	
	

}
