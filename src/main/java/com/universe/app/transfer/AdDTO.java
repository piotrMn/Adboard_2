package com.universe.app.transfer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.universe.app.domain.CategoryEntity;
import com.universe.app.domain.CommentEntity;
import com.universe.app.domain.UserEntity;
import com.universe.app.mapper.UserMapper;

public class AdDTO {

	private Long id;
	private String title;
	private String description;
	private String location;
	private LocalDateTime createdDate;
	private LocalDateTime expiryDate;
	private BigDecimal price;
	private UserEntity user;
	private List<CommentEntity> comments = new ArrayList<>();
	private List<CategoryEntity> categories = new ArrayList<>();

	public AdDTO() {
	}

	public AdDTO(Long id, String title, String description, String location, LocalDateTime createdDate,
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
	
	public void setUser(UserDTO user) {
		this.user = UserMapper.toUserEntity(user);
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public List<CategoryEntity> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryEntity> categories) {
		this.categories = categories;
	}

	public static final class AdDTOBuilder {
		private Long id;
		private String title;
		private String description;
		private String location;
		private LocalDateTime createdDate;
		private LocalDateTime expiryDate;
		private BigDecimal price;
		private UserEntity user;
		private List<CommentEntity> comments;
		private List<CategoryEntity> categories;

		public AdDTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public AdDTOBuilder withTitle(String title) {
			this.title = title;
			return this;
		}

		public AdDTOBuilder withDescription(String description) {
			this.description = description;
			return this;
		}

		public AdDTOBuilder withLocation(String location) {
			this.location = location;
			return this;
		}

		public AdDTOBuilder withCreatedDate(LocalDateTime createdDate) {
			this.createdDate = createdDate;
			return this;
		}

		public AdDTOBuilder withExpiryDate(LocalDateTime expiryDate) {
			this.expiryDate = expiryDate;
			return this;
		}

		public AdDTOBuilder withPrice(BigDecimal price) {
			this.price = price;
			return this;
		}

		public AdDTOBuilder withUser(UserEntity user) {
			this.user = user;
			return this;
		}

		public AdDTOBuilder withComments(List<CommentEntity> comments) {
			this.comments = comments;
			return this;
		}

		public AdDTOBuilder withCategories(List<CategoryEntity> categories) {
			this.categories = categories;
			return this;
		}

		public AdDTO build() {
			return new AdDTO(id, title, description, location, createdDate, expiryDate, price, user, comments,
					categories);
		}

	}

}
