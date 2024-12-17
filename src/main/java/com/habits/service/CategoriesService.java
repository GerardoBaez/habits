package com.habits.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habits.dao.CategoriesDao;
import com.habits.model.Categorie;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoriesService {
	
	@Autowired
	private CategoriesDao catDao;
	
	
	/**
	 * Metodo para crear una categoria 
	 */
	public void createCategory(Categorie catrequest) {
		log.info("Creando categoria.....");
		catDao.createCategory(catrequest);
	}
	
	/**
	 * Metodo para obtener las categorias existentes
	 * @return
	 */
	public List<Categorie> getCategorias() {
		log.info("Obteniendo categorias.....");
		List<Categorie> categorias = new ArrayList<Categorie>();
		categorias = catDao.getcategory();
		return categorias;
	}

}
