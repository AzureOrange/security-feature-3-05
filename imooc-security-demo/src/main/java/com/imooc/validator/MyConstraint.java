package com.imooc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */

// 指定可以标注的范围
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
// 指定当前注解需要什么类去校验
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {
	// 下面三个属性必须写

	String message();

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
