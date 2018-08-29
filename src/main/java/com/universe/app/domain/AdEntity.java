package com.universe.app.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "ad")
public class AdEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 50)
	private String title;

	@Column(nullable = false, columnDefinition = "MEDIUMTEXT")
	private String description;

	@Column(nullable = false, length = 50)
	private String location;

	@CreationTimestamp
	private LocalDateTime createdDate;

	private LocalDateTime expiryDate;

	private BigDecimal price;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@OneToMany(mappedBy = "ad")
	private List<CommentEntity> comments = new ArrayList<>();

	@ManyToMany(mappedBy = "ads")
	private List<CategoryEntity> categories = new ArrayList<>();

	public AdEntity() {
	}

	public AdEntity(Long id, String title, String description, String location, LocalDateTime createdDate,
			LocalDateTime expiryDate, BigDecimal price, UserEntity user, List<CommentEntity> comments,
			List<CategoryEntity> categories) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
		this.createdDate = createdDate;
		this.expiryDate = expiryDate;
		this.price = price;
		this.user = user;
		this.comments = comments;
		this.categories = categories;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<CommentEntity> getComments() {
		if (comments == null) {
			comments = new ArrayList<>();
		}
		return comments;
	}

	public void setCategories(List<CategoryEntity> categories) {
		this.categories = categories;
	}

	public List<CategoryEntity> getCategories() {
		if (categories == null) {
			categories = new ArrayList<>();
		}
		return categories;
	}
	
	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

}
