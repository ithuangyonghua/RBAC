package com.ithuangyonghua.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ithuangyonghua.bean.User;

/**
 * ��½������
 * @author Hyh
 *
 */
public class LoginInterceptor implements HandlerInterceptor{
    
	/**
	 * �������ͼ��Ⱦ֮��,ִ�д˷���
	 */
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}
    /**
     * ������ִ�����֮��ִ�е��߼�����
     */
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}
    /**
     * ������ִ��֮ǰ���ҵ���߼�
     * �����ķ���ֵ�����߼��Ƿ����ִ��,
     * true:��ʾ����ִ��
     * false:��ʾ���ټ���ִ��
     */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		String path = session.getServletContext().getContextPath();
		if(loginUser==null){
			response.sendRedirect(path + "/login");
			return false;
		}else{
			return true;
		}
	}

}
