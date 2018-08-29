package com.universe.app.transfer;

import java.time.LocalDateTime;

public class CommentDTO {

	private Long id;
	private Long adId;
	private String message;
	private LocalDateTime createdDate;

	public CommentDTO(Long id, Long adId, String message, LocalDateTime createdDate) {
		this.id = id;
		this.adId = adId;
		this.message = message;
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAdId() {
		return adId;
	}

	public void setAdId(Long adId) {
		this.adId = adId;
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

	public static final class CommentDTOBuilder {
		private Long id;
		private Long adId;
		private String message;
		private LocalDateTime createdDate;

		public CommentDTOBuilder withId(Long id) {
			this.id = id;
			return this;
		}

		public CommentDTOBuilder withAdId(Long adId) {
			this.adId = adId;
			return this;
		}

		public CommentDTOBuilder withMessage(String message) {
			this.message = message;
			return this;
		}

		public CommentDTOBuilder withCreatedDate(LocalDateTime createdDate) {
			this.createdDate = createdDate;
			return this;
		}

		public CommentDTO build() {
			return new CommentDTO(id, adId, message, createdDate);
		}
	}
}
