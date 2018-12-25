package com.thoughtmechanix.authentication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class JwtUser implements UserDetails {
	private final String username;
	private final String password;
	private final String email;
	private String phone;
	private String description;
	private boolean active;
	private Date expireDate;
	private Date startDate;//授权开始时间
	private Date refreshTime;
	private final Collection<? extends GrantedAuthority> authorities;
	private final Date lastPasswordResetDate;

	public JwtUser(String username, String password, String description, boolean active, Date expireDate,
				   String email, String phone, Collection<? extends GrantedAuthority> authorities, Date lastPasswordResetDate, Date startDate, Date refreshTime) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.authorities = authorities;
		this.lastPasswordResetDate = lastPasswordResetDate;
		this.description = description;
		this.active = active;
		this.expireDate = expireDate;
		this.startDate = startDate;
		this.refreshTime = refreshTime;
	}

	// 返回分配给用户的权限列表
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	// 账户是否未过期
	@JsonIgnore
	public boolean isAccountNonExpired() {
		if (expireDate != null && expireDate.before(new Date())) {
			return false;
		} else {
			return true;
		}
	}
	// 账户是否取消token
	@JsonIgnore
	public boolean isAccountCancelToken() {
		if (refreshTime != null && refreshTime.before(new Date())) {
			return false;
		} else {
			return true;
		}
	}
	// 账户是否未锁定
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	// 密码是否未过期
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 账户是否激活
	@JsonIgnore
	public boolean isEnabled() {
		return this.active;
	}

	//返回上次密码重置日期
	@JsonIgnore
	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}


	public boolean isAccountStartDate() {
		if (startDate != null && startDate.after(new Date())) {
			return false;
		} else {
			return true;
		}
	}
}
