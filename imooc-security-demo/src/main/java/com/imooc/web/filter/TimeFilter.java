package com.imooc.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 拦截服务：过滤器
 * 		优点：拿到原始的请求
 * 		不足：拿不到处理请求方法的信息
 *
 */
//@Component  // 临时注掉
public class TimeFilter implements Filter {


	/* (non-Javadoc)
 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("time filter init");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 在整个项目中获取 request 的方法
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		System.out.println("time filter start");
		long start = System.currentTimeMillis();

		chain.doFilter(request, response);

		System.out.println("time filter 耗时:"+ (System.currentTimeMillis() - start));
		System.out.println("time filter finish");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("time filter destroy");
	}

}
