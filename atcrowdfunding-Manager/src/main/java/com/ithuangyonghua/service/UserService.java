package com.ithuangyonghua.service;

import java.util.List;
import java.util.Map;

import com.ithuangyonghua.bean.User;

public interface UserService {

	List<User> queryAll();

	User queryForLogin(User user);

	List<User> pageQueryData(Map<String,Object> map);

	int pageQueryCount(Map<String, Object> map);

	void insertUser(User user);

	User queryUserById(String id);

	void updateUser(User user);

	void deleteUser(String id);

	void deleteBoathUser(Map<String,Object> map);

}
