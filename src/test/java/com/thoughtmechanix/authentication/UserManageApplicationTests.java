package com.thoughtmechanix.authentication;

import com.thoughtmechanix.authentication.model.Role;
import com.thoughtmechanix.authentication.model.User;
import com.thoughtmechanix.authentication.repository.RoleRepository;
import com.thoughtmechanix.authentication.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManageApplicationTests {
	@Autowired
	private UserRepository userDao;
	@Autowired
	private RoleRepository roleDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
//	@Test
	public void saveUser() {
		Role authority = new Role();
		authority.setRole("ROLE_ADMIN");
		roleDao.save(authority);
		User user = new User();
		user.setUsername("jiang");
		user.setPassword("123456");
		user.setActive(true);
		user.setDescription("description jiang");
		user.setEmail("jiang1@163.com");
		user.setPhone("15801078660");
		user.setExpireDate(new Date());
//		Authority authority = authorityRepository.findById(1);
		List<Role> authorityList = new ArrayList<>();
		authorityList.add(authority);
		user.setRoleList(authorityList);
		userDao.save(user);
	}
//	@Test
	public void findUser() {
		User user = userDao.findByUsername("jss");
		List<Role> roles = user.getRoleList();
		roles.stream().forEach(role -> System.out.println(role.getRole()));
	}
	@Test
	public void encodePwd(){
		System.out.println(passwordEncoder.encode("123456"));
	}
}
