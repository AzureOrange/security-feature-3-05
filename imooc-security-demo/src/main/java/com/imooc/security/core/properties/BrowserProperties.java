package com.imooc.security.core.properties;

/**
 * 返回类型：JSON 或 HTML
 *
 */
public class BrowserProperties {

	private String loginPage = "/imooc-signIn.html";

	// 缓存登录信息时间
	private int rememberMeSeconds = 60;

	private LoginType loginType = LoginType.JSON;

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}

	public int getRememberMeSeconds() {
		return rememberMeSeconds;
	}

	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}
	
}
