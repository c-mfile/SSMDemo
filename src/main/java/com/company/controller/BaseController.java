package com.company.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.company.exception.DemoException;

@Controller
public class BaseController {
	//可以将所有异常均用此方法捕获，也可抛出使用xml文件配置捕获
	@ExceptionHandler
	public String exceptionHandler(HttpServletRequest req,HttpServletResponse resp,Exception e) throws Exception{
		if(e instanceof DemoException) {
			req.setAttribute("message", e.getMessage());
			return "index";
		}else {
			throw e;
		}
	}

}
