package com.habits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habits.dao.SessionsDao;
import com.habits.model.Sesion;

@Service
public class SessionService {
	
	@Autowired
	private SessionsDao sessiondao;
	
	
	public List<Sesion> getSessions() {
		List<Sesion> sessions = sessiondao.getSessions();
		return sessions;
	}
	
	public void createSession(Sesion sesion) {
		sessiondao.createSession(sesion);
	}

}
