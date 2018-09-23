package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.UserDao;
import com.company.entity.User;
import com.company.exception.DemoException;
import com.company.service.UserService;

@Service
public class UserSerivceImpl implements UserService {
	@Autowired
	UserDao userDao;

	public List<User> findAll() {
		// TODO Auto-generated method stub
//		throw new DemoException("出现错误");
		return userDao.findAll();
	}

}
