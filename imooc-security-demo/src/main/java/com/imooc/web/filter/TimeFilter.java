/**
 * 
 */
package com.imooc.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * 拦截服务：过滤器（不足：不知道哪个控制器中的哪个方法处理的）
 *
 */
@Component
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
		System.out.println("time filter start");
		long start = new Date().getTime();

		chain.doFilter(request, response);

		System.out.println("time filter 耗时:"+ (new Date().getTime() - start));
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
