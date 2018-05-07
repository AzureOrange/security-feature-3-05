package com.imooc.security.core.validate.code.sms;

/**
 * 短信发送方式
 *
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

	/* (non-Javadoc)
	 * @see com.imooc.security.core.validate.code.sms.SmsCodeSender#send(java.lang.String, java.lang.String)
	 */
	@Override
	public void send(String mobile, String code) {

		// 调用第三方短信发送服务
		System.out.println("向手机"+mobile+"发送短信验证码"+code);
	}

}
