package com.cdac.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class HitCounterFilter
 */
//@WebFilter("/*")
public class HitCounterFilter extends HttpFilter {
       
	int counter = 0;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		ServletContext sCtx = getServletContext();	
		counter ++;
		sCtx.setAttribute("hitCounter", counter);
		
		chain.doFilter(request, response);
	}

}
