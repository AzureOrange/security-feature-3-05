package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 生成验证码的接口
 *
 */
public interface ValidateCodeGenerator {

	ImageCode generate(ServletWebRequest request);
	
}
