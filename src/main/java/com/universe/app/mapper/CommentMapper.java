package com.universe.app.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.universe.app.dao.AdDao;
import com.universe.app.dao.UserDao;
import com.universe.app.domain.CommentEntity;
import com.universe.app.transfer.CommentDTO;

public class CommentMapper {
	
	@Autowired
	private static AdDao adDao;
	
	public static CommentDTO toCommentDTO(CommentEntity comment) {
		CommentDTO.CommentDTOBuilder builder = new CommentDTO.CommentDTOBuilder();
		return builder
				.withId(comment.getId())
				.withMessage(comment.getMessage())
				.withCreatedDate(comment.getCreatedDate())
				.withAdId(comment.getAd().getId())
				.build();
	}
	
	public static CommentEntity toCommentEntity(CommentDTO comment) {
		return new CommentEntity(comment.getId(), adDao.findOne(comment.getAdId()), comment.getMessage(), comment.getCreatedDate());
	}
	
	public static List<CommentDTO> mapToCommentDTO(List<CommentEntity> comments) {
		if (comments == null) {
			return null;
		}
		return comments.stream().map(CommentMapper::toCommentDTO).collect(Collectors.toList());
	}
	
	public static List<CommentEntity> mapTOCommentEntity(List<CommentDTO> comments) {
		if (comments == null) {
			return null;
		}
		return comments.stream().map(CommentMapper::toCommentEntity).collect(Collectors.toList());
	}

}
