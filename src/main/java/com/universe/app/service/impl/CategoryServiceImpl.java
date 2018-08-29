package com.universe.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universe.app.dao.CategoryDao;
import com.universe.app.domain.CategoryEntity;
import com.universe.app.mapper.CategoryMapper;
import com.universe.app.service.CategoryService;
import com.universe.app.transfer.CategoryDTO;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public CategoryDTO addCategory(CategoryDTO category) {
		CategoryEntity categoryEntity = categoryDao.addCategory(CategoryMapper.toCategoryEntity(category));
		return CategoryMapper.toCategoryDTO(categoryEntity);
	}

	@Override
	public List<CategoryDTO> findAlphabetically() {
		return categoryDao.findAlphabetically().stream().map(CategoryMapper::toCategoryDTO).collect(Collectors.toList());
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO category) {
		CategoryEntity categoryEntity = categoryDao.update(CategoryMapper.toCategoryEntity(category));
		return CategoryMapper.toCategoryDTO(categoryEntity);
	}

	@Override
	public void deleteCategory(CategoryDTO category) {
		categoryDao.deleteCategory(CategoryMapper.toCategoryEntity(category));
	}

	@Override
	public void deleteCategory(Long id) {
		categoryDao.deleteCategory(id);
	}

}
