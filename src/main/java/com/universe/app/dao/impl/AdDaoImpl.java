package com.universe.app.dao.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.universe.app.dao.AdDao;
import com.universe.app.domain.AdEntity;
import com.universe.app.domain.CategoryEntity;
import com.universe.app.domain.UserEntity;

@Repository
public class AdDaoImpl extends AbstractDao<AdEntity, Long> implements AdDao {

	@Override
	public AdEntity addAd(AdEntity ad) {
		return save(ad);
	}

	@Override
	public AdEntity assignToUserAndSave(AdEntity ad, UserEntity user) {
		ad.setUser(user);
		user.getAds().add(ad);
		return updateAd(ad);
	}

	@Override
	public List<AdEntity> findCurrentAds() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AdEntity> cq = cb.createQuery(AdEntity.class);
		Root<AdEntity> ad = cq.from(AdEntity.class);
		cq.select(ad).where(cb.greaterThan(ad.get("expiryDate"), LocalDateTime.now()))
				.orderBy(cb.desc(ad.get("createdDate")));
		return em.createQuery(cq).getResultList();
	}

	@Override
	public List<AdEntity> findByUserName(String username) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AdEntity> cq = cb.createQuery(AdEntity.class);
		Root<AdEntity> ad = cq.from(AdEntity.class);
		cq.select(ad).where(cb.equal(ad.get("user").get("username"), username)).orderBy(cb.desc(ad.get("createdDate")));
		return em.createQuery(cq).getResultList();
	}

	@Override
	public List<AdEntity> findByCategoryName(String category) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AdEntity> cq = cb.createQuery(AdEntity.class);
		Root<AdEntity> ad = cq.from(AdEntity.class);
		Join<AdEntity, CategoryEntity> join = ad.join("categories", JoinType.INNER);
		cq.select(ad).where(cb.equal(join.get("name"), category)).orderBy(cb.desc(ad.get("createdDate")));
		return em.createQuery(cq).getResultList();
	}

	@Override
	public AdEntity updateAd(AdEntity ad) {
		return update(ad);
	}

	@Override
	public void deleteAd(AdEntity ad) {
		delete(ad);
	}

	@Override
	public void deleteAd(Long id) {
		delete(id);
	}


}
