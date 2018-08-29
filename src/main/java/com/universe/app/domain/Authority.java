package com.universe.app.domain;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Authority {

	private String username;

	@Enumerated(EnumType.STRING)
	private Role authority;

	public Authority() {
	}

	public Authority(Role authority) {
		this.authority = authority;
	}

	public Authority(String username, Role authority) {
		this.username = username;
		this.authority = authority;
	}

	public Role getAuthority() {
		return authority;
	}

	public void setAuthority(Role authority) {
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
