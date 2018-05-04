package com.imooc.security.browser;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 登录安全验证 : 认证 、 权限 、 防止恶意访问
 *
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
	
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
