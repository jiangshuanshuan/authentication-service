package com.thoughtmechanix.authentication.repository;

import com.thoughtmechanix.authentication.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,String> {
	public Role findById(String id);
}
