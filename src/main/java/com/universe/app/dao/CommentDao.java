package com.universe.app.dao;

import java.util.List;

import com.universe.app.domain.AdEntity;
import com.universe.app.domain.CommentEntity;

public interface CommentDao extends Dao<CommentEntity, Long> {
	
	CommentEntity addComment(CommentEntity comment);
	
	CommentEntity assignToAdAndSave(CommentEntity comment, AdEntity ad);
	
	List<CommentEntity> findByAdId(Long id);
	
	List<CommentEntity> findByUserName(String username);
	
	CommentEntity updateComment(CommentEntity comment);
	
	void deleteComment(CommentEntity comment);
	
	void deleteComment(Long id);
	
}
