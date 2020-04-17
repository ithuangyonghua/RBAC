package com.ithuangyonghua.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ithuangyonghua.bean.User;
import com.ithuangyonghua.service.UserService;

@Controller
// @RequestMapping("/test")
public class TestController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("getuserall")
	public List<User> queryAll() {
		return userService.queryAll();
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@ResponseBody
	@RequestMapping("/map")
	public Map get() {

		Map<String, String> map = new HashMap();
		map.put("zhangsan", "sa");
		return map;
	}

}
