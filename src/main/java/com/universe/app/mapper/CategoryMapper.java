package com.universe.app.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.universe.app.domain.CategoryEntity;
import com.universe.app.transfer.CategoryDTO;

public class CategoryMapper {
	
	public static CategoryDTO toCategoryDTO(CategoryEntity category) {
		CategoryDTO.CategoryDTOBuilder builder = new CategoryDTO.CategoryDTOBuilder();
		return builder
				.withId(category.getId())
				.withName(category.getName())
				.withAds(category.getAds())
				.build();
		
	}
	
	public static CategoryEntity toCategoryEntity (CategoryDTO category) {
		return new CategoryEntity(category.getId(), category.getName(), category.getAds());
	}
	
	public static List<CategoryDTO> mapToCategoryDTO(List<CategoryEntity> categories) {
		return categories.stream().map(CategoryMapper::toCategoryDTO).collect(Collectors.toList());
	}
	
	public static List<CategoryEntity> mapToCategoryEntity(List<CategoryDTO> categories) {
		return categories.stream().map(CategoryMapper::toCategoryEntity).collect(Collectors.toList());
	}

}
