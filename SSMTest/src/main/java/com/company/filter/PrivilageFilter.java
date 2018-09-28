package com.company.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.company.service.TbUserServcie;

public class PrivilageFilter implements Filter{

	//获取用户的请求(req)，并且取得用户的ID(session)，根据用户和请求，判断该用户有没有访问该功能的权限(查询数据库，最好放在session里面)
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain filterChan)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String url = req.getRequestURI();
		if(url.contains(".js")||url.contains(".css")||url.contains(".img")){
			filterChan.doFilter(request, resp);
		}else{
	//		String userId = req.getSession().getAttribute("userId");
			String usreId = "1";
			//获取service对象，首先拿到容器对象，获取当前容器对象
			WebApplicationContext container = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
			TbUserServcie tbUserServcie = container.getBean(TbUserServcie.class);
			boolean isPrivilage = tbUserServcie.checkUserPrivilage(usreId, url);
			if(isPrivilage){
				filterChan.doFilter(request, resp);
			}else{
				resp.setCharacterEncoding("UTF-8");
				resp.getWriter().append("没有访问权限");
			}
		}
		
	}

	public void destroy() {
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}
	

}
