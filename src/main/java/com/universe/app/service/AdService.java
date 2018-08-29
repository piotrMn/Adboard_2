package com.universe.app.service;

import java.util.List;

import com.universe.app.transfer.AdDTO;
import com.universe.app.transfer.UserDTO;

public interface AdService {
	
	AdDTO addAd(AdDTO ad);
	
	AdDTO assignToUserAndSave(AdDTO ad, UserDTO user);
	
	List<AdDTO> findCurrentAds();
	
	List<AdDTO> findByUserName(String username);
	
	List<AdDTO> findByCategoryName(String category);
	
	AdDTO updateAd(AdDTO ad);
	
	void deleteAd(AdDTO ad);
	
	void deleteAd(Long id);

}
