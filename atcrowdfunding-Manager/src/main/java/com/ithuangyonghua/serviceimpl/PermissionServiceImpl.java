package com.ithuangyonghua.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ithuangyonghua.bean.Permission;
import com.ithuangyonghua.bean.User;
import com.ithuangyonghua.dao.PermissionDao;
import com.ithuangyonghua.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	PermissionDao permissionDao;

	public Permission queryRoot() {
		// TODO Auto-generated method stub
		return permissionDao.queryRoot();
	}

	public List<Permission> queryChildren(Integer id) {
		// TODO Auto-generated method stub
		return permissionDao.queryChildren(id);
	}

	public List<Permission> queryAll() {
		// TODO Auto-generated method stub
		return permissionDao.queryAll();
	}

	public void insertPermission(Permission permission) {
		// TODO Auto-generated method stub
		permissionDao.insertPermission(permission);
	}

	public Permission queryPermissionById(Integer id) {
		// TODO Auto-generated method stub
		return permissionDao.queryPermissionById(id);
	}

	public void updatePermission(Permission permission) {
		// TODO Auto-generated method stub
		permissionDao.updatePermission(permission);
	}

	public void deletePermission(Permission permission) {
		// TODO Auto-generated method stub
		permissionDao.deletePermission(permission);
	}

	public List<Integer> queryPermissionidByRid(Integer rid) {
		// TODO Auto-generated method stub
		return permissionDao.queryPermissionidByRid(rid);
	}

	public List<Permission> queryPermissionByUser(User dbuser) {
		// TODO Auto-generated method stub
		return permissionDao.queryPermissionByUser(dbuser);
	}

}
