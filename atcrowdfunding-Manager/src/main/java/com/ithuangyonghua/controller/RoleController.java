package com.ithuangyonghua.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ithuangyonghua.bean.AjaxResult;
import com.ithuangyonghua.bean.Page;
import com.ithuangyonghua.bean.Role;
import com.ithuangyonghua.service.RoleService;
import com.ithuangyonghua.utils.DateUtils;

@RequestMapping("/role")
@Controller
public class RoleController {
	@Autowired
	RoleService roleService;

	/**
	 * ��ת����ɫҳ��
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "role/index";
	}

	/**
	 * ��ת���޸�ҳ��
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(String id, Model model) {
		Role role = roleService.queryRoleById(id);
		model.addAttribute("roleInfo", role);
		return "role/edit";
	}
	/**
	 * ��ת���������ҳ��
	 * @return
	 */
	@RequestMapping("/assign")
	public String assign(Integer id) {
		//roleService.queryAssignByRid(id);
		return "role/assign";
	}
	/**
	 * ��ѯ
	 * 
	 * @param pageno
	 * @param pagesize
	 * @param searchText
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/pageQuery")
	public Object pageQuery(Integer pageno, Integer pagesize, String searchText) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", (pageno - 1) * pagesize);
			map.put("size", pagesize);
			map.put("searchText", searchText);
			List<Role> rolelist = roleService.pageQuery(map);
			int totalsize = roleService.pageQueryCount(map);// ������
			int totalno = totalsize / pagesize;
			if (totalsize % pagesize != 0) {
				totalno += 1;
			}
			ajaxResult.setSuccess(true);
			Page<Role> page = new Page();
			page.setDatas(rolelist);
			page.setTotalsize(totalsize);
			page.setPageno(pageno);
			page.setTotalno(totalno);
			ajaxResult.setData(page);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult.setSuccess(false);
		}
		return ajaxResult;
	}

	/**
	 * �޸�
	 * 
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Object update(Role role) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			roleService.updateRole(role);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult.setSuccess(false);
		}
		return ajaxResult;
	}

	/**
	 * ��ת������ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("/insertRole")
	public String add() {
		return "role/add";
	}

	/**
	 * ����
	 * 
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insert")
	public Object insertRole(Role role) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			role.setCreatetime(DateUtils.formatDate(new Date()));
			roleService.insertRole(role);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
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
	@RequestMapping("/deleteRoleById")
	public Object deleteRoleById(String id) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			roleService.deleteRoleById(id);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult.setSuccess(false);
		}
		return ajaxResult;
	}
	
	
	@ResponseBody
	@RequestMapping("/deleteRoleBouth")
	public Object deleteRoleBouth(String [] id) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			Map<String,Object> map = new HashMap();
			map.put("roleids", id);
			roleService.deleteRoleBouth(map);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult.setSuccess(false);
		}
		return ajaxResult;
	}
	
	
	@ResponseBody
	@RequestMapping("/doAssign")
	public Object doAssign(Integer roleid,Integer [] permissionids) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			Map<String,Object> map = new HashMap();
			map.put("roleid", roleid);
			map.put("permissionids", permissionids);
			roleService.doAssign(map);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult.setSuccess(false);
		}
		return ajaxResult;
	}
}
