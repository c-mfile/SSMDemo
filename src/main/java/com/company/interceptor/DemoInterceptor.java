package com.company.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor {

	//执行controller之前拦截，返回true即继续执行，返回false则被拦截
	//拦截器属于Spring,配置需要在spring的配置文件中进行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//本例为判断用户是否登录
		String name = (String) request.getSession().getAttribute("client");
		if(name!=null){
			return true;
		}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return false;
		}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
