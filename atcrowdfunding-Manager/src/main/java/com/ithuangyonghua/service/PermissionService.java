package com.ithuangyonghua.service;

import java.util.List;

import com.ithuangyonghua.bean.Permission;
import com.ithuangyonghua.bean.User;

public interface PermissionService {

	Permission queryRoot();

	List<Permission> queryChildren(Integer id);

	List<Permission> queryAll();

	void insertPermission(Permission permission);

	Permission queryPermissionById(Integer id);

	void updatePermission(Permission permission);

	void deletePermission(Permission permission);

	List<Integer> queryPermissionidByRid(Integer rid);

	List<Permission> queryPermissionByUser(User dbuser);

	

}
