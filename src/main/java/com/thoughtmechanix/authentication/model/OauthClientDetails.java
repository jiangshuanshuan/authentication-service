package com.thoughtmechanix.authentication.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name="oauth_client_details")
public class OauthClientDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
