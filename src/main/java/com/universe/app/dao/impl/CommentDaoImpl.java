package com.universe.app.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.universe.app.dao.CommentDao;
import com.universe.app.domain.AdEntity;
import com.universe.app.domain.CommentEntity;

@Repository
public class CommentDaoImpl extends AbstractDao<CommentEntity, Long> implements CommentDao {

	@Override
	public CommentEntity addComment(CommentEntity comment) {
		return save(comment);
	}
	
	@Override
	public CommentEntity assignToAdAndSave(CommentEntity comment, AdEntity ad) {
		return null;
	}


	@Override
	public List<CommentEntity> findByAdId(Long id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CommentEntity> cq = cb.createQuery(CommentEntity.class);
		Root<CommentEntity> comment = cq.from(CommentEntity.class);
		cq.select(comment).where(cb.equal(comment.get("ad").get("id"), id));
		return em.createQuery(cq).getResultList();
	}

	@Override
	public List<CommentEntity> findByUserName(String username) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CommentEntity> cq = cb.createQuery(CommentEntity.class);
		Root<CommentEntity> comment = cq.from(CommentEntity.class);
		cq.select(comment).where(cb.equal(comment.get("user").get("username"), username));
		return em.createQuery(cq).getResultList();
	}

	@Override
	public CommentEntity updateComment(CommentEntity comment) {
		return update(comment);
	}

	@Override
	public void deleteComment(CommentEntity comment) {
		delete(comment);
	}

	@Override
	public void deleteComment(Long id) {
		delete(id);
	}


}
