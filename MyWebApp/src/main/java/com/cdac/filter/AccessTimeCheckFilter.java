package com.cdac.filter;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AccessTimeCheckFilter
 */
@WebFilter({"*.html"})
public class AccessTimeCheckFilter extends HttpFilter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		ServletContext sCtx = getServletContext();

		int startTime = Integer.parseInt(sCtx.getInitParameter("startTime"));
		int endTime = Integer.parseInt(sCtx.getInitParameter("endTime"));
		
		LocalTime time = LocalTime.now();
		if(time.getHour() >= startTime && time.getHour() <= endTime)
			chain.doFilter(request, response);
		else {
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect("accessNotAllowed.jsp");
		}
			
	}

}
