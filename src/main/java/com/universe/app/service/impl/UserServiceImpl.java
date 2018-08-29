package com.universe.app.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universe.app.dao.UserDao;
import com.universe.app.domain.Role;
import com.universe.app.domain.UserEntity;
import com.universe.app.mapper.UserMapper;
import com.universe.app.service.UserService;
import com.universe.app.transfer.UserDTO;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDTO saveUser(UserDTO user) {
		UserEntity userEntity = userDao.saveUser(UserMapper.toUserEntity(user));
		return UserMapper.toUserDTO(userEntity);
	}
	
	@Override
	public UserDTO saveUserWithRole(UserDTO user, Role role) {
		UserEntity userEntity = UserMapper.toUserEntity(user);
		return UserMapper.toUserDTO(userDao.saveUserWithRole(userEntity, role));
	}

	@Override
	public UserDTO findUser(String username) {
		return UserMapper.toUserDTO(userDao.findUser(username));
	}
	
	@Override
	public UserDTO updateUser(UserDTO user) {
		UserEntity userEntity = userDao.updateUser(UserMapper.toUserEntity(user));
		return UserMapper.toUserDTO(userEntity);
	}

	@Override
	public void deleteUser(Long id) {
		userDao.deleteUser(id);
	}

	@Override
	public void deleteUser(UserDTO user) {
		userDao.deleteUser(UserMapper.toUserEntity(user));
	}

	@Override
	public UserDTO findUser(Long id) {
		return null;
	}


}
