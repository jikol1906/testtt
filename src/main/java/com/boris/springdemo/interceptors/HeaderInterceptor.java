package com.boris.springdemo.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HeaderInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("greeting", "We hope you have a scary and fun filled Hallowen!");
		String location = request.getParameter("locationName");
		
		if(location != null) {
			Object loacation;
			request.setAttribute("locationName", location);
		}
		
		return true;
		
	}
	
	

}
