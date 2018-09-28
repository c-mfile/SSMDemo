package com.company.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.company.dao.TbUserMapper;
import com.company.model.TbUser;
import com.company.model.TbUserExample;
import com.company.model.TbUserExample.Criteria;
import com.company.model.TbUserRole;
import com.company.service.TbUserServcie;
@Service
public class TbUserServiceImpl implements TbUserServcie {
	@Autowired
	TbUserMapper userMapper;
	
	@Cacheable("cachelist")
	public List<TbUser> getUsers() {
		List<TbUser> users = userMapper.selectAll();
		return users;
	}

	public List<TbUser> searchUser(TbUser tbUser) {
		TbUserExample usere = new TbUserExample();
		Criteria ceriteria = usere.createCriteria();
		if(tbUser.getFlName()!=null && !"".equals(tbUser.getFlName())){
			ceriteria.andFlNameLike("%"+tbUser.getFlName()+"%");
		}
		if(tbUser.getUsername()!=null && !"".equals(tbUser.getUsername())){
			ceriteria.andUsernameEqualTo(tbUser.getUsername());
		}
		List<TbUser> users = userMapper.selectByExample(usere);
		return users;
	}

	public List<TbUser> getRoleOfUser(String userId) {
		return userMapper.getRolesOfUser(Long.valueOf(userId));
	}

	public void saveUserRoles(String userId, String roleIds) {
		userMapper.deleteAllRoles(Long.valueOf(userId));
		String[] roles = roleIds.split(",");
		List<TbUserRole> urs = new ArrayList<TbUserRole>();
		for (String role : roles) {
			TbUserRole ur = new TbUserRole();
			ur.setRoleId(Long.valueOf(role));
			ur.setUserId(Long.valueOf(userId));
			urs.add(ur);
		}
		userMapper.saveUserRole(urs);
	}

	public TbUser findUserById(String userId) {
		TbUser user = new TbUser();
		user.setUserId(Long.valueOf(userId));
		return userMapper.selectOne(user);
	}

	public void saveUser(TbUser tbUser) {
		if(tbUser.getUserId()!=null){
			//更改信息
			userMapper.updateByPrimaryKey(tbUser);
		}else{
			//增加信息
			userMapper.insert(tbUser);
		}
		
	}

	public void deleteUser(String userId) {
		TbUser user = new TbUser();
		user.setUserId(Long.valueOf(userId));
		userMapper.delete(userMapper.selectOne(user));
		
	}

	public boolean checkUserPrivilage(String userId, String url) {
		List result = userMapper.checkUserPrivilage(Long.valueOf(userId),url);
		if(result==null || result.size()<1){
			return false;
		}else{
			return true;
		}
	}

}
