package com.company.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.company.entity.User;

@Repository
public interface UserDao {
	//查询所有用户
	List<User> findAll();

}
