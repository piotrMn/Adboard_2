package com.universe.app.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.universe.app.dao.Dao;


@Transactional(Transactional.TxType.SUPPORTS)
public abstract class AbstractDao<T, K extends Serializable> implements Dao<T, K> {

	@PersistenceContext
	protected EntityManager em;

	private Class<T> domainClass;

	@Override
	public T save(T entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public T findOne(K id) {
		return em.find(getDomainClass(), id);
	}

	@Override
	public List<T> findAll() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(getDomainClass());
		Root<T> root = query.from(getDomainClass());
		query.select(root);
		TypedQuery<T> typedQuery = em.createQuery(query);
		return typedQuery.getResultList();
	}

	@Override
	public T update(T entity) {
		return em.merge(entity);
	}

	@Override
	public void delete(T entity) {
		em.remove(entity);
	}

	@Override
	public void delete(K id) {
		T t = em.find(domainClass, id);
		em.remove(t);
	}

	@Override
	public void deleteAll() {
		em.createQuery("delete from " + getDomainClass().getName()).executeUpdate();
	}

	@Override
	public boolean exists(K id) {
		return em.find(domainClass, id) != null;
	}
	
    @SuppressWarnings("unchecked")
	protected Class<T> getDomainClass() {
        if (domainClass == null) {
            ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
            domainClass = (Class<T>) type.getActualTypeArguments()[0];
        }
        return domainClass;
    }

}
