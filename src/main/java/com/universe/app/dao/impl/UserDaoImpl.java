package com.universe.app.dao.impl;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.universe.app.dao.UserDao;
import com.universe.app.domain.Authority;
import com.universe.app.domain.Role;
import com.universe.app.domain.UserEntity;

@Repository
public class UserDaoImpl extends AbstractDao<UserEntity, Long> implements UserDao {

	@Override
	public UserEntity saveUser(UserEntity user) {
		return save(user);
	}

	@Override
	public UserEntity saveUserWithRole(UserEntity user, Role role) {
		if (user.getAuthorities() == null) {
			user.setAuthorities(new ArrayList<>());
		}
		user.getAuthorities().clear();
		user.getAuthorities().add(new Authority(user.getUsername(), role));
		return save(user);
	}

	@Override
	public UserEntity findUser(Long id) {
		return findOne(id);
	}

	@Override
	public UserEntity findUser(String username) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
		Root<UserEntity> user = cq.from(UserEntity.class);
		cq.select(user).where(cb.equal(user.get("username"), username));
		return em.createQuery(cq).getSingleResult();
	}

	@Override
	public void deleteUser(UserEntity user) {
		delete(user);
	}
	
	@Override
	public void deleteUser(Long id) {
		delete(id);
	}

	@Override
	public UserEntity updateUser(UserEntity user) {
		return update(user);
	}

}
