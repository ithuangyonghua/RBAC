package com.ithuangyonghua.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ithuangyonghua.bean.AjaxResult;
import com.ithuangyonghua.bean.User;
import com.ithuangyonghua.service.UserService;
/**
 * ��½ && �˳�
 * @author Hyh
 *
 */
@Controller
public class DispatchController {
	@Autowired
	UserService userService;

	/**
	 * ��ת����½
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	/**
	 * ��ת����ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	/**
	 * ִ�е�½
	 * 
	 * @return
	 */
	@RequestMapping("/dologin")
	public String doLogin(User user, Model model) {
		// (1)��ȡ������
		// (1-1) HttpServletRequest
		// (1-2) �ڷ��������б������ӱ���Ӧ�Ĳ���,������ͬ(������ǰ�˵�name����ֵ�뷽������һ��)
		// (1-3) �������ݷ�װΪʵ�������(������ǰ�˵�name����ֵ��ʵ������һ��)

		// (2)��ѯ�û���Ϣ
		User dbuser = userService.queryForLogin(user);
		// (3)�ж��û��Ƿ����
		if (dbuser != null) {
			// ��½�ɹ�,��ת����ҳ��
			return "main";// Ĭ����ת���ķ�ʽ
		} else {
			// ��½ʧ��,��ת�ص�½ҳ��,����ʾ������Ϣ
			String message = "��½���˺Ż��������,����������";
			model.addAttribute("msg", message);
			return "redirect:login";
		}

	}

	/**
	 * Ajax ��½����
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/doAjaxLogin")
	public Object doAjaxLogin(User user,HttpSession session) {
		AjaxResult ajaxResult = new AjaxResult();
		User dbuser = userService.queryForLogin(user);
		if (dbuser != null) {
			// ��½�ɹ�,��ת����ҳ��
			ajaxResult.setSuccess(true);
			session.setAttribute("loginUser", dbuser);
			return ajaxResult;// Ĭ����ת���ķ�ʽ
		} else {
			// ��½ʧ��,��ת�ص�½ҳ��,����ʾ������Ϣ
			// String message = "��½���˺Ż��������,����������";
			// model.addAttribute("msg", message);
			ajaxResult.setSuccess(false);
			return ajaxResult;
		}
	}
	/**
	 * �˳�ϵͳ
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String Logout(HttpSession session){
//		session.removeAttribute("loginUser");
		session.invalidate();
		return "redirect:login";//�ض��򵽵�¼ҳ����������·��Ҳ����login
	}

}
