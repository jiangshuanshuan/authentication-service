package com.thoughtmechanix.authentication.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * 用户表
 */
@Data
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String password;

	private String description;//姓名

	private String email;//邮箱
	private String phone;//手机
	private boolean active;//是否启用
	private Date expireDate;//授权到期时间
	private Date startDate;//授权开始时间
	private Date lastPasswordResetDate;//最后密码重置时间
	private Date refreshTime;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	//1、关系维护端，负责多对多关系的绑定和解除
	//2、@JoinTable注解的name属性指定关联表的名字，joinColumns指定外键的名字，关联到关系维护端(User)
	//3、inverseJoinColumns指定外键的名字，要关联的关系被维护端(Role)
	//4、其实可以不使用@JoinTable注解，默认生成的关联表名称为主表表名+下划线+从表表名，
	//即表名为user_role
	//关联到主表的外键名：主表名+下划线+主表中的主键列名,即user_id
	//关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,即role_id
	//主表就是关系维护端对应的表，从表就是关系被维护端对应的表
	private List<Role> roleList;

	public User(String username, String description, String password,boolean active, String email, String phone) {
		this.username = username;
		this.description = description;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.active = active;
	}
}
