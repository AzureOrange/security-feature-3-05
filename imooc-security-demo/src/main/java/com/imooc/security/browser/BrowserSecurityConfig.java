package com.imooc.security.browser;

import com.imooc.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 登录安全验证 : 认证 、 权限 、 防止恶意访问
 *
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

	@Autowired
	private AuthenticationFailureHandler imoocAuthenticationFailureHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.formLogin() // 表单登录（第一次访问会弹出登录页面）
				.loginPage("/authentication/require")
				.loginProcessingUrl("/authentication/form")
				.successHandler(imoocAuthenticationSuccessHandler)
				.failureHandler(imoocAuthenticationFailureHandler)
//		http.httpBasic()   // 弹出登录窗口
				.and()
				.authorizeRequests()
				.antMatchers("/authentication/require",
						securityProperties.getBrowser().getLoginPage()).permitAll()
				.anyRequest()
				.authenticated()   // 需要认证
				.and()
				.csrf().disable();   // 跨站请求许可

	}
}