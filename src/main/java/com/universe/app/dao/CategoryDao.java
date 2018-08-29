package com.universe.app.dao;


import java.util.List;

import com.universe.app.domain.CategoryEntity;

public interface CategoryDao extends Dao<CategoryEntity, Long> {
	
	CategoryEntity addCategory(CategoryEntity category);
	
	List<CategoryEntity> findAlphabetically();
	
	CategoryEntity updateCategory(CategoryEntity category);
	
	void deleteCategory(CategoryEntity category);
	
	void deleteCategory(Long id);

}
