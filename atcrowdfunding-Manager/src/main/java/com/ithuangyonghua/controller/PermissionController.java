package com.ithuangyonghua.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ithuangyonghua.bean.AjaxResult;
import com.ithuangyonghua.bean.Permission;
import com.ithuangyonghua.service.PermissionService;

@RequestMapping("/permission")
@Controller
public class PermissionController {

	@Autowired
	PermissionService permissionService;

	@RequestMapping("/index")
	public String index() {
		return "permission/index";
	}

	@ResponseBody
	@RequestMapping("/loadAssignData")
	public Object loadAssignData(Integer rid) {
		//��װ��ɫ��Ȩ�޵Ĺ�ϵ
		List<Permission> permissions = new ArrayList<Permission>();//
		List<Permission> ps = permissionService.queryAll();// ��ȡ���еĽڵ�����

		// ��ȡ��ǰ��ɫ�Ѿ�����������Ϣ
		List<Integer> permissionids = permissionService.queryPermissionidByRid(rid);

		Map<Integer, Permission> map = new HashMap<Integer, Permission>();
		for (Permission p : ps) {
			if (permissionids.contains(p.getId())) {
				p.setChecked(true);
			} else {
				p.setChecked(false);
			}
			map.put(p.getId(), p);
		}
		for (Permission p : ps) {
			Permission children = p;// �ӽڵ�
			if (p.getPid() == 0) {// ����ڵ��pidΪ0��˵��Ϊ���ڵ�
				permissions.add(p);
			} else {// �����Ǹ��ڵ�,��˵���϶����и��ڵ��
				Permission parent = map.get(children.getPid());
				parent.getChildren().add(children);
			}
		}
		return permissions;
	}

	@ResponseBody
	@RequestMapping("/loadData")
	public Object loadData() {
		/*
		 * Permission root = new Permission(); root.setId(0);
		 * getChildrens(root); return root.getChildren();
		 */

		// List<Permission> permissions= new ArrayList<Permission>();
		// List<Permission> ps= permissionService.queryAll();//��ȡ���еĽڵ�����
		// ���Ա���
		/*
		 * for(Permission p : ps){ //���� //�ӽڵ� Permission children = p;
		 * if(p.getPid()==0){//����ڵ��pidΪ0��˵��Ϊ���ڵ� permissions.add(p); }else{
		 * for(Permission innerPermission:ps){
		 * if(children.getPid().equals(innerPermission.getId())){ //���ڵ�
		 * Permission parent = innerPermission;
		 * parent.getChildren().add(children); break; } } } }
		 */
		List<Permission> permissions = new ArrayList<Permission>();//
		List<Permission> ps = permissionService.queryAll();// ��ȡ���еĽڵ�����
		Map<Integer, Permission> map = new HashMap<Integer, Permission>();
		for (Permission p : ps) {
			map.put(p.getId(), p);
		}
		for (Permission p : ps) {
			Permission children = p;// �ӽڵ�
			if (p.getPid() == 0) {// ����ڵ��pidΪ0��˵��Ϊ���ڵ�
				permissions.add(p);
			} else {// �����Ǹ��ڵ�,��˵���϶����и��ڵ��
				Permission parent = map.get(children.getPid());
				parent.getChildren().add(children);
			}
		}
		return permissions;
	}

	/**
	 * �ݹ�ʵ����״�˵�,����Ч�ʱȽϵ�
	 * 
	 * @param parent
	 */
	public void getChildrens(Permission parent) {
		List<Permission> queryChildrens = permissionService.queryChildren(parent.getId());
		for (Permission queryChildren : queryChildrens) {
			getChildrens(queryChildren);
		}
		parent.setChildren(queryChildrens);
	}

	// ��ת�����ҳ��
	@RequestMapping("/add")
	public String add() {
		return "permission/add";
	}

	/**
	 * ����Ȩ����Ϣ
	 * 
	 * @param permission
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insert")
	public Object insertPermission(Permission permission) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			permissionService.insertPermission(permission);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult.setSuccess(false);
		}
		return ajaxResult;
	}

	/**
	 * �޸�
	 * 
	 * @param pid
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(Integer id, Model model) {
		Permission permission = permissionService.queryPermissionById(id);
		model.addAttribute("permissionInfo", permission);
		return "permission/edit";
	}

	@ResponseBody
	@RequestMapping("/update")
	public Object updatePermission(Permission permission) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			permissionService.updatePermission(permission);
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
	 * @param permission
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Object deletePermission(Permission permission) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			permissionService.deletePermission(permission);
			ajaxResult.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult.setSuccess(false);
		}
		return ajaxResult;
	}

}
