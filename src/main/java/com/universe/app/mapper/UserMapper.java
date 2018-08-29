package com.universe.app.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.universe.app.domain.UserEntity;
import com.universe.app.transfer.UserDTO;

public class UserMapper {

	public static UserDTO toUserDTO(UserEntity user) {
		UserDTO.UserDTOBuilder builder = new UserDTO.UserDTOBuilder();
		return builder.withId(user.getId()).withUsername(user.getUsername()).withFullname(user.getFullname())
				.withPassword(user.getPassword()).withPhone(user.getPhone()).withEmail(user.getEmail())
				.withEnabled(user.isEnabled()).withSignupDate(user.getSignupDate())
				.withAuthorities(user.getAuthorities()).withAds(user.getAds()).withComments(user.getComments()).build();
	}

	public static UserEntity toUserEntity(UserDTO user) {
		return new UserEntity(user.getId(), user.getUsername(), user.getFullname(), user.getPassword(), user.getPhone(),
				user.getEmail(), user.isEnabled(), user.getSignupDate(), user.getAuthorities(), user.getAds(),
				user.getComments());
	}

	public static List<UserDTO> mapToUserDTO(List<UserEntity> users) {
		return users.stream().map(UserMapper::toUserDTO).collect(Collectors.toList());
	}

	public static List<UserEntity> mapToUserEntity(List<UserDTO> users) {
		return users.stream().map(UserMapper::toUserEntity).collect(Collectors.toList());
	}

}
