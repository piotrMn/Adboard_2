package com.universe.app.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.universe.app.domain.AdEntity;
import com.universe.app.transfer.AdDTO;

public class AdMapper {

	public static AdDTO toAdDTO(AdEntity ad) {
		AdDTO.AdDTOBuilder builder = new AdDTO.AdDTOBuilder();
		return builder.withId(ad.getId()).withTitle(ad.getTitle()).withDescription(ad.getDescription())
				.withLocation(ad.getLocation()).withCreatedDate(ad.getCreatedDate()).withExpiryDate(ad.getExpiryDate())
				.withPrice(ad.getPrice()).withUser(ad.getUser()).withComments(ad.getComments())
				.withCategories(ad.getCategories()).build();
	}

	public static AdEntity toAdEntity(AdDTO ad) {
		return new AdEntity(ad.getId(), ad.getTitle(), ad.getDescription(), ad.getLocation(), ad.getCreatedDate(),
				ad.getExpiryDate(), ad.getPrice(), ad.getUser(), ad.getComments(),
				ad.getCategories());
	}

	public static List<AdDTO> mapToAdDTO(List<AdEntity> ads) {
		return ads.stream().map(AdMapper::toAdDTO).collect(Collectors.toList());
	}

	public static List<AdEntity> mapToAdEntity(List<AdDTO> ads) {
		return ads.stream().map(AdMapper::toAdEntity).collect(Collectors.toList());
	}

}
