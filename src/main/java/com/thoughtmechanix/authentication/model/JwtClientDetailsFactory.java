package com.thoughtmechanix.authentication.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtClientDetailsFactory {

	private JwtClientDetailsFactory() {
	}

	public static JwtClientDetails create(OauthClientDetails details) {
		return new JwtClientDetails(
				details.getClientId()
				,details.getResourceIds()
				,details.getClientSecret()
				,details.getScope()
				,details.getAuthorizedGrantTypes()
				,details.getWebServerRedirectUri()
		);
	}
}