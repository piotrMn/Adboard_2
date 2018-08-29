package com.universe.app.service;

import java.util.List;

import com.universe.app.transfer.CommentDTO;

public interface CommentService {
	
	CommentDTO addComment(CommentDTO comment);
	
	List<CommentDTO> findByAdId(Long id);
	
	List<CommentDTO> findByUserName(String username);
	
	CommentDTO updateComment(CommentDTO comment);
	
	void deleteComment(CommentDTO comment);
	
	void deleteComment(Long id);

}
