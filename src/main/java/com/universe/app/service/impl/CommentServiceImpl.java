package com.universe.app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universe.app.dao.CommentDao;
import com.universe.app.domain.CommentEntity;
import com.universe.app.mapper.CommentMapper;
import com.universe.app.service.CommentService;
import com.universe.app.transfer.CommentDTO;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao commentDao;

	@Override
	public CommentDTO addComment(CommentDTO comment) {
		CommentEntity commentEntity = commentDao.addComment(CommentMapper.toCommentEntity(comment));
		return CommentMapper.toCommentDTO(commentEntity);
	}

	@Override
	public List<CommentDTO> findByAdId(Long id) {
		return commentDao.findByAdId(id).stream().map(CommentMapper::toCommentDTO).collect(Collectors.toList());
	}

	@Override
	public List<CommentDTO> findByUserName(String username) {
		return commentDao.findByUserName(username).stream().map(CommentMapper::toCommentDTO).collect(Collectors.toList());
	}

	@Override
	public CommentDTO updateComment(CommentDTO comment) {
		CommentEntity commentEntity = commentDao.updateComment(CommentMapper.toCommentEntity(comment));
		return CommentMapper.toCommentDTO(commentEntity);
	}

	@Override
	public void deleteComment(CommentDTO comment) {
		commentDao.deleteComment(CommentMapper.toCommentEntity(comment));
	}

	@Override
	public void deleteComment(Long id) {
		commentDao.deleteComment(id);
	}

}
