package com.habits.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habits.dao.CategoriesDao;
import com.habits.dao.HabitsDao;
import com.habits.model.Categorie;
import com.habits.service.CategoriesService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping(path="/categories",produces= MediaType.APPLICATION_JSON_VALUE)
@RestController
@Slf4j
public class CategoriesController {
	
	@Autowired
	private CategoriesService catService;
	
	@PostMapping("/create")
	public void createCategory(@RequestBody Categorie cat) {
		log.info(cat.getName());
		log.info(cat.getDescription());
		catService.createCategory(cat);
	}
	
	
	@GetMapping("/list")
	public List<Categorie> getCategorias() {
		List<Categorie> categorias = new ArrayList<Categorie>();
		categorias = catService.getCategorias();
		return categorias;
	}

}
