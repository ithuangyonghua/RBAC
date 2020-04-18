package com.ithuangyonghua.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ithuangyonghua.bean.Permission;
import com.ithuangyonghua.service.PermissionService;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	PermissionService permissionService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// ��ȡ�û�������·��
		String url = request.getRequestURI();
		// ��½�û�ӵ�е�Ȩ��
		Set<String> autoUrlSet = (Set<String>) request.getSession().getAttribute("autoUrlSet");
		String path = request.getSession().getServletContext().getContextPath();
		// �ж�·���Ƿ���Ҫ����Ȩ����֤
		// ��ѯ������Ҫ��֤��·������--��������Ҫ��֤��·��
		List<Permission> permissions = permissionService.queryAll();
		// Ϊɶ��set,��Ϊ��Щ·���������ظ���--������Ҫ��֤��·������Set
		Set<String> uriSet = new HashSet<String>();
		for (Permission permission : permissions) {
			if (!StringUtils.isEmpty(permission.getUrl()) && !"".equals(permission.getUrl())) {
				uriSet.add(path + permission.getUrl());
			}
		}
		if (uriSet.contains(url)) {
			// Ȩ����֤
			// �û��Ƿ�������Ӧ��Ȩ��
			if (autoUrlSet.contains(url)) {
				return true;
			} else {
				response.sendRedirect(path + "/error");
				return false;
			}
		} else {
			return true;
		}
	}

}
