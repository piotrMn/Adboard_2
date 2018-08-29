package com.universe.app.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true, length = 50)
	private String name;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "ad_category", joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ad_id", referencedColumnName = "id"))
	private List<AdEntity> ads = new ArrayList<>();

	public CategoryEntity() {
	}

	public CategoryEntity(Long id, String name, List<AdEntity> ads) {
		this.id = id;
		this.name = name;
		this.ads = ads;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AdEntity> getAds() {
		if (ads == null) {
			ads = new ArrayList<>();
		}
		return ads;
	}

	public void setAds(List<AdEntity> ads) {
		this.ads = ads;
	}

}
