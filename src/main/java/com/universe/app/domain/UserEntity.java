package com.universe.app.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false, length = 50)
	private String username;

	@Column(nullable = false, length = 50)
	private String fullname;

	@Column(nullable = false)
	private String password;

	private String phone;

	private String email;

	private boolean enabled;

	@CreationTimestamp
	private LocalDateTime signupDate;

	@ElementCollection
	@CollectionTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"))
	private List<Authority> authorities = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<AdEntity> ads = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<CommentEntity> comments = new ArrayList<>();

	public UserEntity() {
	}

	public UserEntity(Long id, String username, String fullname, String password, String phone, String email,
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

	@PrePersist
	public void hashPassword() {
		this.password = "{bcrypt}" + BCrypt.hashpw(this.password, BCrypt.gensalt());
		this.enabled = true;
	}

	public Long getId() {
		return id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return String.format(
				"UserEntity [id=%s, username=%s, fullname=%s, password=%s, phone=%s, email=%s, enabled=%s, signupDate=%s]",
				id, username, fullname, password, phone, email, enabled, signupDate);
	}

}
