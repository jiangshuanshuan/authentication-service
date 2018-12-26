package com.thoughtmechanix.authentication.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;
import java.util.stream.Collectors;

public class JwtClientDetails implements ClientDetails {

	private String clientId;
	private String resourceIds;
	private String clientSecret;
	private String scope;
	private String authorizedGrantTypes;
	private String webServerRedirectUri;
	private String authorities;
	private Integer accessTokenValidity;
	private Integer refreshTokenValidity;
	private String additionalInformation;
	private Date createTime;
	private boolean archived;
	private boolean trusted;
	private String autoapprove;

	public JwtClientDetails(String clientId, String resourceIds, String clientSecret, String scope, String authorizedGrantTypes, String webServerRedirectUri) {
		this.clientId = clientId;
		this.resourceIds = resourceIds;
		this.clientSecret = clientSecret;
		this.scope = scope;
		this.authorizedGrantTypes = authorizedGrantTypes;
		this.webServerRedirectUri = webServerRedirectUri;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	@Override
	public String getClientId() {
		return clientId;
	}

	@Override
	public Set<String> getResourceIds() {
		return resourceIds==null?null:new HashSet<>(Arrays.asList(resourceIds.split(",")));
	}

	@Override
	@JsonIgnore
	public boolean isSecretRequired() {
		return this.clientSecret != null;
	}

	@Override
	@JsonIgnore
	public String getClientSecret() {
		return this.clientSecret;
	}

	@Override
	public boolean isScoped() {
		return this.scope != null && !this.scope.isEmpty();
	}

	@Override
	public Set<String> getScope() {
		return new HashSet<>(Arrays.asList(scope.split(",")));
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return new HashSet<>(Arrays.asList(authorizedGrantTypes.split(",")));
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		return new HashSet<>(Arrays.asList(webServerRedirectUri.split(",")));
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities==null?new ArrayList():Arrays.asList(authorities.split(",")).stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return accessTokenValidity==null?0:accessTokenValidity.intValue();
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return refreshTokenValidity ==null?0:refreshTokenValidity.intValue();
	}

	@Override
	public boolean isAutoApprove(String s) {
		return false;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		return null;
	}
}
