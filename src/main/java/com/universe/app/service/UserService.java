package com.universe.app.service;

import com.universe.app.domain.Role;
import com.universe.app.transfer.UserDTO;

public interface UserService {
	
	UserDTO saveUser(UserDTO user);
	
	UserDTO saveUserWithRole(UserDTO user, Role role);
	
	UserDTO findUser(Long id);

	UserDTO findUser(String username);
	
	UserDTO updateUser(UserDTO user);

	void deleteUser(Long id);

	void deleteUser(UserDTO user);

}
