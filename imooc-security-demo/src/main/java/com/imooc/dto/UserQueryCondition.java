package com.imooc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UserQueryCondition {

	@ApiModelProperty(value = "用户姓名")
	private String username;

	@ApiModelProperty(value = "年龄")
	private int age;

	private int ageTo;
	
	private String xxx;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAgeTo() {
		return ageTo;
	}

	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}

	public String getXxx() {
		return xxx;
	}

	public void setXxx(String xxx) {
		this.xxx = xxx;
	}
	
}
