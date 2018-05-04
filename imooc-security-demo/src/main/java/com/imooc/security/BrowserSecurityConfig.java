package com.imooc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 登录安全验证 : 认证 、 权限 、 防止恶意访问
 *
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.formLogin() // 表单登录（第一次访问会弹出登录页面）
//		http.httpBasic()  // 弹出登录窗口
			.and()
			.authorizeRequests()  // 权限配置
			.anyRequest()
			.authenticated();  // 需要认证
	}

}
