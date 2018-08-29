package com.universe.app.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "comment")
public class CommentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private AdEntity ad;

	private String message;

	@CreationTimestamp
	private LocalDateTime createdDate;

	public CommentEntity() {
	}

	public CommentEntity(Long id, AdEntity ad, String message, LocalDateTime createdDate) {
		this.id = id;
		this.ad = ad;
		this.message = message;
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public AdEntity getAd() {
		return ad;
	}

	public void setAd(AdEntity ad) {
		this.ad = ad;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

}
