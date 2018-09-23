package com.company.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.service.UserService;

@Controller
public class UserController extends BaseController {
	@Autowired
	UserService userSerivce;
	
	@RequestMapping("/demo.do")
	public String demo(HttpServletRequest req,HttpServletResponse resp) {
		userSerivce.findAll();
		req.getSession().setAttribute("client", "user");
		req.setAttribute("message", "demo");
		return "index";
	}
	
	@RequestMapping("/unlogin.do")
	public String unLogin(HttpServletRequest req) {
		req.setAttribute("message", userSerivce.findAll());
		return "index";
	}

}
