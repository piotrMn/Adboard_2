package com.universe.app.transfer;

import java.util.List;

import com.universe.app.domain.AdEntity;

public class CategoryDTO {
	
	private Long id;
	private String name;
	private List<AdEntity> ads;
	
	public CategoryDTO(Long id, String name, List<AdEntity> ads) {
		this.id = id;
		this.name = name;
		this.ads = ads;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AdEntity> getAds() {
		return ads;
	}

	public void setAds(List<AdEntity> ads) {
		this.ads = ads;
	}
	
	public static final class CategoryDTOBuilder {
		private Long id;
		private String name;
		private List<AdEntity> ads;
		
		public CategoryDTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}
		
		public CategoryDTOBuilder withName(String name) {
			this.name = name;
			return this;
		}
		
		public CategoryDTOBuilder withAds(List<AdEntity> ads) {
			this.ads = ads;
			return this;
		}
		
		public CategoryDTO build() {
			return new CategoryDTO(id, name, ads);
		}
		
	}

}
