package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.model.TbUser;
import com.company.service.TbUserServcie;

@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	TbUserServcie userService;
	
	@RequestMapping("list")
	public String searchUser(TbUser tbUser,Model model){
		List<TbUser> users = userService.searchUser(tbUser);
		model.addAttribute("tbUser", tbUser);
		model.addAttribute("users", users);
		return "user/userList";
	}
	
	@RequestMapping("userrole")
	public String userRole(){
		return "user/userrole";
	}
	
	@RequestMapping("roles")
	public String searchRoles(String userId,Model model){
		List<TbUser> roles = userService.getRoleOfUser(userId);
		model.addAttribute("roles", roles);
		return "user/roleList";
	}

	@RequestMapping("saveRoles")
	@ResponseBody
	public String saveRoles(String userId,String roleIds){
		userService.saveUserRoles(userId,roleIds);
		return "保存成功";
	}
	
	@RequestMapping("getUser")
	public String getUser(String userId,Model model){
		TbUser user = userService.findUserById(userId);
		model.addAttribute("tbUser", user);
		return "user/userForm";
	}
	
	@RequestMapping("saveUser")
	@ResponseBody
	public String saveUser(TbUser tbUser){
		userService.saveUser(tbUser);
		return "保存成功";
	}
	
	@RequestMapping("delUser")
	@ResponseBody
	public void delUser(String userId){
		userService.deleteUser(userId);
	}
	
	@RequestMapping("addUser")
	public String addUser(){
		return "user/userForm";
	}
	
}
