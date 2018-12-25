package com.thoughtmechanix.authentication.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String role;

	@ManyToMany(mappedBy = "roleList")
	private List<User> userList;
}
