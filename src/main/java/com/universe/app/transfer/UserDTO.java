package com.universe.app.transfer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.universe.app.domain.AdEntity;
import com.universe.app.domain.Authority;
import com.universe.app.domain.CommentEntity;
import com.universe.app.domain.UserEntity;

public class UserDTO {

	private Long id;
	private String username;
	private String fullname;
	private String password;
	private String phone;
	private String email;
	private boolean enabled;
	private LocalDateTime signupDate;
	private List<Authority> authorities = new ArrayList<>();
	private List<AdEntity> ads = new ArrayList<>();
	private List<CommentEntity> comments = new ArrayList<>();

	public UserDTO() {
	}

	public UserDTO(Long id, String username, String fullname, String password, String phone, String email,
			boolean enabled, LocalDateTime signupDate, List<Authority> authorities, List<AdEntity> ads,
			List<CommentEntity> comments) {
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.enabled = enabled;
		this.signupDate = signupDate;
		this.authorities = authorities;
		this.ads = ads;
		this.comments = comments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LocalDateTime getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(LocalDateTime signupDate) {
		this.signupDate = signupDate;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public List<AdEntity> getAds() {
		return ads;
	}

	public void setAds(List<AdEntity> ads) {
		this.ads = ads;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public static final class UserDTOBuilder {

		private Long id;
		private String username;
		private String fullname;
		private String password;
		private String phone;
		private String email;
		private boolean enabled;
		private LocalDateTime signupDate;
		private List<Authority> authorities;
		private List<AdEntity> ads;
		private List<CommentEntity> comments;
		
		public UserDTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public UserDTOBuilder withUsername(String username) {
			this.username = username;
			return this;
		}

		public UserDTOBuilder withFullname(String fullname) {
			this.fullname = fullname;
			return this;
		}

		public UserDTOBuilder withPassword(String password) {
			this.password = password;
			return this;
		}

		public UserDTOBuilder withPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public UserDTOBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public UserDTOBuilder withEnabled(boolean enabled) {
			this.enabled = enabled;
			return this;
		}

		public UserDTOBuilder withSignupDate(LocalDateTime signupDate) {
			this.signupDate = signupDate;
			return this;
		}

		public UserDTOBuilder withAuthorities(List<Authority> authorities) {
			this.authorities = authorities;
			return this;
		}

		public UserDTOBuilder withAds(List<AdEntity> ads) {
			this.ads = ads;
			return this;
		}

		public UserDTOBuilder withComments(List<CommentEntity> comments) {
			this.comments = comments;
			return this;
		}

		public UserDTO build() {
			return new UserDTO(id, username, fullname, password, phone, email, enabled, signupDate, authorities, ads,
					comments);
		}

	}

}
