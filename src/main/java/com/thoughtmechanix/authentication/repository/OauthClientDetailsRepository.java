package com.thoughtmechanix.authentication.repository;

import com.thoughtmechanix.authentication.model.OauthClientDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthClientDetailsRepository extends CrudRepository<OauthClientDetails,String> {
	public OauthClientDetails findByClientId(String clientId);
}
