package com.imooc.security.browser.support;

/**
 * 给客户端返回时用的json
 *
 */
public class SimpleResponse {

	private Object content;
	
	public SimpleResponse(Object content){
		this.content = content;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
}