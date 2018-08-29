package com.universe.app.service;

import java.util.List;

import com.universe.app.transfer.CategoryDTO;

public interface CategoryService {
	
	CategoryDTO addCategory(CategoryDTO category);
	
	List<CategoryDTO> findAlphabetically();
	
	CategoryDTO updateCategory(CategoryDTO category);
	
	void deleteCategory(CategoryDTO category);
	
	void deleteCategory(Long id);

}
