package com.company.dao;

import com.company.model.TbUser;
import com.company.model.TbUserExample;
import com.company.model.TbUserRole;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface TbUserMapper extends Mapper<TbUser> {

	List<TbUser> getRolesOfUser(Long userId);

	void deleteAllRoles(Long userId);

	void saveUserRole(@Param("userRoles")List<TbUserRole> urs);

	List checkUserPrivilage(@Param("userId")Long valueOf, @Param("url") String url);

}