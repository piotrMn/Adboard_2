package com.universe.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universe.app.dao.AdDao;
import com.universe.app.dao.UserDao;
import com.universe.app.domain.AdEntity;
import com.universe.app.domain.UserEntity;
import com.universe.app.mapper.AdMapper;
import com.universe.app.mapper.UserMapper;
import com.universe.app.service.AdService;
import com.universe.app.transfer.AdDTO;
import com.universe.app.transfer.UserDTO;

@Service
@Transactional
public class AdServiceImpl implements AdService {
	
	@Autowired
	private AdDao adDao;

	@Override
	public AdDTO addAd(AdDTO ad) {
		AdEntity adEntity = adDao.updateAd(AdMapper.toAdEntity(ad));
		return AdMapper.toAdDTO(adEntity);
	}
	
	@Override
	public AdDTO assignToUserAndSave(AdDTO ad, UserDTO user) {
		AdEntity adEntity = AdMapper.toAdEntity(ad);
		UserEntity userEntity = UserMapper.toUserEntity(user);
		return AdMapper.toAdDTO(adDao.assignToUserAndSave(adEntity, userEntity));
		
	}

	@Override
	public List<AdDTO> findCurrentAds() {
		return adDao.findCurrentAds().stream().map(AdMapper::toAdDTO).collect(Collectors.toList());
	}

	@Override
	public List<AdDTO> findByUserName(String username) {
		return adDao.findByUserName(username).stream().map(AdMapper::toAdDTO).collect(Collectors.toList());
	}

	@Override
	public List<AdDTO> findByCategoryName(String category) {
		return adDao.findByCategoryName(category).stream().map(AdMapper::toAdDTO).collect(Collectors.toList());
	}

	@Override
	public AdDTO updateAd(AdDTO ad) {
		AdEntity adEntity = adDao.updateAd(AdMapper.toAdEntity(ad));
		return AdMapper.toAdDTO(adEntity);
	}

	@Override
	public void deleteAd(AdDTO ad) {
		adDao.deleteAd(AdMapper.toAdEntity(ad));
	}

	@Override
	public void deleteAd(Long id) {
		adDao.deleteAd(id);
	}

}
