package com.universe.app.dao;

import com.universe.app.domain.Role;
import com.universe.app.domain.UserEntity;

public interface UserDao extends Dao<UserEntity, Long> {

	UserEntity saveUser(UserEntity user);
	
	UserEntity saveUserWithRole(UserEntity user, Role role);

	UserEntity findUser(Long id);
	
	UserEntity findUser(String username);

	UserEntity updateUser(UserEntity user);

	void deleteUser(Long id);

	void deleteUser(UserEntity user);

}
