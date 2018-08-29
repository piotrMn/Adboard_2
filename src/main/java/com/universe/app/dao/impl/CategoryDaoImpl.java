package com.universe.app.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.universe.app.dao.CategoryDao;
import com.universe.app.domain.CategoryEntity;

@Repository
public class CategoryDaoImpl extends AbstractDao<CategoryEntity, Long> implements CategoryDao {

	@Override
	public CategoryEntity addCategory(CategoryEntity category) {
		return save(category);
	}
	
	@Override
	public List<CategoryEntity> findAlphabetically() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CategoryEntity> cq = cb.createQuery(CategoryEntity.class);
		Root<CategoryEntity> category = cq.from(CategoryEntity.class);
		cq.select(category).orderBy(cb.asc(category.get("name")));
		return em.createQuery(cq).getResultList();
	}

	@Override
	public CategoryEntity updateCategory(CategoryEntity category) {
		return update(category);
	}

	@Override
	public void deleteCategory(CategoryEntity category) {
		delete(category);
	}

	@Override
	public void deleteCategory(Long id) {
		delete(id);
	}

}
