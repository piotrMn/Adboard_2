package com.universe.app.dao;

import java.util.List;

import com.universe.app.domain.AdEntity;
import com.universe.app.domain.UserEntity;

public interface AdDao extends Dao<AdEntity, Long> {
	
	AdEntity addAd(AdEntity ad);
	
	AdEntity assignToUserAndSave(AdEntity ad, UserEntity user);
	
	List<AdEntity> findCurrentAds();
	
	List<AdEntity> findByUserName(String username);
	
	List<AdEntity> findByCategoryName(String category);
	
	AdEntity updateAd(AdEntity ad);
	
	void deleteAd(AdEntity ad);
	
	void deleteAd(Long id);

}
