package com.imooc.validator;

import com.imooc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义注解的实现
 */

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> { // Object 是指注解可以放在哪种类型上

	@Autowired
	private HelloService helloService;

	// 初始化
	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		System.out.println("my validator init");
	}

	// 校验 成功返回true  失败返回false
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		helloService.greeting("tom");
		System.out.println(value);
		return false;
	}

}
