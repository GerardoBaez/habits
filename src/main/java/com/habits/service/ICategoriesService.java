package com.habits.service;

import java.util.List;

import com.habits.model.Categorie;

public interface ICategoriesService {
	
	public void createCategory(Categorie catrequest);
	public List<Categorie> getCategorias();

}
