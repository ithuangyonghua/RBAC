package com.ithuangyonghua.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ithuangyonghua.bean.AjaxResult;
import com.ithuangyonghua.bean.Page;
import com.ithuangyonghua.bean.Role;
import com.ithuangyonghua.bean.User;
import com.ithuangyonghua.service.RoleService;
import com.ithuangyonghua.service.UserService;
import com.ithuangyonghua.utils.DateUtils;

/**
 * �û�Controller
 * 
 * @author Hyh
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;

	/**
	 * ��ת���û���ҳ
	 * 
	 * @return
	 */
	@RequestMapping("/index1")
	public String index1(@RequestParam(defaultValue = "1", required = false) Integer pageno,
			@RequestParam(defaultValue = "2", required = false) Integer pagesize, Model model) {
		// ʵ�ַ�ҳ��ѯ
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", (pageno - 1) * pagesize);
		map.put("size", pagesize);
		List<User> userData = userService.pageQueryData(map);
		model.addAttribute("userList", userData);
		// ��ǰҳ��
		model.addAttribute("pageno", pageno);
		// ���ҳ��(��ҳ��)
		int totalsize = userService.pageQueryCount(map);
		int totalno = 0;
		if (totalsize % pagesize == 0) {
			totalno = totalsize / pagesize;
		} else {
			totalno = totalsize / pagesize + 1;
		}
		// ��ҳ��
		model.addAttribute("totalno", totalno);
		return "user/index1";
	}

	/**
	 * �޸ĺ�: ��ת���û�ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		return "user/index";
	}

	/**
	 * ��ת�����ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("add")
	public String add() {
		return "user/add";
	}

	/**
	 * �޸�
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(String id, Model model) {
		User user = userService.queryUserById(id);
		model.addAttribute("userInfo", user);
		return "user/edit";
	}

	/**
	 * ��ѯ����
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param queryText
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/pageQuery")
	public Object pageQuery(Integer pageno, Integer pagesize, String queryText) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", (pageno - 1) * pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);
			List<User> userData = userService.pageQueryData(map);
			int totalsize = userService.pageQueryCount(map);
			int totalno = 0;
			if (totalsize % pagesize == 0) {
				totalno = totalsize / pagesize;
			} else {
				totalno = totalsize / pagesize + 1;
			}
			Page<User> page = new Page();
			page.setDatas(userData);
			page.setPageno(pageno);
			page.setTotalno(totalno);
			page.setTotalsize(totalsize);
			ajaxResult.setSuccess(true);
			ajaxResult.setData(page);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult.setSuccess(false);
		}
		return ajaxResult;
	}

	/**
	 * ����
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("insert")
	public Object insertUser(User user) {
		AjaxResult ajaxResult = new AjaxResult();

		try {
			user.setPassword("123");
			user.setCreatetime(DateUtils.formatDate(new Date()));
			;
			userService.insertUser(user);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ajaxResult.setSuccess(false);
		}
		return ajaxResult;
	}

	/**
	 * �޸�
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Object updateUser(User user) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			userService.updateUser(user);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ajaxResult.setSuccess(false);
		}
		return ajaxResult;
	}

	/**
	 * ɾ��
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Object deleteUser(String id) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			userService.deleteUser(id);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			ajaxResult.setSuccess(false);
		}
		return ajaxResult;
	}

	/**
	 * ����ɾ��
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteBoath")
	public Object deleteBoathUser(Integer[] ids) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userids", ids);
			userService.deleteBoathUser(map);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult.setSuccess(false);
		}
		return ajaxResult;
	}
    /**
     * �����ɫҳ��
     * @param id
     * @param model
     * @return
     */
	@RequestMapping("assignRole")
	public String assignRole(String id, Model model) {
		//
		User user = userService.queryUserById(id);
		model.addAttribute("userInfo", user);
		List<Role> all = roleService.queryAll();
		model.addAttribute("roleInfo", all);
		return "user/assignRole";
	}
}
