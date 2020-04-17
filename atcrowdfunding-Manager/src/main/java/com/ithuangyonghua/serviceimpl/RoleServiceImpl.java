package com.ithuangyonghua.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ithuangyonghua.bean.Role;
import com.ithuangyonghua.dao.RoleDao;
import com.ithuangyonghua.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDao roleDao;

	public List<Role> pageQuery(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return roleDao.pageQuery(map);
	}

	public int pageQueryCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return roleDao.pageQueryCount(map);
	}

	public Role queryRoleById(String id) {
		// TODO Auto-generated method stub
		return roleDao.queryRoleById(id);
	}

	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		roleDao.updateRole(role);
	}

	public void insertRole(Role role) {
		roleDao.insertRole(role);
		
	}

	public void deleteRoleById(String id) {
		roleDao.deleteRoleById(id);
	}

	public void deleteRoleBouth(Map<String, Object> map) {
		roleDao.deleteRoleBouth(map);
	}

	public List<Role> queryAll() {
		// TODO Auto-generated method stub
		return roleDao.queryAll();
	}
}
