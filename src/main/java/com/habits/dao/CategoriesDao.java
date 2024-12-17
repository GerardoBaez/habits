package com.habits.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.habits.config.HabitsConfig;
import com.habits.mapper.CategoriesMapper;
import com.habits.model.Categorie;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class CategoriesDao implements ICategoriesDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private HabitsConfig config;
	
	
	/**
	 * Metodo para crear una categoria
	 * @param catrequest
	 */
	public void createCategory(Categorie catrequest) {
		Object[] params= {catrequest.getName(),catrequest.getDescription()};
		int result = jdbcTemplate.update(config.getInsertcat(),params);
		if(result>0) {
			log.info("INSERT EXITOSO...");
		}
	}
	
	public List<Categorie> getcategory() {
		List<Categorie> categorias = new ArrayList<Categorie>();
		log.info(config.getCategories().get("list"));
		categorias=jdbcTemplate.query(config.getCategorias(), new CategoriesMapper());
		return categorias;
	}
}
