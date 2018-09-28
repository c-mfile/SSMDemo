package com.company.service;

import java.util.List;

import com.company.model.TbUser;

public interface TbUserServcie {
	public List<TbUser> getUsers();
	public List<TbUser> searchUser(TbUser tbUser);
	public List<TbUser> getRoleOfUser(String userId);
	public void saveUserRoles(String userId, String roleIds);
	public TbUser findUserById(String userId);
	public void saveUser(TbUser tbUser);
	public void deleteUser(String userId);
	public boolean checkUserPrivilage(String userId,String url);

}
