package com.imooc.security.core.validate.code.sms;

/**
 * 短信发送商
 *
 */
public interface SmsCodeSender {
	
	void send(String mobile, String code);

}
