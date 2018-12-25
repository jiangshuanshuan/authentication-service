package com.thoughtmechanix.authentication.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

	private JwtUserFactory() {
	}

	public static JwtUser create(User user) {
		return new JwtUser(
				user.getUsername(),
				user.getPassword(),
				user.getDescription(),
				user.isActive(),
				user.getExpireDate(),
				user.getEmail(),
				user.getPhone(),
				mapToGrantedAuthorities(user.getRoleList().stream().map(Role::getRole).collect(Collectors.toList())),
				user.getLastPasswordResetDate(),
				user.getStartDate(),
				user.getRefreshTime()
		);
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
		return authorities.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
}