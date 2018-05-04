package com.imooc.web.controller.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟存储消息的存储器
 *
 */
@Component
public class DeferredResultHolder {
	
	private Map<String, DeferredResult<String>> map = new HashMap<String, DeferredResult<String>>();



	public Map<String, DeferredResult<String>> getMap() {
		return map;
	}

	public void setMap(Map<String, DeferredResult<String>> map) {
		this.map = map;
	}
	
}
