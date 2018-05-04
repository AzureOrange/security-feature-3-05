package com.imooc.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 拦截配置：切片
 * 		优点：可以拿到请求的参数值与返回值
 * 		不足：拿不到原始的http响应与请求的对象
 *
 * 	拦截器执行顺序：Filter --> Interceptor -->  ControllerAdvice(自定义异常)  -->  Aspect -->  Controller
 *
 */
@Aspect
@Component
public class TimeAspect {

	//	@Before()

	// @Around 包含了@Before()、@After()、@AfterThrowing 等
	@Around("execution(* com.imooc.web.controller.UserController.*(..))")
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("time aspect start");

		// 入参
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			System.out.println("入参 ：arg is "+arg);
		}
		
		long start = new Date().getTime();

		// 执行请求  并返回请求的结果
		Object object = pjp.proceed();

		System.out.printf("执行结果：---" + object);
		
		System.out.println("time aspect 耗时:"+ (new Date().getTime() - start));
		
		System.out.println("time aspect end");
		
		return object;
	}

//	@After()

//	@AfterThrowing

}
