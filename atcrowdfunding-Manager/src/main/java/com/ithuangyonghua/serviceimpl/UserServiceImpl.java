package com.ithuangyonghua.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ithuangyonghua.bean.User;
import com.ithuangyonghua.dao.UserDao;
import com.ithuangyonghua.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return userDao.queryAll();
	}

	public User queryForLogin(User user) {
		// TODO Auto-generated method stub
		return userDao.queryForLogin(user);
	}

	public List<User> pageQueryData(Map<String,Object> map) {
		// TODO Auto-generated method stub
		return userDao.pageQueryData(map);
	}

	public int pageQueryCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.pageQueryCount(map);
	}

	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	public User queryUserById(String id) {
		// TODO Auto-generated method stub
		return userDao.queryUserById(id);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUser(String id) {
		userDao.deleteUser(id);
	}

	public void deleteBoathUser(Map<String,Object> map) {
		userDao.deleteBoathUser(map);
	}
}
