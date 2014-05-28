package com.example.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.service.ServiceException;
import com.example.service.login.LoginService;

public class Admin implements Filter {
	@Autowired private LoginService loginService;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hssr = (HttpServletRequest) request;
		HttpSession hs = hssr.getSession();
		String username = (String) hs.getAttribute("username");
		String userRole = null;
		if(username == null){
			HttpServletResponse hsr = (HttpServletResponse) response;
			hsr.sendRedirect("logout");
			return;
		}
		try {
			userRole = loginService.getUser(username).getRole().getRoleType();
		} catch (ServiceException e) {
			request.setAttribute("errorMsg", "Error in the system. Try again later.");
		}
		
		if(userRole != null && !userRole.equals("admin")){
			HttpServletResponse hsr = (HttpServletResponse) response;
			hsr.sendRedirect("logout");
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
