package com.thoughtmechanix.authentication.service.impl;

import com.thoughtmechanix.authentication.model.JwtClientDetailsFactory;
import com.thoughtmechanix.authentication.model.OauthClientDetails;
import com.thoughtmechanix.authentication.repository.OauthClientDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientDetailsServiceImpl implements ClientDetailsService {
	@Autowired
	private OauthClientDetailsRepository oauthClientDetailsRepository;
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		OauthClientDetails clientDetails = oauthClientDetailsRepository.findByClientId(clientId);
		if (clientDetails == null) {
			log.error(String.format("No clientDetails found with clientId '%s'.", clientId));
		}
		return JwtClientDetailsFactory.create(clientDetails);
	}
}
