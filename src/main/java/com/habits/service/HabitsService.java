package com.habits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.habits.dao.HabitsDao;
import com.habits.model.Habit;
import com.habits.model.HabitRequest;
import com.habits.model.HabitResponse;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HabitsService implements IHabitsService {
	
	@Autowired
	private HabitsDao habitsDao;
	
	
	public List<Habit> getHabits(){
		log.info("Obteniendo habitos");
		List<Habit> habits = habitsDao.getHabits();
		return habits;
	}
	
	/***
	 * Metodo para crear un habito
	 * @param request
	 * @return 
	 * @return
	 */
	public ResponseEntity<HabitResponse>  createHabit(HabitRequest habit) {
		HabitResponse response = new HabitResponse();
		if(habit.getName()==null || habit.getId_cat_category()==null || habit.getId_cat_priority()==null) {
			log.info("No estan informados los campos necesarios para crear un habito");
			response.setMessage("No estan informados los campos necesarios para crear un habito");
			return new ResponseEntity<HabitResponse>(response, HttpStatus.BAD_REQUEST);
		}
		else {
			int createHabit = habitsDao.createHabit(habit);
			if(createHabit>=1) {
				log.info("Se creo habito exitosamente");
				response.setMessage("Se creo el habito correctamente");
				return new ResponseEntity<HabitResponse>(response,HttpStatus.OK);
			}
			else {
				log.info("Hubo algun errro al crear el habito");
				response.setMessage("Hubo algun errro al crear el habito");
				return new ResponseEntity<HabitResponse>(response,HttpStatus.BAD_REQUEST);
			}
		}
		
	}

}
